package flowerseeds.server.datamaps;

import flowerseeds.init.BlockInit;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.datamaps.builtin.Compostable;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;

import java.util.concurrent.CompletableFuture;

public class CompostablesGen extends DataMapProvider {

    public CompostablesGen(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather() {
        var compostables = builder(NeoForgeDataMaps.COMPOSTABLES);

                for (DeferredHolder<Block, ? extends Block> block: BlockInit.BLOCKS.getEntries()) {
                    compostables.add(block.get().asItem().builtInRegistryHolder(), new Compostable(0.3f), false);
                }

    }
}