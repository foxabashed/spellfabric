package net.aliyuruk.spellfabric;

import net.aliyuruk.spellfabric.block.ModBlocks;
import net.aliyuruk.spellfabric.item.ModItemGroup;
import net.aliyuruk.spellfabric.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpellFabric implements ModInitializer {
	public static final String MOD_ID = "spellfabric";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroup.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}