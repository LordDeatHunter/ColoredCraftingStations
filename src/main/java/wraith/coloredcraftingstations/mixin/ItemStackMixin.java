package wraith.coloredcraftingstations.mixin;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import wraith.coloredcraftingstations.ColoredCraftingStations;
import wraith.coloredcraftingstations.StationsInfo;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {

    @Shadow public abstract Item getItem();

    @Inject(method = "getName", at = @At("HEAD"), cancellable = true)
    public void getName(CallbackInfoReturnable<Text> cir) {
        Identifier id = Registry.ITEM.getId(getItem());
        if (!id.getNamespace().equals(ColoredCraftingStations.MOD_ID)) {
            return;
        }
        String[] segments = id.getPath().split("_");
        String color = "";
        String wood = "";
        int i = 0;
        while (!StationsInfo.COLORS.contains(color)) {
            if (i > 0) {
                color += "_";
            }
            color += segments[i++];
        }
        int start = i;
        while (!StationsInfo.PLANKS.containsKey(wood)) {
            if (i > start) {
                wood += "_";
            }
            wood += segments[i++];
        }

        color = new TranslatableText("color.coloredcraftingstations." + color).getString();
        wood = new TranslatableText("planks.coloredcraftingstations." + wood).getString();
        String station = new TranslatableText("coloredcraftingstations.crafting_station").getString();
        cir.setReturnValue(new LiteralText(color + " " + wood + " " + station));
        cir.cancel();
    }

}
