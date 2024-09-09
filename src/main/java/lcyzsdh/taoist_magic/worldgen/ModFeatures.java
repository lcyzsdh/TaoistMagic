package lcyzsdh.taoist_magic.worldgen;

import lcyzsdh.taoist_magic.TaoistMagic;
import lcyzsdh.taoist_magic.registry.BlockRegister;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.AcaciaFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModFeatures {
    public static final ResourceKey<ConfiguredFeature<?,?>> DIRT_ORIGIN_STONE=ResourceKey.create(Registries.CONFIGURED_FEATURE,ResourceLocation.fromNamespaceAndPath(TaoistMagic.MOD_ID,"dirt_origin_stone"));
    public static final ResourceKey<ConfiguredFeature<?,?>> WOOD_ORIGIN_STONE=ResourceKey.create(Registries.CONFIGURED_FEATURE,ResourceLocation.fromNamespaceAndPath(TaoistMagic.MOD_ID,"wood_origin_stone"));
    public static final ResourceKey<ConfiguredFeature<?,?>> WATER_ORIGIN_STONE=ResourceKey.create(Registries.CONFIGURED_FEATURE,ResourceLocation.fromNamespaceAndPath(TaoistMagic.MOD_ID,"water_origin_stone"));
    public static final ResourceKey<ConfiguredFeature<?,?>> FIRE_ORIGIN_STONE=ResourceKey.create(Registries.CONFIGURED_FEATURE,ResourceLocation.fromNamespaceAndPath(TaoistMagic.MOD_ID,"fire_origin_stone"));
    public static final ResourceKey<ConfiguredFeature<?,?>> METAL_ORIGIN_STONE=ResourceKey.create(Registries.CONFIGURED_FEATURE,ResourceLocation.fromNamespaceAndPath(TaoistMagic.MOD_ID,"metal_origin_stone"));
    public static final ResourceKey<ConfiguredFeature<?,?>> PEACH_TREE=ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(TaoistMagic.MOD_ID,"peach_tree"));

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?,?>> pContext){
        RuleTest stoneOreRuleTest=new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepSlateOreRuleTest=new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        List<OreConfiguration.TargetBlockState> list=List.of(
                OreConfiguration.target(stoneOreRuleTest, BlockRegister.DIRT_ORIGIN_STONE.get().defaultBlockState()),
                OreConfiguration.target(deepSlateOreRuleTest,BlockRegister.DIRT_ORIGIN_STONE.get().defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> list2=List.of(
                OreConfiguration.target(stoneOreRuleTest, BlockRegister.WOOD_ORIGIN_STONE.get().defaultBlockState()),
                OreConfiguration.target(deepSlateOreRuleTest,BlockRegister.WOOD_ORIGIN_STONE.get().defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> list3=List.of(
                OreConfiguration.target(stoneOreRuleTest, BlockRegister.FIRE_ORIGIN_STONE.get().defaultBlockState()),
                OreConfiguration.target(deepSlateOreRuleTest,BlockRegister.FIRE_ORIGIN_STONE.get().defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> list4=List.of(
                OreConfiguration.target(stoneOreRuleTest, BlockRegister.METAL_ORIGIN_STONE.get().defaultBlockState()),
                OreConfiguration.target(deepSlateOreRuleTest,BlockRegister.METAL_ORIGIN_STONE.get().defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> list5=List.of(
                OreConfiguration.target(stoneOreRuleTest, BlockRegister.WATER_ORIGIN_STONE.get().defaultBlockState()),
                OreConfiguration.target(deepSlateOreRuleTest,BlockRegister.WATER_ORIGIN_STONE.get().defaultBlockState())
        );

        TreeConfiguration configuration= new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(BlockRegister.PEACH_WOOD_LOG.get()),
                new ForkingTrunkPlacer(4,1,1),
                BlockStateProvider.simple(BlockRegister.PEACH_WOOD_LEAVES.get()),
                new AcaciaFoliagePlacer(ConstantInt.of(3),ConstantInt.of(0)),
                new TwoLayersFeatureSize(2,0,2)
        ).ignoreVines().build();

        FeatureUtils.register(pContext,DIRT_ORIGIN_STONE, Feature.ORE,new OreConfiguration(list,11));
        FeatureUtils.register(pContext,FIRE_ORIGIN_STONE, Feature.ORE,new OreConfiguration(list,11));
        FeatureUtils.register(pContext,WATER_ORIGIN_STONE, Feature.ORE,new OreConfiguration(list,11));
        FeatureUtils.register(pContext,METAL_ORIGIN_STONE, Feature.ORE,new OreConfiguration(list,11));
        FeatureUtils.register(pContext,WOOD_ORIGIN_STONE, Feature.ORE,new OreConfiguration(list,11));
        FeatureUtils.register(pContext,PEACH_TREE, Feature.TREE,configuration);
    }
}
