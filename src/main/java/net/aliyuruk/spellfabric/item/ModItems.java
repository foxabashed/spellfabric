package net.aliyuruk.spellfabric.item;

import net.aliyuruk.spellfabric.SpellFabric;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;

import java.util.function.Predicate;


public class ModItems {
    public static final RangedWeaponItem FIRE_WAND = (RangedWeaponItem) registerItem("fire_wand",
            new RangedWeaponItem(new FabricItemSettings()) {
                @Override
                public Predicate<ItemStack> getProjectiles() {
                    BOW_PROJECTILES.or(stack -> stack.isOf(Items.FIRE_CHARGE));
                    return null;
                }

                @Override
                public int getRange() {
                    return 0;
                }
            });
    public static final RangedWeaponItem FIRE_SPELLBOOK = (RangedWeaponItem) registerItem("fire_spellbook",
            new RangedWeaponItem(new FabricItemSettings()) {
                @Override
                public Predicate<ItemStack> getProjectiles() {
                    return null;
                }

                @Override
                public int getRange() {
                    return 0;
                }
            });

    public static final Item NATURE_STAR = registerItem("nature_star",
        new Item(new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(SpellFabric.MOD_ID, name), item);

    }

    public static void addItemsToItemGroup() {
        addToItemGroup(ModItemGroup.WANDS, FIRE_WAND);
        addToItemGroup(ModItemGroup.SPELLBOOKS, FIRE_SPELLBOOK);
        addToItemGroup(ItemGroups.INGREDIENTS, NATURE_STAR);
    }

    private static void addToItemGroup(ItemGroup group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }

    public static void registerModItems() {
        SpellFabric.LOGGER.info("Registering ModItems for " + SpellFabric.MOD_ID);

        addItemsToItemGroup();
    }
}
