package me.undergroundminer3.uee4.emc;

public class EmcData {

	//influenced by thuamcraft?

	//matter
	public int air; //air CH0
	public int aqua; //water CH1
	public int terra; //stone CH2
	public int electra; //electricity CH3
	public int nil; //void CH4
	public int luma; //light r*g*b (colored lights) or l*l*l CH5
	public int or; //mineral CH6
	public int viva; //living (hunger*20) CH7

	//energy
	public int temperature; //hot+ 0room0 cold- CH8
	public int potenta; //fuel, burning time in ticks? CH9
	public int strengtha; //strength (wood-grass) CH10
	public int complexa; //complexity (buildcraft quarry vs redstone) -tinytech- 0normal0 +supertech+ CH11
	public int modifa1; //spare modifier CH12
	public int modifa2; //spare modifier CH13
	public int mante; //glass-like -reflective- 0stone0 +mirror+ CH14
	public int kindoma; // -plant- 0neutral0 +animal+ CH15
	public int worlda; // -nether- 0overworld0 +end+ CH16
	public int luxa; //luxury, swamp and dirt, vs biomes o plenty promised land CH17
	public int mecha; //mechanical gears CH18

	//TODO able to add properties?

	@Override
	public Object clone() {
		final EmcData result = new EmcData();

		result.air = this.air;
		result.aqua = this.aqua;
		result.terra = this.terra;
		result.electra = this.electra;
		result.nil = this.nil;
		result.luma = this.luma;
		result.or = this.or;
		result.viva = this.viva;

		result.temperature = this.temperature;
		result.potenta = this.potenta;
		result.strengtha = this.strengtha;
		result.complexa = this.complexa;
		result.modifa1 = this.modifa1;
		result.modifa2 = this.modifa2;
		result.mante = this.mante;
		result.kindoma = this.kindoma;
		result.worlda = this.worlda;
		result.luxa = this.luxa;
		result.mecha = this.mecha;

		return result;
	}

	public EmcData mul(final int ammount) {
		final EmcData result = new EmcData();

		result.air = this.air * ammount;
		result.aqua = this.aqua * ammount;
		result.terra = this.terra * ammount;
		result.electra = this.electra * ammount;
		result.nil = this.nil * ammount;
		result.luma = this.luma * ammount;
		result.or = this.or * ammount;
		result.viva = this.viva * ammount;

		result.temperature = this.temperature * ammount;
		result.potenta = this.potenta * ammount;
		result.strengtha = this.strengtha * ammount;
		result.complexa = this.complexa * ammount;
		result.modifa1 = this.modifa1 * ammount;
		result.modifa2 = this.modifa2 * ammount;
		result.mante = this.mante * ammount;
		result.kindoma = this.kindoma * ammount;
		result.worlda = this.worlda * ammount;
		result.luxa = this.luxa * ammount;
		result.mecha = this.mecha * ammount;

		return result;
	}

}
