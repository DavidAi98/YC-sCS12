package io.github.Core.Sub;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class AnimationLoader {
    public static Animation<TextureRegion> createAnimation(String pathPrefix, int frameCount, float frameDuration) {
        Array<TextureRegion> frames = new Array<>();

        for (int i = 0; i < frameCount; i++) {

            String fullPath = pathPrefix + "_" + i + ".png";
            Texture tex = new Texture(Gdx.files.internal(fullPath));


            tex.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
            frames.add(new TextureRegion(tex));
        }


        return new Animation<>(frameDuration, frames, Animation.PlayMode.LOOP);
    }
}
