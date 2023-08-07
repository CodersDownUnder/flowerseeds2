package flowerseeds.client.models;

import flowerseeds.init.BlockInit;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.client.model.generators.*;
import net.minecraftforge.client.model.generators.loaders.CompositeModelBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;

import static flowerseeds.FlowerSeeds.MODID;

public class MainBlockStateProvider extends BlockStateProvider {
    public MainBlockStateProvider(PackOutput output, String MODID, ExistingFileHelper exFileHelper) {
        super(output, MODID, exFileHelper);
    }

    @Override
    public String getName() {
        return "Flower Seeds 2 Main BlockState Provider";
    }

    @Override
    protected void registerStatesAndModels() {
        flowerModel(BlockInit.DANDELION_SEED.get(), "block/dandelion", "dandelion");
        flowerModel(BlockInit.ALLIUM_SEED.get(), "block/allium", "allium");
        flowerModel(BlockInit.AZURE_BLUET_SEED.get(), "block/azure_bluet", "azure_bluet");
        flowerModel(BlockInit.CORNFLOWER_SEED.get(), "block/cornflower", "cornflower");
        flowerModel(BlockInit.BLUE_ORCHID_SEED.get(), "block/blue_orchid", "blue_orchid");
        flowerModel(BlockInit.LILY_OF_THE_VALLEY_SEED.get(), "block/lily_of_the_valley", "lily_of_the_valley");
        flowerModel(BlockInit.ORANGE_TULIP_SEED.get(), "block/orange_tulip", "orange_tulip");
        flowerModel(BlockInit.PINK_TULIP_SEED.get(), "block/pink_tulip", "pink_tulip");
        flowerModel(BlockInit.POPPY_SEED.get(), "block/poppy", "poppy");
        flowerModel(BlockInit.RED_TULIP_SEED.get(), "block/red_tulip", "red_tulip");
        flowerModel(BlockInit.OXEYE_DAISY_SEED.get(), "block/oxeye_daisy", "oxeye_daisy");
        flowerModel(BlockInit.WHITE_TULIP_SEED.get(), "block/white_tulip", "white_tulip");
        flowerModel(BlockInit.WITHER_ROSE_SEED.get(), "block/wither_rose", "wither_rose");
    }

    private BlockModelBuilder fullyGrown(String texture, String model, String flower) {

        return models().getBuilder(flower + "_seed_stage3")
                .customLoader(CompositeModelBuilder::begin)
                .child("flower0", models().withExistingParent(flower + "0_stage3", mcLoc(model))
                        .texture("cross", mcLoc(texture))
                        .texture("particle", mcLoc(texture))
                        .rootTransforms().translation(0.23f, -0.1f, 0.23f).end().renderType("minecraft:cutout_mipped"))
                .child("flower1", models().withExistingParent(flower + "1_stage3", mcLoc(model))
                        .texture("cross", mcLoc(texture))
                        .texture("particle", mcLoc(texture))
                        .rootTransforms().translation(-0.23f, -0.1f, 0.23f).end().renderType("minecraft:cutout_mipped"))
                .child("flower2", models().withExistingParent(flower + "2_stage3", mcLoc(model))
                        .texture("cross", mcLoc(texture))
                        .texture("particle", mcLoc(texture))
                        .rootTransforms().translation(-0.23f, -0.1f, -0.23f).end().renderType("minecraft:cutout_mipped"))
                .child("flower3", models().withExistingParent(flower + "3_stage3", mcLoc(model))
                        .texture("cross", mcLoc(texture))
                        .texture("particle", mcLoc(texture))
                        .rootTransforms().translation(0.23f, -0.1f, -0.23f).end().renderType("minecraft:cutout_mipped"))
                .end();
    }

    private BlockModelBuilder stage(String texture, Integer stage, String flower) {

        return models().getBuilder("dandelion_seed_stage" + stage)
                .customLoader(CompositeModelBuilder::begin)
                .child("flower0", models().singleTexture(flower + "0_stage" + stage, new ResourceLocation(MODID, "block/cross_stage" + stage), "cross", mcLoc(texture))
                        .texture("particle", mcLoc(texture))
                        .rootTransforms().translation(0.23f, -0.1f, 0.23f).end()
                        .renderType("minecraft:cutout_mipped"))
                .child("flower1", models().singleTexture(flower + "1_stage" + stage, new ResourceLocation(MODID, "block/cross_stage" + stage), "cross", mcLoc(texture))
                        .texture("particle", mcLoc(texture))
                        .rootTransforms().translation(-0.23f, -0.1f, 0.23f).end()
                        .renderType("minecraft:cutout_mipped"))
                .child("flower2", models().singleTexture(flower + "2_stage" + stage, new ResourceLocation(MODID, "block/cross_stage" + stage), "cross", mcLoc(texture))
                        .texture("particle", mcLoc(texture))
                        .rootTransforms().translation(-0.23f, -0.1f, -0.23f).end()
                        .renderType("minecraft:cutout_mipped"))
                .child("flower3", models().singleTexture(flower + "3_stage" + stage, new ResourceLocation(MODID, "block/cross_stage" + stage), "cross", mcLoc(texture))
                        .texture("particle", mcLoc(texture))
                        .rootTransforms().translation(0.23f, -0.1f, -0.23f).end()
                        .renderType("minecraft:cutout_mipped"))
                .end();
    }

    private void flowerModel(Block block, String texture, String flower) {


        getVariantBuilder(block)
                .partialState()
                .with(CropBlock.AGE, 0)
                .modelForState()
                .modelFile(stage(texture, 0, flower))
                .addModel()
                .partialState()
                .with(CropBlock.AGE, 1)
                .modelForState()
                .modelFile(stage(texture, 0, flower))
                .addModel()
                .partialState()
                .with(CropBlock.AGE, 2)
                .modelForState()
                .modelFile(stage(texture, 1, flower))
                .addModel()
                .partialState()
                .with(CropBlock.AGE, 3)
                .modelForState()
                .modelFile(stage(texture, 1, flower))
                .addModel()
                .partialState()
                .with(CropBlock.AGE, 4)
                .modelForState()
                .modelFile(stage(texture, 1, flower))
                .addModel()
                .partialState()
                .with(CropBlock.AGE, 5)
                .modelForState()
                .modelFile(stage(texture, 2, flower))
                .addModel()
                .partialState()
                .with(CropBlock.AGE, 6)
                .modelForState()
                .modelFile(stage(texture, 2, flower))
                .addModel()
                .partialState()
                .with(CropBlock.AGE, 7)
                .modelForState()
                .modelFile(fullyGrown(texture, texture, flower))
                .addModel();

    }


    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}