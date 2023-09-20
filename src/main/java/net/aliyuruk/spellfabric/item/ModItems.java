package net.aliyuruk.spellfabric.item;

import net.aliyuruk.spellfabric.SpellFabric;
import net.aliyuruk.spellfabric.item.custom.spellbooks.FireSpellbookItem;
import net.aliyuruk.spellfabric.item.custom.wands.FireWandItem;
import net.aliyuruk.spellfabric.item.custom.swords.DarknessSwordItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModItems {
    public static final Item FIRE_WAND = registerItem("fire_wand",
        new FireWandItem(new FabricItemSettings().maxCount(1)));

    public static final Item FIRE_SPELLBOOK = registerItem("fire_spellbook",
        new FireSpellbookItem(new FabricItemSettings().maxCount(1)));

    public static final Item DARKNESS_SWORD = registerItem("darkness_sword",
        new Item(new FabricItemSettings()));

    public static final Item NATURE_STAR = registerItem("nature_star",
        new Item(new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(SpellFabric.MOD_ID, name), item);

    }

    public static void addItemsToItemGroup() {
        addToItemGroup(ModItemGroup.SWORDS, DARKNESS_SWORD);
        addToItemGroup(ModItemGroup.WANDS, FIRE_WAND);
        addToItemGroup(ModItemGroup.SPELLBOOKS, FIRE_SPELLBOOK);
        addToItemGroup(ModItemGroup.MISCELLANEOUS, NATURE_STAR);
    }

    private static void addToItemGroup(ItemGroup group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }

    public static void registerModItems() {
        SpellFabric.LOGGER.info("Registering ModItems for " + SpellFabric.MOD_ID);

        addItemsToItemGroup();
    }
}
