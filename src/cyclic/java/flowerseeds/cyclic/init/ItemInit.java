package flowerseeds.cyclic.init;

import flowerseeds.cyclic.FlowerSeedsCyclic;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class ItemInit {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FlowerSeedsCyclic.MODID);

//    public static final RegistryObject<Item> flowerseed = ITEMS.register("flowerseed",
//            () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
