package flowerseeds.server.recipes;

import flowerseeds.init.BlockInit;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class MainRecipeProvider  extends RecipeProvider implements IConditionBuilder {

    public MainRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        flowerSeedRecipe(BlockInit.DANDELION_SEED.get().asItem(), Items.DANDELION, pWriter);
        flowerSeedRecipe(BlockInit.ALLIUM_SEED.get().asItem(), Items.ALLIUM, pWriter);
        flowerSeedRecipe(BlockInit.AZURE_BLUET_SEED.get().asItem(), Items.AZURE_BLUET, pWriter);
        flowerSeedRecipe(BlockInit.CORNFLOWER_SEED.get().asItem(), Items.CORNFLOWER, pWriter);
        flowerSeedRecipe(BlockInit.BLUE_ORCHID_SEED.get().asItem(), Items.BLUE_ORCHID, pWriter);
        flowerSeedRecipe(BlockInit.LILY_OF_THE_VALLEY_SEED.get().asItem(), Items.LILY_OF_THE_VALLEY, pWriter);
        flowerSeedRecipe(BlockInit.ORANGE_TULIP_SEED.get().asItem(), Items.ORANGE_TULIP, pWriter);
        flowerSeedRecipe(BlockInit.PINK_TULIP_SEED.get().asItem(), Items.PINK_TULIP, pWriter);
        flowerSeedRecipe(BlockInit.POPPY_SEED.get().asItem(), Items.POPPY, pWriter);
        flowerSeedRecipe(BlockInit.RED_TULIP_SEED.get().asItem(), Items.RED_TULIP, pWriter);
        flowerSeedRecipe(BlockInit.OXEYE_DAISY_SEED.get().asItem(), Items.OXEYE_DAISY, pWriter);
        flowerSeedRecipe(BlockInit.WHITE_TULIP_SEED.get().asItem(), Items.WHITE_TULIP, pWriter);
        flowerSeedRecipe(BlockInit.WITHER_ROSE_SEED.get().asItem(), Items.WITHER_ROSE, pWriter);
    }

    protected static void flowerSeedRecipe(Item flowerSeed, Item flower, Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, flowerSeed, 2)
                .requires(flower)
                .requires(Tags.Items.SEEDS)
                .unlockedBy(getHasName(flower), has(flower))
                .save(pFinishedRecipeConsumer);
    }

}
