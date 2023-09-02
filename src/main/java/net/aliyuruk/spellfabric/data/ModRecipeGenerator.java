package net.aliyuruk.spellfabric.data;

import net.aliyuruk.spellfabric.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        // Recipe for the Fire Wand
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.FIRE_WAND)
                .pattern("  Y")
                .pattern(" S ")
                .pattern("B  ")
                .input('Y', Items.FIRE_CHARGE)
                .input('S', Items.STICK)
                .input('B', Items.BLAZE_POWDER)
                .criterion(FabricRecipeProvider.hasItem(Items.BLAZE_POWDER),
                        FabricRecipeProvider.conditionsFromItem(Items.BLAZE_POWDER))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModItems.FIRE_WAND)));
    }

}
