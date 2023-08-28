package flowerseeds.bop.server.loot;

import biomesoplenty.api.block.BOPBlocks;
import flowerseeds.bop.FlowerSeedsBop;
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

class BopBlockLootTables extends BlockLootSubProvider {
    public BopBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        createLootTable(FlowerSeedsBop.ROSE_SEED.get(), BOPBlocks.ROSE.get());
        createLootTable(FlowerSeedsBop.WILD_FLOWER_SEED.get(), BOPBlocks.WILDFLOWER.get());
        createLootTable(FlowerSeedsBop.ORANGE_COSMOS_SEED.get(), BOPBlocks.ORANGE_COSMOS.get());
        createLootTable(FlowerSeedsBop.PINK_DAFFODIL_SEED.get(), BOPBlocks.PINK_DAFFODIL.get());
        createLootTable(FlowerSeedsBop.GLOW_FLOWER_SEED.get(), BOPBlocks.GLOWFLOWER.get());
        createLootTable(FlowerSeedsBop.WILTED_LILY_SEED.get(), BOPBlocks.WILTED_LILY.get());
        createLootTable(FlowerSeedsBop.BURNING_BLOSSOM_SEED.get(), BOPBlocks.BURNING_BLOSSOM.get());
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
        return FlowerSeedsBop.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}