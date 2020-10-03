package wraith.coloredcraftingstations.registries;

import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import wraith.coloredcraftingstations.screens.*;
import wraith.coloredcraftingstations.ColoredCraftingStations;

import java.util.HashMap;

public class CustomScreenHandlerRegistry {

    public static HashMap<String, ScreenHandlerType<? extends ScreenHandler>> COLORED_CRAFTING_STATIONS_SCREENS = new HashMap<>();


    public static void registerScreenHandlers() {
        COLORED_CRAFTING_STATIONS_SCREENS.put("crafting_station", ScreenHandlerRegistry.registerSimple(new Identifier(ColoredCraftingStations.MOD_ID, "crafting_station"), CraftingStationScreenHandler::new));
    }

}
