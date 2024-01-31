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

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.slf4j.Logger;

import java.util.List;
import java.util.function.Supplier;

// The value here should match an entry in the META-INF/mods.toml file
@ Mod(FlowerSeedsFabulousFlowers.MODID)
public class FlowerSeedsFabulousFlowers
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "flowerseedsfabulousflowers";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "examplemod" namespace

    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(MODID);

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);

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

    public static final DeferredBlock<Block> BLOOMED_DANDELION_SEED = registerBlock("bloomed_dandelion_seed",
            () -> new CustomCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT).sound(SoundType.CROP),
                    SeedColour.WHITE));

    public static final DeferredBlock<Block> ORANGE_POPPY_SEED = registerBlock("orange_poppy_seed",
            () -> new CustomCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT).sound(SoundType.CROP),
                    SeedColour.ORANGE));

    public static final DeferredBlock<Block> WHITE_POPPY_SEED = registerBlock("white_poppy_seed",
            () -> new CustomCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT).sound(SoundType.CROP),
                    SeedColour.LIGHT_GREY));

    public static final DeferredBlock<Block> YELLOW_POPPY_SEED = registerBlock("yellow_poppy_seed",
            () -> new CustomCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT).sound(SoundType.CROP),
                    SeedColour.YELLOW));

    public static final DeferredBlock<Block> PINK_POPPY_SEED = registerBlock("pink_poppy_seed",
            () -> new CustomCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT).sound(SoundType.CROP),
                    SeedColour.PINK));

    public static final DeferredBlock<Block> YELLOW_ORCHID_SEED = registerBlock("yellow_orchid_seed",
                () -> new CustomCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT).sound(SoundType.CROP),
                        SeedColour.YELLOW));
    
    public static final DeferredBlock<Block> WHITE_ORCHID_SEED = registerBlock("white_orchid_seed",
                () -> new CustomCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT).sound(SoundType.CROP),
                        SeedColour.LIGHT_GREY));
    
    public static final DeferredBlock<Block> PINK_ORCHID_SEED = registerBlock("pink_orchid_seed",
                () -> new CustomCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT).sound(SoundType.CROP),
                        SeedColour.PINK));
    
    public static final DeferredBlock<Block> PURPLE_ORCHID_SEED = registerBlock("purple_orchid_seed",
                () -> new CustomCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT).sound(SoundType.CROP),
                        SeedColour.PURPLE));
    
    public static final DeferredBlock<Block> BLUE_ALLIUM_SEED = registerBlock("blue_allium_seed",
                () -> new CustomCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT).sound(SoundType.CROP),
                        SeedColour.BLUE));
    
    public static final DeferredBlock<Block> WHITE_ALLIUM_SEED = registerBlock("white_allium_seed",
                () -> new CustomCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT).sound(SoundType.CROP),
                        SeedColour.WHITE));
    
    public static final DeferredBlock<Block> YELLOW_TULIP_SEED = registerBlock("yellow_tulip_seed",
                () -> new CustomCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT).sound(SoundType.CROP),
                        SeedColour.YELLOW));
    
    public static final DeferredBlock<Block> PURPLE_TULIP_SEED = registerBlock("purple_tulip_seed",
                () -> new CustomCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT).sound(SoundType.CROP),
                        SeedColour.PURPLE));
    
    public static final DeferredBlock<Block> BLUE_TULIP_SEED = registerBlock("blue_tulip_seed",
                () -> new CustomCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT).sound(SoundType.CROP),
                        SeedColour.BLUE));
    
    public static final DeferredBlock<Block> BLACK_TULIP_SEED = registerBlock("black_tulip_seed",
                () -> new CustomCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT).sound(SoundType.CROP),
                        SeedColour.BLACK));
    
    public static final DeferredBlock<Block> ASTER_DAISY_SEED = registerBlock("aster_daisy_seed",
                () -> new CustomCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT).sound(SoundType.CROP),
                        SeedColour.PURPLE));
    
    public static final DeferredBlock<Block> GLORIOSA_DAISY_SEED = registerBlock("gloriosa_daisy_seed",
                () -> new CustomCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT).sound(SoundType.CROP),
                        SeedColour.ORANGE));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ITEMS.register(name, () -> new ItemNameBlockItem(block.get(), new Item.Properties()));
    }

    public FlowerSeedsFabulousFlowers(IEventBus modEventBus)
    {

        ITEMS.register(modEventBus);
        BLOCKS.register(modEventBus);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        modEventBus.addListener(this::addCreative);

        // Register ourselves for server and other game events we are interested in
        //NeoForge.EVENT_BUS.register(this);

    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> {
            for (DeferredHolder<Block, ? extends Block> block : BLOCKS.getEntries()) {
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

                for (DeferredHolder<Block, ? extends Block> block : BLOCKS.getEntries()) {
                    trades.get(villagerLevel).add((trader, rand) -> VillagerTradesEventHandler.addTrade(block.get()));
                }
            }
        }
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void registerItemColor(RegisterColorHandlersEvent.Item event) {
            for (DeferredHolder<Block, ? extends Block> block : BLOCKS.getEntries()) {
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
            for (DeferredHolder<Block, ? extends Block> block : BLOCKS.getEntries()) {
                event.accept(block.get().asItem());
            }

        }
    }


}
