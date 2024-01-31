package flowerseeds;

import com.mojang.logging.LogUtils;
import flowerseeds.blocks.CustomCropBlock;
import flowerseeds.init.BlockInit;
import flowerseeds.init.CreativeTabInit;
import flowerseeds.init.ItemInit;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ComposterBlock;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(FlowerSeeds.MODID)
public class FlowerSeeds
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = FlowerSeedsAPI.FLOWERSEEDS_MODID;
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();
    public FlowerSeeds(IEventBus modEventBus)
    {

        CreativeTabInit.register(modEventBus);

        ItemInit.register(modEventBus);
        BlockInit.register(modEventBus);


        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        //NeoForge.EVENT_BUS.register(this);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);

    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
            LogFilter.apply();

//            event.enqueueWork(() -> {
//                for (DeferredHolder<Block, ? extends Block> block : BlockInit.BLOCKS.getEntries()) {
//                    FlowerSeeds.compostable(block.get());
//                }
//            });
    }

    public static void compostable(Block block) {
        ComposterBlock.COMPOSTABLES.put(block.asItem(), 0.3f);
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void registerItemColor(RegisterColorHandlersEvent.Item event) {
            for (DeferredHolder<Block, ? extends Block> block : BlockInit.BLOCKS.getEntries()) {
                CustomCropBlock item = (CustomCropBlock) block.get();
                event.register(item.getColour().get(), item.asItem());
            }
        }
    }





}
