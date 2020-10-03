package wraith.coloredcraftingstations.registries;

import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import wraith.coloredcraftingstations.screens.CraftingStationScreen;

public class CustomScreenRegistry {

    public static void registerScreens() {
        ScreenRegistry.register(CustomScreenHandlerRegistry.COLORED_CRAFTING_STATIONS_SCREENS.get("crafting_station"), CraftingStationScreen::new);
    }

}
