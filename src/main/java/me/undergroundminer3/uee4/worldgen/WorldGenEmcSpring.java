package me.undergroundminer3.uee4.worldgen;

import java.util.Random;

import me.undergroundminer3.uee4.block.ModBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenEmcSpring implements IWorldGenerator {

	@Override
	public void generate(Random arg0, int arg1, int arg2, World arg3,
			IChunkProvider arg4, IChunkProvider arg5) {

		if (arg0.nextBoolean() && arg0.nextBoolean()) {

			int x = arg1 * 16 + arg0.nextInt(16);
			int y = 68 + (arg0.nextInt(18) - 9);
			int z = arg2 * 16 + arg0.nextInt(16);

			if (arg3.getBiomeGenForCoords(x, z).biomeName.equals("Sky")) {

				arg3.setBlock(x, y, z, ModBlocks.liquidEmcBlock);
				arg3.notifyBlockChange(x, y, z, Blocks.water);
				arg3.notifyBlockChange(x, y, z, ModBlocks.liquidEmcBlock);

			}

		}

	}

}
