package com.github.cwise827.alhpcraft.core.init;

import java.util.EnumMap;
import java.util.function.Supplier;

import com.mojang.serialization.Codec;

import net.minecraft.Util;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

public enum ArmorMaterialInit implements ArmorMaterial, StringRepresentable{
	
	COPPER("copper", 10, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
		map.put(ArmorItem.Type.BOOTS, 2);
		map.put(ArmorItem.Type.LEGGINGS, 5);
		map.put(ArmorItem.Type.CHESTPLATE, 6);
		map.put(ArmorItem.Type.HELMET, 2);
    }), 9, SoundEvents.ARMOR_EQUIP_IRON, 0.0f, 0.0f, () -> Ingredient.of(Items.COPPER_INGOT)),
	
	DERP("derp", 22, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
		map.put(ArmorItem.Type.BOOTS, 2);
		map.put(ArmorItem.Type.LEGGINGS, 4);
		map.put(ArmorItem.Type.CHESTPLATE, 5);
		map.put(ArmorItem.Type.HELMET, 2);
    }), 12, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0f, -4.0f, () -> Ingredient.of(ItemInit.DERP_SHARD)),
	
	BALLISTICS_JELLY("ballistics_jelly", 15, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
		map.put(ArmorItem.Type.BOOTS, 1);
		map.put(ArmorItem.Type.LEGGINGS, 1);
		map.put(ArmorItem.Type.CHESTPLATE, 1);
		map.put(ArmorItem.Type.HELMET, 1);
    }), 12, SoundEvents.SLIME_SQUISH, 0.0f, 0.7f, () -> Ingredient.of(ItemInit.BALLISTICS_JELLY));
	
	private final String armorName;
	private final int durability;
	private final EnumMap<ArmorItem.Type, Integer> protectionFunction;
	private final int enchantability;
	private final SoundEvent equipAudio;
	private final float toughVal;
	private final float knockbackResist;
	private final Supplier<Ingredient> ingredient;
	
	ArmorMaterialInit(String name, int durabilityMultiplier, EnumMap<ArmorItem.Type, Integer> protectionFunctionForType, int enchantmentValue, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient){
		this.armorName = name;
		this.durability = durabilityMultiplier;
		this.protectionFunction = protectionFunctionForType;
		this.enchantability = enchantmentValue;
		this.equipAudio = equipSound;
		this.toughVal = toughness;
		this.knockbackResist = knockbackResistance;
		this.ingredient = repairIngredient;
	}

	public static final Codec<ArmorMaterialInit> CODEC = StringRepresentable.fromEnum(ArmorMaterialInit::values);
	
	private static final EnumMap<ArmorItem.Type, Integer> HEALTH_ARMOR_PROTECTION = Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
		map.put(ArmorItem.Type.BOOTS, 13);
		map.put(ArmorItem.Type.LEGGINGS, 15);
		map.put(ArmorItem.Type.CHESTPLATE, 16);
		map.put(ArmorItem.Type.HELMET, 11);	
	});
	
	@Override
	public String getSerializedName() {
		return this.armorName;
	}

	@Override
	public int getDurabilityForType(Type pType) {
		return HEALTH_ARMOR_PROTECTION.get(pType) * this.durability;
	}

	@Override
	public int getDefenseForType(Type pType) {
		return this.protectionFunction.get(pType);
	}

	@Override
	public int getEnchantmentValue() {
		return this.enchantability;
	}

	@Override
	public SoundEvent getEquipSound() {
		return this.equipAudio;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return this.ingredient.get();
	}

	@Override
	public String getName() {
		return this.armorName;
	}

	@Override
	public float getToughness() {
		return this.toughVal;
	}

	@Override
	public float getKnockbackResistance() {
		return this.knockbackResist;
	}
}
