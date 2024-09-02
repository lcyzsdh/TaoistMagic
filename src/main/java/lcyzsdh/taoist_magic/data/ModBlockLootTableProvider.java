package lcyzsdh.taoist_magic.data;

import lcyzsdh.taoist_magic.registry.BlockRegister;
import lcyzsdh.taoist_magic.registry.ItemRegister;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;

import java.util.Collections;
import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    public static final Set<Block> BLOCKS=Set.of(BlockRegister.DIRT_ORIGIN_STONE.get());
    protected ModBlockLootTableProvider( HolderLookup.Provider registries) {
        super(Collections.emptySet(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        this.add(BlockRegister.DIRT_ORIGIN_STONE.get(),pBlock->this.createOreDrop(pBlock, ItemRegister.DIRT_PIECE.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BLOCKS;
    }
}
