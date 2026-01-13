package io.github.Core;


import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Game extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture image;
    private int stage;
    private boolean isAttacking = false;



    private long attackEndTime = 0;

    public void startAttack() {
        isAttacking = true;
        // 记录下 200 毫秒后的系统时间
        attackEndTime = System.currentTimeMillis() + 200;
    }

    public void update() {
        // 检查当前时间是否超过了结束时间
        if (isAttacking && System.currentTimeMillis() > attackEndTime) {
            isAttacking = false;
        }
    }

    @Override
    public void create() {
        batch = new SpriteBatch();
        image = new Texture("libgdx.png");
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();
        batch.draw(image, 140, 210);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
    }
}
