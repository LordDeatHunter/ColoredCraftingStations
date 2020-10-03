package wraith.coloredcraftingstations.registries;

import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import wraith.coloredcraftingstations.ColoredCraftingStations;
import wraith.coloredcraftingstations.block.*;

public class BlockEntityRegistry {

    public static final BlockEntityType<CraftingStationBlockEntity> CRAFTING_STATION_BLOCK_ENTITY = BlockEntityType.Builder.create(CraftingStationBlockEntity::new,
            BlockRegistry.COLORED_CRAFTING_STATIONS_BLOCKS.get("crafting_station_red"),
            BlockRegistry.COLORED_CRAFTING_STATIONS_BLOCKS.get("crafting_station_white"),
            BlockRegistry.COLORED_CRAFTING_STATIONS_BLOCKS.get("crafting_station_gray"),
            BlockRegistry.COLORED_CRAFTING_STATIONS_BLOCKS.get("crafting_station_light_gray"),
            BlockRegistry.COLORED_CRAFTING_STATIONS_BLOCKS.get("crafting_station_black"),
            BlockRegistry.COLORED_CRAFTING_STATIONS_BLOCKS.get("crafting_station_brown"),
            BlockRegistry.COLORED_CRAFTING_STATIONS_BLOCKS.get("crafting_station_orange"),
            BlockRegistry.COLORED_CRAFTING_STATIONS_BLOCKS.get("crafting_station_lime"),
            BlockRegistry.COLORED_CRAFTING_STATIONS_BLOCKS.get("crafting_station_green"),
            BlockRegistry.COLORED_CRAFTING_STATIONS_BLOCKS.get("crafting_station_cyan"),
            BlockRegistry.COLORED_CRAFTING_STATIONS_BLOCKS.get("crafting_station_magenta"),
            BlockRegistry.COLORED_CRAFTING_STATIONS_BLOCKS.get("crafting_station_purple"),
            BlockRegistry.COLORED_CRAFTING_STATIONS_BLOCKS.get("crafting_station_light_blue"),
            BlockRegistry.COLORED_CRAFTING_STATIONS_BLOCKS.get("crafting_station_yellow"),
            BlockRegistry.COLORED_CRAFTING_STATIONS_BLOCKS.get("crafting_station_pink"),
            BlockRegistry.COLORED_CRAFTING_STATIONS_BLOCKS.get("crafting_station_blue")
                    ).build(null);

    public static void registerBlockEntities() {
        Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(ColoredCraftingStations.MOD_ID, "crafting_station"), CRAFTING_STATION_BLOCK_ENTITY);
    }

}
