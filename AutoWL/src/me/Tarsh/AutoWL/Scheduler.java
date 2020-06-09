package me.Tarsh.AutoWL;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class Scheduler extends BukkitRunnable{
	String wlTime;
	
	public Scheduler(String time) {
		wlTime = time;
	}
	@Override
	public void run() {
		String currTime = Time.getTime();
		if (currTime.equals(wlTime)) {
			Core.getPlugin(Core.class).getServer().dispatchCommand(Bukkit.getConsoleSender(), "whitelist off");
			cancel();
		}
		
	}
	


}
