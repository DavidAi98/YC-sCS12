package io.github.Core.Sub;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class Arrow extends Entity {
    private float speed = 400f;
    protected float lifeTime = 2.0f;

    public Arrow(float x, float y, float heading) {

        super(x, y, 32, 10, heading);


        animations.put("IDLE", AnimationLoader.createAnimation("characters/player/arrow", 1, 1f));
        this.setState("IDLE");
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);


        this.x += speed * heading * deltaTime;

        lifeTime -= deltaTime;
    }

    public boolean isExpired() {
        return lifeTime <= 0;
    }
}
