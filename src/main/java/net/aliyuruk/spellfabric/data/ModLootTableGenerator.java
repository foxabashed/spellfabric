package net.aliyuruk.spellfabric.data;

import net.aliyuruk.spellfabric.block.ModBlocks;
import net.aliyuruk.spellfabric.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.data.client.BlockStateModelGenerator;

public class ModLootTableGenerator extends FabricBlockLootTableProvider {

    public ModLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    public void generate() {
        addDrop(ModBlocks.DARK_PURPUR_BLOCK);
        addDrop(ModBlocks.DARK_PURPUR_PILLAR);
        addDrop(ModBlocks.DARK_PURPUR_SLAB);
    }
}
