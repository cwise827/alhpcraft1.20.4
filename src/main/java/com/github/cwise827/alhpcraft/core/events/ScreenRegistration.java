package com.github.cwise827.alhpcraft.core.events;



import com.github.cwise827.alhpcraft.screen.DerpBlockScreen;

import net.minecraft.client.gui.screens.MenuScreens;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;

public class ScreenRegistration {
	
	public static void registerScreens() {
		MenuScreens.register(MenuRegistration.DERP_BLOCK_MENU.get(), DerpBlockScreen::new);
	}
}
