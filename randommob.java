package ir.praxime.randommob;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main extends JavaPlugin implements CommandExecutor {

    private final Random random = new Random();
    private final List<EntityType> spawnableMobs = Arrays.stream(EntityType.values())
            .filter(type -> type.isAlive() && type.isSpawnable())
            .filter(type -> type != EntityType.ENDER_DRAGON
                    && type != EntityType.WITHER
                    && type != EntityType.WARDEN)
            .toList();

    @Override
    public void onEnable() {
        this.getCommand("randommob").setExecutor(this);
        getLogger().info("RandomMob plugin enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("RandomMob plugin disabled.");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("Only players can run this command.");
            return true;
        }

        EntityType randomMob = spawnableMobs.get(random.nextInt(spawnableMobs.size()));
        Location location = player.getLocation();
        player.getWorld().spawnEntity(location, randomMob);
        player.sendMessage("Spawned a random mob: " + randomMob.name());
        return true;
    }
}
