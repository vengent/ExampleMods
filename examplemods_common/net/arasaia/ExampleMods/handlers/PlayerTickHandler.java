package net.arasaia.ExampleMods.handlers;

import java.util.EnumSet;

import net.arasaia.ExampleMods.ExampleMods;
import net.arasaia.ExampleMods.lib.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class PlayerTickHandler implements ITickHandler{

    public PlayerTickHandler() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void tickStart(EnumSet<TickType> type, Object... tickData) {
        
    }

    @Override
    public void tickEnd(EnumSet<TickType> type, Object... tickData) {
        if(type.equals(EnumSet.of(TickType.PLAYER))){
            onPlayerTick((EntityPlayer) tickData[0]);
        }
    }

    @Override
    public EnumSet<TickType> ticks() {
        return EnumSet.of(TickType.PLAYER);
    }

    @Override
    public String getLabel() {
        return Reference.MOD_NAME + ": " + this.getClass().getSimpleName();
    }
    
    private void onPlayerTick(EntityPlayer player){        
        if(player.inventory.hasItemStack(new ItemStack(ExampleMods.ringNether, 1, Reference.RING_MINING_META_ID))){
            player.addPotionEffect(new PotionEffect(Potion.digSpeed.getId(), 100, 0));
        }
        else
            player.removePotionEffect(Potion.digSpeed.getId());
        
        if(player.inventory.hasItemStack(new ItemStack(ExampleMods.ringNether, 1, Reference.RING_REGEN_META_ID))){
            player.addPotionEffect(new PotionEffect(Potion.regeneration.getId(), 100, 0));
        }
        else
            player.removePotionEffect(Potion.regeneration.getId());
        
        if(player.inventory.hasItemStack(new ItemStack(ExampleMods.ringNether, 1, Reference.RING_SPEED_META_ID))){
            player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 100, 0));
        }
        else
            player.removePotionEffect(Potion.moveSpeed.getId());
        
        if(player.inventory.hasItemStack(new ItemStack(ExampleMods.ringNether, 1, Reference.RING_STRENGTH_META_ID))){
            player.addPotionEffect(new PotionEffect(Potion.damageBoost.getId(), 100, 0));
        }
        else
            player.removePotionEffect(Potion.damageBoost.getId());
    }
}