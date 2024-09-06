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
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.BlockPredicateFilter;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class PeachTreePlacement {
    public static final ResourceKey<PlacedFeature> PEACH_TREE=ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(TaoistMagic.MOD_ID,"peach_tree"));

    public static void bootstrap(BootstrapContext<PlacedFeature> pContext){
        HolderGetter<ConfiguredFeature<?,?>> holderGetter=pContext.lookup(Registries.CONFIGURED_FEATURE);
        Holder<ConfiguredFeature<?,?>> holder=holderGetter.getOrThrow(PeachTreeFeature.PEACH_TREE);
        List<PlacementModifier> list=List.of(PlacementUtils.filteredByBlockSurvival(BlockRegister.PEACH_SAPLING.get()));
        PlacementUtils.register(pContext,PEACH_TREE,holder,list);
    }
}
