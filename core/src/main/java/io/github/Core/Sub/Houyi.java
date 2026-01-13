package io.github.Core.Sub;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

import javax.imageio.ImageIO;

public class Houyi extends Entity{
    private Animation<TextureRegion> walkAnimation;
    private Animation<TextureRegion> idleAnimation;
    private Animation<TextureRegion> attackingAnimation;
    private Animation<TextureRegion> defendingAnimation;


    public Array<Arrow> activeArrows = new Array<>();


    private double health;
    private double attack;
    private double defence;

    private Base base;
    private boolean bask;

    protected Rectangle hurtbox;
    // 攻击碰撞箱
    protected Rectangle attackBox;
    // 是否正在攻击
    protected boolean isAttacking = false;

    public Houyi(Base base, float x, float y, float width, float height, float heading){
        super(x,y,width,height,heading);
        this.base = base;

        hurtbox = new Rectangle(x, y,  width, height);

        attackBox = new Rectangle(0,0, 60, 20);


        // 批量加载动画
        // 假设 assets/characters/player/ 下有 idle_0.png, idle_1.png ...
        animations.put("IDLE", AnimationLoader.createAnimation("characters/player/idle", 2, 0.3f));
        animations.put("WALK", AnimationLoader.createAnimation("characters/player/walk", 4, 0.1f));
        animations.put("ATTACK", AnimationLoader.createAnimation("characters/player/attack", 3, 0.05f));
        animations.put("DAMAGE", AnimationLoader.createAnimation("characters/player/damage", 3, 0.05f));




    }




    public void checkbask() {
        if (bask) {
            this.setDotDamage(true, 2.0f, 2.0f); // 激活持续扣血
        } else {
            this.setDotDamage(false, 0, 0);      // 停止扣血
        }
    }

    public void setBask(boolean bask){
        this.bask = bask;
    }


    public Rectangle getHurtBox() {

        return hurtbox;
    }

    public Rectangle getAttackBox(){
        return attackBox;

    }





    public void fireArrow() {
        // 箭矢起始位置在后羿中心稍微偏前
        float startX = (heading == 1) ? x + width : x - 32;
        Arrow arrow = new Arrow(startX, y + height/2, this.heading);
        activeArrows.add(arrow);
    }
    private int attackTick = 0;

    public void startAttack() {
        if (attackTick <= 0) {
            setState("ATTACK");
            isAttacking = true;
            attackTick = 30;
        }
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);


        if (attackTick > 0) {
            attackTick--;
            updateAttackBox();
        } else {
            isAttacking = false;
        }
    }

    private void updateAttackBox() {
        // 根据 heading (1 或 -1) 让攻击盒出现在身前
        float offset = (heading == 1) ? width : -attackBox.width;
        attackBox.setPosition(x + offset, y + height/3);
    }



}
