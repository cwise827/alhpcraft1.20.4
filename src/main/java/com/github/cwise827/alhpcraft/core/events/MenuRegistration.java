package com.github.cwise827.alhpcraft.core.events;

import java.util.function.Supplier;

import com.github.cwise827.alhpcraft.menu.DerpBlockMenu;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.registries.DeferredRegister;

public class MenuRegistration {

	public static final DeferredRegister<MenuType<?>> REGISTER = DeferredRegister.create(BuiltInRegistries.MENU, "alhpcraft");
	public static final Supplier<MenuType<DerpBlockMenu>> DERP_BLOCK_MENU = REGISTER.register("derp_block_menu", () -> new MenuType(DerpBlockMenu::new, FeatureFlags.DEFAULT_FLAGS));
}
