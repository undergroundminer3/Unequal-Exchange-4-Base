package me.undergroundminer3.uee4.emc;

import net.minecraftforge.event.entity.player.ItemTooltipEvent;

public final class EmcDisplayHelper {

	private EmcDisplayHelper() {};
	
	public static void addToolTips(final ItemTooltipEvent evt, final EmcData data, final String prefix) {
		final String[] gotData = getData(data);
		evt.toolTip.add(prefix+gotData[0]);
		evt.toolTip.add(prefix+gotData[1]);
		evt.toolTip.add(prefix+gotData[2]);
	}
	
	public static String[] getData(final EmcData data) {
		final String[] result = new String[3];
		
		result[0] = "n"+data.air+"w"+data.aqua+"_"+data.terra+"Z"+data.electra+"~"+data.nil+"{"+data.luma+"%"+data.or+"@"+data.viva;
		result[1] = "!"+data.temperature+"*"+data.potenta+"#"+data.strengtha+"^"+data.complexa+"["+data.modifa1+"]"+data.modifa2+"D"+data.mante;
		result[2] = "P"+data.kindoma+"U"+data.worlda+":"+data.luxa+"W"+data.mecha;
		
		return result;
	}
	
	public static EmcData getMax(final EmcData data1, final EmcData data2) {
		
		//do not call this in realtime, it will cause lag.
		
		final EmcData result = new EmcData();
		
		result.air = data1.air > data2.air ? data1.air : data2.air;
		result.aqua = data1.aqua > data2.aqua ? data1.aqua : data2.aqua;
		result.terra = data1.terra > data2.terra ? data1.terra : data2.terra;
		result.electra = data1.electra > data2.electra ? data1.electra : data2.electra;
		result.nil = data1.nil > data2.nil ? data1.nil : data2.nil;
		result.luma = data1.luma > data2.luma ? data1.luma : data2.luma;
		result.or = data1.or > data2.or ? data1.or : data2.or;
		result.viva = data1.viva > data2.viva ? data1.viva : data2.viva;

		result.temperature = data1.temperature > data2.temperature ? data1.temperature : data2.temperature;
		result.potenta = data1.potenta > data2.potenta ? data1.potenta : data2.potenta;
		result.strengtha = data1.strengtha > data2.strengtha ? data1.strengtha : data2.strengtha;
		result.complexa = data1.complexa > data2.complexa ? data1.complexa : data2.complexa;
		result.modifa1 = data1.modifa1 > data2.modifa1 ? data1.modifa1 : data2.modifa1;
		result.modifa2 = data1.modifa2 > data2.modifa2 ? data1.modifa2 : data2.modifa2;
		result.mante = data1.mante > data2.mante ? data1.mante : data2.mante;
		result.kindoma = data1.kindoma > data2.kindoma ? data1.kindoma : data2.kindoma;
		result.worlda = data1.worlda > data2.worlda ? data1.worlda : data2.worlda;
		result.luxa = data1.luxa > data2.luxa ? data1.luxa : data2.luxa;
		result.mecha = data1.mecha > data2.mecha ? data1.mecha : data2.mecha;
		
		return result;
	}
}
