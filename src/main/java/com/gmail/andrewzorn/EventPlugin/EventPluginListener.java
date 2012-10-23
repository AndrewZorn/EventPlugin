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
	public void onBlockPlace(BlockPlaceEvent event) {
		if (event.isCancelled()) return;

		if (event.getBlock().getType() == Material.TNT) {
			event.setCancelled(true);

			Player player = event.getPlayer();

			player.sendMessage(ChatColor.RED+"You are not allowed to use TNT on this server!");

			for (Player onLinePlayer : Bukkit.getServer().getOnlinePlayers()) {
				if (onLinePlayer.isOp()) {
					onLinePlayer.sendMessage(player.getName()+" just placed TNT");
				}
			}
		}
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void onExplosionPrime(ExplosionPrimeEvent event) {
		if (event.isCancelled()) return;

		if (event.getEntity() instanceof TNTPrimed) {
			event.setCancelled(true);
		}
	}
}
