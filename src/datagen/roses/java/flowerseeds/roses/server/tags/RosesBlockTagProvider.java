package flowerseeds.roses.server.tags;

import flowerseeds.data.tags.FlowerSeedsBlockTagsProvider;

import flowerseeds.roses.init.BlockInit;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class RosesBlockTagProvider extends FlowerSeedsBlockTagsProvider {
    public RosesBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper, String modid) {
        super(output, lookupProvider, modid, existingFileHelper);
    }

    @Override
    public String getName() {
        return "Flower Seeds 2 Roses Block Tag data Provider";
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tagSet(BlockInit.ROSE_SEED.get(), BlockInit.CYAN_FLOWER_SEED.get());
    }

}