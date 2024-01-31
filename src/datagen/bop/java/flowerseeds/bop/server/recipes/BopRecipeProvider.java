package flowerseeds.bop.server.recipes;

import biomesoplenty.api.block.BOPBlocks;
import flowerseeds.bop.FlowerSeedsBop;
import flowerseeds.server.recipes.MainRecipeProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;


public class BopRecipeProvider extends MainRecipeProvider implements IConditionBuilder {

    public BopRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

//    @Override
//    public String getName() {
//        return "Flower Seeds 2 Roses Compat data Provider";
//    }

    @Override
    protected void buildRecipes(RecipeOutput pWriter) {

        flowerSeedRecipe(FlowerSeedsBop.ROSE_SEED.get().asItem(), BOPBlocks.ROSE.asItem(), pWriter, "biomesoplenty");
        flowerSeedRecipe(FlowerSeedsBop.WILD_FLOWER_SEED.get().asItem(), BOPBlocks.WILDFLOWER.asItem(), pWriter, "biomesoplenty");
        flowerSeedRecipe(FlowerSeedsBop.ORANGE_COSMOS_SEED.get().asItem(), BOPBlocks.ORANGE_COSMOS.asItem(), pWriter, "biomesoplenty");
        flowerSeedRecipe(FlowerSeedsBop.PINK_DAFFODIL_SEED.get().asItem(), BOPBlocks.PINK_DAFFODIL.asItem(), pWriter, "biomesoplenty");
        flowerSeedRecipe(FlowerSeedsBop.GLOW_FLOWER_SEED.get().asItem(), BOPBlocks.GLOWFLOWER.asItem(), pWriter, "biomesoplenty");
        flowerSeedRecipe(FlowerSeedsBop.WILTED_LILY_SEED.get().asItem(), BOPBlocks.WILTED_LILY.asItem(), pWriter, "biomesoplenty");
        flowerSeedRecipe(FlowerSeedsBop.BURNING_BLOSSOM_SEED.get().asItem(), BOPBlocks.BURNING_BLOSSOM.asItem(), pWriter, "biomesoplenty");

    }

}
