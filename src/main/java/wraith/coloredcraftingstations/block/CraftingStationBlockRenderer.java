package wraith.coloredcraftingstations.block;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Vector3f;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Direction;

public class CraftingStationBlockRenderer extends BlockEntityRenderer<CraftingStationBlockEntity> {

    public CraftingStationBlockRenderer(BlockEntityRenderDispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    public void render(CraftingStationBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        int deg;
        String rot = entity.getCachedState().get(CraftingStationBlock.FACING).asString();
        switch (rot) {
            case "east":
                deg = 90;
                break;
            case "west":
                deg = 270;
                break;
            case "north":
                deg = 180;
                break;
            default:
                deg = 0;
                break;
        }
        float d = 4f; //decrease
        for (float x = -1f/(d/3.5f), i = 0; x <= 1f/(d/3.5f); x += 1f/(d/3.5f)) {
            for (float z = -1f/(d/3.5f); z <= 1f/(d/3.5f); z += 1f/(d/3.5f), ++i) {
                ItemStack stack = entity.getItems().get((int) i);
                if (stack.isEmpty()) continue;
                matrices.push();
                matrices.scale(1f / d, 1f / d, 1f / d);
                matrices.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(deg));
                matrices.translate(d/2f + z, d, d/2f + x);
                switch (deg) {
                    case 0:
                        break;
                    case 90:
                        matrices.translate(-d, 0,0);
                        break;
                    case 180:
                        matrices.translate(-d, 0, -d);
                        break;
                    default:
                        matrices.translate(0, 0, -d);
                        break;
                }
                matrices.multiply(Vector3f.POSITIVE_X.getDegreesQuaternion(90));
                matrices.multiply(Vector3f.POSITIVE_Z.getDegreesQuaternion(180));
                int lightAbove = WorldRenderer.getLightmapCoordinates(entity.getWorld(), entity.getPos().up());
                MinecraftClient.getInstance().getItemRenderer().renderItem(stack, ModelTransformation.Mode.FIXED, lightAbove, overlay, matrices, vertexConsumers);
                matrices.pop();
            }
        }
    }

}
