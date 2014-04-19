package me.undergroundminer3.uee4.emc;

public class EmcData {

	//influenced by thuamcraft?

	public int air; //air
	public int aqua; //water
	public int terra; //stone
	public int electra; //electricity
	public int nil; //void
	public int luma; //light r*g*b (colored lights) or l*l*l
	public int or; //mineral
	public int viva; //living (hunger*20)

	public int temperature; //hot+ 0room0 cold-
	public int potenta; //fuel, burning time in ticks?
	public int strengtha; //strength (wood-grass)
	public int complexa; //complexity (buildcraft quarry vs redstone) -tinytech- 0normal0 +supertech+
	public int modifa1; //spare modifier
	public int modifa2; //spare modifier
	public int mante; //glass-like -reflective- 0stone0 +mirror+
	public int kindoma; // -plant- 0neutral0 +animal+
	public int worlda; // -nether- 0overworld0 +end+
	public int luxa; //luxury, swamp and dirt, vs biomes o plenty promised land

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

		return result;
	}

}
