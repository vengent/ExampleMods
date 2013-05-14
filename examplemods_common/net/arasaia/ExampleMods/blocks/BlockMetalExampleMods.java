package net.arasaia.ExampleMods.blocks;

import java.util.List;

import net.arasaia.ExampleMods.lib.Reference;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockMetalExampleMods extends BlockGeneralExampleMods{

    @SideOnly(Side.CLIENT)
    private Icon[] icons;
    @SideOnly(Side.CLIENT)
    private String[] oreNames = new String[]{"copper","silver"};
    @SideOnly(Side.CLIENT)
    private static String[] iconNames = new String[]{"blockCopper", "blockSilver"}; 
    
    public BlockMetalExampleMods(int par1, Material par2Material) {
        super(par1, par2Material);
        this.setHardness(5.0F);
        this.setResistance(10.0F);
        this.setStepSound(soundMetalFootstep);
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
    public Icon getIcon(int par1, int par2){
        return icons[par2];
    }
    
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(int par1, CreativeTabs part2CreativeTabs, List par3List){
        for(int i = 0; i < 2; i++){
            par3List.add(new ItemStack(par1, 1, i));
        }
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public int damageDropped(int par1)
    {
        return par1;
    }
}
