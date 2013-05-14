package net.arasaia.ExampleMods.items;

import net.arasaia.ExampleMods.lib.Reference;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemGeneralExampleMods extends Item{
    public ItemGeneralExampleMods(int id){
        super(id);
        this.setCreativeTab(CreativeTabs.tabMaterials);
    }
    
    @Override
    public void registerIcons(IconRegister par1IconRegister){
        this.itemIcon = par1IconRegister.registerIcon(Reference.MOD_ID
                + ":" + this.getUnlocalizedName().substring(5));
    }
}
