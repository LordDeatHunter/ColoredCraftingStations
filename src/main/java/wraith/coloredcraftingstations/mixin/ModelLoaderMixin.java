package wraith.coloredcraftingstations.mixin;

import net.minecraft.client.render.model.ModelLoader;
import net.minecraft.client.render.model.json.JsonUnbakedModel;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import wraith.coloredcraftingstations.ColoredCraftingStations;
import wraith.coloredcraftingstations.Utils;

@Mixin(ModelLoader.class)
public class ModelLoaderMixin {

    @Inject(method = "loadModelFromJson", at = @At("HEAD"), cancellable = true)
    public void loadModelFromJson(Identifier id, CallbackInfoReturnable<JsonUnbakedModel> cir) {
        if (!id.getNamespace().equals(ColoredCraftingStations.MOD_ID) || id.getPath().contains("base_crafting_station")) {
            return;
        }
        if (id.getPath().startsWith("item/")) {
            JsonUnbakedModel model = JsonUnbakedModel.deserialize(Utils.createBlockItemModelJson(id.getPath().split("/")[1]));
            model.id = id.toString();
            cir.setReturnValue(model);
            cir.cancel();
        } else if (id.getPath().startsWith("block/")) {
            String json = Utils.createBlockModelJson(id.getPath().split("/")[1]);
            JsonUnbakedModel model = JsonUnbakedModel.deserialize(json);
            model.id = id.toString();
            cir.setReturnValue(model);
            cir.cancel();
        }
    }

}
