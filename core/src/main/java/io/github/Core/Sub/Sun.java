package io.github.Core.Sub;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class Sun extends Entity{

    private Animation<TextureRegion> idleAnimation;
    private Animation<TextureRegion> attackingAnimation;
    private Animation<TextureRegion> defendingAnimation;



    private double health;
    private double attack;
    private double defence;

    private static int nOfMonsters;
    private Base base;
    private boolean bask;

    public Sun(Base base, float x, float y, float width, float height){
        super(x,y,width,height,0);
        this.base = base;
        nOfMonsters++;


        animations.put("IDLE", AnimationLoader.createAnimation("characters/player/idle", 2, 0.3f));

        animations.put("ATTACK", AnimationLoader.createAnimation("characters/player/attack", 3, 0.05f));
        animations.put("DAMAGE", AnimationLoader.createAnimation("characters/player/damage", 3, 0.05f));


    }

    public Rectangle getBounds() {

        return new Rectangle(x, y, width, height);
    }





}

