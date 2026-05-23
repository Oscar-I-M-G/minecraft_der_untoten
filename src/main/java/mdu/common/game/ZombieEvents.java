package mdu.common.game;

import mdu.common.PlayerPoints;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.minecraft.world.entity.monster.zombie.Zombie;
import net.minecraft.world.entity.player.Player;

public class ZombieEvents {
    private static final int HIT_POINTS = 10;
    private static final int KILL_POINTS = 100;

    public static void init(){
        ServerLivingEntityEvents.ALLOW_DAMAGE.register((entity, source, amount) -> {
          if (!(entity instanceof Zombie)){
              return true;
          }
          if (source.getEntity() instanceof Player player){
              PlayerPoints.add(player.getUUID(), HIT_POINTS);
          }
          return true;
        });

        ServerLivingEntityEvents.AFTER_DEATH.register((entity, damageSource) -> {
            if (!(entity instanceof Zombie)){
                return;
            }

            if (damageSource.getEntity() instanceof Player player){
                PlayerPoints.add(player.getUUID(), KILL_POINTS);
            }
        });
    }
}
