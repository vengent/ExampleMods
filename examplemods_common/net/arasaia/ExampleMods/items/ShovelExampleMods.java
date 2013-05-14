package net.arasaia.ExampleMods.items;

import net.arasaia.ExampleMods.lib.Reference;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSpade;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ShovelExampleMods extends ItemSpade{
    String texture;
    
    public ShovelExampleMods(int id, EnumToolMaterial toolMaterial, String texture){
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
                + "shovel" + texture);
    }
}
