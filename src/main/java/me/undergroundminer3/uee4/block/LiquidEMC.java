package me.undergroundminer3.uee4.block;

import me.undergroundminer3.uee4.abstacts.LiquidEE;

public class LiquidEMC extends LiquidEE {

	public LiquidEMC(final String name) {
		super(name);
		//TODO glowing like lava
		this.setLuminosity(16); //This shall do for now.
		this.setDensity(50);
		this.setTemperature(300);
		this.setViscosity(1000);
	}

}
