package flowerseeds.cyclic.server.compat;

import com.lothrazar.cyclic.registry.BlockRegistry;
import flowerseeds.cyclic.FlowerSeedsCyclic;
import flowerseeds.server.compat.MainCompatDataProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.data.event.GatherDataEvent;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class CyclicCompatDataProvider extends MainCompatDataProvider {

    public CyclicCompatDataProvider(String modid, GatherDataEvent event) {
        super(modid, event);
    }

    @Override
    protected @NotNull CompletableFuture<?> generate() {

        basicFlowerProcessing(FlowerSeedsCyclic.ABSALON_TULIP_SEED.get(), BlockRegistry.FLOWER_ABSALON_TULIP.get().asItem());
        basicFlowerProcessing(FlowerSeedsCyclic.LIME_CARNATION_SEED.get(), BlockRegistry.FLOWER_LIME_CARNATION.get().asItem());
        basicFlowerProcessing(FlowerSeedsCyclic.PURPLE_TULIP_SEED.get(), BlockRegistry.FLOWER_PURPLE_TULIP.get().asItem());
        basicFlowerProcessing(FlowerSeedsCyclic.CYAN_ROSE_SEED.get(), BlockRegistry.FLOWER_CYAN.get().asItem());

       
       //This is here to force it to generate all the files, otherwise the last few files don't get generated for some reason or other.
        //TODO: fix this in future (somehow?)
       MEKANISM_CRUSHING.builder(toName(Blocks.AIR), Ingredient.of(Blocks.AIR.asItem()), new ResourceLocation("minecraft:air"), 0);

       return CompletableFuture.completedFuture(null);
    }

    @Override
    public String getName() {
        return "Flower Seeds 2 Cyclic Compat data Provider";
    }

}