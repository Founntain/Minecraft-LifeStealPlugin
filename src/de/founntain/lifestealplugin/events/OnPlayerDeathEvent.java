package de.founntain.lifestealplugin.events;


import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

public class OnPlayerDeathEvent implements Listener {
    @EventHandler
    public void onPlayerDamage(PlayerDeathEvent e){

        if(e.getEntity() instanceof Player){
            Player player = (Player) e.getEntity();

            if(player.getKiller() == null) return;

            double maxHealth = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue();
            double newMaxHealth = maxHealth - 1;

            if(newMaxHealth <= 2){
                player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(2);
            }else{
                player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(newMaxHealth);
            }

            Player killer = player.getKiller();
            double killerMaxHealth = killer.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue();

            killer.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(killerMaxHealth + 1);
        }
    }
}
