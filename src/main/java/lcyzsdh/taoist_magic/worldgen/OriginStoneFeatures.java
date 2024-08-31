package lcyzsdh.taoist_magic.worldgen;

import lcyzsdh.taoist_magic.TaoistMagic;
import lcyzsdh.taoist_magic.registry.BlockRegister;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class OriginStoneFeatures {
    public static final ResourceKey<ConfiguredFeature<?,?>> ORIGIN_STONE=ResourceKey.create(Registries.CONFIGURED_FEATURE,ResourceLocation.fromNamespaceAndPath(TaoistMagic.MOD_ID,"origin_stone"));

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?,?>> pContext){
        RuleTest stoneOreRuleTest=new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> list=List.of(
                OreConfiguration.target(stoneOreRuleTest, BlockRegister.DIRT_ORIGIN_STONE.get().defaultBlockState())
        );
        FeatureUtils.register(pContext,ORIGIN_STONE, Feature.ORE,new OreConfiguration(list,9));
    }
}
