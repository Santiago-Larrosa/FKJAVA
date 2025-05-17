package com.FK.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AnimationHandler {
    private final TextureRegion[] frames;
    private float frameDuration;
    private float stateTime = 0;

    public AnimationHandler(Texture spriteSheet, int[][] frameData, float frameDuration) {
        this.frameDuration = frameDuration;
        this.frames = new TextureRegion[frameData.length];

        for (int i = 0; i < frameData.length; i++) {
            int[] f = frameData[i];
            frames[i] = new TextureRegion(spriteSheet, f[0], f[1], f[2], f[3]);
        }
    }

    public void update(float delta) {
        stateTime += delta;
    }

    public TextureRegion getCurrentFrame() {
        int index = (int)(stateTime / frameDuration) % frames.length;
        return frames[index];
    }
    public void reset() {
        stateTime = 0f;
    }

    public void dispose() {
        if (frames.length > 0) {
            frames[0].getTexture().dispose(); // solo necesitamos eliminar el spriteSheet una vez
        }
    }
}
