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

public class OreExampleMods extends BlockGeneralExampleMods{

    public OreExampleMods(int par1, Material par2Material) {
        super(par1, par2Material);
        this.setHardness(3.0F);
        this.setResistance(89.5F);
        this.setStepSound(soundStoneFootstep);
    }
    
    @SideOnly(Side.CLIENT)
    private Icon[] icons;
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister){
        icons = new Icon[Reference.ORE_PICKAXE_STONE_HARVEST_TOTAL];
        
        for(int i = 0; i < icons.length; i++){
            icons[i] = par1IconRegister.registerIcon(Reference.MOD_ID
                    + ":"
                    + (this.getUnlocalizedName().substring(5))+i);
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
}
