package WGHxPERNAxBEAST.basicallyanything.worldgen;

import java.util.Random;

import WGHxPERNAxBEAST.basicallyanything.blocks.BlockPlatinumNuggetOre;
import WGHxPERNAxBEAST.basicallyanything.blocks.BlockTinOre;
import WGHxPERNAxBEAST.basicallyanything.handlers.EnumHandler.OreType;
import WGHxPERNAxBEAST.basicallyanything.init.ModBlocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class OreGen implements IWorldGenerator {
	
	//World Generators
	private WorldGenerator platinum_overworld;
	private WorldGenerator platinum_nugget_overworld;
	private WorldGenerator platinum_nugget_end;
	private WorldGenerator platinum_nugget_nether;
	private WorldGenerator tin_overworld;
	private WorldGenerator tin_nether;
	private WorldGenerator tin_end;

	
	public OreGen() {
		platinum_overworld = new WorldGenMinable(ModBlocks.platinum_ore.getDefaultState(), 4);
		platinum_nugget_overworld = new WorldGenMinable(ModBlocks.platinum_nugget_ore.getDefaultState(), 12);
		platinum_nugget_end = new WorldGenMinable(ModBlocks.platinum_nugget_ore.getDefaultState().withProperty(BlockPlatinumNuggetOre.TYPE, OreType.END), 14, new EndGenPredicate());
		platinum_nugget_nether = new WorldGenMinable(ModBlocks.platinum_nugget_ore.getDefaultState().withProperty(BlockPlatinumNuggetOre.TYPE, OreType.NETHER), 14, new NetherGenPredicate());
tin_overworld = new WorldGenMinable(
				ModBlocks.tinOre.getDefaultState().withProperty(BlockTinOre.TYPE, OreType.OVERWORLD), 8); //Here we are saying that our ore spawns in veins of up to 8
		tin_nether = new WorldGenMinable(
				ModBlocks.tinOre.getDefaultState().withProperty(BlockTinOre.TYPE, OreType.NETHER), 8,
				new NetherGenPredicate()); //Uses the nether predicate so that when it is being generated it replaces the netherrack
		tin_end = new WorldGenMinable(ModBlocks.tinOre.getDefaultState().withProperty(BlockTinOre.TYPE, OreType.END), 8,
				new EndGenPredicate());

	}
	
	private void runGenerator(WorldGenerator generator, World world, Random rand, int chunk_X, int chunk_Z, int chancesToSpawn, int minHeight, int maxHeight) {
		if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
			throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");

		int heightDiff = maxHeight - minHeight + 1;
		for (int i = 0; i < chancesToSpawn; i ++) {
			int x = chunk_X * 16 + rand.nextInt(16);
		        int y = minHeight + rand.nextInt(heightDiff);
		        int z = chunk_Z * 16 + rand.nextInt(16);
		        generator.generate(world, rand, new BlockPos(x, y, z));
		}
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {
		switch(world.provider.getDimension()) {
		case 0: //OverWorld
			this.runGenerator(platinum_overworld, world, random, chunkX, chunkZ, 2, 0, 20);
			this.runGenerator(platinum_nugget_overworld, world, random, chunkX, chunkZ, 6, 0, 85);
			this.runGenerator(tin_overworld, world, random, chunkX, chunkZ, 30, 0, 64);

			break;
		case 1: //End
			this.runGenerator(platinum_nugget_end, world, random, chunkX, chunkZ, 6, 0, 85);
			this.runGenerator(tin_end, world, random, chunkX, chunkZ, 30, 0, 256);

			break;
		case -1: //Nether
			this.runGenerator(platinum_nugget_nether, world, random, chunkX, chunkZ, 6, 0, 85);			this.runGenerator(tin_nether, world, random, chunkX, chunkZ, 30, 0, 64);

			break;
		}
	}

}

