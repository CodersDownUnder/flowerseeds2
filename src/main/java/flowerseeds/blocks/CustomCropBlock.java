package flowerseeds.blocks;

import flowerseeds.events.SeedColour;
import flowerseeds.init.BlockInit;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.PlantType;
import org.jetbrains.annotations.NotNull;

public class CustomCropBlock extends CropBlock implements IPlantable {

    private final SeedColour colour;
    public CustomCropBlock(Properties pProperties, SeedColour colour) {
        super(pProperties);
        this.colour = colour;

    }

    public SeedColour getColour() {
        return colour;
    }

    @Override
    public @NotNull ItemStack getCloneItemStack(BlockGetter pLevel, BlockPos pPos, BlockState pState) {
        return this.asItem().getDefaultInstance();
    }

    @Override
    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        Block ground = pLevel.getBlockState(pPos.below()).getBlock();

        if (this == BlockInit.WITHER_ROSE_SEED.get()) {
            return ground == Blocks.SOUL_SAND || ground == Blocks.NETHERRACK || super.canSurvive(pState, pLevel, pPos);
        } else {
            return super.canSurvive(pState, pLevel, pPos);
        }

    }
}
