package wraith.coloredcraftingstations.registries;

import wraith.coloredcraftingstations.block.CraftingStationBlockRenderer;

public class BlockEntityRendererRegistry {

    public static void RegisterBlockEntityRenderers(){
        net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry.INSTANCE.register(BlockEntityRegistry.CRAFTING_STATION_BLOCK_ENTITY, CraftingStationBlockRenderer::new);
    }

}
