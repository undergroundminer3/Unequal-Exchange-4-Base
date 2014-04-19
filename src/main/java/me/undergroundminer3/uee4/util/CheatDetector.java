package me.undergroundminer3.uee4.util;

import me.undergroundminer3.uee4.config.Config;

public final class CheatDetector {

	private CheatDetector() {};
	
	public static void detectCheats(boolean silence) {
		if (!Config.allowCheats) {
			detectCheats_do();
			if (!silence) LogHelper.info("Unequal Exchange 4 did not detect any cheats. You're a true minecrafter.");
		} else {
			if (!silence) LogHelper.warn("Unequal Exchange Cheat detection was disabled. (Now, who could have done that?)");
		}
	}
	
	private static void detectCheats_do() {
		
		boolean ue = true;
		
		try {
			Class.forName("universalElectricity.core.UELoader");
		} catch (ClassNotFoundException e) {
			ue = false;
		}
		
		if (ue == true) {
			LogHelper.fatal("[UEE4] Cheat: UE Detected!");
			throw new RuntimeException("Universal Electricity was Detected! THIS IS CHEATING!!! (ENERGYCONV)");
		}
		
		boolean mec = true;
		
		try {
			Class.forName("mekanism.common.Mekanism");
		} catch (ClassNotFoundException e) {
			mec = false;
		}
		
		if (mec == true) {
			LogHelper.fatal("[UEE4] Cheat: Mekanism Detected!");
			throw new RuntimeException("Mekanism was Detected! THIS IS CHEATING!!! (ENERGYCONV)");
		}
		
		boolean pcConv = true;
		
		try {
			Class.forName("powercrystals.powerconverters.PowerConverterCore");
		} catch (ClassNotFoundException e) {
			pcConv = false;
		}
		
		if (pcConv == true) {
			LogHelper.fatal("[UEE4] Cheat: PowerConverters Detected!");
			throw new RuntimeException("Power Converters were Detected! THIS IS CHEATING!!! (ENERGYCONV)");
		}
		
		boolean altConv = true;
		
		try {
			Class.forName("alternatemods.alteng.AlternateEnergy");
		} catch (ClassNotFoundException e) {
			altConv = false;
		}
		
		if (altConv == true) {
			LogHelper.fatal("[UEE4] Cheat: PowerBoxes Detected!");
			throw new RuntimeException("Power Boxes were Detected! THIS IS CHEATING!!! (ENERGYCONV)");
		}
	}
}
