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
            .comment("Allow Wither Rose seeds to be obtainable from master farmers?")
            .define("witherrosetrading", false);

    static final ForgeConfigSpec SPEC = BUILDER.build();

    public static boolean allowWitherRoseTrading;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        allowWitherRoseTrading = WITHER_ROSE_TRADING.get();
    }
}