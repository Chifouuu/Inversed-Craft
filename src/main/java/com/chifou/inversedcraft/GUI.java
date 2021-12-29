package com.chifou.inversedcraft;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.TextComponent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.RenderGameOverlayEvent.Chat;

public class GUI extends GuiScreen {

	public GUI() {
		
	}
	
	GuiButton close;
	GuiButton discord;
	GuiButton toggle;
	GuiButton untoggle;
	
	
	public void initGui() {
		
		int x1 = width/2 - 50;
		int y1 = height/2 + 80;
		
		int y2 = height/2 + 58;
		
		this.buttonList.add(this.toggle = new GuiButton(3, x1, y2 - 22, 100, 20, "Inverse"));
		this.buttonList.add(this.close = new GuiButton (1, x1, y1, 100, 20, "Close menu"));
		this.buttonList.add(this.discord = new GuiButton (2, x1, y2, 100, 20, "GitHub"));
		
	}
	
	public void mouseClicked(int mouseX, int mouseY, int mousebutton) {
		
		if (close.isMouseOver()) {
			
			mc.displayGuiScreen((GuiScreen) null);
			
		} else if (discord.isMouseOver()) {
			
			Desktop desk = Desktop.getDesktop();
			
			if (discord.isMouseOver()) {
				try {
					desk.browse(new URI("https://github.com/Chifouuu"));
				} catch (IOException e1){
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					e1.printStackTrace();
				}
			}
			
		} else if (toggle.isMouseOver()) {
			
			if (mc.gameSettings.fovSetting == 200) {
				
				mc.gameSettings.fovSetting = 70;
				mc.gameSettings.invertMouse = false;
				
			} else {
				
				mc.gameSettings.fovSetting = 200;
				mc.gameSettings.invertMouse = true;
				
			}
			

		}
		
	}
	
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		
		this.drawDefaultBackground();
		super.drawScreen(mouseX, mouseY, partialTicks);
		
		int x1 = width/2;
		int y1 = height/2 - 120;
		
		int x2 = width/2;
		int y2 = height/2 - 110;
		
		this.drawCenteredString(mc.fontRendererObj, "Inversed\2474Craft", x1, y1, Color.WHITE.getRGB());
		this.drawCenteredString(mc.fontRendererObj, "Mod by\2476 Chifou", x2, y2, Color.WHITE.getRGB());
	}
	
	public boolean doesGuiPauseGame() {
		return false;
	}
	
}
