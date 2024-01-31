package flowerseeds.fabulousflowers.server.tags;

import flowerseeds.data.tags.FlowerSeedsItemTagsProvider;
import flowerseeds.fabulousflowers.FlowerSeedsFabulousFlowers;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredHolder;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

public class FabulousFlowersItemTagProvider extends FlowerSeedsItemTagsProvider {
    public FabulousFlowersItemTagProvider(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_,
                                            CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper, String modid) {
        super(p_275343_, p_275729_, p_275322_, modid, existingFileHelper);
    }

    @Override
    public String getName() {
        return "Flower Seeds 2 Fabulous Flowers Item Tag data Provider";
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        ArrayList<Item> blocks = new ArrayList<Item>();

        for (DeferredHolder<Block, ? extends Block> block : FlowerSeedsFabulousFlowers.BLOCKS.getEntries()) {
            blocks.add(block.get().asItem());
        }

        tagSet(blocks.toArray(new Item[blocks.size()]));
    }

}