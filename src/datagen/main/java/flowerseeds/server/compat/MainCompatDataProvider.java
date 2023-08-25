package flowerseeds.server.compat;

import com.github.minecraftschurlimods.easydatagenlib.CompatDataProvider;
import com.github.minecraftschurlimods.easydatagenlib.util.botanypots.DisplayState;
import com.github.minecraftschurlimods.easydatagenlib.util.immersiveengineering.ClocheRenderType;
import flowerseeds.FlowerSeeds;
import flowerseeds.init.BlockInit;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.data.event.GatherDataEvent;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class MainCompatDataProvider extends CompatDataProvider{

    public MainCompatDataProvider(String modid, GatherDataEvent event) {
        super(modid, event);
    }

    @Override
    protected @NotNull CompletableFuture<?> generate() {

        basicFlowerProcessing(BlockInit.DANDELION_SEED.get(), Items.DANDELION);
        basicFlowerProcessing(BlockInit.ALLIUM_SEED.get(), Items.ALLIUM);
        basicFlowerProcessing(BlockInit.AZURE_BLUET_SEED.get(), Items.AZURE_BLUET);
        basicFlowerProcessing(BlockInit.CORNFLOWER_SEED.get(), Items.CORNFLOWER);
        basicFlowerProcessing(BlockInit.BLUE_ORCHID_SEED.get(), Items.BLUE_ORCHID);
        basicFlowerProcessing(BlockInit.LILY_OF_THE_VALLEY_SEED.get(), Items.LILY_OF_THE_VALLEY);
        basicFlowerProcessing(BlockInit.ORANGE_TULIP_SEED.get(), Items.ORANGE_TULIP);
        basicFlowerProcessing(BlockInit.PINK_TULIP_SEED.get(), Items.PINK_TULIP);
        basicFlowerProcessing(BlockInit.POPPY_SEED.get(), Items.POPPY);
        basicFlowerProcessing(BlockInit.RED_TULIP_SEED.get(), Items.RED_TULIP);
        basicFlowerProcessing(BlockInit.OXEYE_DAISY_SEED.get(), Items.OXEYE_DAISY);
        basicFlowerProcessing(BlockInit.WHITE_TULIP_SEED.get(), Items.WHITE_TULIP);
        basicFlowerProcessing(BlockInit.WITHER_ROSE_SEED.get(), Items.WITHER_ROSE);
       
       //This is here to force it to generate all the files, otherwise the last few files don't get generated for some reason or other.
        //TODO: fix this in future (somehow?)
       MEKANISM_CRUSHING.builder(toName(Blocks.AIR), Ingredient.of(Blocks.AIR.asItem()), new ResourceLocation("minecraft:air"), 0);

       return CompletableFuture.completedFuture(null);
    }

    @Override
    public String getName() {
        return "Flower Seeds 2 Compat data Provider";
    }

    protected void basicFlowerProcessing(Block seed, Item flower) {
        

            Ingredient ingredient = Ingredient.of(seed.asItem());

            BOTANY_POTS_CROP.builder(toName(seed.asItem()), ingredient, 150)
                    .addCategory("dirt")
                    .addDisplay(new DisplayState.Aging(seed))
                    .addOutput(flower)
                    .addOutput(seed.asItem()).build();

            THERMAL_INSOLATING.builder(toName(seed.asItem()))
                    .addInput(ingredient)
                    .addOutputItem(flower, 2, 4f)
                    .addOutputItem(seed.asItem(), 1, 2f).build();

            IMMERSIVE_ENGINEERING_CLOCHE.builder(toName(seed.asItem()), 240, ingredient, Ingredient.of(Blocks.DIRT), ClocheRenderType.CROP, blockId(seed))
                    .addOutput(Ingredient.of(flower))
                    .addOutput(ingredient).build();

            MEKANISM_CRUSHING.builder(toName(seed.asItem()), ingredient, BIO_FUEL, 2).build();

            MEKANISM_CRUSHING.builder(toName(Blocks.AIR), Ingredient.of(Blocks.AIR.asItem()), new ResourceLocation("minecraft:air"), 0);

    }

}