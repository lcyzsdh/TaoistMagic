package lcyzsdh.taoist_magic.worldgen;

import lcyzsdh.taoist_magic.TaoistMagic;
import lcyzsdh.taoist_magic.registry.BlockRegister;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModPlacement {
    public static final ResourceKey<PlacedFeature> WOOD_ORIGIN_STONE =ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(TaoistMagic.MOD_ID,"wood_origin_stone"));
    public static final ResourceKey<PlacedFeature> FIRE_ORIGIN_STONE =ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(TaoistMagic.MOD_ID,"fire_origin_stone"));
    public static final ResourceKey<PlacedFeature> WATER_ORIGIN_STONE =ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(TaoistMagic.MOD_ID,"water_origin_stone"));
    public static final ResourceKey<PlacedFeature> METAl_ORIGIN_STONE =ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(TaoistMagic.MOD_ID,"metal_origin_stone"));
    public static final ResourceKey<PlacedFeature> DIRT_ORIGIN_STONE =ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(TaoistMagic.MOD_ID,"dirt_origin_stone"));
    public static final ResourceKey<PlacedFeature> PEACH_TREE=ResourceKey.create(Registries.PLACED_FEATURE,ResourceLocation.fromNamespaceAndPath(TaoistMagic.MOD_ID,"peach_tree"));
    public static void bootstrap(BootstrapContext<PlacedFeature> pContext){
        HolderGetter<ConfiguredFeature<?,?>> holderGetter=pContext.lookup(Registries.CONFIGURED_FEATURE);
        Holder<ConfiguredFeature<?,?>> holder1 =holderGetter.getOrThrow(ModFeatures.DIRT_ORIGIN_STONE);
        Holder<ConfiguredFeature<?,?>> holder12 =holderGetter.getOrThrow(ModFeatures.WOOD_ORIGIN_STONE);
        Holder<ConfiguredFeature<?,?>> holder13 =holderGetter.getOrThrow(ModFeatures.FIRE_ORIGIN_STONE);
        Holder<ConfiguredFeature<?,?>> holder14 =holderGetter.getOrThrow(ModFeatures.METAL_ORIGIN_STONE);
        Holder<ConfiguredFeature<?,?>> holder15 =holderGetter.getOrThrow(ModFeatures.WATER_ORIGIN_STONE);
        Holder<ConfiguredFeature<?,?>> holder2 =holderGetter.getOrThrow(ModFeatures.PEACH_TREE);
        List<PlacementModifier> list=List.of(PlacementUtils.filteredByBlockSurvival(BlockRegister.PEACH_SAPLING.get()));

        PlacementUtils.register(pContext,PEACH_TREE, holder2,list);
        PlacementUtils.register(pContext, DIRT_ORIGIN_STONE, holder1,commonOrePlacement(16,HeightRangePlacement.uniform(VerticalAnchor.absolute(-60),VerticalAnchor.absolute(130))));
        PlacementUtils.register(pContext, WOOD_ORIGIN_STONE, holder12,commonOrePlacement(16,HeightRangePlacement.uniform(VerticalAnchor.absolute(-40),VerticalAnchor.absolute(130))));
        PlacementUtils.register(pContext, FIRE_ORIGIN_STONE, holder13,commonOrePlacement(12,HeightRangePlacement.uniform(VerticalAnchor.absolute(-80),VerticalAnchor.absolute(100))));
        PlacementUtils.register(pContext, METAl_ORIGIN_STONE, holder14,commonOrePlacement(12,HeightRangePlacement.uniform(VerticalAnchor.absolute(-80),VerticalAnchor.absolute(100))));
        PlacementUtils.register(pContext, WATER_ORIGIN_STONE, holder15,commonOrePlacement(14,HeightRangePlacement.uniform(VerticalAnchor.absolute(-10),VerticalAnchor.absolute(140))));

    }

    private static List<PlacementModifier> commonOrePlacement(int pCount,PlacementModifier pHeight){
        return List.of(CountPlacement.of(pCount), InSquarePlacement.spread(),pHeight, BiomeFilter.biome());
    }
}
