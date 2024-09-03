package lcyzsdh.taoist_magic.data;

import lcyzsdh.taoist_magic.TaoistMagic;
import lcyzsdh.taoist_magic.registry.BlockRegister;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public static final TagKey<Block> PEACH_WOOD_LOGS=TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(TaoistMagic.MOD_ID,"peach_wood_logs"));
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, TaoistMagic.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        //Mod Tags
        this.tag(PEACH_WOOD_LOGS).add(BlockRegister.PEACH_WOOD_LOG.get());

        //Vanilla Tags
        this.tag(BlockTags.NEEDS_STONE_TOOL).add(BlockRegister.DIRT_ORIGIN_STONE.get());
        this.tag(BlockTags.NEEDS_STONE_TOOL).add(BlockRegister.WOOD_ORIGIN_STONE.get());
        this.tag(BlockTags.NEEDS_STONE_TOOL).add(BlockRegister.WATER_ORIGIN_STONE.get());
        this.tag(BlockTags.NEEDS_STONE_TOOL).add(BlockRegister.METAL_ORIGIN_STONE.get());
        this.tag(BlockTags.NEEDS_STONE_TOOL).add(BlockRegister.FIRE_ORIGIN_STONE.get());
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(BlockRegister.DIRT_ORIGIN_STONE.get());
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(BlockRegister.WOOD_ORIGIN_STONE.get());
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(BlockRegister.WATER_ORIGIN_STONE.get());
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(BlockRegister.METAL_ORIGIN_STONE.get());
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(BlockRegister.FIRE_ORIGIN_STONE.get());
    }
}
