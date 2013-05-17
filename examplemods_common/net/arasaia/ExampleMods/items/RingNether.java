package net.arasaia.ExampleMods.items;

import java.util.List;

import net.arasaia.ExampleMods.lib.Reference;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RingNether extends Item {

    // ick
    private int ringSilverIndex = 2;
    
    public RingNether(int par1) {
        super(par1);
        this.maxStackSize = 1;
        this.setHasSubtypes(true);
        this.setUnlocalizedName("ringNether");
        this.setCreativeTab(CreativeTabs.tabMisc);
    }

    @SideOnly(Side.CLIENT)
    private String[] ringNames = new String[]{"mining","regen","silver","speed","strength"};
    @SideOnly(Side.CLIENT)
    private static String[] iconNames = new String[]{"ringNetherMining", "ringNetherRegen", "ringNetherSilver","ringNetherSpeed", "ringNetherStrength"};
    
    @SideOnly(Side.CLIENT)
    private Icon[] icons;

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
        int j = MathHelper.clamp_int(par1, 0, Reference.RING_TOTAL);
        return this.icons[j];
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List){
        for(int i = 0; i< Reference.RING_TOTAL; i++){
            par3List.add(new ItemStack(par1, 1, i));
        }
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public String getUnlocalizedName(ItemStack par1ItemStack)
    {
        int i = MathHelper.clamp_int(par1ItemStack.getItemDamage(), 0, Reference.RING_TOTAL);
        return super.getUnlocalizedName() + "." + ringNames[i];
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public boolean hasEffect(ItemStack par1ItemStack){
        return this.getItemDamageFromStack(par1ItemStack) != 2;        
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public EnumRarity getRarity(ItemStack par1ItemStack){
        if(this.getItemDamageFromStack(par1ItemStack) != 2){
            return EnumRarity.epic;
        }
        
        return EnumRarity.common;
    }
}
