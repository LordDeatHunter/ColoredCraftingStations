package wraith.coloredcraftingstations.block;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.stat.Stats;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import wraith.coloredcraftingstations.ColoredCraftingStations;
import wraith.coloredcraftingstations.screens.CraftingStationScreenHandler;

public class CraftingStationBlock extends BlockWithEntity {

    private static final Text TITLE = new TranslatableText("container." + ColoredCraftingStations.MOD_ID + ".crafting_station");
    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;;

    //top
    protected static final VoxelShape vs1 = Block.createCuboidShape(0f, 13f, 0f, 16f, 16f, 16f);
    protected static final VoxelShape vs2 = Block.createCuboidShape(0f, 0f, 0f, 3f, 13f, 3f);
    protected static final VoxelShape vs3 = Block.createCuboidShape(13f, 0f, 0f, 16f, 13f, 3f);
    protected static final VoxelShape vs4 = Block.createCuboidShape(0f, 0f, 13f, 3f, 13f, 16f);
    protected static final VoxelShape vs5 = Block.createCuboidShape(13f, 0f, 13f, 16f, 13f, 16f);
    protected static final VoxelShape VOXEL_SHAPE = VoxelShapes.union(vs1, vs2, vs3, vs4, vs5).simplify();

    public CraftingStationBlock(Settings settings) {
        super(settings);
        setDefaultState(getStateManager().getDefaultState().with(FACING, Direction.NORTH));
    }

    @Override
    public BlockEntity createBlockEntity(BlockView world) {
        return new CraftingStationBlockEntity();
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(FACING);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerFacing().getOpposite());
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            NamedScreenHandlerFactory screenHandlerFactory = state.createScreenHandlerFactory(world, pos);
            if (screenHandlerFactory != null) {
                player.openHandledScreen(screenHandlerFactory);
                player.incrementStat(Stats.INTERACT_WITH_CRAFTING_TABLE);
                
            }
            ((CraftingStationBlockEntity)world.getBlockEntity(pos)).sync();
        }
        world.getBlockEntity(pos).markDirty();
        return ActionResult.SUCCESS;
    }

    @Override
    public NamedScreenHandlerFactory createScreenHandlerFactory(BlockState state, World world, BlockPos pos) {
        return new SimpleNamedScreenHandlerFactory((i, playerInventory, playerEntity) -> new CraftingStationScreenHandler(i, playerInventory, ScreenHandlerContext.create(world, pos), (CraftingStationBlockEntity)world.getBlockEntity(pos)), TITLE);
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof CraftingStationBlockEntity) {
                ItemScatterer.spawn(world, pos, (CraftingStationBlockEntity)blockEntity);
                world.updateComparators(pos,this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return VOXEL_SHAPE;
    }


}
