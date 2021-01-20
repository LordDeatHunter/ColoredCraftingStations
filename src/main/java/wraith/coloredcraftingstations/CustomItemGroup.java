package wraith.coloredcraftingstations;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import wraith.coloredcraftingstations.registries.BlockRegistry;

public class CustomItemGroup {

    public static final ItemGroup COLORED_CRAFTING_STATIONS_GROUP = FabricItemGroupBuilder.create(new Identifier(ColoredCraftingStations.MOD_ID, "blocks")).icon(() -> new ItemStack(BlockRegistry.BLOCKS.get("crafting_station_red"))).build();

}
