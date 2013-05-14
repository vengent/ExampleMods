package net.arasaia.ExampleMods;

import net.arasaia.ExampleMods.blocks.ItemExampleModBlock;
import net.arasaia.ExampleMods.blocks.OreExampleMods;
import net.arasaia.ExampleMods.items.AxeExampleMods;
import net.arasaia.ExampleMods.items.HoeExampleMods;
import net.arasaia.ExampleMods.items.IngotExampleMods;
import net.arasaia.ExampleMods.items.PickaxeExampleMods;
import net.arasaia.ExampleMods.items.ShovelExampleMods;
import net.arasaia.ExampleMods.items.SwordExampleMods;
import net.arasaia.ExampleMods.lib.Reference;
import net.arasaia.ExampleMods.worldgen.WorldGenExampleMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(
modid = Reference.MOD_ID,
name = Reference.MOD_NAME,
version = Reference.MOD_VERSION
)
public class ExampleMods {
    public static ExampleMods instance;
    
    // ores and ingots
    public static Block oreExampleMod;
    public static Item ingotExampleMod;
    
    // copper tools
    public static Item swordCopper;
    public static Item shovelCopper;
    public static Item pickaxeCopper;
    public static Item axeCopper;
    public static Item hoeCopper;
    
    // silver tools
    public static Item swordSilver;
    public static Item shovelSilver;
    public static Item pickaxeSilver;
    public static Item axeSilver;
    public static Item hoeSilver;
    
    @PreInit
    public void preInit(FMLPreInitializationEvent event){
        
    }
    
    @Init
    public void load(FMLInitializationEvent event){
        // Blocks
        this.initializeBlocks();
        this.registerBlocks();
        this.addBlockNames();
        this.setHarvestLevels();
        this.registerWorldGen();
        
        // Items
        this.initializeItems();
        this.initializeTools();
        this.registerItems(); // nothing at the moment
        this.addItemNames();
        
        // Ore dictionary registration
        this.registerOreDictionaryEntries();
        
        // Recipes
        ExampleModRecipes.addRecipes();
        
    }
    
    @PostInit
    public void modsLoaded(FMLPostInitializationEvent event){
        
    }
    
    private void initializeBlocks() {
        oreExampleMod = (new OreExampleMods(Reference.ORE_ID, Material.rock))
                .setUnlocalizedName("oreExampleMods");
    }

    private void registerBlocks() {
        GameRegistry.registerBlock(oreExampleMod, ItemExampleModBlock.class,
                Reference.MOD_ID+(oreExampleMod.getUnlocalizedName().substring(5)));
    }
    
    private void addBlockNames() {
        LanguageRegistry.addName(new ItemStack(oreExampleMod, 1, Reference.ORE_COPPER_META_ID), "Copper Ore");
        LanguageRegistry.addName(new ItemStack(oreExampleMod, 1, Reference.ORE_SILVER_META_ID), "Silver Ore");
    }
    
    private void setHarvestLevels() {
        MinecraftForge.setBlockHarvestLevel(oreExampleMod, "pickaxe", 1);        
    }
    
    private void registerWorldGen(){
        GameRegistry.registerWorldGenerator(new WorldGenExampleMod());
    }
    
    private void initializeItems(){
        ingotExampleMod = new IngotExampleMods(Reference.INGOT_ID);
    }
    
