package net.aliyuruk.spellfabric.item;

import net.aliyuruk.spellfabric.SpellFabric;
import net.aliyuruk.spellfabric.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static ItemGroup MISCELLANEOUS;
    public static ItemGroup WANDS;
    public static ItemGroup SPELLBOOKS;
    public static ItemGroup BLOCKS;

    public static void registerItemGroups() {
        WANDS = FabricItemGroup.builder(new Identifier(SpellFabric.MOD_ID, "wands"))
                .displayName(Text.translatable("itemgroup.wands"))
                .icon(() -> new ItemStack(ModItems.FIRE_WAND)).build();
        SPELLBOOKS = FabricItemGroup.builder(new Identifier(SpellFabric.MOD_ID, "spellbooks"))
                .displayName(Text.translatable("itemgroup.spellbooks"))
                .icon(() -> new ItemStack(ModItems.FIRE_SPELLBOOK)).build();
        BLOCKS = FabricItemGroup.builder(new Identifier(SpellFabric.MOD_ID, "blocks"))
                .displayName(Text.translatable("itemgroup.blocks"))
                .icon(() -> new ItemStack(ModBlocks.SUSPICIOUS_DEEPSLATE)).build();
        MISCELLANEOUS = FabricItemGroup.builder(new Identifier(SpellFabric.MOD_ID, "miscellaneous"))
                .displayName(Text.translatable("itemgroup.miscellaneous"))
                .icon(() -> new ItemStack(ModBlocks.SUSPICIOUS_DEEPSLATE)).build();
    }
}
