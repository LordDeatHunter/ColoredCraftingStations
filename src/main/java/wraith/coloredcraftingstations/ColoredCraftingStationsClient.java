package wraith.coloredcraftingstations;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import wraith.coloredcraftingstations.registries.BlockEntityRendererRegistry;
import wraith.coloredcraftingstations.registries.CustomScreenRegistry;

import java.text.DecimalFormat;

@Environment(EnvType.CLIENT)
public class ColoredCraftingStationsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockEntityRendererRegistry.RegisterBlockEntityRenderers();
        CustomScreenRegistry.registerScreens();
    }

}
