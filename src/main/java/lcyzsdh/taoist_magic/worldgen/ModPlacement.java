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
    public static final ResourceKey<PlacedFeature> ORIGIN_STONE=ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(TaoistMagic.MOD_ID,"origin_stone"));
    public static final ResourceKey<PlacedFeature> PEACH_TREE=ResourceKey.create(Registries.PLACED_FEATURE,ResourceLocation.fromNamespaceAndPath(TaoistMagic.MOD_ID,"peach_tree"));
    public static void bootstrap(BootstrapContext<PlacedFeature> pContext){
        HolderGetter<ConfiguredFeature<?,?>> holderGetter1=pContext.lookup(Registries.CONFIGURED_FEATURE);
        Holder<ConfiguredFeature<?,?>> holder1 =holderGetter1.getOrThrow(ModFeatures.ORIGIN_STONE);
        HolderGetter<ConfiguredFeature<?,?>> holderGetter2=pContext.lookup(Registries.CONFIGURED_FEATURE);
        Holder<ConfiguredFeature<?,?>> holder2 =holderGetter2.getOrThrow(ModFeatures.PEACH_TREE);
        List<PlacementModifier> list=List.of(PlacementUtils.filteredByBlockSurvival(BlockRegister.PEACH_SAPLING.get()));

        PlacementUtils.register(pContext,PEACH_TREE, holder2,list);
        PlacementUtils.register(pContext,ORIGIN_STONE, holder1,commonOrePlacement(16,HeightRangePlacement.uniform(VerticalAnchor.absolute(-64),VerticalAnchor.absolute(100))));
    }

    private static List<PlacementModifier> commonOrePlacement(int pCount,PlacementModifier pHeight){
        return List.of(CountPlacement.of(pCount), InSquarePlacement.spread(),pHeight, BiomeFilter.biome());
    }
}
