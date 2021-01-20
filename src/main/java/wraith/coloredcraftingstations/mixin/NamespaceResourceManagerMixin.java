package wraith.coloredcraftingstations.mixin;

import net.minecraft.resource.NamespaceResourceManager;
import net.minecraft.resource.Resource;
import net.minecraft.resource.ResourceImpl;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import wraith.coloredcraftingstations.ColoredCraftingStations;
import wraith.coloredcraftingstations.Utils;

import java.util.ArrayList;
import java.util.List;

@Mixin(NamespaceResourceManager.class)
public class NamespaceResourceManagerMixin {
    @Inject(method = "getAllResources", at = @At("HEAD"), cancellable = true)
    public void getAllResources(Identifier id, CallbackInfoReturnable<List<Resource>> cir) {
        if (!id.getNamespace().equals(ColoredCraftingStations.MOD_ID) || !id.getPath().startsWith("blockstates/") || !id.getPath().endsWith(".json")) {
            return;
        }
        List<Resource> resources = new ArrayList<>();
        String json = Utils.createBlockStateJson(id.getPath().split("/")[1].split("\\.")[0]);
        resources.add(new ResourceImpl(ColoredCraftingStations.MOD_ID, id, Utils.stringToInputStream(json), null));
        cir.setReturnValue(resources);
        cir.cancel();
    }
}
