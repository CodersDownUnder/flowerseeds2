package flowerseeds.server;

import flowerseeds.FlowerSeeds;
import flowerseeds.FlowerSeedsAPI;
import flowerseeds.client.lang.EN_US;
import flowerseeds.client.models.MainBlockStateProvider;
import flowerseeds.client.models.MainItemModelProvider;
import flowerseeds.server.compat.MainCompatDataProvider;
import flowerseeds.server.loot.MainLootTableProvider;
import flowerseeds.server.recipes.MainRecipeProvider;
import flowerseeds.server.tags.MainBlockTagProvider;
import flowerseeds.server.tags.MainItemTagProvider;
import net.minecraft.DetectedVersion;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.metadata.PackMetadataGenerator;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.metadata.pack.PackMetadataSection;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.stream.Collectors;

@Mod.EventBusSubscriber(modid = FlowerSeeds.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    private static final String MODID = FlowerSeedsAPI.FLOWERSEEDS_MODID;

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(true, new PackMetadataGenerator(packOutput)
                .add(PackMetadataSection.TYPE, new PackMetadataSection(
                        Component.translatable("text.packmeta.description"),
                        DetectedVersion.BUILT_IN.getPackVersion(PackType.CLIENT_RESOURCES),
                        Arrays.stream(PackType.values()).collect(Collectors.toMap(Function.identity(), DetectedVersion.BUILT_IN::getPackVersion))
                ))
        );
        generator.addProvider(event.includeClient(), new EN_US(packOutput));

        ItemModelProvider itemModels = new MainItemModelProvider(packOutput, MODID, event.getExistingFileHelper());
        generator.addProvider(event.includeClient(), itemModels);
        generator.addProvider(event.includeClient(), new MainBlockStateProvider(packOutput, MODID, itemModels.existingFileHelper));

        generator.addProvider(event.includeServer(), MainLootTableProvider.create(packOutput));
        generator.addProvider(event.includeServer(), new MainRecipeProvider(packOutput));

        MainBlockTagProvider blockTagGenerator = generator.addProvider(event.includeServer(),
                new MainBlockTagProvider(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new MainItemTagProvider(packOutput, lookupProvider, blockTagGenerator.contentsGetter(), existingFileHelper));

        generator.addProvider(event.includeServer(), new MainCompatDataProvider(MODID, event));
        new MainCompatDataProvider(MODID, event);
    }
}