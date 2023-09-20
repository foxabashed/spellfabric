package net.aliyuruk.spellfabric.item.custom.spellbooks;

import net.minecraft.item.ItemStack;
import net.minecraft.item.RangedWeaponItem;

import java.util.function.Predicate;

public class FireSpellbookItem extends RangedWeaponItem {
    public FireSpellbookItem(Settings settings) {
        super(settings);
    }

    @Override
    public Predicate<ItemStack> getProjectiles() {
        return null;
    }



    @Override
    public int getRange() {
        return 0;
    }
}
