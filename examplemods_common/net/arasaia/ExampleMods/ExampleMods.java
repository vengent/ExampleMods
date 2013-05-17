package net.arasaia.ExampleMods;

import net.arasaia.ExampleMods.blocks.BlockMetalExampleMods;
import net.arasaia.ExampleMods.blocks.ItemExampleModBlock;
import net.arasaia.ExampleMods.blocks.OreExampleMods;
import net.arasaia.ExampleMods.items.AxeExampleMods;
import net.arasaia.ExampleMods.items.HoeExampleMods;
import net.arasaia.ExampleMods.items.IngotExampleMods;
import net.arasaia.ExampleMods.items.PickaxeExampleMods;
import net.arasaia.ExampleMods.items.RingNether;
import net.arasaia.ExampleMods.items.ShovelExampleMods;
import net.arasaia.ExampleMods.items.SwordExampleMods;
import net.arasaia.ExampleMods.handlers.PlayerTickHandler;
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
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

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
    
    // metal blocks
    public static Block blockMetalExampleMod;
    
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
    
    // rings
    public static Item ringNether;
    
    @PreInit
    public void preInit(FMLPreInitializationEvent event){
        // TODO: straighten up server/client handlers
        TickRegistry.registerTickHandler(new PlayerTickHandler(),  Side.CLIENT);
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
        this.initializeArmor();
        this.registerItems();
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
        // Ore blocks
        oreExampleMod = (new OreExampleMods(Reference.ORE_ID, Material.rock))
                .setUnlocalizedName("oreExampleMods");
        
        // Metal blocks
        blockMetalExampleMod = (new BlockMetalExampleMods(Reference.BLOCK_METAL_ID, Material.iron))
                .setUnlocalizedName("blockMetalExampleMods");
    }

    private void registerBlocks() {
        GameRegistry.registerBlock(oreExampleMod, ItemExampleModBlock.class,
                Reference.MOD_ID+(oreExampleMod.getUnlocalizedName().substring(5)));
        
        GameRegistry.registerBlock(blockMetalExampleMod, ItemExampleModBlock.class,
                Reference.MOD_ID+(blockMetalExampleMod.getUnlocalizedName().substring(5)));
    }
    
    private void addBlockNames() {
        LanguageRegistry.addName(new ItemStack(oreExampleMod, 1, Reference.ORE_COPPER_META_ID), "Copper Ore");
        LanguageRegistry.addName(new ItemStack(oreExampleMod, 1, Reference.ORE_SILVER_META_ID), "Silver Ore");
        LanguageRegistry.addName(new ItemStack(blockMetalExampleMod, 1, Reference.ORE_COPPER_META_ID), "Copper Block");
        LanguageRegistry.addName(new ItemStack(blockMetalExampleMod, 1, Reference.ORE_SILVER_META_ID), "Silver Block");
    }
    
    private void setHarvestLevels() {
        MinecraftForge.setBlockHarvestLevel(oreExampleMod, "pickaxe", 1);
        MinecraftForge.setBlockHarvestLevel(blockMetalExampleMod, "pickaxe", 1);
    }
    
    private void registerWorldGen(){
        GameRegistry.registerWorldGenerator(new WorldGenExampleMod());
    }
    
    private void initializeItems(){
        ingotExampleMod = new IngotExampleMods(Reference.INGOT_ID);
        ringNether = new RingNether(Reference.RING_ID);
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
    
    private void initializeArmor(){
        // TODO: initializeArmor()
    }
    
    private void registerItems(){
        
    }
    
    private void addItemNames(){
        // Ingots
        LanguageRegistry.addName(new ItemStack(ingotExampleMod, 1, Reference.INGOT_COPPER_META_ID), "Copper Ingot");
        LanguageRegistry.addName(new ItemStack(ingotExampleMod, 1, Reference.INGOT_SILVER_META_ID), "Silver Ingot");
        
        // Tools
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
        
        // Rings
        LanguageRegistry.addName(new ItemStack(ringNether, 1, Reference.RING_MINING_META_ID), "Miner's Ring");
        LanguageRegistry.addName(new ItemStack(ringNether, 1, Reference.RING_REGEN_META_ID), "Ring of Regeneration");
        LanguageRegistry.addName(new ItemStack(ringNether, 1, Reference.RING_SILVER_META_ID), "Silver Ring");
        LanguageRegistry.addName(new ItemStack(ringNether, 1, Reference.RING_SPEED_META_ID), "Ring of Speed");
        LanguageRegistry.addName(new ItemStack(ringNether, 1, Reference.RING_STRENGTH_META_ID), "Ring of Strength");
    }
    
    private void registerOreDictionaryEntries(){
        OreDictionary.registerOre("oreCopper", new ItemStack(oreExampleMod, 1, Reference.ORE_COPPER_META_ID));
        OreDictionary.registerOre("oreSilver", new ItemStack(oreExampleMod, 1, Reference.ORE_SILVER_META_ID));
        OreDictionary.registerOre("ingotCopper", new ItemStack(ingotExampleMod, 1, Reference.INGOT_COPPER_META_ID));
        OreDictionary.registerOre("ingotSilver", new ItemStack(ingotExampleMod, 1, Reference.INGOT_SILVER_META_ID));
    }
}
