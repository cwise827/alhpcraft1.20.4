package com.github.cwise827.alhpcraft.core.init;

import com.github.cwise827.alhpcraft.armor.BallisticsJellyArmor;
import com.github.cwise827.alhpcraft.armor.CopperArmor;
import com.github.cwise827.alhpcraft.armor.DerpArmor;
import com.github.cwise827.alhpcraft.core.enums.CustomItemTiers;
import com.github.cwise827.alhpcraft.item.CopperAxe;
import com.github.cwise827.alhpcraft.item.CopperHoe;
import com.github.cwise827.alhpcraft.item.CopperPickaxe;
import com.github.cwise827.alhpcraft.item.CopperShovel;
import com.github.cwise827.alhpcraft.item.CopperSword;
import com.github.cwise827.alhpcraft.item.DerpAxe;
import com.github.cwise827.alhpcraft.item.DerpHoe;
import com.github.cwise827.alhpcraft.item.DerpPickaxe;
import com.github.cwise827.alhpcraft.item.DerpShovel;
import com.github.cwise827.alhpcraft.item.DerpSword;
import com.github.cwise827.alhpcraft.item.DrPepper;
import com.github.cwise827.alhpcraft.item.Knife;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.Tiers;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ItemInit {
	//Deferred register
	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems("alhpcraft");
	
	//Block items
	public static final DeferredItem<BlockItem> DERP_BLOCK_ITEM = ITEMS.registerSimpleBlockItem("derp_block", BlockInit.DERP_BLOCK);
	
	//Food items
    public static final DeferredItem<Item> SPICY_CHICKEN_SANDWICH = ITEMS.registerSimpleItem("spicy_chicken_sandwich", new Item.Properties().food(new FoodProperties.Builder().nutrition(7).saturationMod(2f).build()));
    public static final DeferredItem<Item> CHICKEN_SANDWICH = ITEMS.registerSimpleItem("chicken_sandwich", new Item.Properties().food(new FoodProperties.Builder().nutrition(7).saturationMod(2f).build()));
    public static final DeferredItem<Item> WAFFLE_FRIES = ITEMS.registerSimpleItem("waffle_fries", new Item.Properties().food(new FoodProperties.Builder().nutrition(3).saturationMod(1f).build()));
    public static final DeferredItem<Item> RED_PEPPER = ITEMS.registerSimpleItem("red_pepper", new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationMod(.2f).build()));
    public static final DeferredHolder<Item, Item> DR_PEPPER = ITEMS.register("dr_pepper", () -> new DrPepper(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationMod(0.1F).build()).stacksTo(813)));
    
    //Simple items
    public static final DeferredItem<Item> DERP_SHARD = ITEMS.registerSimpleItem("derp_shard");
    public static final DeferredItem<Item> DERP_INGOT = ITEMS.registerSimpleItem("derp_ingot");
    public static final DeferredItem<Item> BALLISTICS_JELLY = ITEMS.registerSimpleItem("ballistics_jelly");
    
    //Tools and weapons
    public static final DeferredItem<Item> KNIFE = ITEMS.register("knife", () -> new Knife(Tiers.IRON, new Item.Properties().stacksTo(1).rarity(Rarity.COMMON)));
    public static final DeferredItem<Item> DERP_AXE = ITEMS.register("derp_axe", () -> new DerpAxe(CustomItemTiers.DERP, new Item.Properties().stacksTo(1).rarity(Rarity.COMMON)));
    public static final DeferredItem<Item> DERP_HOE = ITEMS.register("derp_hoe", () -> new DerpHoe(CustomItemTiers.DERP, new Item.Properties().stacksTo(1).rarity(Rarity.COMMON)));
    public static final DeferredItem<Item> DERP_PICKAXE = ITEMS.register("derp_pickaxe", () -> new DerpPickaxe(CustomItemTiers.DERP, new Item.Properties().stacksTo(1).rarity(Rarity.COMMON)));
    public static final DeferredItem<Item> DERP_SWORD = ITEMS.register("derp_sword", () -> new DerpSword(CustomItemTiers.DERP, new Item.Properties().stacksTo(1).rarity(Rarity.COMMON)));
    public static final DeferredItem<Item> DERP_SHOVEL = ITEMS.register("derp_shovel", () -> new DerpShovel(CustomItemTiers.DERP, new Item.Properties().stacksTo(1).rarity(Rarity.COMMON)));
    public static final DeferredItem<Item> COPPER_AXE = ITEMS.register("copper_axe", () -> new CopperAxe(CustomItemTiers.COPPER, new Item.Properties().stacksTo(1).rarity(Rarity.COMMON)));
    public static final DeferredItem<Item> COPPER_HOE = ITEMS.register("copper_hoe", () -> new CopperHoe(CustomItemTiers.COPPER, new Item.Properties().stacksTo(1).rarity(Rarity.COMMON)));
    public static final DeferredItem<Item> COPPER_PICKAXE = ITEMS.register("copper_pickaxe", () -> new CopperPickaxe(CustomItemTiers.COPPER, new Item.Properties().stacksTo(1).rarity(Rarity.COMMON)));
    public static final DeferredItem<Item> COPPER_SWORD = ITEMS.register("copper_sword", () -> new CopperSword(CustomItemTiers.COPPER, new Item.Properties().stacksTo(1).rarity(Rarity.COMMON)));
    public static final DeferredItem<Item> COPPER_SHOVEL = ITEMS.register("copper_shovel", () -> new CopperShovel(CustomItemTiers.COPPER, new Item.Properties().stacksTo(1).rarity(Rarity.COMMON)));
    
    //Armor
    public static DeferredItem<Item> COPPER_HELMET = ITEMS.register("copper_helmet", () -> new CopperArmor(ArmorItem.Type.HELMET));
    public static DeferredItem<Item> COPPER_CHESTPLATE = ITEMS.register("copper_chestplate", () -> new CopperArmor(ArmorItem.Type.CHESTPLATE));
    public static DeferredItem<Item> COPPER_LEGGINGS = ITEMS.register("copper_leggings", () -> new CopperArmor(ArmorItem.Type.LEGGINGS));
    public static DeferredItem<Item> COPPER_BOOTS = ITEMS.register("copper_boots", () -> new CopperArmor(ArmorItem.Type.BOOTS));
    public static DeferredItem<Item> DERP_HELMET = ITEMS.register("derp_helmet", () -> new DerpArmor(ArmorItem.Type.HELMET));
    public static DeferredItem<Item> DERP_CHESTPLATE = ITEMS.register("derp_chestplate", () -> new DerpArmor(ArmorItem.Type.CHESTPLATE));
    public static DeferredItem<Item> DERP_LEGGINGS = ITEMS.register("derp_leggings", () -> new DerpArmor(ArmorItem.Type.LEGGINGS));
    public static DeferredItem<Item> DERP_BOOTS = ITEMS.register("derp_boots", () -> new DerpArmor(ArmorItem.Type.BOOTS));
    public static DeferredItem<Item> BALLISTICS_JELLY_HELMET = ITEMS.register("ballistics_jelly_helmet", () -> new BallisticsJellyArmor(ArmorItem.Type.HELMET));
    public static DeferredItem<Item> BALLISTICS_JELLY_CHESTPLATE = ITEMS.register("ballistics_jelly_chestplate", () -> new BallisticsJellyArmor(ArmorItem.Type.CHESTPLATE));
    public static DeferredItem<Item> BALLISTICS_JELLY_LEGGINGS = ITEMS.register("ballistics_jelly_leggings", () -> new BallisticsJellyArmor(ArmorItem.Type.LEGGINGS));
    public static DeferredItem<Item> BALLISTICS_JELLY_BOOTS = ITEMS.register("ballistics_jelly_boots", () -> new BallisticsJellyArmor(ArmorItem.Type.BOOTS));
    
    //Spawn egg items
    public static final DeferredHolder<Item, Item> CORRUPTED_DERP_SPAWN_EGG = ITEMS.register("corrupted_derp_spawn_egg", () -> new SpawnEggItem((EntityType)EntityInit.CORRUPTED_DERP.get(), 0x3bf906, 0xb40a1a, new Item.Properties()));
    public static final DeferredHolder<Item, Item> DERP_SPAWN_EGG = ITEMS.register("derp_spawn_egg", () -> new SpawnEggItem((EntityType)EntityInit.DERP.get(), 0x3bf906, 0xebf0ee, new Item.Properties()));
    public static final DeferredHolder<Item, Item> JELLY_SLIME_SPAWN_EGG = ITEMS.register("jelly_slime_spawn_egg", () -> new SpawnEggItem((EntityType)EntityInit.JELLY_SLIME.get(), 0xa27e1d, 0xc7a342, new Item.Properties()));
    public static final DeferredHolder<Item, Item> JELLY_CUBE_SPAWN_EGG = ITEMS.register("jelly_cube_spawn_egg", () -> new SpawnEggItem((EntityType)EntityInit.JELLY_CUBE.get(), 0x241a01, 0x3c2c01, new Item.Properties()));
    
    
    //Fabric edges
    public static final DeferredItem<Item> FABRIC_EDGE_BLACK = ITEMS.registerSimpleItem("fabric_edge_black");
    public static final DeferredItem<Item> FABRIC_EDGE_BLUE = ITEMS.registerSimpleItem("fabric_edge_blue");
    public static final DeferredItem<Item> FABRIC_EDGE_BROWN = ITEMS.registerSimpleItem("fabric_edge_brown");
    public static final DeferredItem<Item> FABRIC_EDGE_CYAN = ITEMS.registerSimpleItem("fabric_edge_cyan");
    public static final DeferredItem<Item> FABRIC_EDGE_GRAY = ITEMS.registerSimpleItem("fabric_edge_gray");
    public static final DeferredItem<Item> FABRIC_EDGE_GREEN = ITEMS.registerSimpleItem("fabric_edge_green");
    public static final DeferredItem<Item> FABRIC_EDGE_LIGHT_BLUE = ITEMS.registerSimpleItem("fabric_edge_light_blue");
    public static final DeferredItem<Item> FABRIC_EDGE_LIGHT_GRAY = ITEMS.registerSimpleItem("fabric_edge_light_gray");
    public static final DeferredItem<Item> FABRIC_EDGE_LIME = ITEMS.registerSimpleItem("fabric_edge_lime");
    public static final DeferredItem<Item> FABRIC_EDGE_MAGENTA = ITEMS.registerSimpleItem("fabric_edge_magenta");
    public static final DeferredItem<Item> FABRIC_EDGE_ORANGE = ITEMS.registerSimpleItem("fabric_edge_orange");
    public static final DeferredItem<Item> FABRIC_EDGE_PINK = ITEMS.registerSimpleItem("fabric_edge_pink");
    public static final DeferredItem<Item> FABRIC_EDGE_PURPLE = ITEMS.registerSimpleItem("fabric_edge_purple");
    public static final DeferredItem<Item> FABRIC_EDGE_RED = ITEMS.registerSimpleItem("fabric_edge_red");
    public static final DeferredItem<Item> FABRIC_EDGE_WHITE = ITEMS.registerSimpleItem("fabric_edge_white");
    public static final DeferredItem<Item> FABRIC_EDGE_YELLOW = ITEMS.registerSimpleItem("fabric_edge_yellow");
}
