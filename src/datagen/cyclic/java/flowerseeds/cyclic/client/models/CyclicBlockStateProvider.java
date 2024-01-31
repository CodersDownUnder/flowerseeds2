package flowerseeds.cyclic.client.models;

import flowerseeds.client.models.MainBlockStateProvider;
import flowerseeds.cyclic.FlowerSeedsCyclic;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

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

        //flowerModelCompat(FlowerSeedsCyclic.CYAN_ROSE_SEED.get(), "block/flower_cyan", "flower_cyan", "cyclic", BlockRegistry.FLOWER_CYAN.get());
        //flowerModelCompat(FlowerSeedsCyclic.LIME_CARNATION_SEED.get(), "block/flower_lime_carnation", "flower_lime_carnation", "cyclic", BlockRegistry.FLOWER_LIME_CARNATION.get());
        //flowerModelCompat(FlowerSeedsCyclic.PURPLE_TULIP_SEED.get(), "block/flower_purple_tulip", "flower_purple_tulip", "cyclic", BlockRegistry.FLOWER_PURPLE_TULIP.get());
        //flowerModelCompat(FlowerSeedsCyclic.ABSALON_TULIP_SEED.get(), "block/flower_absalon_tulip", "flower_absalon_tulip", "cyclic", BlockRegistry.FLOWER_ABSALON_TULIP.get());
    }



}