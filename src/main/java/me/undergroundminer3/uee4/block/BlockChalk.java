package me.undergroundminer3.uee4.block;

import me.undergroundminer3.uee4.item.ModItems;
import me.undergroundminer3.uee4.reference.Names;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

import java.util.Random;

public class BlockChalk extends BlockEE
{
    public BlockChalk()
    {
        super(Material.clay);
        this.setBlockName(Names.Items.CHALK);
        this.setHardness(0.6f);
        this.setStepSound(soundTypeStone);
    }

    @Override
    public Item getItemDropped(int par1, Random random, int par2)
    {
        return ModItems.chalk;
    }

    @Override
    public int quantityDropped(Random random)
    {
        return (random.nextInt(4) + 1);
    }
}
