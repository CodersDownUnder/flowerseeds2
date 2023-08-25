package flowerseeds.events;

import flowerseeds.FlowerSeeds;
import flowerseeds.init.BlockInit;
import net.minecraft.client.color.item.ItemColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = FlowerSeeds.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ItemColorEventHandler {

    public static final ItemColor COLOUR_YELLOW = (stack, tintIndex) -> 0xFED83D;
    public static final ItemColor COLOUR_RED = (stack, tintIndex) -> 0xB02E26;
    public static final ItemColor COLOUR_LIGHT_BLUE = (stack, tintIndex) -> 0x3AB3DA;
    public static final ItemColor COLOUR_MAGENTA = (stack, tintIndex) -> 0xC74EBD;
    public static final ItemColor COLOUR_LIGHT_GREY = (stack, tintIndex) -> 0x9D9D97;
    public static final ItemColor COLOUR_ORANGE = (stack, tintIndex) -> 0xF9801D;
    public static final ItemColor COLOUR_PINK = (stack, tintIndex) -> 0xF38BAA;
    public static final ItemColor COLOUR_BLUE = (stack, tintIndex) -> 0x3C44AA;
    public static final ItemColor COLOUR_WHITE = (stack, tintIndex) -> 0xffffff;
    public static final ItemColor COLOUR_BLACK = (stack, tintIndex) -> 0x1D1D21;
    public static final ItemColor COLOUR_CYAN = (stack, tintIndex) -> 0x158991;
    public static final ItemColor COLOUR_LIME = (stack, tintIndex) -> 0x80C71F;
    public static final ItemColor COLOUR_PURPLE = (stack, tintIndex) ->  0x8932B8;
    public static final ItemColor COLOUR_BROWN = (stack, tintIndex) ->  0x835432;


    @SubscribeEvent
    public static void registerItemColor(RegisterColorHandlersEvent.Item event) {

        event.register(COLOUR_YELLOW, BlockInit.DANDELION_SEED.get().asItem().asItem());
        event.register(COLOUR_BLACK, BlockInit.WITHER_ROSE_SEED.get().asItem());
        event.register(COLOUR_RED, BlockInit.POPPY_SEED.get().asItem());
        event.register(COLOUR_LIGHT_BLUE, BlockInit.BLUE_ORCHID_SEED.get().asItem());
        event.register(COLOUR_MAGENTA, BlockInit.ALLIUM_SEED.get().asItem());
        event.register(COLOUR_LIGHT_GREY, BlockInit.AZURE_BLUET_SEED.get().asItem());
        event.register(COLOUR_RED, BlockInit.RED_TULIP_SEED.get().asItem());
        event.register(COLOUR_ORANGE, BlockInit.ORANGE_TULIP_SEED.get().asItem());
        event.register(COLOUR_LIGHT_GREY, BlockInit.WHITE_TULIP_SEED.get().asItem());
        event.register(COLOUR_PINK, BlockInit.PINK_TULIP_SEED.get().asItem());
        event.register(COLOUR_LIGHT_GREY, BlockInit.OXEYE_DAISY_SEED.get().asItem());
        event.register(COLOUR_BLUE, BlockInit.CORNFLOWER_SEED.get().asItem());
        event.register(COLOUR_WHITE, BlockInit.LILY_OF_THE_VALLEY_SEED.get().asItem());


    }


}