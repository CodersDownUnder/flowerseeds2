package flowerseeds.cyclic;

import com.mojang.logging.LogUtils;
import flowerseeds.FlowerSeeds;
import flowerseeds.blocks.CustomCropBlock;
import flowerseeds.events.SeedColour;
import flowerseeds.events.VillagerTradesEventHandler;
import flowerseeds.init.CreativeTabInit;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

import java.util.List;
import java.util.function.Supplier;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(FlowerSeedsCyclic.MODID)
public class FlowerSeedsCyclic
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "flowerseedscyclic";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "examplemod" namespace

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static final RegistryObject<Block> CYAN_ROSE_SEED = registerBlock("cyan_rose_seed",
            () -> new CustomCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).sound(SoundType.CROP), SeedColour.CYAN.get()));

    public static final RegistryObject<Block> PURPLE_TULIP_SEED = registerBlock("purple_tulip_seed",
            () -> new CustomCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).sound(SoundType.CROP), SeedColour.PURPLE.get()));

    public static final RegistryObject<Block> LIME_CARNATION_SEED = registerBlock("lime_carnation_seed",
            () -> new CustomCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).sound(SoundType.CROP), SeedColour.LIME.get()));

    public static final RegistryObject<Block> ABSALON_TULIP_SEED = registerBlock("absalon_tulip_seed",
            () -> new CustomCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).sound(SoundType.CROP), SeedColour.BROWN.get()));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
       ITEMS.register(name, () -> new ItemNameBlockItem(block.get(), new Item.Properties()));
    }

    public FlowerSeedsCyclic()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ITEMS.register(modEventBus);
        BLOCKS.register(modEventBus);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        modEventBus.addListener(this::addCreative);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> {
            for (RegistryObject<Block> block : BLOCKS.getEntries()) {
                FlowerSeeds.compostable(block.get());
            }

        });

    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class VillagerEventHandler {
        @SubscribeEvent
        public static void onVillagerTrades(VillagerTradesEvent pEvent) {
            if (pEvent.getType().equals(VillagerProfession.FARMER)) {
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = pEvent.getTrades();
                int villagerLevel = 1;

                for (RegistryObject<Block> block : BLOCKS.getEntries()) {
                    trades.get(villagerLevel).add((trader, rand) -> VillagerTradesEventHandler.addTrade(block.get()));
                }
            }
        }
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void registerItemColor(RegisterColorHandlersEvent.Item event) {
            for (RegistryObject<Block> block : BLOCKS.getEntries()) {
                CustomCropBlock item = (CustomCropBlock) block.get();
                event.register(item.getColour(), item.asItem());
            }
        }
    }


    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if (event.getTabKey() == CreativeTabInit.FLOWER_SEEDS_TAB.getKey()) {
            for (RegistryObject<Block> block : BLOCKS.getEntries()) {
                event.accept(block.get().asItem());
            }
        }
    }


}
