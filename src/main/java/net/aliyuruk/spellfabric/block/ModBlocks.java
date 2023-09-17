package net.aliyuruk.spellfabric.block;

import net.aliyuruk.spellfabric.SpellFabric;
import net.aliyuruk.spellfabric.item.ModItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    public static final Block SUSPICIOUS_DEEPSLATE = registerBlock("suspicious_deepslate",
            new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).strength(4.0f).requiresTool(),
                    UniformIntProvider.create(1, 2)), ModItemGroup.BLOCKS);

    public static final Block DARK_PURPUR_BLOCK = registerBlock("dark_purpur_block",
            new Block(FabricBlockSettings.of(Material.DECORATION).hardness(3.0f).resistance(9.0f).requiresTool()), ModItemGroup.BLOCKS);
    public static final Block DARK_PURPUR_PILLAR = registerBlock("dark_purpur_pillar",
            new Block(FabricBlockSettings.of(Material.DECORATION).hardness(3.0f).resistance(9.0f).requiresTool()), ModItemGroup.BLOCKS);
    public static final SlabBlock DARK_PURPUR_SLAB = (SlabBlock) registerBlock("dark_purpur_slab",
            new SlabBlock(FabricBlockSettings.of(Material.DECORATION).hardness(3.0f).resistance(9.0f).requiresTool()), ModItemGroup.BLOCKS);

    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registries.BLOCK, new Identifier(SpellFabric.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        Item item = Registry.register(Registries.ITEM, new Identifier(SpellFabric.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
        return item;
    }

    public static void registerModBlocks() {
        SpellFabric.LOGGER.info("Registering ModBlocks for " + SpellFabric.MOD_ID);
    }
}
