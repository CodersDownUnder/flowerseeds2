package flowerseeds.init;

import flowerseeds.FlowerSeeds;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CreativeTabInit {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FlowerSeeds.MODID);

    public static final RegistryObject<CreativeModeTab> FLOWER_SEEDS_TAB = CREATIVE_MODE_TABS.register("flower_seeds_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(BlockInit.DANDELION_SEED.get()))
                    .title(Component.translatable("flowerseeds.creativetab.name"))
                    .withSearchBar()
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(BlockInit.DANDELION_SEED.get());
                        pOutput.accept(BlockInit.ALLIUM_SEED.get());
                        pOutput.accept(BlockInit.AZURE_BLUET_SEED.get());
                        pOutput.accept(BlockInit.CORNFLOWER_SEED.get());
                        pOutput.accept(BlockInit.BLUE_ORCHID_SEED.get());
                        pOutput.accept(BlockInit.LILY_OF_THE_VALLEY_SEED.get());
                        pOutput.accept(BlockInit.ORANGE_TULIP_SEED.get());
                        pOutput.accept(BlockInit.PINK_TULIP_SEED.get());
                        pOutput.accept(BlockInit.POPPY_SEED.get());
                        pOutput.accept(BlockInit.RED_TULIP_SEED.get());
                        pOutput.accept(BlockInit.OXEYE_DAISY_SEED.get());
                        pOutput.accept(BlockInit.WHITE_TULIP_SEED.get());
                        pOutput.accept(BlockInit.WITHER_ROSE_SEED.get());

                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
