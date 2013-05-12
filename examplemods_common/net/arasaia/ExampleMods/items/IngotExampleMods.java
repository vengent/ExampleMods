package net.arasaia.ExampleMods.items;

import java.util.List;

import net.arasaia.ExampleMods.lib.Reference;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class IngotExampleMods extends ItemGeneralExampleMods{
    @SideOnly(Side.CLIENT)
    private String[] names = new String[]{"copper","silver"};
    
    @SideOnly(Side.CLIENT)
    private Icon[] icons;
    
    public IngotExampleMods(int id){
        super(id);
        this.setUnlocalizedName("ingotExampleMods");
        this.setCreativeTab(CreativeTabs.tabMaterials);
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister){
        icons = new Icon[Reference.INGOT_TOTAL];
        
        for(int i = 0; i < icons.length; i++){
            icons[i] = 
                    par1IconRegister.registerIcon(
                            Reference.MOD_ID 
                            + ":" 
                            + (this.getUnlocalizedName().substring(5)) + i);
        }
    }
    
    @Override
    public int getMetadata(int i)
    {
        return i;
    }
    
    @SideOnly(Side.CLIENT)
    public Icon getIconFromDamage(int i){
        return icons[i];
    }
    
    @SideOnly(Side.CLIENT)
    public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List){
        for(int i = 0; i< Reference.INGOT_TOTAL; i++){
            par3List.add(new ItemStack(par1, 1, i));
        }
    }
    
    @Override
    public String getUnlocalizedName(ItemStack itemstack)
    {
        return super.getUnlocalizedName() + "." + names[itemstack.getItemDamage()];
    }
}
