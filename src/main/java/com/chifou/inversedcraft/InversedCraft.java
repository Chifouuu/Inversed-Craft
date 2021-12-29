package com.chifou.inversedcraft;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.init.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

@Mod(modid = InversedCraft.MODID, version = InversedCraft.VERSION)
public class InversedCraft
{
    public static final String MODID = "InversedCraft";
    public static final String VERSION = "beta1.0";
    public static KeyBinding menu = new KeyBinding("Ouvrir le menu InversedCraft", Keyboard.KEY_RSHIFT, "Inversed Craft");
    public static Minecraft mc = Minecraft.getMinecraft();
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
		
    	ClientRegistry.registerKeyBinding(menu);
    	
    	MinecraftForge.EVENT_BUS.register(this);
    	
    }
    
    @SubscribeEvent
    public void onKey(InputEvent.KeyInputEvent e) {
    	
    	if (menu.isPressed()) {
    		
    		mc.displayGuiScreen(new GUI());
    		
    	}
    	
    }
}
