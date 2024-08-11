package com.github.cwise827.alhpcraft.core.enums;

import java.util.Objects;
import java.util.function.Supplier;

import com.github.cwise827.alhpcraft.core.init.ItemInit;
import com.google.common.base.Suppliers;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;

public enum CustomItemTiers implements Tier {

	COPPER(BlockTags.NEEDS_DIAMOND_TOOL, 2, 150, 6.5f,  2.0f, 17, () -> Ingredient.of((ItemLike[])new ItemLike[]{(ItemLike)Items.COPPER_INGOT})),
	DERP(BlockTags.NEEDS_DIAMOND_TOOL, 2, 813, 5.0f, 1.5f, 20, () -> Ingredient.of((ItemLike[])new ItemLike[]{(ItemLike)ItemInit.DERP_SHARD.get()}));
	
	private final TagKey<Block> block;
	private final int level;
	private final int maxUses;
    private final float efficiency;
    private final float attackDamageBonus;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    private CustomItemTiers(TagKey<Block> icBlock, int mineLevel, int durability, float mineSpeed, float damageBonus, int enchant, Supplier<Ingredient> supplier) {
        this.block = icBlock;
        this.level = mineLevel;
    	this.maxUses = durability;
        this.efficiency = mineSpeed;
        this.attackDamageBonus = damageBonus;
        this.enchantability = enchant;
        Objects.requireNonNull(supplier);
        this.repairIngredient = Suppliers.memoize(supplier::get);;
    }


    public int getUses() {
        return this.maxUses;
    }

    public float getSpeed() {
        return this.efficiency;
    }

    public float getAttackDamageBonus() {
        return this.attackDamageBonus;
    }


    public TagKey<Block> getIncorrectBlocksForDrops() {
        return this.block;
    }

    public int getEnchantmentValue() {
        return this.enchantability;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }


	@Override
	public int getLevel() {
		return this.level;
	}


}

