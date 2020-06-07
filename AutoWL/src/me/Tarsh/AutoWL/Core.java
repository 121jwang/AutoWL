package me.Tarsh.AutoWL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;



public class Core extends JavaPlugin{
	final static String PREFIX = ChatColor.AQUA + "AutoWL>> " + ChatColor.RESET;
			
	@Override
	public void onEnable() {
		getCommand("autowl").setExecutor(this);
	}
	
	@Override
	public void onDisable() {
		
	}
	
	public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args) {
		if (command.getName().equalsIgnoreCase("autowl")){
			// Make sure the user sends valid input
			if (args.length == 0 || !args[0].matches("\\d{2}:\\d{2}")) {
				sender.sendMessage(PREFIX + ChatColor.RED + "Invalid Usage! /autowl <XX:XX>");
				return false;
			}
			
			String wlTime = args[0];
			sender.sendMessage(PREFIX + ChatColor.GREEN + "Server will be unwhitelisted at " + wlTime + " UTC");
			
			// Checks every tick for the time until it's the right time
			new BukkitRunnable()
			{
			  public void run()
			  {
				  String currTime = getTime();
				  if (currTime.equals(wlTime)) {
            		getServer().dispatchCommand(Bukkit.getConsoleSender(), "whitelist off");
            		cancel();
				  }
			  }
			 
			}.runTaskTimer(this, 0L, 20L);
			
		}
		
		
		return false;
	}
	

		  
	  // Gets the UTC time in XX:XX format
	  public static String getTime(){
		try {
			URL url = new URL("http://worldtimeapi.org/api/timezone/Etc/UTC.txt");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;

			StringBuffer content = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				content.append(inputLine + "\n");
			}
			in.close();
			
			// Parses the return data into a hashmap
			Map<String, String> vals = new HashMap<String, String>();
			String[] pairs = content.toString().split("\n");

			for (int i = 0;i < pairs.length; i++) {
				String pair = pairs[i];
				try{
					String[] keyValue = pair.split(": ");
					vals.put(keyValue[0], keyValue[1]);
				}
				catch (ArrayIndexOutOfBoundsException e){
					continue;
				}
			}

			String[] time = vals.get("datetime").split("T")[1].split(":");
			return time[0] + ":" + time[1];
		} catch (IOException e) {
			return "error";
		}

		
	  }
}	
