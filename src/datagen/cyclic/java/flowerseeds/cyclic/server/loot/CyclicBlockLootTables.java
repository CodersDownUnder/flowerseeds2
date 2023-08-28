package flowerseeds.cyclic.server.loot;

import com.lothrazar.cyclic.registry.BlockRegistry;
import flowerseeds.cyclic.FlowerSeedsCyclic;
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

import java.util.Set;

public class CyclicBlockLootTables extends BlockLootSubProvider {
    public CyclicBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        createLootTable(FlowerSeedsCyclic.ABSALON_TULIP_SEED.get(), BlockRegistry.FLOWER_ABSALON_TULIP.get());
        createLootTable(FlowerSeedsCyclic.PURPLE_TULIP_SEED.get(), BlockRegistry.FLOWER_PURPLE_TULIP.get());
        createLootTable(FlowerSeedsCyclic.LIME_CARNATION_SEED.get(), BlockRegistry.FLOWER_LIME_CARNATION.get());
        createLootTable(FlowerSeedsCyclic.CYAN_ROSE_SEED.get(), BlockRegistry.FLOWER_CYAN.get());
    }

    protected void createLootTable(Block block, Block block2) {
        add(block, FlowerLootTableBuilder(block, block2.asItem()));
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
        return FlowerSeedsCyclic.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}