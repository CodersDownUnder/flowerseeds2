package flowerseeds.cyclic.server.tags;

import flowerseeds.cyclic.FlowerSeedsCyclic;
import flowerseeds.data.tags.FlowerSeedsItemTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class CyclicItemTagProvider extends FlowerSeedsItemTagsProvider {
    public CyclicItemTagProvider(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_,
                                    CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper, String modid) {
        super(p_275343_, p_275729_, p_275322_, modid, existingFileHelper);
    }

    @Override
    public String getName() {
        return "Flower Seeds 2 Roses Item Tag data Provider";
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tagSet(FlowerSeedsCyclic.CYAN_ROSE_SEED.get().asItem(),
                FlowerSeedsCyclic.LIME_CARNATION_SEED.get().asItem(),
                FlowerSeedsCyclic.PURPLE_TULIP_SEED.get().asItem(),
                FlowerSeedsCyclic.ABSALON_TULIP_SEED.get().asItem());
    }

}