package flowerseeds.roses.init;

import flowerseeds.blocks.CustomCropBlock;
import flowerseeds.roses.FlowerSeedsRoses;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, FlowerSeedsRoses.MODID);

    public static final RegistryObject<Block> ROSE_SEED = registerBlock("rose_seed",
            () -> new CustomCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).sound(SoundType.CROP)));

    public static final RegistryObject<Block> CYAN_FLOWER_SEED = registerBlock("cyan_flower_seed",
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
