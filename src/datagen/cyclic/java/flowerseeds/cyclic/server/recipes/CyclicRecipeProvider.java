package flowerseeds.cyclic.server.recipes;

import com.lothrazar.cyclic.registry.BlockRegistry;
import flowerseeds.cyclic.FlowerSeedsCyclic;
import flowerseeds.server.recipes.MainRecipeProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class CyclicRecipeProvider extends MainRecipeProvider implements IConditionBuilder {

    public CyclicRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

//    @Override
//    public String getName() {
//        return "Flower Seeds 2 Roses Compat data Provider";
//    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        flowerSeedRecipe(FlowerSeedsCyclic.CYAN_ROSE_SEED.get().asItem(), BlockRegistry.FLOWER_CYAN.get().asItem(), pWriter, "cyclic");
        flowerSeedRecipe(FlowerSeedsCyclic.ABSALON_TULIP_SEED.get().asItem(), BlockRegistry.FLOWER_ABSALON_TULIP.get().asItem(), pWriter, "cyclic");
        flowerSeedRecipe(FlowerSeedsCyclic.PURPLE_TULIP_SEED.get().asItem(), BlockRegistry.FLOWER_PURPLE_TULIP.get().asItem(), pWriter, "cyclic");
        flowerSeedRecipe(FlowerSeedsCyclic.LIME_CARNATION_SEED.get().asItem(), BlockRegistry.FLOWER_LIME_CARNATION.get().asItem(), pWriter, "cyclic");

    }


}
