package lcyzsdh.taoist_magic.worldgen;

import lcyzsdh.taoist_magic.TaoistMagic;
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

public class OriginStonePlacement {
    public static final ResourceKey<PlacedFeature> ORIGIN_STONE=ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(TaoistMagic.MOD_ID,"origin_stone"));

    public static void bootstrap(BootstrapContext<PlacedFeature> pContext){
        HolderGetter<ConfiguredFeature<?,?>> holderGetter=pContext.lookup(Registries.CONFIGURED_FEATURE);
        Holder<ConfiguredFeature<?,?>> stoneHolder=holderGetter.getOrThrow(OriginStoneFeatures.ORIGIN_STONE);
        PlacementUtils.register(pContext,ORIGIN_STONE,stoneHolder,commonOrePlacement(16,HeightRangePlacement.uniform(VerticalAnchor.absolute(-64),VerticalAnchor.absolute(70))));
    }

    private static List<PlacementModifier> commonOrePlacement(int pCount,PlacementModifier pHeight){
        return List.of(CountPlacement.of(pCount), InSquarePlacement.spread(),pHeight, BiomeFilter.biome());
    }
}
