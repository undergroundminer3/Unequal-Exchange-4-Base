package me.undergroundminer3.uee4.init1;

import me.undergroundminer3.uee4.init2.PipeModConnectors;

public final class ModConnectors {

	private ModConnectors() {};
	
	public static final void init0() { //preinit1
		
	}
	
	public static final void init1() { //preinit 2
		
	}
	
	public static final void init2() { //init 1
		PipeModConnectors.init2();
	}
	
	public static final void init3() { //init 2
		PipeModConnectors.init3();
	}
	
	public static final void init4() { //postinit 1
		
	}
	
	public static final void init5() { //postinit 2
		
	}
}
