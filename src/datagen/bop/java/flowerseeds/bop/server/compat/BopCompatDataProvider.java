//package flowerseeds.bop.server.compat;
//
//import biomesoplenty.api.block.BOPBlocks;
//import biomesoplenty.api.item.BOPItems;
//import flowerseeds.bop.FlowerSeedsBop;
//import flowerseeds.server.compat.MainCompatDataProvider;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.world.item.crafting.Ingredient;
//import net.minecraft.world.level.block.Blocks;
//import net.minecraftforge.data.event.GatherDataEvent;
//import org.jetbrains.annotations.NotNull;
//
//import java.util.concurrent.CompletableFuture;
//
//public class BopCompatDataProvider extends MainCompatDataProvider {
//
//    public BopCompatDataProvider(String modid, GatherDataEvent event) {
//        super(modid, event);
//    }
//
//    @Override
//    protected @NotNull CompletableFuture<?> generate() {
//
//        basicFlowerProcessing(FlowerSeedsBop.ROSE_SEED.get(), BOPBlocks.ROSE.get().asItem());
//        basicFlowerProcessing(FlowerSeedsBop.WILD_FLOWER_SEED.get(), BOPBlocks.WILDFLOWER.get().asItem());
//        basicFlowerProcessing(FlowerSeedsBop.ORANGE_COSMOS_SEED.get(), BOPBlocks.ORANGE_COSMOS.get().asItem());
//        basicFlowerProcessing(FlowerSeedsBop.PINK_DAFFODIL_SEED.get(), BOPBlocks.PINK_DAFFODIL.get().asItem());
//        basicFlowerProcessing(FlowerSeedsBop.GLOW_FLOWER_SEED.get(), BOPBlocks.GLOWFLOWER.get().asItem());
//        basicFlowerProcessing(FlowerSeedsBop.WILTED_LILY_SEED.get(), BOPBlocks.WILTED_LILY.get().asItem());
//
//        basicNetherFlowerProcessing(FlowerSeedsBop.BURNING_BLOSSOM_SEED.get(), BOPBlocks.BURNING_BLOSSOM.get().asItem());
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