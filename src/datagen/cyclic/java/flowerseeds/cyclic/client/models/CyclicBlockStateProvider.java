package flowerseeds.cyclic.client.models;

import com.lothrazar.cyclic.block.BlockCyclic;
import com.lothrazar.cyclic.registry.BlockRegistry;
import com.lothrazar.cyclic.registry.CyclicRecipeType;
import flowerseeds.client.models.MainBlockStateProvider;
import flowerseeds.cyclic.init.BlockInit;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import willatendo.roses.server.block.RosesBlocks;

public class CyclicBlockStateProvider extends MainBlockStateProvider {
    public CyclicBlockStateProvider(PackOutput output, String MODID, ExistingFileHelper exFileHelper) {
        super(output, MODID, exFileHelper);
    }

    @Override
    public String getName() {
        return "Flower Seeds 2 Cyclic BlockState Provider";
    }

    @Override
    protected void registerStatesAndModels() {

        flowerModelCompat(BlockInit.CYAN_ROSE_SEED.get(), "block/flower_cyan", "flower_cyan", "cyclic", BlockRegistry.FLOWER_CYAN.get());
        flowerModelCompat(BlockInit.LIME_CARNATION_SEED.get(), "block/flower_lime_carnation", "flower_lime_carnation", "cyclic", BlockRegistry.FLOWER_LIME_CARNATION.get());
        flowerModelCompat(BlockInit.PURPLE_TULIP_SEED.get(), "block/flower_purple_tulip", "flower_purple_tulip", "cyclic", BlockRegistry.FLOWER_PURPLE_TULIP.get());
        flowerModelCompat(BlockInit.ABSALON_TULIP_SEED.get(), "block/flower_absalon_tulip", "flower_absalon_tulip", "cyclic", BlockRegistry.FLOWER_ABSALON_TULIP.get());
    }



}