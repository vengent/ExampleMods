package net.arasaia.ExampleMods.items;

import net.arasaia.ExampleMods.lib.Reference;
import net.arasaia.ExampleMods.ExampleMods;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class HoeExampleMods extends ItemHoe{
    String texture;
    
    public HoeExampleMods(int id, EnumToolMaterial toolMaterial, String texture){
        super(id, toolMaterial);
        this.texture = texture;
        this.setCreativeTab(CreativeTabs.tabTools);
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IconRegister par1IconRegister){
        this.itemIcon = 
                par1IconRegister.registerIcon(
                        Reference.MOD_ID 
                + ":"
                + "hoe" + texture);
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack) {
        return (new ItemStack(ExampleMods.ingotExampleMod, 1,
                par2ItemStack.getItemDamage())).itemID == par2ItemStack.itemID ? true
                : super.getIsRepairable(par1ItemStack, par2ItemStack);
    }
}
