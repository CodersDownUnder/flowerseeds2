package flowerseeds.roses.server.loot;

import flowerseeds.roses.FlowerSeedsRoses;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;
import willatendo.roses.server.block.RosesBlocks;

import java.util.Set;

public class RoseBlockLootTables extends BlockLootSubProvider {
    public RoseBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }




    @Override
    protected void generate() {
        add(FlowerSeedsRoses.ROSE_SEED.get(), FlowerLootTableBuilder(FlowerSeedsRoses.ROSE_SEED.get(), RosesBlocks.ROSE.get().asItem()));
        add(FlowerSeedsRoses.CYAN_FLOWER_SEED.get(), FlowerLootTableBuilder(FlowerSeedsRoses.CYAN_FLOWER_SEED.get(), RosesBlocks.CYAN_FLOWER.get().asItem()));
    }

    protected LootTable.Builder FlowerLootTableBuilder(Block pCropBlock, Item pGrownCropItem) {
        LootItemCondition.Builder lootitemcondition$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(pCropBlock).setProperties(StatePropertiesPredicate.Builder
                        .properties().hasProperty(CropBlock.AGE, 7));
        return FlowerSeedsCropDrops(pCropBlock, pGrownCropItem, pCropBlock.asItem(), lootitemcondition$builder);
    }


    protected LootTable.Builder FlowerSeedsCropDrops(Block pCropBlock, Item pGrownCropItem, Item pSeedsItem, LootItemCondition.Builder pDropGrownCropCondition) {
        return applyExplosionDecay(pCropBlock, LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(pGrownCropItem).setWeight(2).when(pDropGrownCropCondition).otherwise(LootItem.lootTableItem(pSeedsItem)))).withPool(LootPool.lootPool().when(pDropGrownCropCondition).add(LootItem.lootTableItem(pSeedsItem).apply(ApplyBonusCount.addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.5714286F, 3)))));
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return FlowerSeedsRoses.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}