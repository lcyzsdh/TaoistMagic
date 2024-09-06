package lcyzsdh.taoist_magic.worldgen;

import lcyzsdh.taoist_magic.TaoistMagic;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ModBiomeModifier {
    public static final ResourceKey<BiomeModifier> ADD_ORIGIN_STONE=ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(TaoistMagic.MOD_ID,"add_origin_stone"));
    public static final ResourceKey<BiomeModifier> ADD_PEACH_TREE=ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(TaoistMagic.MOD_ID,"add_peach_tree"));

    public static void bootstrap(BootstrapContext<BiomeModifier> pContext){
        var placedFeatures=pContext.lookup(Registries.PLACED_FEATURE);
        var biomes=pContext.lookup(Registries.BIOME);
        pContext.register(ADD_ORIGIN_STONE,new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(OriginStonePlacement.ORIGIN_STONE)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        pContext.register(ADD_PEACH_TREE,new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_FOREST),
                HolderSet.direct(placedFeatures.getOrThrow(PeachTreePlacement.PEACH_TREE)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
    }
}
