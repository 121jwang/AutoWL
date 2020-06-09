package me.Tarsh.AutoWL;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.scheduler.BukkitTask;

public class AutoWL implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args) {
		if (command.getName().equalsIgnoreCase("autowl")) {
			// Make sure the user sends valid input
			if (args.length == 0 || !args[0].matches("\\d{2}:\\d{2}")) {
				sender.sendMessage(Core.PREFIX + ChatColor.RED + "Invalid Usage! /autowl <XX:XX>");
				return false;
			}
			try {
				Integer.parseInt(args[0].substring(0, 2));
				Integer.parseInt(args[0].substring(3, 5));
			}
			catch(Exception e) {
				sender.sendMessage(Core.PREFIX + ChatColor.RED + "Invalid Usage! /autowl <XX:XX>");
				return false;
			}

			String wlTime = args[0];
			sender.sendMessage(Core.PREFIX + ChatColor.GREEN + "Server will be unwhitelisted at " + wlTime + " UTC");

			BukkitTask task = new Scheduler(wlTime).runTaskTimer(Core.getPlugin(Core.class), 0L, 20L);

		}

		return false;
	}

}
