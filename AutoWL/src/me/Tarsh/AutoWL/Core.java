package me.Tarsh.AutoWL;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin {
	final static String PREFIX = ChatColor.AQUA + "AutoWL>> " + ChatColor.RESET;
	
	@Override
	public void onEnable() {
		getCommand("autowl").setExecutor(new AutoWL());
	}

	@Override
	public void onDisable() {

	}



}
