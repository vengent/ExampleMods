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
    }

    private static void addFurnaceRecipes() {
        /*
         * FurnaceRecipes .smelting() .addSmelting( Reference.ORE_ID,
         * Reference.ORE_COPPER_META_ID, new ItemStack( Reference.INGOT_ID,
         * Reference.INGOT_COPPER_META_ID, 1), 0.5f);
         */
        FurnaceRecipes.smelting().addSmelting(
                Reference.ORE_ID,
                Reference.ORE_COPPER_META_ID,
                new ItemStack(Reference.INGOT_ID, 1,
                        Reference.INGOT_COPPER_META_ID), 0.5F);

        /*
         * FurnaceRecipes .smelting() .addSmelting( Reference.ORE_ID,
         * Reference.ORE_SILVER_META_ID, new ItemStack( Reference.INGOT_ID,
         * Reference.INGOT_SILVER_META_ID, 1), 1.0f);
         */
    }

    private static void addBuckets() {
        GameRegistry.addRecipe(new ShapedOreRecipe(Item.bucketEmpty, true,
                new Object[] { "I I", " I ", Character.valueOf('I'),
                        "ingotCopper" }));

        GameRegistry.addRecipe(new ShapedOreRecipe(Item.bucketEmpty, true,
                new Object[] { "I I", " I ", Character.valueOf('I'),
                        "ingotSilver" }));
    }
}