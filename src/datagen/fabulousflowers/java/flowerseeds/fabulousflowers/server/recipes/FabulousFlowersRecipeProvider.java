package flowerseeds.fabulousflowers.server.recipes;

import fabulousflowers.init.FabulousFlowersModBlocks;
import flowerseeds.fabulousflowers.FlowerSeedsFabulousFlowers;
import flowerseeds.server.recipes.MainRecipeProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class FabulousFlowersRecipeProvider extends MainRecipeProvider implements IConditionBuilder {

    public FabulousFlowersRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

//    @Override
//    public String getName() {
//        return "Flower Seeds 2 Roses Compat data Provider";
//    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {

        flowerSeedRecipe(FlowerSeedsFabulousFlowers.BLOOMED_DANDELION_SEED.get().asItem(), FabulousFlowersModBlocks.BLOOMED_DANDELION.get().asItem(), pWriter, "fabulous_flowers");
        flowerSeedRecipe(FlowerSeedsFabulousFlowers.ORANGE_POPPY_SEED.get().asItem(), FabulousFlowersModBlocks.ORANGE_POPPY.get().asItem(), pWriter, "fabulous_flowers");
        flowerSeedRecipe(FlowerSeedsFabulousFlowers.WHITE_POPPY_SEED.get().asItem(), FabulousFlowersModBlocks.WHITE_POPPY.get().asItem(), pWriter, "fabulous_flowers");
        flowerSeedRecipe(FlowerSeedsFabulousFlowers.YELLOW_POPPY_SEED.get().asItem(), FabulousFlowersModBlocks.YELLOW_POPPY.get().asItem(), pWriter, "fabulous_flowers");
        flowerSeedRecipe(FlowerSeedsFabulousFlowers.PINK_POPPY_SEED.get().asItem(), FabulousFlowersModBlocks.PINK_POPPY.get().asItem(), pWriter, "fabulous_flowers");
        flowerSeedRecipe(FlowerSeedsFabulousFlowers.YELLOW_ORCHID_SEED.get().asItem(), FabulousFlowersModBlocks.YELLOW_ORCHID.get().asItem(), pWriter, "fabulous_flowers");
        flowerSeedRecipe(FlowerSeedsFabulousFlowers.WHITE_ORCHID_SEED.get().asItem(), FabulousFlowersModBlocks.WHITE_ORCHID.get().asItem(), pWriter, "fabulous_flowers");
        flowerSeedRecipe(FlowerSeedsFabulousFlowers.PINK_ORCHID_SEED.get().asItem(), FabulousFlowersModBlocks.PINK_ORCHID.get().asItem(), pWriter, "fabulous_flowers");
        flowerSeedRecipe(FlowerSeedsFabulousFlowers.PURPLE_ORCHID_SEED.get().asItem(), FabulousFlowersModBlocks.PURPLE_ORCHID.get().asItem(), pWriter, "fabulous_flowers");
        flowerSeedRecipe(FlowerSeedsFabulousFlowers.BLUE_ALLIUM_SEED.get().asItem(), FabulousFlowersModBlocks.BLUE_ALLIUM.get().asItem(), pWriter, "fabulous_flowers");
        flowerSeedRecipe(FlowerSeedsFabulousFlowers.WHITE_ALLIUM_SEED.get().asItem(), FabulousFlowersModBlocks.WHITE_ALLIUM.get().asItem(), pWriter, "fabulous_flowers");
        flowerSeedRecipe(FlowerSeedsFabulousFlowers.YELLOW_TULIP_SEED.get().asItem(), FabulousFlowersModBlocks.YELLOW_TULIP.get().asItem(), pWriter, "fabulous_flowers");
        flowerSeedRecipe(FlowerSeedsFabulousFlowers.PURPLE_TULIP_SEED.get().asItem(), FabulousFlowersModBlocks.PURPLE_TULIP.get().asItem(), pWriter, "fabulous_flowers");
        flowerSeedRecipe(FlowerSeedsFabulousFlowers.BLUE_TULIP_SEED.get().asItem(), FabulousFlowersModBlocks.BLUE_TULIP.get().asItem(), pWriter, "fabulous_flowers");
        flowerSeedRecipe(FlowerSeedsFabulousFlowers.BLACK_TULIP_SEED.get().asItem(), FabulousFlowersModBlocks.BLACK_TULIP.get().asItem(), pWriter, "fabulous_flowers");
        flowerSeedRecipe(FlowerSeedsFabulousFlowers.ASTER_DAISY_SEED.get().asItem(), FabulousFlowersModBlocks.ASTER_DAISY.get().asItem(), pWriter, "fabulous_flowers");
        flowerSeedRecipe(FlowerSeedsFabulousFlowers.GLORIOSA_DAISY_SEED.get().asItem(), FabulousFlowersModBlocks.GLORIOSA_DAISY.get().asItem(), pWriter, "fabulous_flowers");
    }

}
