package wraith.coloredcraftingstations;

import net.fabricmc.api.ModInitializer;
import wraith.coloredcraftingstations.registries.*;

public class ColoredCraftingStations implements ModInitializer {

    public static final String MOD_ID = "coloredcraftingstations";

    @Override
    public void onInitialize() {
        BlockRegistry.registerBlocks();
        BlockEntityRegistry.registerBlockEntities();
        ItemRegistry.registerItems();
        CustomScreenHandlerRegistry.registerScreenHandlers();
    }

}
