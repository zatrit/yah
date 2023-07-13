package net.zatrit.yah;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class YetAnotherHeads extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerDeath(@NotNull PlayerDeathEvent event) {
        final var player = event.getEntity();

        if (player.getKiller() != null) {
            final var stack = new ItemStack(Material.PLAYER_HEAD);
            final var meta = (SkullMeta) stack.getItemMeta();
            meta.setOwningPlayer(event.getPlayer());
            stack.setItemMeta(meta);

            event.getDrops().add(stack);
        }
    }
}
