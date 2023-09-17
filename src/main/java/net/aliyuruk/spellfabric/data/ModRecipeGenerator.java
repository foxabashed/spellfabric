package net.aliyuruk.spellfabric.data;

import net.aliyuruk.spellfabric.block.ModBlocks;
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
                .pattern("  F")
                .pattern(" S ")
                .pattern("B  ")
                .input('F', Items.FIRE_CHARGE)
                .input('S', Items.STICK)
                .input('B', Items.BLAZE_POWDER)
                .criterion(FabricRecipeProvider.hasItem(Items.BLAZE_POWDER),
                        FabricRecipeProvider.conditionsFromItem(Items.BLAZE_POWDER))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModItems.FIRE_WAND)));


        // Recipe for the Dark Purpur Slab
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DARK_PURPUR_SLAB)
                .pattern("")
                .pattern("DDD")
                .pattern("")
                .input('D', ModBlocks.DARK_PURPUR_BLOCK)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.DARK_PURPUR_BLOCK),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.DARK_PURPUR_BLOCK))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModBlocks.DARK_PURPUR_SLAB)));
    }
}
