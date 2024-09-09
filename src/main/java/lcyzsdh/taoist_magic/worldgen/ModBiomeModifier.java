package lcyzsdh.taoist_magic.worldgen;

import lcyzsdh.taoist_magic.TaoistMagic;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.holdersets.AndHolderSet;

import java.util.List;

public class ModBiomeModifier {
    public static final ResourceKey<BiomeModifier> ADD_DIRT_ORIGIN_STONE=ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(TaoistMagic.MOD_ID,"add_dirt_origin_stone"));
    public static final ResourceKey<BiomeModifier> ADD_FIRE_ORIGIN_STONE=ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(TaoistMagic.MOD_ID,"add_fire_origin_stone"));
    public static final ResourceKey<BiomeModifier> ADD_WATER_ORIGIN_STONE=ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(TaoistMagic.MOD_ID,"add_water_origin_stone"));
    public static final ResourceKey<BiomeModifier> ADD_METAl_ORIGIN_STONE=ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(TaoistMagic.MOD_ID,"add_metal_origin_stone"));
    public static final ResourceKey<BiomeModifier> ADD_WOOD_ORIGIN_STONE=ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(TaoistMagic.MOD_ID,"add_wood_origin_stone"));
    public static final ResourceKey<BiomeModifier> ADD_PEACH_TREE=ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(TaoistMagic.MOD_ID,"add_peach_tree"));

    public static void bootstrap(BootstrapContext<BiomeModifier> pContext){
        var placedFeatures=pContext.lookup(Registries.PLACED_FEATURE);
        var biomes=pContext.lookup(Registries.BIOME);
        pContext.register(ADD_FIRE_ORIGIN_STONE,new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacement.FIRE_ORIGIN_STONE)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        pContext.register(ADD_METAl_ORIGIN_STONE,new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacement.METAl_ORIGIN_STONE)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        pContext.register(ADD_WATER_ORIGIN_STONE,new BiomeModifiers.AddFeaturesBiomeModifier(new AndHolderSet<>(List.of(biomes.getOrThrow(BiomeTags.IS_FOREST),biomes.getOrThrow(BiomeTags.IS_RIVER),biomes.getOrThrow(BiomeTags.IS_JUNGLE),biomes.getOrThrow(BiomeTags.IS_BEACH))),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacement.FIRE_ORIGIN_STONE)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        pContext.register(ADD_DIRT_ORIGIN_STONE,new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacement.DIRT_ORIGIN_STONE)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        pContext.register(ADD_WOOD_ORIGIN_STONE,new BiomeModifiers.AddFeaturesBiomeModifier(new AndHolderSet<>(List.of(biomes.getOrThrow(BiomeTags.IS_FOREST),biomes.getOrThrow(BiomeTags.IS_JUNGLE))),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacement.WOOD_ORIGIN_STONE)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        pContext.register(ADD_PEACH_TREE,new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_FOREST),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacement.PEACH_TREE)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
    }
}
