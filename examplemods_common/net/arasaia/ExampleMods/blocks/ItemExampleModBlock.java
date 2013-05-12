package net.arasaia.ExampleMods.blocks;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemExampleModBlock extends ItemBlock{

    public ItemExampleModBlock(int par1) {
        super(par1);
        setHasSubtypes(true);
    }
    
    @Override
    public String getUnlocalizedName(ItemStack itemStack){
        String name = "";
        
        switch(itemStack.getItemDamage()){
            case 0:
                name = "copper";
                break;
            case 1:
                name = "silver";
                break;
            default:
                name = "broken";
                break;
        }
        
        return super.getUnlocalizedName() + "." + name;
    }
    
    public int getMetadata(int par1){
        return par1;
    }
}
