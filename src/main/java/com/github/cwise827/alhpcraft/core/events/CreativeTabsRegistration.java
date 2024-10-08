package com.github.cwise827.alhpcraft.core.events;

import com.github.cwise827.alhpcraft.core.init.ItemInit;
import com.github.cwise827.alhpcraft.core.init.PotionInit;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod.EventBusSubscriber;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@EventBusSubscriber(modid="alhpcraft", bus=EventBusSubscriber.Bus.MOD)
public class CreativeTabsRegistration {

	public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, "alhpcraft");
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ALHP_CRAFT = CREATIVE_MODE_TABS.register("alhp_craft", () -> CreativeModeTab.builder()
            .title(Component.translatable("ALHP Craft"))
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> ItemInit.DERP_BLOCK_ITEM.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
            	output.accept(ItemInit.COPPER_BOOTS.get());
            	output.accept(ItemInit.COPPER_LEGGINGS.get());
            	output.accept(ItemInit.COPPER_CHESTPLATE.get());
            	output.accept(ItemInit.COPPER_HELMET.get());
            	output.accept(ItemInit.COPPER_SWORD.get());
            	output.accept(ItemInit.COPPER_PICKAXE.get());
            	output.accept(ItemInit.COPPER_AXE.get());
            	output.accept(ItemInit.COPPER_SHOVEL.get());
            	output.accept(ItemInit.COPPER_HOE.get());
            	output.accept(ItemInit.DERP_BOOTS.get());
            	output.accept(ItemInit.DERP_LEGGINGS.get());
            	output.accept(ItemInit.DERP_CHESTPLATE.get());
            	output.accept(ItemInit.DERP_HELMET.get());
            	output.accept(ItemInit.DERP_SWORD.get());
            	output.accept(ItemInit.DERP_PICKAXE.get());
            	output.accept(ItemInit.DERP_AXE.get());
            	output.accept(ItemInit.DERP_SHOVEL.get());
            	output.accept(ItemInit.DERP_HOE.get());
            	output.accept(ItemInit.BALLISTICS_JELLY_BOOTS.get());
            	output.accept(ItemInit.BALLISTICS_JELLY_LEGGINGS.get());
            	output.accept(ItemInit.BALLISTICS_JELLY_CHESTPLATE.get());
            	output.accept(ItemInit.BALLISTICS_JELLY_HELMET.get());
            	output.accept(ItemInit.BALLISTICS_JELLY_SWORD.get());
            	output.accept(ItemInit.BALLISTICS_JELLY.get());
            	output.accept(ItemInit.BALLISTICS_JELLY_CONCENTRATE.get());
            	output.accept(ItemInit.COMPACT_BALLISTICS_JELLY.get());
            	output.accept(ItemInit.JELLY_CREAM.get());
            	output.accept(ItemInit.KNIFE.get());
                output.accept(ItemInit.DERP_INGOT.get());
                output.accept(ItemInit.DERP_SHARD.get());
            	output.accept(ItemInit.DERP_BLOCK_ITEM.get());
            	output.accept(ItemInit.BALLISTICS_JELLY_BLOCK_ITEM.get());
            	output.accept(ItemInit.COMPACT_BALLISTICS_JELLY_BLOCK_ITEM.get());
            	output.accept(ItemInit.LAUNCHPAD_ITEM.get());
            	output.accept(ItemInit.CORRUPTED_DERP_SPAWN_EGG.get());
            	output.accept(ItemInit.MRP_MAN_SPAWN_EGG.get());
            	output.accept(ItemInit.DERP_SPAWN_EGG.get());
            	output.accept(ItemInit.JELLY_SLIME_SPAWN_EGG.get());
                output.accept(ItemInit.JELLY_CUBE_SPAWN_EGG.get());
            	output.accept(ItemInit.CHICKEN_SANDWICH.get());
            	output.accept(ItemInit.SPICY_CHICKEN_SANDWICH.get());
                output.accept(ItemInit.WAFFLE_FRIES.get());
                output.accept(ItemInit.RED_PEPPER.get());
                output.accept(ItemInit.RED_PEPPER_SEEDS.get());
                output.accept(ItemInit.RED_PEPPER_JELLY.get());
                output.accept(ItemInit.DR_PEPPER.get());
                output.accept(ItemInit.SALT.get());
                output.accept(PotionUtils.setPotion(new ItemStack(Items.POTION), PotionInit.GENTLE_FALLING_POTION.get()));
                output.accept(PotionUtils.setPotion(new ItemStack(Items.SPLASH_POTION), PotionInit.GENTLE_FALLING_POTION.get()));
                output.accept(PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), PotionInit.GENTLE_FALLING_POTION.get()));
                output.accept(PotionUtils.setPotion(new ItemStack(Items.POTION), PotionInit.FIRE_BREATHING_POTION.get()));
                output.accept(PotionUtils.setPotion(new ItemStack(Items.SPLASH_POTION), PotionInit.FIRE_BREATHING_POTION.get()));
                output.accept(PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), PotionInit.FIRE_BREATHING_POTION.get()));
                output.accept(PotionUtils.setPotion(new ItemStack(Items.POTION), PotionInit.SWEATY_PALMS_POTION.get()));
                output.accept(PotionUtils.setPotion(new ItemStack(Items.SPLASH_POTION), PotionInit.SWEATY_PALMS_POTION.get()));
                output.accept(PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), PotionInit.SWEATY_PALMS_POTION.get()));
                output.accept(ItemInit.FABRIC_EDGE_BLACK.get());
                output.accept(ItemInit.FABRIC_EDGE_BLUE.get());
                output.accept(ItemInit.FABRIC_EDGE_BROWN.get());
                output.accept(ItemInit.FABRIC_EDGE_CYAN.get());
                output.accept(ItemInit.FABRIC_EDGE_GRAY.get());
                output.accept(ItemInit.FABRIC_EDGE_GREEN.get());
                output.accept(ItemInit.FABRIC_EDGE_LIGHT_BLUE.get());
                output.accept(ItemInit.FABRIC_EDGE_LIGHT_GRAY.get());
                output.accept(ItemInit.FABRIC_EDGE_LIME.get());
                output.accept(ItemInit.FABRIC_EDGE_MAGENTA.get());
                output.accept(ItemInit.FABRIC_EDGE_ORANGE.get());
                output.accept(ItemInit.FABRIC_EDGE_PINK.get());
                output.accept(ItemInit.FABRIC_EDGE_PURPLE.get());
                output.accept(ItemInit.FABRIC_EDGE_RED.get());
                output.accept(ItemInit.FABRIC_EDGE_WHITE.get());
                output.accept(ItemInit.FABRIC_EDGE_YELLOW.get());
                
            }).build());
	@SubscribeEvent
    public static void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            event.accept(ItemInit.DERP_BLOCK_ITEM.get());
        }
        if (event.getTabKey() == CreativeModeTabs.REDSTONE_BLOCKS){
        	event.accept(ItemInit.BALLISTICS_JELLY_BLOCK_ITEM.get());
        	event.accept(ItemInit.COMPACT_BALLISTICS_JELLY_BLOCK_ITEM.get());
        	event.accept(ItemInit.LAUNCHPAD_ITEM.get());
        }
        if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
        	event.accept(ItemInit.CHICKEN_SANDWICH.get());
        	event.accept(ItemInit.SPICY_CHICKEN_SANDWICH.get());
        	event.accept(ItemInit.WAFFLE_FRIES.get());
        	event.accept(ItemInit.RED_PEPPER.get());
        	event.accept(ItemInit.RED_PEPPER_SEEDS.get());
        	event.accept(ItemInit.RED_PEPPER_JELLY.get());
        	event.accept(ItemInit.DR_PEPPER.get());
        	event.accept(PotionUtils.setPotion(new ItemStack(Items.POTION), PotionInit.GENTLE_FALLING_POTION.get()));
        	event.accept(PotionUtils.setPotion(new ItemStack(Items.SPLASH_POTION), PotionInit.GENTLE_FALLING_POTION.get()));
        	event.accept(PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), PotionInit.GENTLE_FALLING_POTION.get()));
        	event.accept(PotionUtils.setPotion(new ItemStack(Items.POTION), PotionInit.FIRE_BREATHING_POTION.get()));
        	event.accept(PotionUtils.setPotion(new ItemStack(Items.SPLASH_POTION), PotionInit.FIRE_BREATHING_POTION.get()));
        	event.accept(PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), PotionInit.FIRE_BREATHING_POTION.get()));
        	event.accept(PotionUtils.setPotion(new ItemStack(Items.POTION), PotionInit.SWEATY_PALMS_POTION.get()));
        	event.accept(PotionUtils.setPotion(new ItemStack(Items.SPLASH_POTION), PotionInit.SWEATY_PALMS_POTION.get()));
        	event.accept(PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), PotionInit.SWEATY_PALMS_POTION.get()));
        }
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
        	event.accept(ItemInit.DERP_SHARD.get());
        	event.accept(ItemInit.DERP_INGOT.get());
        	event.accept(ItemInit.BALLISTICS_JELLY.get());
        	event.accept(ItemInit.BALLISTICS_JELLY_CONCENTRATE.get());
        	event.accept(ItemInit.COMPACT_BALLISTICS_JELLY.get());
        	event.accept(ItemInit.JELLY_CREAM.get());
        	event.accept(ItemInit.SALT.get());
        }
        if(event.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
        	event.accept(ItemInit.CORRUPTED_DERP_SPAWN_EGG.get());
        	event.accept(ItemInit.DERP_SPAWN_EGG.get());
        	event.accept(ItemInit.JELLY_SLIME_SPAWN_EGG.get());
        	event.accept(ItemInit.JELLY_CUBE_SPAWN_EGG.get());
        }
        if(event.getTabKey() == CreativeModeTabs.COMBAT) {
        	event.accept(ItemInit.DERP_SWORD.get());
        	event.accept(ItemInit.COPPER_SWORD.get());
        	event.accept(ItemInit.KNIFE.get());
        	event.accept(ItemInit.BALLISTICS_JELLY_SWORD.get());
        	event.accept(ItemInit.COPPER_BOOTS.get());
        	event.accept(ItemInit.COPPER_LEGGINGS.get());
        	event.accept(ItemInit.COPPER_CHESTPLATE.get());
        	event.accept(ItemInit.COPPER_HELMET.get());
        	event.accept(ItemInit.DERP_BOOTS.get());
        	event.accept(ItemInit.DERP_LEGGINGS.get());
        	event.accept(ItemInit.DERP_CHESTPLATE.get());
        	event.accept(ItemInit.DERP_HELMET.get());
        	event.accept(ItemInit.BALLISTICS_JELLY_BOOTS.get());
        	event.accept(ItemInit.BALLISTICS_JELLY_LEGGINGS.get());
        	event.accept(ItemInit.BALLISTICS_JELLY_CHESTPLATE.get());
        	event.accept(ItemInit.BALLISTICS_JELLY_HELMET.get());
        }
        if(event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
        	event.accept(ItemInit.DERP_PICKAXE.get());
        	event.accept(ItemInit.DERP_AXE.get());
        	event.accept(ItemInit.DERP_SHOVEL.get());
        	event.accept(ItemInit.DERP_HOE.get());
        	event.accept(ItemInit.COPPER_PICKAXE.get());
        	event.accept(ItemInit.COPPER_AXE.get());
        	event.accept(ItemInit.COPPER_SHOVEL.get());
        	event.accept(ItemInit.COPPER_HOE.get());
        }
    }
}
