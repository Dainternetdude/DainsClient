package com.dainsclient.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Objects;

@Mixin(ItemRenderer.class)
public abstract class MixinItemRenderer {
    @Shadow
    public class ItemRenderer(Minecraft mc) {
        this.mc = mc;
    }
    private final Minecraft mc;
    private float prevEquippedProgressMainHand;
    private float prevEquippedProgressOffHand;
    private float equippedProgressMainHand;
    private float equippedProgressOffHand;
    private ItemStack itemStackMainHand;
    private ItemStack itemStackOffHand;


    @Shadow
    public void updateEquippedItem() {
        this.prevEquippedProgressMainHand = this.equippedProgressMainHand;
        this.prevEquippedProgressOffHand = this.equippedProgressOffHand;
        EntityPlayerSP entityplayersp = this.mc.player;
        ItemStack itemstack = entityplayersp.getHeldItemMainhand();
        ItemStack itemstack1 = entityplayersp.getHeldItemOffhand();

        if (entityplayersp.isRowingBoat())
        {
            this.equippedProgressMainHand = MathHelper.clamp(this.equippedProgressMainHand - 0.4F, 0.0F, 1.0F);
            this.equippedProgressOffHand = MathHelper.clamp(this.equippedProgressOffHand - 0.4F, 0.0F, 1.0F);
        }
        else
        {
            float f = entityplayersp.getCooledAttackStrength(1.0F);
            //if(!this.mc.gameSettings.itemRefreshCooldown)
            {
                this.equippedProgressMainHand += MathHelper.clamp((float)(Objects.equals(this.itemStackMainHand, itemstack) ? 1 : 0) - this.equippedProgressMainHand, -0.4F, 0.4F);
            }
/*
            else
            {
                this.equippedProgressMainHand += MathHelper.clamp((Objects.equals(this.itemStackMainHand, itemstack) ? f * f * f : 0.0F) - this.equippedProgressMainHand, -0.4F, 0.4F);
            }*/
            this.equippedProgressOffHand += MathHelper.clamp((float)(Objects.equals(this.itemStackOffHand, itemstack1) ? 1 : 0) - this.equippedProgressOffHand, -0.4F, 0.4F);

        }

        if (this.equippedProgressMainHand < 0.1F)
        {
            this.itemStackMainHand = itemstack;
        }

        if (this.equippedProgressOffHand < 0.1F)
        {
            this.itemStackOffHand = itemstack1;
        }
    }
}
