package io.github.Core.Sub;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class Wugang extends Entity{

    private Animation<TextureRegion> idleAnimation;
    private Animation<TextureRegion> attackingAnimation;
    private Animation<TextureRegion> defendingAnimation;
    private Animation<TextureRegion> walkAnimation;



    private double health;
    private double attack;
    private double defence;

    private static int nOfMonsters;
    private Base base;
    private boolean bask;

    public Wugang(Base base, float x, float y, float width, float height){
        super(x,y,width,height,0);
        this.base = base;
        nOfMonsters++;


        // 批量加载动画
        // 假设 assets/characters/player/ 下有 idle_0.png, idle_1.png ...
        animations.put("IDLE", AnimationLoader.createAnimation("characters/player/idle", 2, 0.3f));

        animations.put("WALK", AnimationLoader.createAnimation("characters/player/walk", 4, 0.1f));
        animations.put("ATTACK", AnimationLoader.createAnimation("characters/player/attack", 3, 0.05f));
        animations.put("DAMAGE", AnimationLoader.createAnimation("characters/player/damage", 3, 0.05f));


    }

    public Rectangle getBounds() {

        return new Rectangle(x, y, width, height);
    }





}

