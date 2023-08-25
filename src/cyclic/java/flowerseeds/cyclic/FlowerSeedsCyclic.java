package flowerseeds.cyclic;

import com.mojang.logging.LogUtils;
import flowerseeds.FlowerSeeds;
import flowerseeds.cyclic.init.BlockInit;
import flowerseeds.cyclic.init.ItemInit;
import flowerseeds.events.ItemColorEventHandler;
import flowerseeds.init.CreativeTabInit;
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
@Mod(FlowerSeedsCyclic.MODID)
public class FlowerSeedsCyclic
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "flowerseedscyclic";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "examplemod" namespace

    public FlowerSeedsCyclic()
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
            FlowerSeeds.compostable(BlockInit.CYAN_ROSE_SEED.get());
            FlowerSeeds.compostable(BlockInit.ABSALON_TULIP_SEED.get());
            FlowerSeeds.compostable(BlockInit.LIME_CARNATION_SEED.get());
            FlowerSeeds.compostable(BlockInit.PURPLE_TULIP_SEED.get());
        });

    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void registerItemColor(RegisterColorHandlersEvent.Item event) {
            event.register(ItemColorEventHandler.COLOUR_CYAN, BlockInit.CYAN_ROSE_SEED.get());
            event.register(ItemColorEventHandler.COLOUR_LIME, BlockInit.LIME_CARNATION_SEED.get());
            event.register(ItemColorEventHandler.COLOUR_PURPLE, BlockInit.PURPLE_TULIP_SEED.get());
            event.register(ItemColorEventHandler.COLOUR_BROWN, BlockInit.ABSALON_TULIP_SEED.get());
        }
    }


    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if (event.getTabKey() == CreativeTabInit.FLOWER_SEEDS_TAB.getKey()) {
            event.accept(BlockInit.CYAN_ROSE_SEED.get().asItem());
            event.accept(BlockInit.ABSALON_TULIP_SEED.get().asItem());
            event.accept(BlockInit.LIME_CARNATION_SEED.get().asItem());
            event.accept(BlockInit.PURPLE_TULIP_SEED.get().asItem());

        }
    }


}
