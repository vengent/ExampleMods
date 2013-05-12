package net.arasaia.ExampleMods.worldgen;

import java.util.Random;

import net.arasaia.ExampleMods.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenExampleMod implements IWorldGenerator{

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world,
            IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        switch(world.provider.dimensionId){
            case -1:
                generateNether(world, random, chunkX*16, chunkZ*16);
                break;
            case 0:
                generateSurface(world, random, chunkX*16, chunkZ*16);
                break;
            case 1:
                generateEnd(world, random, chunkX*16, chunkZ*16);
                break;
        }
    }
    
    private void generateNether(World world, Random random, int i, int j){
        // nether generation
    }
    
    private void generateSurface(World world, Random random, int i, int j){
        int firstBlockXCoord = i + random.nextInt(16);
        int firstBlockYCoord = random.nextInt(Reference.ORE_COPPER_HEIGHT);
        int firstBlockZCoord = j + random.nextInt(16);
        
        // surface generation        
        // copper generation
        for(int k = 0; k < Reference.ORE_COPPER_VEINS_PER_CHUNK; k++){
            (new WorldGenMinable(Reference.ORE_ID, Reference.ORE_COPPER_META_ID, Reference.ORE_COPPER_PER_VEIN, Block.stone.blockID))
                .generate(world, random, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
            
            firstBlockXCoord = i + random.nextInt(16);
            firstBlockYCoord = random.nextInt(Reference.ORE_COPPER_HEIGHT);
            firstBlockZCoord = j + random.nextInt(16);
        }
        
        firstBlockXCoord = i + random.nextInt(16);
        firstBlockYCoord = random.nextInt(Reference.ORE_SILVER_HEIGHT);
        firstBlockZCoord = j + random.nextInt(16);
        
        //silver generation
        for(int k = 0; k < Reference.ORE_SILVER_VEINS_PER_CHUNK; k++){
            (new WorldGenMinable(Reference.ORE_ID, Reference.ORE_SILVER_META_ID, Reference.ORE_SILVER_PER_VEIN, Block.stone.blockID))
                .generate(world, random, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
            
            firstBlockXCoord = i + random.nextInt(16);
            firstBlockYCoord = random.nextInt(128);
            firstBlockZCoord = j + random.nextInt(16);
        }
    }
    
    private void generateEnd(World world, Random random, int i, int j){
        // end generation
    }
}
