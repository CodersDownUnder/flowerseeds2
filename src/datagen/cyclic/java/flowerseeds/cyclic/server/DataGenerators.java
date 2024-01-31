package flowerseeds.cyclic.server;

import flowerseeds.cyclic.FlowerSeedsCyclic;
import flowerseeds.cyclic.client.lang.EN_US;
import flowerseeds.cyclic.client.models.CyclicBlockStateProvider;
import flowerseeds.cyclic.client.models.CyclicItemModelProvider;
import flowerseeds.cyclic.server.loot.CyclicLootTableProvider;
import flowerseeds.cyclic.server.recipes.CyclicRecipeProvider;
import flowerseeds.cyclic.server.tags.CyclicBlockTagProvider;
import flowerseeds.cyclic.server.tags.CyclicItemTagProvider;
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
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.stream.Collectors;

@Mod.EventBusSubscriber(modid = DataGenerators.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    public static final String MODID = FlowerSeedsCyclic.MODID;

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(true, new PackMetadataGenerator(packOutput)
                .add(OverlayMetadataSection.TYPE, new OverlayMetadataSection(List.of(
                        new OverlayMetadataSection.OverlayEntry(new InclusiveRange<>(0, Integer.MAX_VALUE), "pack_overlays_test"))))
                .add(PackMetadataSection.TYPE, new PackMetadataSection(
                        Component.translatable("flowerseeds.packmeta.description"),
                        DetectedVersion.BUILT_IN.getPackVersion(PackType.CLIENT_RESOURCES),
                        Optional.of(new InclusiveRange<>(0, Integer.MAX_VALUE)))));

        generator.addProvider(event.includeClient(), new EN_US(packOutput, MODID));

        ItemModelProvider itemModels = new CyclicItemModelProvider(packOutput, MODID, event.getExistingFileHelper());
        generator.addProvider(event.includeClient(), itemModels);
        generator.addProvider(event.includeClient(), new CyclicBlockStateProvider(packOutput, MODID, itemModels.existingFileHelper));

        generator.addProvider(event.includeServer(), CyclicLootTableProvider.create(packOutput));
        generator.addProvider(event.includeServer(), new CyclicRecipeProvider(packOutput));

        CyclicBlockTagProvider blockTagGenerator = generator.addProvider(event.includeServer(),
                new CyclicBlockTagProvider(packOutput, lookupProvider, existingFileHelper, MODID));
        generator.addProvider(event.includeServer(), new CyclicItemTagProvider(packOutput, lookupProvider, blockTagGenerator.contentsGetter(), existingFileHelper, MODID));
    }
}