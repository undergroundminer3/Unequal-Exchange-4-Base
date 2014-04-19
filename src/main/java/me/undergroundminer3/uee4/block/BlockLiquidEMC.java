package me.undergroundminer3.uee4.block;

import me.undergroundminer3.uee4.util.LogHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.Fluid;

public class BlockLiquidEMC extends BlockLiquidEE {

	public BlockLiquidEMC(Fluid fluid, Material material) {
		super(fluid, material);
		this.setLightOpacity(4);
//		this.maxScaledLight = 16;
//		this.lightValue = 16;
//		this.lightOpacity = 1;
		
	}

//	@Override
//	public int getLightValue() {
//		return 15;
//	}


}
