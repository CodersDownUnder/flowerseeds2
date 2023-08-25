package flowerseeds.init;

import flowerseeds.FlowerSeeds;
import flowerseeds.blocks.CustomCropBlock;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, FlowerSeeds.MODID);

    public static final RegistryObject<Block> DANDELION_SEED = registerBlock("dandelion_seed",
            () -> new CustomCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).sound(SoundType.CROP)));

    public static final RegistryObject<Block> POPPY_SEED = registerBlock("poppy_seed",
            () -> new CustomCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).sound(SoundType.CROP)));

    public static final RegistryObject<Block> BLUE_ORCHID_SEED = registerBlock("blue_orchid_seed",
            () -> new CustomCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).sound(SoundType.CROP)));

    public static final RegistryObject<Block> ALLIUM_SEED = registerBlock("allium_seed",
            () -> new CustomCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).sound(SoundType.CROP)));

    public static final RegistryObject<Block> AZURE_BLUET_SEED = registerBlock("azure_bluet_seed",
            () -> new CustomCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).sound(SoundType.CROP)));

    public static final RegistryObject<Block> RED_TULIP_SEED = registerBlock("red_tulip_seed",
            () -> new CustomCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).sound(SoundType.CROP)));

    public static final RegistryObject<Block> ORANGE_TULIP_SEED = registerBlock("orange_tulip_seed",
            () -> new CustomCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).sound(SoundType.CROP)));

    public static final RegistryObject<Block> WHITE_TULIP_SEED = registerBlock("white_tulip_seed",
            () -> new CustomCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).sound(SoundType.CROP)));

    public static final RegistryObject<Block> PINK_TULIP_SEED = registerBlock("pink_tulip_seed",
            () -> new CustomCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).sound(SoundType.CROP)));

    public static final RegistryObject<Block> OXEYE_DAISY_SEED = registerBlock("oxeye_daisy_seed",
            () -> new CustomCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).sound(SoundType.CROP)));

    public static final RegistryObject<Block> CORNFLOWER_SEED = registerBlock("cornflower_seed",
            () -> new CustomCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).sound(SoundType.CROP)));

    public static final RegistryObject<Block> LILY_OF_THE_VALLEY_SEED = registerBlock("lily_of_the_valley_seed",
            () -> new CustomCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).sound(SoundType.CROP)));

    public static final RegistryObject<Block> WITHER_ROSE_SEED = registerBlock("wither_rose_seed",
            () -> new CustomCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).sound(SoundType.CROP)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ItemInit.ITEMS.register(name, () -> new ItemNameBlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
