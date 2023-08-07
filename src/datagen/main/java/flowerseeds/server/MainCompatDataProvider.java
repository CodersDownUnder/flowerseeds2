package flowerseeds.server;

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

class MainCompatDataProvider extends CompatDataProvider{

    public MainCompatDataProvider(GatherDataEvent event) {
        super(FlowerSeeds.MODID, event);
    }

    @Override
    protected @NotNull CompletableFuture<?> generate() {

       basicFlowerProcessing();

       //This is here to force it to generate all the files, otherwise the last few files don't get generated for some reason or other.
       MEKANISM_CRUSHING.builder(toName(Blocks.AIR), Ingredient.of(Blocks.AIR.asItem()), new ResourceLocation("minecraft:air"), 0);

       return CompletableFuture.completedFuture(null);
    }

    @Override
    public String getName() {
        return "Flower Seeds 2 Compat data Provider";
    }

    protected void basicFlowerProcessing() {

        Map<Block, Item> seeds = new HashMap<Block, Item>();
        seeds.put(BlockInit.DANDELION_SEED.get(), Items.DANDELION);
        seeds.put(BlockInit.ALLIUM_SEED.get(), Items.ALLIUM);
        seeds.put(BlockInit.AZURE_BLUET_SEED.get(), Items.AZURE_BLUET);
        seeds.put(BlockInit.CORNFLOWER_SEED.get(), Items.CORNFLOWER);
        seeds.put(BlockInit.BLUE_ORCHID_SEED.get(), Items.BLUE_ORCHID);
        seeds.put(BlockInit.LILY_OF_THE_VALLEY_SEED.get(), Items.LILY_OF_THE_VALLEY);
        seeds.put(BlockInit.ORANGE_TULIP_SEED.get(), Items.ORANGE_TULIP);
        seeds.put(BlockInit.PINK_TULIP_SEED.get(), Items.PINK_TULIP);
        seeds.put(BlockInit.POPPY_SEED.get(), Items.POPPY);
        seeds.put(BlockInit.RED_TULIP_SEED.get(), Items.RED_TULIP);
        seeds.put(BlockInit.OXEYE_DAISY_SEED.get(), Items.OXEYE_DAISY);
        seeds.put(BlockInit.WHITE_TULIP_SEED.get(), Items.WHITE_TULIP);
        seeds.put(BlockInit.WITHER_ROSE_SEED.get(), Items.WITHER_ROSE);

        //seeds.put(Blocks.WHEAT, Items.WHEAT);

        for (Map.Entry<Block, Item> entry : seeds.entrySet()) {
            Block seed = entry.getKey();
            Item flower = entry.getValue();

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

            //MEKANISM_CRUSHING.builder(toName(seed), ingredient, BIO_FUEL, 2).build();
            FlowerSeeds.LOGGER.info("made it to the end");

        }
    }

}