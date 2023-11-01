package flowerseeds.fabulousflowers;

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
@Mod(FlowerSeedsFabulousFlowers.MODID)
public class FlowerSeedsFabulousFlowers
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "flowerseedsfabulousflowers";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "examplemod" namespace

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    /* Flowers to add
    Bloomed Dandelion -> white
    Orange Poppy -> Orange
    White Poppy -> Light Grey
    Yellow Poppy -> Yellow
    Pink Poppy -> Pink
    Yellow Orchid -> Yellow
    White Orchid -> Light Grey
    Pink Orchid -> Pink
    Purple Orchid -> Purple
    Blue Allium -> Blue
    White Allium -> White
    Yellow Tulip -> Yellow
    Purple Tulip -> Purple
    Blue Tulip -> Blue
    Black Tulip -> Black
    Aster Daisy -> Purple
    Gloriosa Daisy -> Orange
     */

    public static final RegistryObject<Block> BLOOMED_DANDELION_SEED = registerBlock("bloomed_dandelion_seed",
            () -> new CustomCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).sound(SoundType.CROP),
                    SeedColour.WHITE));

    public static final RegistryObject<Block> ORANGE_POPPY_SEED = registerBlock("orange_poppy_seed",
            () -> new CustomCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).sound(SoundType.CROP),
                    SeedColour.ORANGE));

    public static final RegistryObject<Block> WHITE_POPPY_SEED = registerBlock("white_poppy_seed",
            () -> new CustomCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).sound(SoundType.CROP),
                    SeedColour.LIGHT_GREY));

    public static final RegistryObject<Block> YELLOW_POPPY_SEED = registerBlock("yellow_poppy_seed",
            () -> new CustomCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).sound(SoundType.CROP),
                    SeedColour.YELLOW));

    public static final RegistryObject<Block> PINK_POPPY_SEED = registerBlock("pink_poppy_seed",
            () -> new CustomCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).sound(SoundType.CROP),
                    SeedColour.PINK));

    public static final RegistryObject<Block> YELLOW_ORCHID_SEED = registerBlock("yellow_orchid_seed",
                () -> new CustomCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).sound(SoundType.CROP),
                        SeedColour.YELLOW));
    
    public static final RegistryObject<Block> WHITE_ORCHID_SEED = registerBlock("white_orchid_seed",
                () -> new CustomCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).sound(SoundType.CROP),
                        SeedColour.LIGHT_GREY));
    
    public static final RegistryObject<Block> PINK_ORCHID_SEED = registerBlock("pink_orchid_seed",
                () -> new CustomCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).sound(SoundType.CROP),
                        SeedColour.PINK));
    
    public static final RegistryObject<Block> PURPLE_ORCHID_SEED = registerBlock("purple_orchid_seed",
                () -> new CustomCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).sound(SoundType.CROP),
                        SeedColour.PURPLE));
    
    public static final RegistryObject<Block> BLUE_ALLIUM_SEED = registerBlock("blue_allium_seed",
                () -> new CustomCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).sound(SoundType.CROP),
                        SeedColour.BLUE));
    
    public static final RegistryObject<Block> WHITE_ALLIUM_SEED = registerBlock("white_allium_seed",
                () -> new CustomCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).sound(SoundType.CROP),
                        SeedColour.WHITE));
    
    public static final RegistryObject<Block> YELLOW_TULIP_SEED = registerBlock("yellow_tulip_seed",
                () -> new CustomCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).sound(SoundType.CROP),
                        SeedColour.YELLOW));
    
    public static final RegistryObject<Block> PURPLE_TULIP_SEED = registerBlock("purple_tulip_seed",
                () -> new CustomCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).sound(SoundType.CROP),
                        SeedColour.PURPLE));
    
    public static final RegistryObject<Block> BLUE_TULIP_SEED = registerBlock("blue_tulip_seed",
                () -> new CustomCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).sound(SoundType.CROP),
                        SeedColour.BLUE));
    
    public static final RegistryObject<Block> BLACK_TULIP_SEED = registerBlock("black_tulip_seed",
                () -> new CustomCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).sound(SoundType.CROP),
                        SeedColour.BLACK));
    
    public static final RegistryObject<Block> ASTER_DAISY_SEED = registerBlock("aster_daisy_seed",
                () -> new CustomCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).sound(SoundType.CROP),
                        SeedColour.PURPLE));
    
    public static final RegistryObject<Block> GLORIOSA_DAISY_SEED = registerBlock("gloriosa_daisy_seed",
                () -> new CustomCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).sound(SoundType.CROP),
                        SeedColour.ORANGE));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
       ITEMS.register(name, () -> new ItemNameBlockItem(block.get(), new Item.Properties()));
    }

    public FlowerSeedsFabulousFlowers()
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
//            FlowerSeeds.compostable(CYAN_ROSE_SEED.get());
//            FlowerSeeds.compostable(ABSALON_TULIP_SEED.get());
//            FlowerSeeds.compostable(LIME_CARNATION_SEED.get());
//            FlowerSeeds.compostable(PURPLE_TULIP_SEED.get());
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
                event.register(item.getColour().get(), item.asItem());
            }
//            event.register(SeedColour.CYAN.get(), CYAN_ROSE_SEED.get());
//            event.register(SeedColour.LIME.get(), LIME_CARNATION_SEED.get());
//            event.register(SeedColour.PURPLE.get(), PURPLE_TULIP_SEED.get());
//            event.register(SeedColour.BROWN.get(), ABSALON_TULIP_SEED.get());
        }
    }


    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if (event.getTabKey() == CreativeTabInit.FLOWER_SEEDS_TAB.getKey()) {
            for (RegistryObject<Block> block : BLOCKS.getEntries()) {
                event.accept(block.get().asItem());
            }
//            event.accept(CYAN_ROSE_SEED.get().asItem());
//            event.accept(ABSALON_TULIP_SEED.get().asItem());
//            event.accept(LIME_CARNATION_SEED.get().asItem());
//            event.accept(PURPLE_TULIP_SEED.get().asItem());

        }
    }


}
