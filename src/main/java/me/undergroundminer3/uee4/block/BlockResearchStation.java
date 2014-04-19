package me.undergroundminer3.uee4.block;

import me.undergroundminer3.uee4.reference.Names;
import me.undergroundminer3.uee4.reference.RenderIds;
import me.undergroundminer3.uee4.tileentity.TileResearchStation;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockResearchStation extends BlockEE implements ITileEntityProvider
{
    public BlockResearchStation()
    {
        super(Material.rock);
        this.setHardness(2.0f);
        this.setBlockName(Names.Blocks.RESEARCH_STATION);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int metaData)
    {
        return new TileResearchStation();
    }

    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
    public int getRenderType()
    {
        return RenderIds.researchStation;
    }
}
