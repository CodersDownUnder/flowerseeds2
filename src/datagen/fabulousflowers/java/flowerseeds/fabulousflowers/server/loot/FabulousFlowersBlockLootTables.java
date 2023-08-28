package flowerseeds.fabulousflowers.server.loot;

import fabulousflowers.init.FabulousFlowersModBlocks;
import flowerseeds.fabulousflowers.FlowerSeedsFabulousFlowers;
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
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

class FabulousFlowersBlockLootTables extends BlockLootSubProvider {
    public FabulousFlowersBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        createLootTable(FlowerSeedsFabulousFlowers.ASTER_DAISY_SEED.get(), FabulousFlowersModBlocks.ASTER_DAISY.get());
        createLootTable(FlowerSeedsFabulousFlowers.BLACK_TULIP_SEED.get(), FabulousFlowersModBlocks.BLACK_TULIP.get());
        createLootTable(FlowerSeedsFabulousFlowers.BLOOMED_DANDELION_SEED.get(), FabulousFlowersModBlocks.BLOOMED_DANDELION.get());
        createLootTable(FlowerSeedsFabulousFlowers.PURPLE_TULIP_SEED.get(), FabulousFlowersModBlocks.PURPLE_TULIP.get());
        createLootTable(FlowerSeedsFabulousFlowers.BLUE_ALLIUM_SEED.get(), FabulousFlowersModBlocks.BLUE_ALLIUM.get());
        createLootTable(FlowerSeedsFabulousFlowers.BLUE_TULIP_SEED.get(), FabulousFlowersModBlocks.BLUE_TULIP.get()); 
        createLootTable(FlowerSeedsFabulousFlowers.GLORIOSA_DAISY_SEED.get(), FabulousFlowersModBlocks.GLORIOSA_DAISY.get());
        createLootTable(FlowerSeedsFabulousFlowers.PINK_ORCHID_SEED.get(), FabulousFlowersModBlocks.PINK_ORCHID.get());
        createLootTable(FlowerSeedsFabulousFlowers.ORANGE_POPPY_SEED.get(), FabulousFlowersModBlocks.ORANGE_POPPY.get());
        createLootTable(FlowerSeedsFabulousFlowers.PINK_POPPY_SEED.get(), FabulousFlowersModBlocks.PINK_POPPY.get());
        createLootTable(FlowerSeedsFabulousFlowers.PURPLE_ORCHID_SEED.get(), FabulousFlowersModBlocks.PURPLE_ORCHID.get());
        createLootTable(FlowerSeedsFabulousFlowers.WHITE_ALLIUM_SEED.get(), FabulousFlowersModBlocks.WHITE_ALLIUM.get());
        createLootTable(FlowerSeedsFabulousFlowers.WHITE_ORCHID_SEED.get(), FabulousFlowersModBlocks.WHITE_ORCHID.get());
        createLootTable(FlowerSeedsFabulousFlowers.WHITE_POPPY_SEED.get(), FabulousFlowersModBlocks.WHITE_POPPY.get());
        createLootTable(FlowerSeedsFabulousFlowers.YELLOW_ORCHID_SEED.get(), FabulousFlowersModBlocks.YELLOW_ORCHID.get());
        createLootTable(FlowerSeedsFabulousFlowers.YELLOW_POPPY_SEED.get(), FabulousFlowersModBlocks.YELLOW_POPPY.get());
        createLootTable(FlowerSeedsFabulousFlowers.YELLOW_TULIP_SEED.get(), FabulousFlowersModBlocks.YELLOW_TULIP.get());
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
        return FlowerSeedsFabulousFlowers.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}