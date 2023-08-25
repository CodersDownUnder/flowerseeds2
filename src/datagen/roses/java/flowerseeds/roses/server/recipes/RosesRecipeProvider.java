package flowerseeds.roses.server.recipes;

import flowerseeds.roses.init.BlockInit;
import flowerseeds.server.recipes.MainRecipeProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import willatendo.roses.server.block.RosesBlocks;

import java.util.function.Consumer;

public class RosesRecipeProvider extends MainRecipeProvider implements IConditionBuilder {

    public RosesRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

//    @Override
//    public String getName() {
//        return "Flower Seeds 2 Roses Compat data Provider";
//    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        flowerSeedRecipe(BlockInit.ROSE_SEED.get().asItem(), RosesBlocks.ROSE.get().asItem(), pWriter, "roses");
        flowerSeedRecipe(BlockInit.CYAN_FLOWER_SEED.get().asItem(), RosesBlocks.CYAN_FLOWER.get().asItem(), pWriter, "roses");
    }


}
