package net.arasaia.ExampleMods;

import net.arasaia.ExampleMods.lib.Reference;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

public class ExampleModRecipes {
    public static void addRecipes() {
        addMetalBlocks();
        addFurnaceRecipes();
        addBuckets();
        addSwords();
        addShovels();
        addPicks();
        addAxes();
        addHoes();
        addRings();
    }

    private static void addMetalBlocks() {
        ItemStack stackBlockCopper = new ItemStack(
                ExampleMods.blockMetalExampleMod, 1,
                Reference.BLOCK_METAL_COPPER_META_ID);
        ItemStack stackBlockSilver = new ItemStack(
                ExampleMods.blockMetalExampleMod, 1,
                Reference.BLOCK_METAL_SILVER_META_ID);
        ItemStack stackIngotCopper = new ItemStack(ExampleMods.ingotExampleMod,
                9, Reference.INGOT_COPPER_META_ID);
        ItemStack stackIngotSilver = new ItemStack(ExampleMods.ingotExampleMod,
                9, Reference.INGOT_SILVER_META_ID);

        GameRegistry.addRecipe(new ShapedOreRecipe(stackBlockCopper, true,
                new Object[] { "III", "III", "III", Character.valueOf('I'),
                        "ingotCopper" }));
        
        GameRegistry.addRecipe(new ShapedOreRecipe(stackBlockSilver, true,
                new Object[] { "III", "III", "III", Character.valueOf('I'),
                        "ingotSilver" }));
        
        GameRegistry.addShapelessRecipe(stackIngotCopper, stackBlockCopper);
        GameRegistry.addShapelessRecipe(stackIngotSilver, stackBlockSilver);
    }

    private static void addFurnaceRecipes() {
        FurnaceRecipes.smelting().addSmelting(
                Reference.ORE_ID,
                Reference.ORE_COPPER_META_ID,
                new ItemStack(ExampleMods.ingotExampleMod, 1,
                        Reference.INGOT_COPPER_META_ID), 0.5F);

        FurnaceRecipes.smelting().addSmelting(
                Reference.ORE_ID,
                Reference.ORE_SILVER_META_ID,
                new ItemStack(ExampleMods.ingotExampleMod, 1,
                        Reference.INGOT_SILVER_META_ID), 1.0F);
    }

    private static void addBuckets() {
        GameRegistry.addRecipe(new ShapedOreRecipe(Item.bucketEmpty, true,
                new Object[] { "I I", " I ", Character.valueOf('I'),
                        "ingotCopper" }));

        GameRegistry.addRecipe(new ShapedOreRecipe(Item.bucketEmpty, true,
                new Object[] { "I I", " I ", Character.valueOf('I'),
                        "ingotSilver" }));
    }

    private static void addSwords() {
        GameRegistry.addRecipe(new ShapedOreRecipe(ExampleMods.swordCopper,
                true, new Object[] { " I ", " I ", " S ",
                        Character.valueOf('I'), "ingotCopper",
                        Character.valueOf('S'), Item.stick }));

        GameRegistry.addRecipe(new ShapedOreRecipe(ExampleMods.swordSilver,
                true, new Object[] { " I ", " I ", " S ",
                        Character.valueOf('I'), "ingotSilver",
                        Character.valueOf('S'), Item.stick }));
    }

    private static void addShovels() {
        GameRegistry.addRecipe(new ShapedOreRecipe(ExampleMods.shovelCopper,
                true, new Object[] { " I ", " S ", " S ",
                        Character.valueOf('I'), "ingotCopper",
                        Character.valueOf('S'), Item.stick }));

        GameRegistry.addRecipe(new ShapedOreRecipe(ExampleMods.shovelSilver,
                true, new Object[] { " I ", " S ", " S ",
                        Character.valueOf('I'), "ingotSilver",
                        Character.valueOf('S'), Item.stick }));
    }

    private static void addPicks() {
        GameRegistry.addRecipe(new ShapedOreRecipe(ExampleMods.pickaxeCopper,
                true, new Object[] { "III", " S ", " S ",
                        Character.valueOf('I'), "ingotCopper",
                        Character.valueOf('S'), Item.stick }));

        GameRegistry.addRecipe(new ShapedOreRecipe(ExampleMods.pickaxeSilver,
                true, new Object[] { "III", " S ", " S ",
                        Character.valueOf('I'), "ingotSilver",
                        Character.valueOf('S'), Item.stick }));
    }

    private static void addAxes() {
        GameRegistry.addRecipe(new ShapedOreRecipe(ExampleMods.axeCopper, true,
                new Object[] { "II ", "IS ", " S ", Character.valueOf('I'),
                        "ingotCopper", Character.valueOf('S'), Item.stick }));

        GameRegistry.addRecipe(new ShapedOreRecipe(ExampleMods.axeSilver, true,
                new Object[] { "II ", "IS ", " S ", Character.valueOf('I'),
                        "ingotSilver", Character.valueOf('S'), Item.stick }));
    }

    private static void addHoes() {
        GameRegistry.addRecipe(new ShapedOreRecipe(ExampleMods.hoeCopper, true,
                new Object[] { "II ", " S ", " S ", Character.valueOf('I'),
                        "ingotCopper", Character.valueOf('S'), Item.stick }));

        GameRegistry.addRecipe(new ShapedOreRecipe(ExampleMods.hoeSilver, true,
                new Object[] { "II ", " S ", " S ", Character.valueOf('I'),
                        "ingotSilver", Character.valueOf('S'), Item.stick }));
    }
    
    private static void addRings(){
        ItemStack stackIngotSilver = new ItemStack(
                ExampleMods.ingotExampleMod, 1,
                Reference.INGOT_SILVER_META_ID);
        
        ItemStack stackRingNetherSilver = new ItemStack(
                ExampleMods.ringNether, 1,
                Reference.RING_SILVER_META_ID);
        
        ItemStack stackRingNetherMining = new ItemStack(
                ExampleMods.ringNether, 1,
                Reference.RING_MINING_META_ID);
        
        ItemStack stackRingNetherRegen = new ItemStack(
                ExampleMods.ringNether, 1,
                Reference.RING_REGEN_META_ID);
        
        ItemStack stackRingNetherSpeed = new ItemStack(
                ExampleMods.ringNether, 1,
                Reference.RING_SPEED_META_ID);
        
        ItemStack stackRingNetherStrength = new ItemStack(
                ExampleMods.ringNether, 1,
                Reference.RING_STRENGTH_META_ID);
        
        GameRegistry.addRecipe(new ShapedOreRecipe(stackRingNetherSilver, true,
                new Object[] { "III", "I I", "III", Character.valueOf('I'),
                        "ingotSilver" }));
        
        GameRegistry.addShapelessRecipe(stackRingNetherMining, stackRingNetherSilver, new ItemStack(Item.diamond), new ItemStack(Item.netherStar, 1));
        GameRegistry.addShapelessRecipe(stackRingNetherRegen, stackRingNetherSilver, new ItemStack(Item.appleGold, 1, 1), new ItemStack(Item.netherStar, 1));
        GameRegistry.addShapelessRecipe(stackRingNetherSpeed, stackRingNetherSilver, new ItemStack(Item.bootsDiamond), new ItemStack(Item.netherStar, 1));
        GameRegistry.addShapelessRecipe(stackRingNetherStrength, stackRingNetherSilver, new ItemStack(Item.swordDiamond), new ItemStack(Item.netherStar, 1));
    }
}