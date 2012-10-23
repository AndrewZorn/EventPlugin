package com.gmail.andrewzorn.EventPlugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.ExplosionPrimeEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class EventPluginListener implements Listener
{
	private final EventPlugin plugin;

	public EventPluginListener(EventPlugin plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		this.plugin = plugin;
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		event.getPlayer().sendMessage(this.plugin.getConfig().getString("basic.message"));
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void build (PlayerInteractEvent Event event) {
		if (event.getAction() == ACTION.LEFT_CLICK_BLOCK) {
			Block buildOn = event.getClickedBlock();
			if(buildOn!=null) {
				Location buildLocation = buildOn.location();
				World world = buildLocation.getWorld();

				for(int i=0;i<Integer.parseInt(args[0]);i++) {
					Block toChange = world.getBlockAt(buildLocation);
					toChange.setTypeId(05);
					buildLocation.setZ(location.getZ()+1);
				}

				plugin.logger.info("Bridge built.");
			}
		}
	}
}
