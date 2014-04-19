package me.undergroundminer3.uee4.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import me.undergroundminer3.uee4.reference.Names;
import me.undergroundminer3.uee4.util.NBTHelper;
import net.minecraft.item.ItemStack;

public class ItemMiniumStone extends ItemEE
{
    public ItemMiniumStone()
    {
        super();
        this.setUnlocalizedName(Names.Items.MINIUM_STONE);
        this.setMaxDamage(1000); // TODO Get this from configs
    }

    @Override
    public boolean doesContainerItemLeaveCraftingGrid(ItemStack itemStack)
    {
        return false;
    }

    @Override
    public boolean getShareTag()
    {
        return true;
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack)
    {
        ItemStack copiedStack = itemStack.copy();

        copiedStack.setItemDamage(copiedStack.getItemDamage() + 1);
        copiedStack.stackSize = 1;

        return copiedStack;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack itemStack, int renderPass)
    {
        return NBTHelper.hasTag(itemStack, Names.NBT.CRAFTING_GUI_OPEN) || NBTHelper.hasTag(itemStack, Names.NBT.TRANSMUTATION_GUI_OPEN);
    }
}
