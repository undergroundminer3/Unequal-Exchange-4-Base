package me.undergroundminer3.uee4.init0;

import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.FluidRegistry;
import me.undergroundminer3.uee4.block.BlockAlchemicalChest;
import me.undergroundminer3.uee4.block.BlockAlchemicalFuel;
import me.undergroundminer3.uee4.block.BlockAludel;
import me.undergroundminer3.uee4.block.BlockCalcinator;
import me.undergroundminer3.uee4.block.BlockChalk;
import me.undergroundminer3.uee4.block.BlockGlassBell;
import me.undergroundminer3.uee4.block.BlockInfusedCloth;
import me.undergroundminer3.uee4.block.BlockInfusedPlank;
import me.undergroundminer3.uee4.block.BlockInfusedWood;
import me.undergroundminer3.uee4.block.BlockLiquidEMC;
import me.undergroundminer3.uee4.block.BlockResearchStation;
import me.undergroundminer3.uee4.block.LiquidEMC;
import me.undergroundminer3.uee4.init2.EmcBlocksInit;
import me.undergroundminer3.uee4.init2.EnginesInit;
import me.undergroundminer3.uee4.init2.PipesInit;
import me.undergroundminer3.uee4.item.ItemBlockAlchemicalChest;
import me.undergroundminer3.uee4.item.ItemBlockAlchemicalFuel;
import me.undergroundminer3.uee4.item.ItemBlockInfusedCloth;
import me.undergroundminer3.uee4.item.ItemBlockInfusedPlank;
import me.undergroundminer3.uee4.item.ItemBlockInfusedWood;
import me.undergroundminer3.uee4.reference.Names;
import me.undergroundminer3.uee4.worldgen.WorldGenEmcSpring;
import cpw.mods.fml.common.registry.GameRegistry;
import static me.undergroundminer3.uee4.init.ModBlocks.*;

public final class InitBlocks {

	private InitBlocks() {};

	public static void init0() {

		chalk = new BlockChalk();
		alchemicalFuel = new BlockAlchemicalFuel();
		infusedCloth = new BlockInfusedCloth();
		infusedWood = new BlockInfusedWood();
		infusedPlank = new BlockInfusedPlank();
		alchemicalChest = new BlockAlchemicalChest();
		aludel = new BlockAludel();
		calcinator = new BlockCalcinator();
		glassBell = new BlockGlassBell();
		researchStation = new BlockResearchStation();
		fluidEmc = new LiquidEMC(Names.Liquids.LIQUID_EMC);

		FluidRegistry.registerFluid(fluidEmc);
		liquidEmcBlock = new BlockLiquidEMC(fluidEmc, Material.lava);

		PipesInit.init0();

		EmcBlocksInit.init0();

		EnginesInit.init0();
	}

	public static void init1() {

		//TODO decide if we'll use the oredict or not
		//TODO FOR: Compatability
		//TODO FOR: Ores
		//TODO AGAINST: Keep things unequal
		//TODO AGAINST: Nobody else will try to register emc.

		GameRegistry.registerBlock(chalk, "tile." + Names.Items.CHALK);
		GameRegistry.registerBlock(alchemicalFuel, ItemBlockAlchemicalFuel.class, "tile." + Names.Items.ALCHEMICAL_FUEL);
		GameRegistry.registerBlock(infusedCloth, ItemBlockInfusedCloth.class, "tile." + Names.Blocks.INFUSED_CLOTH);
		GameRegistry.registerBlock(infusedWood, ItemBlockInfusedWood.class, "tile." + Names.Blocks.INFUSED_WOOD);
		GameRegistry.registerBlock(infusedPlank, ItemBlockInfusedPlank.class, "tile." + Names.Blocks.INFUSED_PLANK);
		GameRegistry.registerBlock(alchemicalChest, ItemBlockAlchemicalChest.class, "tile." + Names.Blocks.ALCHEMICAL_CHEST);
		GameRegistry.registerBlock(aludel, "tile." + Names.Blocks.ALUDEL);
		GameRegistry.registerBlock(calcinator, "tile." + Names.Blocks.CALCINATOR);
		GameRegistry.registerBlock(glassBell, "tile." + Names.Blocks.GLASS_BELL);
		GameRegistry.registerBlock(researchStation, "tile." + Names.Blocks.RESEARCH_STATION);

		GameRegistry.registerBlock(liquidEmcBlock, "tile." + Names.Liquids.LIQUID_EMC);
		fluidEmc.setUnlocalizedName("liquidEmc");

		GameRegistry.registerWorldGenerator(new WorldGenEmcSpring(), 32);

		PipesInit.init1();

		EmcBlocksInit.init1();

		EnginesInit.init1();
	}
}
