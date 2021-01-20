package wraith.coloredcraftingstations;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.loot.ConstantLootTableRange;
import net.minecraft.loot.condition.*;
import net.minecraft.loot.entry.ItemEntry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import wraith.coloredcraftingstations.registries.*;

public class ColoredCraftingStations implements ModInitializer {

    public static final String MOD_ID = "coloredcraftingstations";
    public static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void onInitialize() {
        if (FabricLoader.getInstance().isModLoaded("byg")) {
            StationsInfo.loadBYGSupport();
        }

        BlockRegistry.loadBlocks();
        BlockRegistry.registerBlocks();

        BlockEntityRegistry.loadBlockEntities();
        BlockEntityRegistry.registerBlockEntities();

        ItemRegistry.loadItems();
        ItemRegistry.registerItems();

        CustomScreenHandlerRegistry.registerScreenHandlers();

        registerEvents();

        LOGGER.info("[Colored Crafting Stations] has successfully been initialized");
    }

    private void registerEvents() {
        LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, supplier, setter) -> {
            if (id.getNamespace().equals(MOD_ID)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootTableRange.create(1))
                        .withCondition(SurvivesExplosionLootCondition.builder().build())
                        .withEntry(ItemEntry.builder(ItemRegistry.ITEMS.get(id.toString())).build());
                supplier.withPool(poolBuilder.build());
            }
        });
    }

}
