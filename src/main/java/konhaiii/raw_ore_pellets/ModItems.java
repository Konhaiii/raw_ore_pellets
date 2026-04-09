package konhaiii.raw_ore_pellets;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.function.Function;

public class ModItems {
	public static <GenericItem extends Item> GenericItem register(String name, Function<Item.Properties, GenericItem> itemFactory, Item.Properties settings) {
		ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(RawOrePellets.MOD_ID, name));
		GenericItem item = itemFactory.apply(settings.setId(itemKey));
		Registry.register(BuiltInRegistries.ITEM, itemKey, item);
		return item;
	}

	public static final Item RAW_COPPER_PELLET = register("raw_copper_pellet", Item::new, new Item.Properties());
	public static final Item RAW_IRON_PELLET = register("raw_iron_pellet", Item::new, new Item.Properties());
	public static final Item RAW_GOLD_PELLET = register("raw_gold_pellet", Item::new, new Item.Properties());

	public static void initialize() {
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS)
				.register((itemGroup) -> itemGroup.insertAfter(Items.RAW_GOLD, RAW_COPPER_PELLET, RAW_IRON_PELLET, RAW_GOLD_PELLET));
	}
}
