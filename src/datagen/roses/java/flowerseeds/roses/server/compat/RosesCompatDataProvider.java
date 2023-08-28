package flowerseeds.roses.server.compat;

import flowerseeds.roses.FlowerSeedsRoses;
import flowerseeds.server.compat.MainCompatDataProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.data.event.GatherDataEvent;
import org.jetbrains.annotations.NotNull;
import willatendo.roses.server.block.RosesBlocks;
import java.util.concurrent.CompletableFuture;

public class RosesCompatDataProvider extends MainCompatDataProvider {

    public RosesCompatDataProvider(String modid, GatherDataEvent event) {
        super(modid, event);
    }

    @Override
    protected @NotNull CompletableFuture<?> generate() {

        basicFlowerProcessing(FlowerSeedsRoses.ROSE_SEED.get(), RosesBlocks.ROSE.get().asItem());
        basicFlowerProcessing(FlowerSeedsRoses.CYAN_FLOWER_SEED.get(), RosesBlocks.CYAN_FLOWER.get().asItem());

       
       //This is here to force it to generate all the files, otherwise the last few files don't get generated for some reason or other.
        //TODO: fix this in future (somehow?)
       MEKANISM_CRUSHING.builder(toName(Blocks.AIR), Ingredient.of(Blocks.AIR.asItem()), new ResourceLocation("minecraft:air"), 0);

       return CompletableFuture.completedFuture(null);
    }

    @Override
    public String getName() {
        return "Flower Seeds 2 Roses Compat data Provider";
    }

}