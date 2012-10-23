package com.gmail.andrewzorn.EventPlugin;

import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.Location;
import org.bukkit.World;

import com.google.common.base.Joiner;

public class EventPluginCommandExecutor implements CommandExecutor
{
	private final EventPlugin plugin;

	public EventPluginCommandExecutor(EventPlugin plugin) {
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (command.getName().equalsIgnoreCase("woodenBridge")) {
			Player player = (Player)sender;
			Location location = player.getLocation();
			World world = location.getWorld();
			float direction = player.getLocation().getYaw();
			
			location.setY(location.getY()-1);
			for(int i=0;i<Integer.parseInt(args[0]);i++) {
				Block toChange = world.getBlockAt(location);
				toChange.setTypeId(05);
				location.setZ(location.getZ()+1);
			}
		}
			
		return false;
	}
}
