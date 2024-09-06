package lcyzsdh.taoist_magic.registry;

import lcyzsdh.taoist_magic.TaoistMagic;
import lcyzsdh.taoist_magic.worldgen.PeachTreeFeature;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

public class BlockRegister {
    public static final DeferredRegister.Blocks BLOCKS=DeferredRegister.createBlocks(TaoistMagic.MOD_ID);
    public static final List<DeferredBlock<Block>> BLOCK_LIST=new ArrayList<>();//include normal blocks

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

    public static final DeferredBlock<RotatedPillarBlock> PEACH_WOOD_LOG=logRegister("peach_wood_log");
    public static final DeferredBlock<LeavesBlock> PEACH_WOOD_LEAVES=BLOCKS.register("peach_wood_leaves",()->new LeavesBlock(
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT)
                    .strength(0.2F)
                    .randomTicks()
                    .sound(SoundType.GRASS)
                    .noOcclusion()
                    .isValidSpawn(Blocks::ocelotOrParrot)
                    .isSuffocating((state,fe,e)->{return false;})
                    .isViewBlocking((state,fe,e)->{return false;})
                    .ignitedByLava()
                    .pushReaction(PushReaction.DESTROY)
                    .isRedstoneConductor((state,fe,e)->{return false;})
    ));
    public static final DeferredBlock<SaplingBlock> PEACH_SAPLING=BLOCKS.register("peach_sapling",()->new SaplingBlock(new TreeGrower("peach_wood",
            Optional.empty(),Optional.of(PeachTreeFeature.PEACH_TREE),Optional.empty()),BlockBehaviour.Properties.of()
            .noCollission()
            .randomTicks()
            .instabreak()
            .sound(SoundType.GRASS)
            .pushReaction(PushReaction.DESTROY)
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

    public static DeferredBlock<RotatedPillarBlock> logRegister(String name){
        DeferredBlock<RotatedPillarBlock> block=BLOCKS.register(name,()->new RotatedPillarBlock(
                BlockBehaviour.Properties.of()
                        .mapColor(state -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MapColor.WOOD : MapColor.PODZOL)
                        .instrument(NoteBlockInstrument.BASS)
                        .strength(2.0F)
                        .sound(SoundType.WOOD)
                        .ignitedByLava()
        ));
        ItemRegister.ITEMS.register(name,()->new BlockItem(block.get(),new Item.Properties()));
        return block;
    }

}
