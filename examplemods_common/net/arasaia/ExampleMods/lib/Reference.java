package net.arasaia.ExampleMods.lib;

import net.minecraft.item.EnumToolMaterial;
import net.minecraftforge.common.EnumHelper;

public abstract class Reference {
    public static final String MOD_ID = "ExampleMods";
    public static final String MOD_NAME = "Example Mods";
    public static final String MOD_VERSION = "0.0.1";
    
    // Block data
    public static final int BLOCK_METAL_ID = 540;
    public static final int BLOCK_METAL_COPPER_META_ID = 0;
    public static final int BLOCK_METAL_SILVER_META_ID = 1;
    
    /******************************************************/
    
    // Ore data
    public static final int ORE_ID = 538;
    public static final int ORE_PICKAXE_STONE_HARVEST_TOTAL = 2;
    
    // Ore world heights
    public static final int ORE_COPPER_HEIGHT = 64;
    public static final int ORE_SILVER_HEIGHT = 32;
    
    // Metadata ids for ore
    public static final int ORE_COPPER_META_ID = 0;
    public static final int ORE_SILVER_META_ID = 1;
    
    // Ores per vein
    public static final int ORE_COPPER_PER_VEIN = 10;
    public static final int ORE_SILVER_PER_VEIN = 6;
    
    // Veins per chunk
    public static final int ORE_COPPER_VEINS_PER_CHUNK = 12;
    public static final int ORE_SILVER_VEINS_PER_CHUNK = 7;
    
    /******************************************************/
    
    // Ingot data
    public static final int INGOT_ID = 539;
    public static final int INGOT_TOTAL = 2;
    
    // Metadata ids for ingots
    public static final int INGOT_COPPER_META_ID = 0;
    public static final int INGOT_SILVER_META_ID = 1;
    
    /******************************************************/
    
    // Copper tools
    public static final int SWORD_COPPER_ID = 541;
    public static final int SHOVEL_COPPER_ID = SWORD_COPPER_ID + 1;
    public static final int PICKAXE_COPPER_ID = SWORD_COPPER_ID + 2;
    public static final int AXE_COPPER_ID = SWORD_COPPER_ID + 3;
    public static final int HOE_COPPER_ID = SWORD_COPPER_ID + 4;
    
    // Silver tools
    public static final int SWORD_SILVER_ID = SWORD_COPPER_ID + 5;
    public static final int SHOVEL_SILVER_ID = SWORD_COPPER_ID + 6;
    public static final int PICKAXE_SILVER_ID = SWORD_COPPER_ID + 7;
    public static final int AXE_SILVER_ID = SWORD_COPPER_ID + 8;
    public static final int HOE_SILVER_ID = SWORD_COPPER_ID + 9;
    
    /******************************************************/
    
    // Tool materials
    public static final EnumToolMaterial TOOL_MATERIAL_COPPER = EnumHelper.addToolMaterial("Copper", 1, 59, 12.0F, 1, 14);
    public static final EnumToolMaterial TOOL_MATERIAL_SILVER = EnumHelper.addToolMaterial("Silver", 0, 40, 12.0F, 0, 22);
}