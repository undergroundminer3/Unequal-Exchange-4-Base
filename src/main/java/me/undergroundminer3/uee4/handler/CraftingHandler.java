package me.undergroundminer3.uee4.handler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import me.undergroundminer3.uee4.item.ModItems;
import me.undergroundminer3.uee4.item.crafting.RecipesAlchemicalBagDyes;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.oredict.OreDictionary;

public class CraftingHandler
{
	private CraftingHandler() {};

	public static void init()
	{

		// Add in the ability to dye Alchemical Bags
		CraftingManager.getInstance().getRecipeList().add(new RecipesAlchemicalBagDyes());

		GameRegistry.addRecipe(new ItemStack(ModItems.miniumStone), "WWW", "WOW", "WWW", 'W',
				new ItemStack(ModItems.miniumShard), 'O', new ItemStack(ModItems.inertStone));

		addReWoodRecipes();


		//SANDSTONE -> 3 SAND
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.sand, 3),
				new ItemStack(ModItems.miniumStone.setContainerItem(ModItems.miniumStone),
						1, OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.sandstone));

		//2GRAVEL -> 1FLINT
		GameRegistry.addShapelessRecipe(new ItemStack(Items.flint, 1),
				new ItemStack(ModItems.miniumStone.setContainerItem(ModItems.miniumStone),
						1, OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.gravel), new ItemStack(Blocks.gravel));

		addStairRecraftRecipes();
		addSlabRecraftRecipes();
		addMineralRecipes();
		addBucketRecipes();
		addMushroomRecipes();
		addSeedRecipes();
		addTreeShiftRecipes();

	}

	private static void addTreeShiftRecipes() {
		//TODO implement
	}

	private static void addReWoodRecipes() {

		//8PLANKS -> WOOD
		regCraft8(new ItemStack(Blocks.log), new ItemStack(Blocks.planks));

		//8STICKS -> PLANKS
		regCraft8(new ItemStack(Blocks.planks), new ItemStack(Items.stick));
	}

	private static void addSeedRecipes() {
		//2GRASS + 1 SEEDS -> 4SEEDS + 1DIRT
		GameRegistry.addShapelessRecipe(new ItemStack(Items.wheat_seeds, 4),
				new ItemStack(ModItems.miniumStone.setContainerItem(ModItems.miniumStone),
						1, OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.grass), new ItemStack(Blocks.grass),
						new ItemStack(Items.wheat_seeds.setContainerItem(Blocks.dirt.getItem(null, 0, 0, 0))));

		//2GRASS + 2 SEEDS -> 6SEEDS + 2DIRT
		GameRegistry.addShapelessRecipe(new ItemStack(Items.wheat_seeds, 6),
				new ItemStack(ModItems.miniumStone.setContainerItem(ModItems.miniumStone),
						1, OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.grass), new ItemStack(Blocks.grass),
						new ItemStack(Items.wheat_seeds.setContainerItem(Blocks.dirt.getItem(null, 0, 0, 0))),
						new ItemStack(Items.wheat_seeds.setContainerItem(Blocks.dirt.getItem(null, 0, 0, 0))));

		//2GRASS + 1 SEEDS -> 4SEEDS + 1DIRT

		GameRegistry.addShapelessRecipe(new ItemStack(Items.melon_seeds, 4),
				new ItemStack(ModItems.miniumStone.setContainerItem(ModItems.miniumStone),
						1, OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.grass), new ItemStack(Blocks.grass),
						new ItemStack(Items.melon_seeds.setContainerItem(Blocks.dirt.getItem(null, 0, 0, 0))));

		//2GRASS + 2 SEEDS -> 6SEEDS + 2DIRT
		GameRegistry.addShapelessRecipe(new ItemStack(Items.melon_seeds, 6),
				new ItemStack(ModItems.miniumStone.setContainerItem(ModItems.miniumStone),
						1, OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.grass), new ItemStack(Blocks.grass),
						new ItemStack(Items.melon_seeds.setContainerItem(Blocks.dirt.getItem(null, 0, 0, 0))),
						new ItemStack(Items.melon_seeds.setContainerItem(Blocks.dirt.getItem(null, 0, 0, 0))));

		//2GRASS + 1 SEEDS -> 4SEEDS + 1DIRT

		GameRegistry.addShapelessRecipe(new ItemStack(Items.pumpkin_seeds, 4),
				new ItemStack(ModItems.miniumStone.setContainerItem(ModItems.miniumStone),
						1, OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.grass), new ItemStack(Blocks.grass),
						new ItemStack(Items.pumpkin_seeds.setContainerItem(Blocks.dirt.getItem(null, 0, 0, 0))));

		//2GRASS + 2 SEEDS -> 6SEEDS + 2DIRT
		GameRegistry.addShapelessRecipe(new ItemStack(Items.pumpkin_seeds, 6),
				new ItemStack(ModItems.miniumStone.setContainerItem(ModItems.miniumStone),
						1, OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.grass), new ItemStack(Blocks.grass),
						new ItemStack(Items.pumpkin_seeds.setContainerItem(Blocks.dirt.getItem(null, 0, 0, 0))),
						new ItemStack(Items.pumpkin_seeds.setContainerItem(Blocks.dirt.getItem(null, 0, 0, 0))));
	}

	private static void addMineralRecipes() {
		//8IRON -> 1LAPIS
		regCraft8(new ItemStack(Items.dye, 1, 4),
				new ItemStack(Items.iron_ingot));

		//8LAPIS -> 1GOLD
		regCraft8N1(new ItemStack(Items.gold_ingot), new ItemStack(Items.gold_nugget),
				new ItemStack(Items.dye, 1, 4), new ItemStack(Items.dye, 1, 4));

		//8GOLD -> 1DIAMOND
		regCraft8(new ItemStack(Items.diamond),
				new ItemStack(Items.gold_ingot));

		//8IRON -> 1LAPIS
		regCraft8(new ItemStack(Blocks.lapis_block),
				new ItemStack(Blocks.iron_block));

		//8LAPIS -> 1GOLD
		regCraft8(new ItemStack(Blocks.gold_block),
				new ItemStack(Blocks.lapis_block));

		//8GOLD -> 1DIAMOND
		regCraft8(new ItemStack(Blocks.diamond_block),
				new ItemStack(Blocks.gold_block));

		//2COBBLE -> 1STONE
		regCraft2(new ItemStack(Blocks.stone), new ItemStack(Blocks.cobblestone));

		//TODO Hardcore: 8PANES -> 1GLASS?
		//8PANES -> 2GLASS
		regCraft8(new ItemStack(Blocks.glass, 2), new ItemStack(Blocks.glass_pane));

		//4SAND + 4GRAVEL -> 8CLAYBALLS
		GameRegistry.addShapelessRecipe(new ItemStack(Items.clay_ball, 8),
				new ItemStack(ModItems.miniumStone.setContainerItem(ModItems.miniumStone),
						1, OreDictionary.WILDCARD_VALUE),
						new ItemStack(Blocks.sand), new ItemStack(Blocks.sand),
						new ItemStack(Blocks.sand), new ItemStack(Blocks.sand),
						new ItemStack(Blocks.gravel), new ItemStack(Blocks.gravel),
						new ItemStack(Blocks.gravel), new ItemStack(Blocks.gravel));
	}

	private static void addMushroomRecipes() {
		//4BONEMEAL + 2MUSHROOM -> 16MUSHROOM
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.brown_mushroom, 16),
				new ItemStack(ModItems.miniumStone.setContainerItem(ModItems.miniumStone),
						1, OreDictionary.WILDCARD_VALUE),
						new ItemStack(Blocks.brown_mushroom), new ItemStack(Blocks.brown_mushroom),
						new ItemStack(Items.dye, 1, 15), new ItemStack(Items.dye, 1, 15),
						new ItemStack(Items.dye, 1, 15), new ItemStack(Items.dye, 1, 15));

		//4BONEMEAL + 2MUSHROOM -> 16MUSHROOM
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.red_mushroom_block, 16),
				new ItemStack(ModItems.miniumStone.setContainerItem(ModItems.miniumStone),
						1, OreDictionary.WILDCARD_VALUE),
						new ItemStack(Blocks.red_mushroom), new ItemStack(Blocks.red_mushroom),
						new ItemStack(Items.dye, 1, 15), new ItemStack(Items.dye, 1, 15),
						new ItemStack(Items.dye, 1, 15), new ItemStack(Items.dye, 1, 15));

		//1IRONBAR + 7IRONINGOT -> 1ENDERPEARL
		GameRegistry.addShapelessRecipe(new ItemStack(Items.ender_pearl),
				new ItemStack(ModItems.miniumStone.setContainerItem(ModItems.miniumStone),
						1, OreDictionary.WILDCARD_VALUE),
						new ItemStack(Blocks.iron_bars),
						new ItemStack(Items.iron_ingot), new ItemStack(Items.iron_ingot), new ItemStack(Items.iron_ingot),
						new ItemStack(Items.iron_ingot), new ItemStack(Items.iron_ingot), new ItemStack(Items.iron_ingot),
						new ItemStack(Items.iron_ingot));
	}

	private static void addBucketRecipes() {

		//1OBBY + 4 REDSTONE + 2 STONE -> 2OBBY
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.obsidian, 2),
				new ItemStack(ModItems.miniumStone.setContainerItem(ModItems.miniumStone),
						1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.redstone), new ItemStack(Items.redstone),
						new ItemStack(Items.redstone), new ItemStack(Items.redstone), new ItemStack(Blocks.stone),
						new ItemStack(Blocks.stone));

		//4STONE_PRESSURE + 2 BLAZEROD + 1 BUCKET -> 1 LAVA BUCKET 
		GameRegistry.addShapelessRecipe(new ItemStack(Items.lava_bucket),
				new ItemStack(ModItems.miniumStone.setContainerItem(ModItems.miniumStone),
						1, OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.stone_pressure_plate),
						new ItemStack(Blocks.stone_pressure_plate),
						new ItemStack(Blocks.stone_pressure_plate),
						new ItemStack(Blocks.stone_pressure_plate),
						new ItemStack(Items.blaze_rod),
						new ItemStack(Items.blaze_rod),
						new ItemStack(Items.bucket));

		//1OBBY + 1BLAZEROD + 1 BUCKET -> 1 LAVA BUCKET
		GameRegistry.addShapelessRecipe(new ItemStack(Items.lava_bucket),
				new ItemStack(ModItems.miniumStone.setContainerItem(ModItems.miniumStone),
						1, OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.obsidian),
						new ItemStack(Items.blaze_rod),
						new ItemStack(Items.bucket));

		//2ICE + 1BUCKET -> 1 WATER BUCKET
		GameRegistry.addShapelessRecipe(new ItemStack(Items.water_bucket),
				new ItemStack(ModItems.miniumStone.setContainerItem(ModItems.miniumStone),
						1, OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.ice),
						new ItemStack(Blocks.ice),
						new ItemStack(Items.bucket));


	}

	private static void addSlabRecraftRecipes() {
		//3SLABS -> 2STONE
		regCraft3(new ItemStack(Blocks.planks, 2, 0), new ItemStack(Blocks.wooden_slab, 1, 0));

		//3SLABS -> 2STONE
		regCraft3(new ItemStack(Blocks.planks, 2, 1), new ItemStack(Blocks.wooden_slab, 1, 1));

		//3SLABS -> 2STONE
		regCraft3(new ItemStack(Blocks.planks, 2, 2), new ItemStack(Blocks.wooden_slab, 1, 2));

		//3SLABS -> 2STONE
		regCraft3(new ItemStack(Blocks.planks, 2, 3), new ItemStack(Blocks.wooden_slab, 1, 3));

		//3SLABS -> 2STONE
		regCraft3(new ItemStack(Blocks.planks, 2, 4), new ItemStack(Blocks.wooden_slab, 1, 4));

		//3SLABS -> 2STONE
		regCraft3(new ItemStack(Blocks.planks, 2, 5), new ItemStack(Blocks.wooden_slab, 1, 5));

		//3SLABS -> 2STONE
		regCraft3(new ItemStack(Blocks.stone, 2), new ItemStack(Blocks.stone_slab, 1, 0));

		//3SLABS -> 2STONE
		regCraft3(new ItemStack(Blocks.sandstone, 2), new ItemStack(Blocks.stone_slab, 1, 1));

		//3SLABS -> 2STONE
		regCraft3(new ItemStack(Blocks.cobblestone, 2), new ItemStack(Blocks.stone_slab, 1, 2));

		//3SLABS -> 2STONE
		regCraft3(new ItemStack(Blocks.brick_block, 2), new ItemStack(Blocks.stone_slab, 1, 3));

		//3SLABS -> 2STONE
		regCraft3(new ItemStack(Blocks.stonebrick, 2), new ItemStack(Blocks.stone_slab, 1, 4));

		//3SLABS -> 2STONE
		regCraft3(new ItemStack(Blocks.nether_brick, 2), new ItemStack(Blocks.stone_slab, 1, 5));

		//3SLABS -> 2STONE
		regCraft3(new ItemStack(Blocks.quartz_block, 2), new ItemStack(Blocks.stone_slab, 1, 6));
	}

	private static void regCraft3(final ItemStack output, final ItemStack input) {
		GameRegistry.addShapelessRecipe(output,
				new ItemStack(ModItems.miniumStone.setContainerItem(ModItems.miniumStone),
						1, OreDictionary.WILDCARD_VALUE), input, input, input);
	}

	private static void regCraft2(final ItemStack output, final ItemStack input) {
		GameRegistry.addShapelessRecipe(output,
				new ItemStack(ModItems.miniumStone.setContainerItem(ModItems.miniumStone),
						1, OreDictionary.WILDCARD_VALUE), input, input);
	}

	private static void regCraft8(final ItemStack output, final ItemStack input) {
		GameRegistry.addShapelessRecipe(output,
				new ItemStack(ModItems.miniumStone.setContainerItem(ModItems.miniumStone),
						1, OreDictionary.WILDCARD_VALUE), input, input, input, input,
						input, input, input, input);
	}

	private static void regCraft1(final ItemStack output, final ItemStack input) {
		GameRegistry.addShapelessRecipe(output,
				new ItemStack(ModItems.miniumStone.setContainerItem(ModItems.miniumStone),
						1, OreDictionary.WILDCARD_VALUE), input);
	}

	private static void regCraft8N1(final ItemStack output8, final ItemStack output1,
			final ItemStack input8, final ItemStack input1) {
		regCraft8(output8, input8);
		regCraft1(output1, input1);
	}

	private static void addStairRecraftRecipes() {

		//2STAIRS -> 2PLANKS
		regCraft2(new ItemStack(Blocks.planks, 2, 0), new ItemStack(Blocks.oak_stairs, 1));

		//2STAIRS -> 2PLANKS
		regCraft2(new ItemStack(Blocks.planks, 2, 1), new ItemStack(Blocks.spruce_stairs, 1));

		//2STAIRS -> 2PLANKS
		regCraft2(new ItemStack(Blocks.planks, 2, 2), new ItemStack(Blocks.birch_stairs, 1));

		//2STAIRS -> 2PLANKS
		regCraft2(new ItemStack(Blocks.planks, 2, 3), new ItemStack(Blocks.jungle_stairs, 1));

		//2STAIRS -> 2PLANKS
		regCraft2(new ItemStack(Blocks.planks, 2, 4), new ItemStack(Blocks.acacia_stairs, 1));

		//2STAIRS -> 2PLANKS
		regCraft2(new ItemStack(Blocks.planks, 2, 5), new ItemStack(Blocks.dark_oak_stairs, 1));

		//2STAIRS -> 2STONE

		//2STAIRS -> 2PLANKS
		regCraft2(new ItemStack(Blocks.sandstone, 2), new ItemStack(Blocks.sandstone_stairs, 1));

		//2STAIRS -> 2STONE
		regCraft2(new ItemStack(Blocks.cobblestone, 2), new ItemStack(Blocks.stone_stairs, 1));

		//2STAIRS -> 2STONE
		regCraft2(new ItemStack(Blocks.brick_block, 2), new ItemStack(Blocks.brick_stairs, 1));

		//2STAIRS -> 2STONE
		regCraft2(new ItemStack(Blocks.stonebrick, 2), new ItemStack(Blocks.stone_brick_stairs, 1));

		//2STAIRS -> 2STONE
		regCraft2(new ItemStack(Blocks.nether_brick, 2), new ItemStack(Blocks.nether_brick_stairs, 1));

		//2STAIRS -> 2STONE
		regCraft2(new ItemStack(Blocks.quartz_block, 2), new ItemStack(Blocks.quartz_stairs, 1));
	}

	@SubscribeEvent
	public void onItemCraftedEvent(PlayerEvent.ItemCraftedEvent event)
	{
		// TODO Set owner on who crafted the item (make sure it's not a FakePlayer)
	}
}
