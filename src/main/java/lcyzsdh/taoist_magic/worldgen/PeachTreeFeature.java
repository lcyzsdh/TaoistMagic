package lcyzsdh.taoist_magic.worldgen;

import lcyzsdh.taoist_magic.TaoistMagic;
import lcyzsdh.taoist_magic.registry.BlockRegister;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.AcaciaFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;

public class PeachTreeFeature {
    public static final ResourceKey<ConfiguredFeature<?,?>> PEACH_TREE=ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(TaoistMagic.MOD_ID,"peach_tree"));

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?,?>> pContext){
        TreeConfiguration configuration= new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(BlockRegister.PEACH_WOOD_LOG.get()),
                new ForkingTrunkPlacer(4,1,1),
                BlockStateProvider.simple(BlockRegister.PEACH_WOOD_LEAVES.get()),
                new AcaciaFoliagePlacer(ConstantInt.of(3),ConstantInt.of(0)),
                new TwoLayersFeatureSize(2,0,2)

        ).ignoreVines().build();
        FeatureUtils.register(pContext,PEACH_TREE, Feature.TREE,configuration);
    }
}