    private void initializeTools(){
        swordCopper = 
                new SwordExampleMods(
                        Reference.SWORD_COPPER_ID, 
                        Reference.TOOL_MATERIAL_COPPER, 
                        "Copper")
                    .setUnlocalizedName(Reference.MOD_ID + "swordCopper");
        
        swordSilver = 
                new SwordExampleMods(
                        Reference.SWORD_SILVER_ID, 
                        Reference.TOOL_MATERIAL_SILVER, 
                        "Silver")
                    .setUnlocalizedName(Reference.MOD_ID + "swordSilver");
        
        shovelCopper = 
                new ShovelExampleMods(
                        Reference.SHOVEL_COPPER_ID, 
                        Reference.TOOL_MATERIAL_COPPER, 
                        "Copper")
                    .setUnlocalizedName(Reference.MOD_ID + "shovelCopper");
        
        shovelSilver = 
                new ShovelExampleMods(
                        Reference.SHOVEL_SILVER_ID, 
                        Reference.TOOL_MATERIAL_SILVER, 
                        "Silver")
                    .setUnlocalizedName(Reference.MOD_ID + "shovelSilver");
        
        pickaxeCopper = 
                new PickaxeExampleMods(
                        Reference.PICKAXE_COPPER_ID, 
                        Reference.TOOL_MATERIAL_COPPER, 
                        "Copper")
                    .setUnlocalizedName(Reference.MOD_ID + "pickaxeCopper");
        
        pickaxeSilver = 
                new PickaxeExampleMods(
                        Reference.PICKAXE_SILVER_ID, 
                        Reference.TOOL_MATERIAL_SILVER, 
                        "Silver")
                    .setUnlocalizedName(Reference.MOD_ID + "pickaxeSilver");
        
        axeCopper = 
                new AxeExampleMods(
                        Reference.AXE_COPPER_ID, 
                        Reference.TOOL_MATERIAL_COPPER, 
                        "Copper")
                    .setUnlocalizedName(Reference.MOD_ID + "axeCopper");
        
        axeSilver = 
                new AxeExampleMods(
                        Reference.AXE_SILVER_ID, 
                        Reference.TOOL_MATERIAL_SILVER, 
                        "Silver")
                    .setUnlocalizedName(Reference.MOD_ID + "axeSilver");
        
        hoeCopper = 
                new HoeExampleMods(
                        Reference.HOE_COPPER_ID, 
                        Reference.TOOL_MATERIAL_COPPER, 
                        "Copper")
                    .setUnlocalizedName(Reference.MOD_ID + "hoeCopper");
        
        hoeSilver = 
                new HoeExampleMods(
                        Reference.HOE_SILVER_ID, 
                        Reference.TOOL_MATERIAL_SILVER, 
                        "Silver")
                    .setUnlocalizedName(Reference.MOD_ID + "hoeSilver");
        
        MinecraftForge.setToolClass(shovelCopper, "shovel", 1);
        MinecraftForge.setToolClass(shovelSilver, "shovel", 1);
        MinecraftForge.setToolClass(pickaxeCopper, "pickaxe", 1);
        MinecraftForge.setToolClass(pickaxeSilver, "pickaxe", 1);
        MinecraftForge.setToolClass(axeCopper, "axe", 1);
        MinecraftForge.setToolClass(axeSilver, "axe", 1);
    }
    
    private void registerItems(){
    }
    
    private void addItemNames(){
        LanguageRegistry.addName(new ItemStack(ingotExampleMod, 1, Reference.INGOT_COPPER_META_ID), "Copper Ingot");
        LanguageRegistry.addName(new ItemStack(ingotExampleMod, 1, Reference.INGOT_SILVER_META_ID), "Silver Ingot");
        
        LanguageRegistry.addName(swordCopper, "Copper Sword");
        LanguageRegistry.addName(swordSilver, "Silver Sword");
        LanguageRegistry.addName(shovelCopper, "Copper Shovel");
        LanguageRegistry.addName(shovelSilver, "Silver Shovel");
        LanguageRegistry.addName(pickaxeCopper, "Copper Pickaxe");
        LanguageRegistry.addName(pickaxeSilver, "Silver Pickaxe");
        LanguageRegistry.addName(axeCopper, "Copper Axe");
        LanguageRegistry.addName(axeSilver, "Silver Axe");
        LanguageRegistry.addName(hoeCopper, "Copper Hoe");
        LanguageRegistry.addName(hoeSilver, "Silver Hoe");
    }
    
    private void registerOreDictionaryEntries(){
        OreDictionary.registerOre("oreCopper", new ItemStack(oreExampleMod, 1, Reference.ORE_COPPER_META_ID));
        OreDictionary.registerOre("oreSilver", new ItemStack(oreExampleMod, 1, Reference.ORE_SILVER_META_ID));
        OreDictionary.registerOre("ingotCopper", new ItemStack(ingotExampleMod, 1, Reference.INGOT_COPPER_META_ID));
        OreDictionary.registerOre("ingotSilver", new ItemStack(ingotExampleMod, 1, Reference.INGOT_SILVER_META_ID));
    }
}
