package com.gmail.andrewzorn.EventPlugin;

import org.bukkit.plugin.java.JavaPlugin;

public class EventPlugin extends JavaPlugin
{
	EventPluginLogger logger;

	@Override
	public void onEnable() {
		logger = new EventPluginLogger(this);
		logger.info("EventPlugin enabled.");
		saveDefaultConfig();
		new EventPluginListener(this);
		this.getCommand("woodenBridge").setExecutor(new EventPluginCommandExecutor(this));
	}

	@Override
	public void onDisable() {
		logger = new EventPluginLogger(this);
		logger.info("EventPlugin disabled.");
	}
}
