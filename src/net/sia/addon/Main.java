package net.sia.addon;

import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.plugin.java.JavaPlugin;

import ch.njol.skript.Skript;
import ch.njol.skript.SkriptAddon;
import ch.njol.skript.lang.ExpressionType;
import net.sia.addon.expr.*;

public class Main extends JavaPlugin implements Listener {
	
	private static Main instance;
	private static SkriptAddon addonInstance;
	public Main() {
		if (instance == null) {
			instance = this;
		} else {
			throw new IllegalStateException();
		}
	}
	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(this, this);
		Skript.registerAddon(this);
		Skript.registerExpression(ExprClickType.class, ClickType.class, ExpressionType.COMBINED, "[SkF] get clicked type");
		Skript.registerExpression(UUID.class, String.class, ExpressionType.COMBINED, new String[] {"[SkF] %player% id"});
		Skript.registerExpression(BorderSize.class, String.class, ExpressionType.COMBINED, new String[] {"[SkF] border size of %string%"});
		Skript.registerExpression(GetHotbarSlot.class, Long.class, ExpressionType.COMBINED, "[SkF] get hotbar slot of %player%");
	}
	
	public static Main getInstance() {
		if (instance == null) {
			throw new IllegalStateException();
		} else {
			return instance;
		}
	}

	public static SkriptAddon getAddonInstance() {
		if (addonInstance == null) {
			addonInstance = Skript.registerAddon(getInstance());
		}
		return addonInstance;
	}

}
