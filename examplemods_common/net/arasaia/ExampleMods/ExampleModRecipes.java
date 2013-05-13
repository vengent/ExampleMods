package net.arasaia.ExampleMods;

import net.arasaia.ExampleMods.lib.Reference;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

public class ExampleModRecipes {
    public static void addRecipes() {
        addFurnaceRecipes();
        addBuckets();
        addPicks();
    }

    private static void addFurnaceRecipes() {
        FurnaceRecipes
            .smelting()
            .addSmelting(
                Reference.ORE_ID, 
                Reference.INGOT_COPPER_META_ID, 
                new ItemStack(
                        ExampleMods.ingotExampleMod, 
                        1, 
                        Reference.INGOT_COPPER_META_ID), 
                0.5F);
        
        FurnaceRecipes
        .smelting()
        .addSmelting(
            Reference.ORE_ID, 
            Reference.INGOT_SILVER_META_ID, 
            new ItemStack(
                    ExampleMods.ingotExampleMod, 
                    1, 
                    Reference.INGOT_SILVER_META_ID), 
            1.0F);
    }

    private static void addBuckets() {
        GameRegistry.addRecipe(new ShapedOreRecipe(Item.bucketEmpty, true,
                new Object[] { "I I", " I ", Character.valueOf('I'),
                        "ingotCopper" }));

        GameRegistry.addRecipe(new ShapedOreRecipe(Item.bucketEmpty, true,
                new Object[] { "I I", " I ", Character.valueOf('I'),
                        "ingotSilver" }));
    }
    
    private static void addPicks(){
        GameRegistry.addRecipe(new ShapedOreRecipe(Item.pickaxeIron, true,
                new Object[] { "III", " S ", " S ", Character.valueOf('I'),
                        "ingotCopper", Character.valueOf('S'), Item.stick }));
        
        GameRegistry.addRecipe(new ShapedOreRecipe(Item.pickaxeGold, true,
                new Object[] { "III", " S ", " S ", Character.valueOf('I'),
                        "ingotSilver", Character.valueOf('S'), Item.stick }));
    }
}