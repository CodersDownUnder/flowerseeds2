package flowerseeds.blocks;

import biomesoplenty.api.block.BOPBlocks;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.IPlantable;

public class CustomBurningCropBlock extends CropBlock implements IPlantable {

    private final ItemColor colour;
    public CustomBurningCropBlock(Properties pProperties, ItemColor colour) {
        super(pProperties);
        this.colour = colour;

    }

    public ItemColor getColour() {
        return colour;
    }

    @Override
    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {

        Block ground = pLevel.getBlockState(pPos.below()).getBlock();

        return ground == Blocks.NETHERRACK || ground == Blocks.SOUL_SAND || ground == Blocks.SOUL_SOIL || ground == Blocks.CRIMSON_NYLIUM || ground == Blocks.WARPED_NYLIUM || super.canSurvive(pState, pLevel, pPos);

    }

    @Override
    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {

        if (this.getAge(pState) == 7) {
            if (!pEntity.fireImmune()) {
                pEntity.setRemainingFireTicks(pEntity.getRemainingFireTicks() + 1);
                if (pEntity.getRemainingFireTicks() == 0) {
                    pEntity.setSecondsOnFire(1);
                }

                pEntity.hurt(pLevel.damageSources().inFire(), 1.0F);
            }
        }

        super.entityInside(pState, pLevel, pPos, pEntity);
    }

    public void animateTick(BlockState stateIn, Level worldIn, BlockPos pos, RandomSource rand) {
        super.animateTick(stateIn, worldIn, pos, rand);
            if (rand.nextInt(8) == 0) {
                worldIn.addParticle(ParticleTypes.FLAME, (double)pos.getX() + 0.5 + (rand.nextDouble() - rand.nextDouble()) / 4.0, (double)pos.getY() + 0.75, (double)pos.getZ() + 0.5 + (rand.nextDouble() - rand.nextDouble()) / 4.0, 0.0, 0.0, 0.0);
            }

            if (rand.nextInt(4) == 0) {
                worldIn.addParticle(ParticleTypes.SMOKE, (double)pos.getX() + 0.5 + (rand.nextDouble() - rand.nextDouble()) / 4.0, (double)pos.getY() + 0.75, (double)pos.getZ() + 0.5 + (rand.nextDouble() - rand.nextDouble()) / 4.0, 0.0, 0.0, 0.0);
            }
    }
}
