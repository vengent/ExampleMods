package net.arasaia.ExampleMods;

import net.arasaia.ExampleMods.blocks.ItemExampleModBlock;
import net.arasaia.ExampleMods.blocks.OreExampleMods;
import net.arasaia.ExampleMods.items.IngotExampleMods;
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
    
    public static Block oreExampleMod;
    public static Item ingotExampleMod;
    
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
        ingotExampleMod = (new IngotExampleMods(Reference.INGOT_ID))
                .setUnlocalizedName("ingotExampleMod");
    }
    
    private void registerItems(){
    }
    
    private void addItemNames(){
        LanguageRegistry.addName(new ItemStack(ingotExampleMod, 1, Reference.INGOT_COPPER_META_ID), "Copper Ingot");
        LanguageRegistry.addName(new ItemStack(ingotExampleMod, 1, Reference.INGOT_SILVER_META_ID), "Silver Ingot");
    }
    
    private void registerOreDictionaryEntries(){
        OreDictionary.registerOre("oreCopper", new ItemStack(oreExampleMod, 1, Reference.ORE_COPPER_META_ID));
        OreDictionary.registerOre("oreSilver", new ItemStack(oreExampleMod, 1, Reference.ORE_SILVER_META_ID));
        OreDictionary.registerOre("ingotCopper", new ItemStack(ingotExampleMod, 1, Reference.INGOT_COPPER_META_ID));
        OreDictionary.registerOre("ingotSilver", new ItemStack(ingotExampleMod, 1, Reference.INGOT_SILVER_META_ID));
    }
}
