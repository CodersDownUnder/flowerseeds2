package flowerseeds.fabulousflowers.server.tags;

import flowerseeds.data.tags.FlowerSeedsBlockTagsProvider;
import flowerseeds.fabulousflowers.FlowerSeedsFabulousFlowers;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

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

        for (RegistryObject<Block> block : FlowerSeedsFabulousFlowers.BLOCKS.getEntries()) {
            blocks.add(block.get());
        }

        tagSet(blocks.toArray(new Block[blocks.size()]));
    }

}