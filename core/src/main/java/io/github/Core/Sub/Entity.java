package io.github.Core.Sub;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

import java.util.HashMap;

public abstract class Entity {
    public float x, y, width, height,heading;

    public float hp;

    // 随时间扣血相关的变量
    private float damageTimer = 0;      // 计时器：记录当前过了多少秒
    private float damageInterval = 1.0f; // 频率：每 1.0 秒扣一次血
    private float damagePerTick = 5.0f;  // 数值：每次扣 5 点血
    private boolean isTakingDotDamage = false; // 开关：当前是否处于持续扣血状态
    protected Rectangle hitbox; // 统一叫 hitbox



    // 动画属性
    protected float stateTime = 0;
    protected String currentState = "IDLE";
    protected HashMap<String, Animation<TextureRegion>> animations = new HashMap<>();

    public Entity(float x, float y, float width, float height,float heading) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.heading = heading;
        this.hitbox = new Rectangle(x, y, width, height);
    }


    public void setState(String newState) {
        if (!currentState.equals(newState)) {
            currentState = newState;
            stateTime = 0;
        }
    }






    public Rectangle getHitbox() { return hitbox; }

    public void draw(SpriteBatch batch) {
        Animation<TextureRegion> anim = animations.get(currentState);
        if (anim != null) {
            TextureRegion currentFrame = anim.getKeyFrame(stateTime);
            if(heading == -1){
                batch.draw(currentFrame, x, y, width, height);
            }else{
                batch.draw(currentFrame, x+width, y, -width, height);
            }

        }

    }

    public void setDotDamage(boolean active, float damage, float interval) {
        this.isTakingDotDamage = active;
        this.damagePerTick = damage;
        this.damageInterval = interval;
    }

    public void update(float deltaTime) {
        stateTime += deltaTime;
        hitbox.setPosition(x, y);


        if (isTakingDotDamage && hp > 0) {
            damageTimer += deltaTime;


            if (damageTimer >= damageInterval) {
                hp -= damagePerTick;
                damageTimer = 0;


                onDamaged();
            }
        }
    }

    protected void onDamaged() {

        this.setState("DAMAGED");
    }

    public void setHeading(float heading){
        this.heading = heading;
    }



    public float getX(){
        return x;
    }

    public float getY(){
        return y;
    }

    public float getHeading(){
        return heading;
    }

}


