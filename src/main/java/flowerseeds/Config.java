package flowerseeds;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber(modid = FlowerSeeds.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config
{
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    private static final ForgeConfigSpec.BooleanValue WITHER_ROSE_TRADING = BUILDER
            .comment("Allow Wither Rose seeds to be obtainable from Farmers?")
            .define("witherrosetrading", false);

    private static final ForgeConfigSpec.IntValue WITHER_ROSE_TRADE_LEVEL = BUILDER
            .comment("Wither Rose Farmer Trade Level")
            .defineInRange("witherrosettradelevel", 5, 1, 5);

    private static final ForgeConfigSpec.BooleanValue WITHER_ROSE_TRADING_CLERIC = BUILDER
            .comment("Allow Wither Rose seeds to be obtainable from master Clerics?")
            .define("witherrosetradingcleric", false);

    private static final ForgeConfigSpec.IntValue WITHER_ROSE_TRADE_LEVEL_CLERIC = BUILDER
            .comment("Wither Rose Cleric Trade Level")
            .defineInRange("witherrosettradelevelcleric", 5, 1, 5);

    static final ForgeConfigSpec SPEC = BUILDER.build();

    public static boolean allowWitherRoseTrading;
    public static boolean allowWitherRoseTradingCleric;

    public static int witherRoseTradeLevel;
    public static int witherRoseTradeLevelCleric;


    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        allowWitherRoseTrading = WITHER_ROSE_TRADING.get();
        allowWitherRoseTradingCleric = WITHER_ROSE_TRADING_CLERIC.get();

        witherRoseTradeLevel = WITHER_ROSE_TRADE_LEVEL.get();
        witherRoseTradeLevelCleric = WITHER_ROSE_TRADE_LEVEL_CLERIC.get();

    }
}