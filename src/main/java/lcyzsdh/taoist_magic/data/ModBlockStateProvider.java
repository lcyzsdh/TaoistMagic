package lcyzsdh.taoist_magic.data;

import lcyzsdh.taoist_magic.TaoistMagic;
import lcyzsdh.taoist_magic.registry.BlockRegister;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, TaoistMagic.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        BlockRegister.BLOCK_LIST.forEach(block->this.simpleBlockWithItem(block.get(),cubeAll(block.get())));
        this.logBlock(BlockRegister.PEACH_WOOD_LOG.get());
        this.itemModels().getBuilder("peach_wood_log").parent(itemModels().getExistingFile(ResourceLocation.fromNamespaceAndPath(TaoistMagic.MOD_ID,"block/peach_wood_log")));
        this.simpleBlockWithItem(BlockRegister.PEACH_WOOD_LEAVES.get(),cubeAll(BlockRegister.PEACH_WOOD_LEAVES.get()));
        ModelFile modelFile=this.models().withExistingParent("peach_sapling","block/cross").texture("cross",ResourceLocation.fromNamespaceAndPath(TaoistMagic.MOD_ID, "block/peach_sapling")).renderType("cutout");
        this.simpleBlock(BlockRegister.PEACH_SAPLING.get(),modelFile);
        this.itemModels().getBuilder("peach_sapling")
                .parent(new ModelFile.UncheckedModelFile("item/generated"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(TaoistMagic.MOD_ID, "block/peach_sapling"));
    }
}
