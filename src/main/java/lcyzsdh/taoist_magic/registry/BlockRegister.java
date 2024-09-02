package lcyzsdh.taoist_magic.registry;

import lcyzsdh.taoist_magic.TaoistMagic;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class BlockRegister {
    public static final DeferredRegister.Blocks BLOCKS=DeferredRegister.createBlocks(TaoistMagic.MOD_ID);
    public static final List<DeferredBlock<Block>> BLOCK_LIST=new ArrayList<>();

    public static final DeferredBlock<Block> METAL_ORIGIN_STONE=register("metal_origin_stone");
    public static final DeferredBlock<Block> WATER_ORIGIN_STONE=register("water_origin_stone");
    public static final DeferredBlock<Block> WOOD_ORIGIN_STONE=register("wood_origin_stone");
    public static final DeferredBlock<Block> FIRE_ORIGIN_STONE=register("fire_origin_stone");
    public static final DeferredBlock<Block> DIRT_ORIGIN_STONE=register("dirt_origin_stone");

    public static final DeferredBlock<Block> PEACH_WOOD_PLANKS=register("peach_wood_planks",BlockBehaviour.Properties.of()
            .mapColor(MapColor.WOOD)
            .ignitedByLava()
            .instrument(NoteBlockInstrument.BASS)
            .strength(3.0F,4.0F)
            .sound(SoundType.WOOD));

    public static final DeferredBlock<Block> PEACH_WOOD_LOG=BLOCKS.register("peach_wood_log",()->new RotatedPillarBlock(
            BlockBehaviour.Properties.of()
                    .mapColor(p_152624_ -> p_152624_.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MapColor.WOOD : MapColor.PODZOL)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F)
                    .sound(SoundType.WOOD)
                    .ignitedByLava()
    ));

    public static DeferredBlock<Block> register(String name){
        DeferredBlock<Block> block=BLOCKS.registerSimpleBlock(name, BlockBehaviour.Properties.of());
        BLOCK_LIST.add(block);
        registerBlockItem(block,name);
        return block;
    }

    public static DeferredBlock<Block> register(String name,BlockBehaviour.Properties properties){
        DeferredBlock<Block> block=BLOCKS.registerSimpleBlock(name,properties);
        BLOCK_LIST.add(block);
        registerBlockItem(block,name);
        return block;
    }

    public static void registerBlockItem(Supplier<Block> block, String name){
        ItemRegister.ITEMS.register(name,()->new BlockItem(block.get(),new Item.Properties()));
    }
}
