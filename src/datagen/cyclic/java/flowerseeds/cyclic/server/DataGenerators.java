package flowerseeds.cyclic.server;

import flowerseeds.cyclic.FlowerSeedsCyclic;
import flowerseeds.client.lang.EN_US;
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

@Mod.EventBusSubscriber(modid = FlowerSeedsCyclic.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
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
        //generator.addProvider(event.includeServer(), new ModRecipeProvider(packOutput));
        //generator.addProvider(event.includeServer(), ModLootTableProvider.create(packOutput));

        //generator.addProvider(event.includeClient(), new ModBlockStateProvider(packOutput, existingFileHelper));
        //generator.addProvider(event.includeClient(), new ModItemModelProvider(packOutput, existingFileHelper));

        //ModBlockTagGenerator blockTagGenerator = generator.addProvider(event.includeServer(),
        //        new ModBlockTagGenerator(packOutput, lookupProvider, existingFileHelper));
        //generator.addProvider(event.includeServer(), new ModItemTagGenerator(packOutput, lookupProvider, blockTagGenerator.contentsGetter(), existingFileHelper));
    }
}