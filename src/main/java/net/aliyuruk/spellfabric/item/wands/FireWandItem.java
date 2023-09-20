package net.aliyuruk.spellfabric.item.wands;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.RangedWeaponItem;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import java.util.function.Predicate;

public class FireWandItem extends RangedWeaponItem {
    public FireWandItem(Settings settings) {
        super(settings);
    }

    @Override
    public Predicate<ItemStack> getProjectiles() {
        return null;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {

        ItemStack stack = player.getStackInHand(hand);

        final float f = -MathHelper.sin(player.getYaw() *
                ((float) Math.PI / 180)) *
                MathHelper.cos(player.getPitch() *
                        ((float) Math.PI / 180));

        final float g = -MathHelper.sin(player.getPitch() * ((float) Math.PI / 180));

        final float h = MathHelper.cos(player.getYaw() * ((float) Math.PI / 180)) * MathHelper.cos(player.getPitch() * ((float) Math.PI / 180));
        if (!player.world.isClient()) {
            // 2 second cooldown
            player.getItemCooldownManager().set(this, 40);

            // Create the fireball entity
            FireballEntity fireballEntity = new FireballEntity(world, player, f, g, h, 2);

            // Set the fireball's velocity
            fireballEntity.setVelocity(player, player.getPitch(), player.getYaw(), 0F, 2, 0.5F);

            // Spawn the fireball entity
            world.spawnEntity(fireballEntity);

            // Play fireball sound
            world.playSound(null, player.getBlockPos(), SoundEvents.ITEM_FIRECHARGE_USE, SoundCategory.PLAYERS, 0.2f, 1);

        }
        return super.use(world, player, hand);
    }

    @Override
    public int getRange() {
        return 0;
    }
}
