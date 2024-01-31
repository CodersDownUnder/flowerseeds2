package flowerseeds.bop.server;

import flowerseeds.bop.FlowerSeedsBop;
import flowerseeds.bop.client.lang.EN_US;
import flowerseeds.bop.client.models.BopBlockStateProvider;
import flowerseeds.bop.client.models.BopItemModelProvider;
import flowerseeds.bop.server.loot.BopLootTableProvider;
import flowerseeds.bop.server.recipes.BopRecipeProvider;
import flowerseeds.bop.server.tags.BopBlockTagProvider;
import flowerseeds.bop.server.tags.BopItemTagProvider;
import net.minecraft.DetectedVersion;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.metadata.PackMetadataGenerator;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.OverlayMetadataSection;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.metadata.pack.PackMetadataSection;
import net.minecraft.util.InclusiveRange;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.datamaps.builtin.Compostable;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.stream.Collectors;

@Mod.EventBusSubscriber(modid = FlowerSeedsBop.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        String MODID = FlowerSeedsBop.MODID;

        generator.addProvider(true, new PackMetadataGenerator(packOutput)
                .add(OverlayMetadataSection.TYPE, new OverlayMetadataSection(List.of(
                        new OverlayMetadataSection.OverlayEntry(new InclusiveRange<>(0, Integer.MAX_VALUE), "pack_overlays_test"))))
                .add(PackMetadataSection.TYPE, new PackMetadataSection(
                        Component.translatable("flowerseedsbop.packmeta.description"),
                        DetectedVersion.BUILT_IN.getPackVersion(PackType.CLIENT_RESOURCES),
                        Optional.of(new InclusiveRange<>(0, Integer.MAX_VALUE)))));

        generator.addProvider(event.includeClient(), new EN_US(packOutput, MODID));
        generator.addProvider(event.includeServer(), new BopRecipeProvider(packOutput));
        generator.addProvider(event.includeServer(), BopLootTableProvider.create(packOutput));

        generator.addProvider(event.includeClient(), new BopBlockStateProvider(packOutput, MODID, existingFileHelper));
        generator.addProvider(event.includeClient(), new BopItemModelProvider(packOutput, MODID, existingFileHelper));

        BopBlockTagProvider blockTagGenerator = generator.addProvider(event.includeServer(),
                new BopBlockTagProvider(packOutput, lookupProvider, existingFileHelper, MODID));
        generator.addProvider(event.includeServer(), new BopItemTagProvider(packOutput, lookupProvider, blockTagGenerator.contentsGetter(), existingFileHelper, MODID));

//        generator.addProvider(event.includeServer(), new BopCompatDataProvider(MODID, event));
//        new BopCompatDataProvider(MODID, event);
        generator.addProvider(event.includeServer(), new CompostablesGen(packOutput, lookupProvider));


    }
}

class CompostablesGen extends DataMapProvider {

    public CompostablesGen(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather() {
        var compostables = builder(NeoForgeDataMaps.COMPOSTABLES);
        // Always give entities that drop any item in the minecraft:fox_food tag 12 hearts
        for (DeferredHolder<Block, ? extends Block> block: FlowerSeedsBop.BLOCKS.getEntries()) {
            compostables.add(block.get().asItem().builtInRegistryHolder(), new Compostable(0.3f), false);
        }
        // Have a 10% chance of healing entities that drop an acacia boat by one point

    }
}