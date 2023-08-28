package flowerseeds.bop.client.models;

import biomesoplenty.api.block.BOPBlocks;
import biomesoplenty.init.ModBlocks;
import fabulousflowers.init.FabulousFlowersModBlocks;
import flowerseeds.bop.FlowerSeedsBop;
import flowerseeds.client.models.MainBlockStateProvider;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BopBlockStateProvider extends MainBlockStateProvider {
    public BopBlockStateProvider(PackOutput output, String MODID, ExistingFileHelper exFileHelper) {
        super(output, MODID, exFileHelper);
    }

    @Override
    public String getName() {
        return "Flower Seeds 2 Biomes O Plenty BlockState Provider";
    }

    
    @Override
    protected void registerStatesAndModels() {

        flowerModelCompat(FlowerSeedsBop.ROSE_SEED.get(), "block/rose", "rose", "biomesoplenty", BOPBlocks.ROSE.get());
        flowerModelCompat(FlowerSeedsBop.WILD_FLOWER_SEED.get(), "block/wildflower", "wildflower", "biomesoplenty", BOPBlocks.WILDFLOWER.get());
        flowerModelCompat(FlowerSeedsBop.ORANGE_COSMOS_SEED.get(), "block/orange_cosmos", "orange_cosmos", "biomesoplenty", BOPBlocks.ORANGE_COSMOS.get());
        flowerModelCompat(FlowerSeedsBop.PINK_DAFFODIL_SEED.get(), "block/pink_daffodil", "pink_daffodil", "biomesoplenty", BOPBlocks.PINK_DAFFODIL.get());
        flowerModelCompat(FlowerSeedsBop.GLOW_FLOWER_SEED.get(), "block/glowflower", "glowflower", "biomesoplenty", BOPBlocks.GLOWFLOWER.get());
        flowerModelCompat(FlowerSeedsBop.WILTED_LILY_SEED.get(), "block/wilted_lily", "wilted_lily", "biomesoplenty", BOPBlocks.WILTED_LILY.get());
        flowerModelCompat(FlowerSeedsBop.BURNING_BLOSSOM_SEED.get(), "block/burning_blossom", "burning_blossom", "biomesoplenty", BOPBlocks.BURNING_BLOSSOM.get());
    }



}