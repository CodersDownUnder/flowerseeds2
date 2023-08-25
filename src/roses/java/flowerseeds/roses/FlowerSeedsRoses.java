package flowerseeds.roses;

import com.mojang.logging.LogUtils;
import flowerseeds.FlowerSeeds;
import flowerseeds.events.ItemColorEventHandler;
import flowerseeds.init.CreativeTabInit;
import flowerseeds.roses.init.BlockInit;
import flowerseeds.roses.init.ItemInit;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(FlowerSeedsRoses.MODID)
public class FlowerSeedsRoses
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "flowerseedsroses";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "examplemod" namespace

    public FlowerSeedsRoses()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemInit.register(modEventBus);
        BlockInit.register(modEventBus);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        modEventBus.addListener(this::addCreative);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> {
            FlowerSeeds.compostable(BlockInit.CYAN_FLOWER_SEED.get());
            FlowerSeeds.compostable(BlockInit.ROSE_SEED.get());
        });

    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void registerItemColor(RegisterColorHandlersEvent.Item event) {
            event.register(ItemColorEventHandler.COLOUR_RED, BlockInit.ROSE_SEED.get());
            event.register(ItemColorEventHandler.COLOUR_CYAN, BlockInit.CYAN_FLOWER_SEED.get());
        }
    }


    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if (event.getTabKey() == CreativeTabInit.FLOWER_SEEDS_TAB.getKey()) {
            event.accept(BlockInit.CYAN_FLOWER_SEED.get().asItem());
            event.accept(BlockInit.ROSE_SEED.get().asItem());
        }
    }


}
