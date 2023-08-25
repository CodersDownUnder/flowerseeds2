package flowerseeds.roses.client.models;

import flowerseeds.client.models.MainBlockStateProvider;
import flowerseeds.roses.init.BlockInit;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.ModList;
import willatendo.roses.server.block.RosesBlocks;

public class RosesBlockStateProvider extends MainBlockStateProvider {
    public RosesBlockStateProvider(PackOutput output, String MODID, ExistingFileHelper exFileHelper) {
        super(output, MODID, exFileHelper);
    }

    @Override
    public String getName() {
        return "Flower Seeds 2 Roses Main BlockState Provider";
    }

    @Override
    protected void registerStatesAndModels() {

        flowerModelCompat(BlockInit.ROSE_SEED.get(), "block/rose", "rose", "roses", RosesBlocks.ROSE.get());
        flowerModelCompat(BlockInit.CYAN_FLOWER_SEED.get(), "block/cyan_flower", "cyan_flower", "roses", RosesBlocks.CYAN_FLOWER.get());
    }



}