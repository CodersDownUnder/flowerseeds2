//package flowerseeds.fabulousflowers.server.compat;
//
//import fabulousflowers.init.FabulousFlowersModBlocks;
//import flowerseeds.fabulousflowers.FlowerSeedsFabulousFlowers;
//import flowerseeds.server.compat.MainCompatDataProvider;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.world.item.crafting.Ingredient;
//import net.minecraft.world.level.block.Blocks;
//import net.minecraftforge.data.event.GatherDataEvent;
//import org.jetbrains.annotations.NotNull;
//
//import java.util.concurrent.CompletableFuture;
//
//public class FabulousFlowersCompatDataProvider extends MainCompatDataProvider {
//
//    public FabulousFlowersCompatDataProvider(String modid, GatherDataEvent event) {
//        super(modid, event);
//    }
//
//    @Override
//    protected @NotNull CompletableFuture<?> generate() {
//
//        basicFlowerProcessing(FlowerSeedsFabulousFlowers.BLOOMED_DANDELION_SEED.get(), FabulousFlowersModBlocks.BLOOMED_DANDELION.get().asItem());
//        basicFlowerProcessing(FlowerSeedsFabulousFlowers.ORANGE_POPPY_SEED.get(), FabulousFlowersModBlocks.ORANGE_POPPY.get().asItem());
//        basicFlowerProcessing(FlowerSeedsFabulousFlowers.WHITE_POPPY_SEED.get(), FabulousFlowersModBlocks.WHITE_POPPY.get().asItem());
//        basicFlowerProcessing(FlowerSeedsFabulousFlowers.YELLOW_POPPY_SEED.get(), FabulousFlowersModBlocks.YELLOW_POPPY.get().asItem());
//        basicFlowerProcessing(FlowerSeedsFabulousFlowers.PINK_POPPY_SEED.get(), FabulousFlowersModBlocks.PINK_POPPY.get().asItem());
//        basicFlowerProcessing(FlowerSeedsFabulousFlowers.YELLOW_ORCHID_SEED.get(), FabulousFlowersModBlocks.YELLOW_ORCHID.get().asItem());
//        basicFlowerProcessing(FlowerSeedsFabulousFlowers.WHITE_ORCHID_SEED.get(), FabulousFlowersModBlocks.WHITE_ORCHID.get().asItem());
//        basicFlowerProcessing(FlowerSeedsFabulousFlowers.PINK_ORCHID_SEED.get(), FabulousFlowersModBlocks.PINK_ORCHID.get().asItem());
//        basicFlowerProcessing(FlowerSeedsFabulousFlowers.PURPLE_ORCHID_SEED.get(), FabulousFlowersModBlocks.PURPLE_ORCHID.get().asItem());
//        basicFlowerProcessing(FlowerSeedsFabulousFlowers.BLUE_ALLIUM_SEED.get(), FabulousFlowersModBlocks.BLUE_ALLIUM.get().asItem());
//        basicFlowerProcessing(FlowerSeedsFabulousFlowers.WHITE_ALLIUM_SEED.get(), FabulousFlowersModBlocks.WHITE_ALLIUM.get().asItem());
//        basicFlowerProcessing(FlowerSeedsFabulousFlowers.YELLOW_TULIP_SEED.get(), FabulousFlowersModBlocks.YELLOW_TULIP.get().asItem());
//        basicFlowerProcessing(FlowerSeedsFabulousFlowers.PURPLE_TULIP_SEED.get(), FabulousFlowersModBlocks.PURPLE_TULIP.get().asItem());
//        basicFlowerProcessing(FlowerSeedsFabulousFlowers.BLUE_TULIP_SEED.get(), FabulousFlowersModBlocks.BLUE_TULIP.get().asItem());
//        basicFlowerProcessing(FlowerSeedsFabulousFlowers.BLACK_TULIP_SEED.get(), FabulousFlowersModBlocks.BLACK_TULIP.get().asItem());
//        basicFlowerProcessing(FlowerSeedsFabulousFlowers.ASTER_DAISY_SEED.get(), FabulousFlowersModBlocks.ASTER_DAISY.get().asItem());
//        basicFlowerProcessing(FlowerSeedsFabulousFlowers.GLORIOSA_DAISY_SEED.get(), FabulousFlowersModBlocks.GLORIOSA_DAISY.get().asItem());
//
//
//       //This is here to force it to generate all the files, otherwise the last few files don't get generated for some reason or other.
//        //TODO: fix this in future (somehow?)
//       MEKANISM_CRUSHING.builder(toName(Blocks.AIR), Ingredient.of(Blocks.AIR.asItem()), new ResourceLocation("minecraft:air"), 0);
//
//       return CompletableFuture.completedFuture(null);
//    }
//
//    @Override
//    public String getName() {
//        return "Flower Seeds 2 Cyclic Compat data Provider";
//    }
//
//}