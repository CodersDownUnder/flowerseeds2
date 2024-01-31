package flowerseeds.cyclic.server.tags;

import flowerseeds.cyclic.FlowerSeedsCyclic;
import flowerseeds.data.tags.FlowerSeedsBlockTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class CyclicBlockTagProvider extends FlowerSeedsBlockTagsProvider {
    public CyclicBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper, String modid) {
        super(output, lookupProvider, modid, existingFileHelper);
    }

    @Override
    public String getName() {
        return "Flower Seeds 2 Cyclic Block Tag data Provider";
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tagSet(FlowerSeedsCyclic.CYAN_ROSE_SEED.get(),
                FlowerSeedsCyclic.LIME_CARNATION_SEED.get(),
                FlowerSeedsCyclic.PURPLE_TULIP_SEED.get(),
                FlowerSeedsCyclic.ABSALON_TULIP_SEED.get());
    }

}