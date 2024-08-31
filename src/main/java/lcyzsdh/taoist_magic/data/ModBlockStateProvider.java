package lcyzsdh.taoist_magic.data;

import lcyzsdh.taoist_magic.TaoistMagic;
import lcyzsdh.taoist_magic.registry.BlockRegister;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, TaoistMagic.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        BlockRegister.BLOCK_LIST.forEach(block->this.simpleBlockWithItem(block.get(),cubeAll(block.get())));
    }
}
