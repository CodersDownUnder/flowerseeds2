package flowerseeds.events;

import flowerseeds.FlowerSeeds;
import flowerseeds.init.BlockInit;
import net.minecraft.client.color.item.ItemColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = FlowerSeeds.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventsHandler {

    @SubscribeEvent
    public static void registerItemColor(RegisterColorHandlersEvent.Item event) {
        final ItemColor dandelionColor = (stack, tintIndex) -> 0xFED83D;
        event.register(dandelionColor, BlockInit.DANDELION_SEED.get().asItem().asItem());

        final ItemColor poppyColor = (stack, tintIndex) -> 0xB02E26;
        event.register(poppyColor, BlockInit.POPPY_SEED.get().asItem());

        final ItemColor orchidColor = (stack, tintIndex) -> 0x3AB3DA;
        event.register(orchidColor, BlockInit.BLUE_ORCHID_SEED.get().asItem());

        final ItemColor alliumColor = (stack, tintIndex) -> 0xC74EBD;
        event.register(alliumColor, BlockInit.ALLIUM_SEED.get().asItem());

        final ItemColor azureColor = (stack, tintIndex) -> 0x9D9D97;
        event.register(azureColor, BlockInit.AZURE_BLUET_SEED.get().asItem());

        final ItemColor tulip_redColor = (stack, tintIndex) -> 0xB02E26;
        event.register(tulip_redColor, BlockInit.RED_TULIP_SEED.get().asItem());

        final ItemColor tulip_orangeColor = (stack, tintIndex) -> 0xF9801D;
        event.register(tulip_orangeColor, BlockInit.ORANGE_TULIP_SEED.get().asItem());

        final ItemColor tulip_whiteColor = (stack, tintIndex) -> 0xFED83D;
        event.register(tulip_whiteColor, BlockInit.WHITE_TULIP_SEED.get().asItem());

        final ItemColor tulip_pinkColor = (stack, tintIndex) -> 0xF38BAA;
        event.register(tulip_pinkColor, BlockInit.PINK_TULIP_SEED.get().asItem());
        
        final ItemColor oxeyeColor = (stack, tintIndex) -> 0x9D9D97;
        event.register(oxeyeColor, BlockInit.OXEYE_DAISY_SEED.get().asItem());

        final ItemColor cornflowerColor = (stack, tintIndex) -> 0x3C44AA;
        event.register(cornflowerColor, BlockInit.CORNFLOWER_SEED.get().asItem());

        final ItemColor lilyColor = (stack, tintIndex) -> 0xffffff;
        event.register(lilyColor, BlockInit.LILY_OF_THE_VALLEY_SEED.get().asItem());

        final ItemColor witherroseColor = (stack, tintIndex) -> 0x1D1D21;
        event.register(witherroseColor, BlockInit.WITHER_ROSE_SEED.get().asItem());

//        final ItemColor cyanroseColor = (stack, tintIndex) -> 0x158991;
//        event.register(cyanroseColor, BlockInit.CYANROSE_SEED.get().asItem());
//        event.register(cyanroseColor, BlockInit.CYAN_ROSE_SEED.get().asItem());
//        event.register(cyanroseColor, BlockInit.CYAN_TULIP_SEED.get().asItem());



    }

}