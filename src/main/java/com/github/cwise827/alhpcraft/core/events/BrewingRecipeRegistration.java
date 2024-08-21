package com.github.cwise827.alhpcraft.core.events;

import com.github.cwise827.alhpcraft.core.init.ItemInit;
import com.github.cwise827.alhpcraft.core.init.PotionInit;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.brewing.BrewingRecipe;
import net.neoforged.neoforge.common.brewing.BrewingRecipeRegistry;

public class BrewingRecipeRegistration {

	public void register(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            Ingredient awkwardPotionIngredient = Ingredient.of(Items.POTION);
            Ingredient saltIngredient = Ingredient.of(ItemInit.SALT.get());
            Ingredient compactBallisticsJelly = Ingredient.of(ItemInit.COMPACT_BALLISTICS_JELLY.get());
            Ingredient redPepperIngredient = Ingredient.of(ItemInit.RED_PEPPER_JELLY.get());

            // Add custom brewing recipes
            BrewingRecipeRegistry.addRecipe(new BrewingRecipe(
                // Ingredient for potion input (e.g., Awkward Potion)
                awkwardPotionIngredient,
                saltIngredient,
                PotionUtils.setPotion(new ItemStack(Items.POTION), PotionInit.SWEATY_PALMS_POTION.get())
            ) {
                @Override
                public boolean isInput(ItemStack input) {
                    // Ensure the input potion is an Awkward Potion
                    return PotionUtils.getPotion(input).equals(Potions.AWKWARD);
                }
            });

            BrewingRecipeRegistry.addRecipe(new BrewingRecipe(
                awkwardPotionIngredient,
                compactBallisticsJelly,
                PotionUtils.setPotion(new ItemStack(Items.POTION), PotionInit.GENTLE_FALLING_POTION.get())
            ) {
                @Override
                public boolean isInput(ItemStack input) {
                    return PotionUtils.getPotion(input).equals(Potions.AWKWARD);
                }
            });
            
            BrewingRecipeRegistry.addRecipe(new BrewingRecipe(
                    // Ingredient for potion input (e.g., Awkward Potion)
                    awkwardPotionIngredient,
                    redPepperIngredient,
                    PotionUtils.setPotion(new ItemStack(Items.POTION), PotionInit.FIRE_BREATHING_POTION.get())
                ) {
                    @Override
                    public boolean isInput(ItemStack input) {
                        // Ensure the input potion is an Awkward Potion
                        return PotionUtils.getPotion(input).equals(Potions.AWKWARD);
                    }
                });

            // Splash Potions
            BrewingRecipeRegistry.addRecipe(new BrewingRecipe(
                Ingredient.of(Items.SPLASH_POTION),
                saltIngredient,
                PotionUtils.setPotion(new ItemStack(Items.SPLASH_POTION), PotionInit.SWEATY_PALMS_POTION.get())
            ) {
                @Override
                public boolean isInput(ItemStack input) {
                    return PotionUtils.getPotion(input).equals(Potions.AWKWARD);
                }
            });

            BrewingRecipeRegistry.addRecipe(new BrewingRecipe(
                Ingredient.of(Items.SPLASH_POTION),
                compactBallisticsJelly,
                PotionUtils.setPotion(new ItemStack(Items.SPLASH_POTION), PotionInit.GENTLE_FALLING_POTION.get())
            ) {
                @Override
                public boolean isInput(ItemStack input) {
                    return PotionUtils.getPotion(input).equals(Potions.AWKWARD);
                }
            });
            
            BrewingRecipeRegistry.addRecipe(new BrewingRecipe(
                Ingredient.of(Items.SPLASH_POTION),
                redPepperIngredient,
                PotionUtils.setPotion(new ItemStack(Items.SPLASH_POTION), PotionInit.FIRE_BREATHING_POTION.get())
            ) {
                @Override
                public boolean isInput(ItemStack input) {
                    return PotionUtils.getPotion(input).equals(Potions.AWKWARD);
                }
            });

            //Lingering Potions
            BrewingRecipeRegistry.addRecipe(new BrewingRecipe(
                Ingredient.of(Items.LINGERING_POTION),
                saltIngredient,
                PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), PotionInit.SWEATY_PALMS_POTION.get())
            ) {
                @Override
                public boolean isInput(ItemStack input) {
                    return PotionUtils.getPotion(input).equals(Potions.AWKWARD);
                }
            });

            BrewingRecipeRegistry.addRecipe(new BrewingRecipe(
                Ingredient.of(Items.LINGERING_POTION),
                compactBallisticsJelly,
                PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), PotionInit.GENTLE_FALLING_POTION.get())
            ) {
                @Override
                public boolean isInput(ItemStack input) {
                    return PotionUtils.getPotion(input).equals(Potions.AWKWARD);
                }
            });
            
            BrewingRecipeRegistry.addRecipe(new BrewingRecipe(
                Ingredient.of(Items.LINGERING_POTION),
                redPepperIngredient,
                PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), PotionInit.FIRE_BREATHING_POTION.get())
            ) {
                @Override
                public boolean isInput(ItemStack input) {
                    return PotionUtils.getPotion(input).equals(Potions.AWKWARD);
                }
            });
            
            
        });
    }
	
}
