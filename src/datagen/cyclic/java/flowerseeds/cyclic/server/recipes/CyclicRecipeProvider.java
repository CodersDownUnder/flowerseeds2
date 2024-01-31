package flowerseeds.cyclic.server.recipes;

import flowerseeds.cyclic.FlowerSeedsCyclic;
import flowerseeds.server.recipes.MainRecipeProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;


public class CyclicRecipeProvider extends MainRecipeProvider implements IConditionBuilder {

    public CyclicRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

//    @Override
//    public String getName() {
//        return "Flower Seeds 2 Roses Compat data Provider";
//    }

    @Override
    protected void buildRecipes(RecipeOutput pWriter) {
//        flowerSeedRecipe(FlowerSeedsCyclic.CYAN_ROSE_SEED.get().asItem(), BlockRegistry.FLOWER_CYAN.get().asItem(), pWriter, "cyclic");
//        flowerSeedRecipe(FlowerSeedsCyclic.ABSALON_TULIP_SEED.get().asItem(), BlockRegistry.FLOWER_ABSALON_TULIP.get().asItem(), pWriter, "cyclic");
//        flowerSeedRecipe(FlowerSeedsCyclic.PURPLE_TULIP_SEED.get().asItem(), BlockRegistry.FLOWER_PURPLE_TULIP.get().asItem(), pWriter, "cyclic");
//        flowerSeedRecipe(FlowerSeedsCyclic.LIME_CARNATION_SEED.get().asItem(), BlockRegistry.FLOWER_LIME_CARNATION.get().asItem(), pWriter, "cyclic");

    }


}
