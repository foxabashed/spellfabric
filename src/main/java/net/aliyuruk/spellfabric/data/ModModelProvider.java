package net.aliyuruk.spellfabric.data;

import net.aliyuruk.spellfabric.block.ModBlocks;
import net.aliyuruk.spellfabric.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DARK_PURPUR_BLOCK);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SUSPICIOUS_DEEPSLATE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        // Future Item Model Generation will Go Here
    }
}
