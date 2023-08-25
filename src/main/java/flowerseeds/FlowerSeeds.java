package flowerseeds;

import com.mojang.logging.LogUtils;
import flowerseeds.init.BlockInit;
import flowerseeds.init.CreativeTabInit;
import flowerseeds.init.ItemInit;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(FlowerSeeds.MODID)
public class FlowerSeeds
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = FlowerSeedsAPI.FLOWERSEEDS_MODID;
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();
    public FlowerSeeds()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        CreativeTabInit.register(modEventBus);

        ItemInit.register(modEventBus);
        BlockInit.register(modEventBus);


        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);

    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
            event.enqueueWork(() -> {
                compostable(BlockInit.DANDELION_SEED.get());
                compostable(BlockInit.ALLIUM_SEED.get());
                compostable(BlockInit.AZURE_BLUET_SEED.get());
                compostable(BlockInit.CORNFLOWER_SEED.get());
                compostable(BlockInit.BLUE_ORCHID_SEED.get());
                compostable(BlockInit.LILY_OF_THE_VALLEY_SEED.get());
                compostable(BlockInit.ORANGE_TULIP_SEED.get());
                compostable(BlockInit.PINK_TULIP_SEED.get());
                compostable(BlockInit.POPPY_SEED.get());
                compostable(BlockInit.RED_TULIP_SEED.get());
                compostable(BlockInit.OXEYE_DAISY_SEED.get());
                compostable(BlockInit.WHITE_TULIP_SEED.get());
                compostable(BlockInit.WITHER_ROSE_SEED.get());

            });
    }

    public static void compostable(Block block) {
        ComposterBlock.COMPOSTABLES.put(block.asItem(), 0.3f);
    }


}
