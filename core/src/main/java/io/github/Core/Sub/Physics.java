package io.github.Core.Sub;

import com.badlogic.gdx.utils.Array;

public class Physics {

    public static boolean isColliding(Entity a, Entity b) {
        return a.getHitbox().overlaps(b.getHitbox()); // LibGDX 用 overlaps
    }

    public static boolean checkAttack(Houyi attacker, Entity target) {
        if (attacker.isAttacking && attacker != target) {
            return attacker.getAttackBox().overlaps(target.getHitbox());
        }
        return false;
    }

    public static void updateProjectileCollision(Array<Arrow> arrows, Array<Monster> monsters) {
        for (Arrow arrow : arrows) {
            for (Monster monster : monsters) {

                if (arrow.getHitbox().overlaps(monster.getHitbox())) {
                    monster.hp -= 10;
                    arrow.lifeTime = 0;
                }
            }
        }
    }

}
