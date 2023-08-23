package net.aliyuruk.spellfabric.item;

import net.aliyuruk.spellfabric.SpellFabric;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModItems {
    public static final Item FIREWAND = registerItem("fire_wand",
        new Item(new FabricItemSettings()));
    public static final Item FIRESPELLBOOK = registerItem("fire_spellbook",
        new Item(new FabricItemSettings()));
    public static final Item NATURESTAR = registerItem("nature_star",
        new Item(new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(SpellFabric.MOD_ID, name), item);

    }

    public static void addItemsToItemGroup() {
        addToItemGroup(ModItemGroup.WANDS, FIREWAND);
        addToItemGroup(ModItemGroup.SPELLBOOKS, FIRESPELLBOOK);
        addToItemGroup(ItemGroups.INGREDIENTS, NATURESTAR);
    }

    private static void addToItemGroup(ItemGroup group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }

    public static void registerModItems() {
        SpellFabric.LOGGER.info("Registering ModItems for " + SpellFabric.MOD_ID);

        addItemsToItemGroup();
    }
}
