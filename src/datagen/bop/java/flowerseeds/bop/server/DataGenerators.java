package flowerseeds.bop.server;

import flowerseeds.bop.FlowerSeedsBop;
import flowerseeds.bop.client.lang.EN_US;
import flowerseeds.bop.client.models.BopBlockStateProvider;
import flowerseeds.bop.client.models.BopItemModelProvider;
import flowerseeds.bop.server.compat.BopCompatDataProvider;
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
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.metadata.pack.PackMetadataSection;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Arrays;
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
                .add(PackMetadataSection.TYPE, new PackMetadataSection(
                        Component.translatable("text.packmeta.description"),
                        DetectedVersion.BUILT_IN.getPackVersion(PackType.CLIENT_RESOURCES),
                        Arrays.stream(PackType.values()).collect(Collectors.toMap(Function.identity(), DetectedVersion.BUILT_IN::getPackVersion))
                ))
        );
        generator.addProvider(event.includeClient(), new EN_US(packOutput, MODID));
        generator.addProvider(event.includeServer(), new BopRecipeProvider(packOutput));
        generator.addProvider(event.includeServer(), BopLootTableProvider.create(packOutput));

        generator.addProvider(event.includeClient(), new BopBlockStateProvider(packOutput, MODID, existingFileHelper));
        generator.addProvider(event.includeClient(), new BopItemModelProvider(packOutput, MODID, existingFileHelper));

        BopBlockTagProvider blockTagGenerator = generator.addProvider(event.includeServer(),
               new BopBlockTagProvider(packOutput, lookupProvider, existingFileHelper, MODID));
        generator.addProvider(event.includeServer(), new BopItemTagProvider(packOutput, lookupProvider, blockTagGenerator.contentsGetter(), existingFileHelper, MODID));

        generator.addProvider(event.includeServer(), new BopCompatDataProvider(MODID, event));
        new BopCompatDataProvider(MODID, event);
    }
}