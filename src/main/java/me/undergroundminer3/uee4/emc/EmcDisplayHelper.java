package me.undergroundminer3.uee4.emc;

import net.minecraftforge.event.entity.player.ItemTooltipEvent;

public final class EmcDisplayHelper {

	private EmcDisplayHelper() {};
	
	public static void addToolTips(final ItemTooltipEvent evt, final EmcData data, final String prefix) {
		evt.toolTip.add(prefix+"n"+data.air+"w"+data.aqua+"_"+data.terra+"Z"+data.electra+"~"+data.nil+"{"+data.luma+"%"+data.or+"@"+data.viva);
		evt.toolTip.add(prefix+"!"+data.temperature+"*"+data.potenta+"#"+data.strengtha+"^"+data.complexa+"["+data.modifa1+"]"+data.modifa2+"D"+data.mante);
		evt.toolTip.add(prefix+"P"+data.kindoma+"U"+data.worlda+":"+data.luxa);
	}
}
