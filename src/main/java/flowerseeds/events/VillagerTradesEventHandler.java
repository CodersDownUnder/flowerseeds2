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
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = FlowerSeeds.MODID)
public class VillagerTradesEventHandler {

    //TODO: add villager trades
    @SubscribeEvent
    public static void onVillagerTrades(VillagerTradesEvent pEvent) {
        if (pEvent.getType().equals(VillagerProfession.FARMER)) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = pEvent.getTrades();
            int villagerLevel = 1;

            trades.get(villagerLevel).add((trader, rand) -> addTrade(BlockInit.ALLIUM_SEED.get()));
            trades.get(villagerLevel).add((trader, rand) -> addTrade(BlockInit.AZURE_BLUET_SEED.get()));
            trades.get(villagerLevel).add((trader, rand) -> addTrade(BlockInit.BLUE_ORCHID_SEED.get()));
            trades.get(villagerLevel).add((trader, rand) -> addTrade(BlockInit.DANDELION_SEED.get()));
            trades.get(villagerLevel).add((trader, rand) -> addTrade(BlockInit.CORNFLOWER_SEED.get()));
            trades.get(villagerLevel).add((trader, rand) -> addTrade(BlockInit.LILY_OF_THE_VALLEY_SEED.get()));
            trades.get(villagerLevel).add((trader, rand) -> addTrade(BlockInit.ORANGE_TULIP_SEED.get()));
            trades.get(villagerLevel).add((trader, rand) -> addTrade(BlockInit.OXEYE_DAISY_SEED.get()));
            trades.get(villagerLevel).add((trader, rand) -> addTrade(BlockInit.PINK_TULIP_SEED.get()));
            trades.get(villagerLevel).add((trader, rand) -> addTrade(BlockInit.POPPY_SEED.get()));
            trades.get(villagerLevel).add((trader, rand) -> addTrade(BlockInit.RED_TULIP_SEED.get()));
            trades.get(villagerLevel).add((trader, rand) -> addTrade(BlockInit.WHITE_TULIP_SEED.get()));

            if (Config.allowWitherRoseTrading) {
                trades.get(5).add((trader, rand) -> addTrade(BlockInit.WITHER_ROSE_SEED.get()));
            }


        }
    }

    /**
     * Add default trade of 1 emerald for 1 seed
     * @param seed a seed item
     * @return {@link MerchantOffer}
     */
    protected static MerchantOffer addTrade(ItemLike seed) {
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
    protected static MerchantOffer addTrade(ItemLike seed, int amount) {
        ItemStack stack = new ItemStack(seed, 1);
        int villagerLevel = 1;

        return new MerchantOffer(
                new ItemStack(Items.EMERALD, amount),
                stack,10,8,0.02F);
    }
}
