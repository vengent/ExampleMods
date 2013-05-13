package net.arasaia.ExampleMods.items;

import java.util.List;

import net.arasaia.ExampleMods.lib.Reference;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class IngotExampleMods extends ItemGeneralExampleMods{
    @SideOnly(Side.CLIENT)
    private String[] ingotNames = new String[]{"copper","silver"};
    @SideOnly(Side.CLIENT)
    private static String[] iconNames = new String[]{"ingotCopper", "ingotSilver"};
    
    @SideOnly(Side.CLIENT)
    private Icon[] icons;
    
    public IngotExampleMods(int id){
        super(id);
        this.setHasSubtypes(true);
        this.setUnlocalizedName("ingotExampleMods");
        this.setCreativeTab(CreativeTabs.tabMaterials);
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.icons = new Icon[iconNames.length];

        for (int i = 0; i < iconNames.length; ++i)
        {
            this.icons[i] = par1IconRegister.registerIcon(Reference.MOD_ID + ":" + iconNames[i]);
        }
    }
    
    @SideOnly(Side.CLIENT)
    public Icon getIconFromDamage(int par1)
    {
        int j = MathHelper.clamp_int(par1, 0, Reference.INGOT_TOTAL);
        return this.icons[j];
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List){
        for(int i = 0; i< Reference.INGOT_TOTAL; i++){
            par3List.add(new ItemStack(par1, 1, i));
        }
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public String getUnlocalizedName(ItemStack par1ItemStack)
    {
        int i = MathHelper.clamp_int(par1ItemStack.getItemDamage(), 0, Reference.INGOT_TOTAL);
        return super.getUnlocalizedName() + "." + ingotNames[i];
    }
}
