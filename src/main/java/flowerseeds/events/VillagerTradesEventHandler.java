package flowerseeds.events;

import flowerseeds.Config;
import flowerseeds.FlowerSeeds;
import flowerseeds.init.BlockInit;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

@Mod.EventBusSubscriber(modid = FlowerSeeds.MODID)
public class VillagerTradesEventHandler {

    @SubscribeEvent
    public static void onVillagerTrades(VillagerTradesEvent pEvent) {
        if (pEvent.getType().equals(VillagerProfession.FARMER)) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = pEvent.getTrades();
            int villagerLevel = 1;

            for (RegistryObject<Block> block : BlockInit.BLOCKS.getEntries()) {
                trades.get(villagerLevel).add((trader, rand) -> addTrade(block.get()));
            }

            if (Config.allowWitherRoseTrading) {
                trades.get(Config.witherRoseTradeLevel).add((trader, rand) -> addTrade(BlockInit.WITHER_ROSE_SEED.get()));
            }
        }

        if (pEvent.getType().equals(VillagerProfession.CLERIC)) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = pEvent.getTrades();

            if (Config.allowWitherRoseTradingCleric) {
                trades.get(Config.witherRoseTradeLevelCleric).add((trader, rand) -> addTrade(BlockInit.WITHER_ROSE_SEED.get()));
            }
        }
    }

    /**
     * Add default trade of 1 emerald for 1 seed
     * @param seed a seed item
     * @return {@link MerchantOffer}
     */
    public static MerchantOffer addTrade(ItemLike seed) {
        ItemStack stack = new ItemStack(seed, 1);


        return new MerchantOffer(
                new ItemStack(Items.EMERALD, 1),
                stack,10,8,0.02F);
    }

    /**
     * Add trade for x number of emeralds for 1 seed
     * @param seed a seed item
     * @param amount amount of emeralds for trade
     * @return {@link MerchantOffer}
     */
    public static MerchantOffer addTrade(ItemLike seed, int amount) {
        ItemStack stack = new ItemStack(seed, 1);
        int villagerLevel = 1;

        return new MerchantOffer(
                new ItemStack(Items.EMERALD, amount),
                stack,10,8,0.02F);
    }
}
