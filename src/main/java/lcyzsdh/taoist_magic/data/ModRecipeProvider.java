package lcyzsdh.taoist_magic.data;

import lcyzsdh.taoist_magic.registry.BlockRegister;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput p_recipeOutput) {
        planksFromLog(p_recipeOutput,BlockRegister.PEACH_WOOD_PLANKS,ModItemTagProvider.PEACH_WOOD_LOGS,3);
    }
}
