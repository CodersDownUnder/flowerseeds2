package flowerseeds.fabulousflowers.server.tags;

import flowerseeds.data.tags.FlowerSeedsBlockTagsProvider;
import flowerseeds.fabulousflowers.FlowerSeedsFabulousFlowers;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredHolder;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

public class FabulousFlowersBlockTagProvider extends FlowerSeedsBlockTagsProvider {
    public FabulousFlowersBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper, String modid) {
        super(output, lookupProvider, modid, existingFileHelper);
    }

    @Override
    public String getName() {
        return "Flower Seeds 2 Fabulous Flowers Block Tag data Provider";
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {

        ArrayList<Block> blocks = new ArrayList<Block>();

        for (DeferredHolder<Block, ? extends Block> block : FlowerSeedsFabulousFlowers.BLOCKS.getEntries()) {
            blocks.add(block.get());
        }

        tagSet(blocks.toArray(new Block[blocks.size()]));
    }

}