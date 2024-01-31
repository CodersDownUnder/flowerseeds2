package flowerseeds.roses.server;

import flowerseeds.roses.FlowerSeedsRoses;
import flowerseeds.roses.client.lang.EN_US;
import flowerseeds.roses.client.models.RosesBlockStateProvider;
import flowerseeds.roses.client.models.RosesItemModelProvider;
import flowerseeds.roses.server.loot.RoseLootTableProvider;
import flowerseeds.roses.server.recipes.RosesRecipeProvider;
import flowerseeds.roses.server.tags.RosesBlockTagProvider;
import flowerseeds.roses.server.tags.RosesItemTagProvider;
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

import static flowerseeds.roses.server.DataGenerators.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    public static final String MODID = FlowerSeedsRoses.MODID;

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

        ItemModelProvider itemModels = new RosesItemModelProvider(packOutput, MODID, event.getExistingFileHelper());
        generator.addProvider(event.includeClient(), itemModels);
        generator.addProvider(event.includeClient(), new RosesBlockStateProvider(packOutput, MODID, itemModels.existingFileHelper));

        generator.addProvider(event.includeServer(), RoseLootTableProvider.create(packOutput));
        generator.addProvider(event.includeServer(), new RosesRecipeProvider(packOutput));

        RosesBlockTagProvider blockTagGenerator = generator.addProvider(event.includeServer(),
                new RosesBlockTagProvider(packOutput, lookupProvider, existingFileHelper, MODID));
        generator.addProvider(event.includeServer(), new RosesItemTagProvider(packOutput, lookupProvider, blockTagGenerator.contentsGetter(), existingFileHelper, MODID));

    }
}