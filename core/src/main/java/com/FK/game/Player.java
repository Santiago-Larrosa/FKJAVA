package com.FK.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;



public class Player {
    private static final float WIDTH = 155;
    private static final float HEIGHT = 110;
    private static final float SPEED = 200;
    private static final float GRAVITY = -900;
    private static final float JUMP_VELOCITY = 250;
    private static final float FLOOR_Y = 100;
    private AnimationHandler walkRightAnimation;
    private AnimationHandler walkLeftAnimation;
    private AnimationHandler idleRightAnimation;
    private AnimationHandler idleLeftAnimation;
    private AnimationHandler chargeJumpAnimation;
    private AnimationHandler chargeLeftJumpAnimation;
    private AnimationHandler jumpingAnimation;
    private AnimationHandler jumpingLeftAnimation;
    private AnimationHandler fallingAnimation;
    private AnimationHandler fallingLeftAnimation;
    private AnimationHandler attackingAnimation;
    private AnimationHandler attackingLeftAnimation;
    private boolean facingRight = true;
    private boolean chargingJump = false;
    private final Texture texture;
    private final Texture pass;
    private final Texture passLeft;
    private final Rectangle bounds;
    private final Vector2 velocity;
    private boolean onGround = true;
    private JumpState jumpState = JumpState.NONE;
    private boolean isAttacking = false;
    private float attackTimeLeft = 0f;
    private static final float ATTACK_DURATION = 0.332f; 



    public Player() {
        texture = new Texture("idle1.png"); 
        pass = new Texture("Pass.png"); 
        passLeft = new Texture("PassLeft.png"); 
        bounds = new Rectangle(100, FLOOR_Y, WIDTH, HEIGHT);
        velocity = new Vector2(0, 0);
        Texture walkSheet = new Texture("walk.png");
        Texture walkLeftSheet = new Texture("walk_left.png");
        Texture idleSheet = new Texture("idle.png");
        Texture idleLeftSheet = new Texture("idleLeft.png");
        Texture chargeJumpSheet = new Texture("chargejump.png");
        Texture chargeLeftJumpSheet = new Texture("chargeLeftJump.png");
        Texture jumpingSheet = new Texture("jumping.png");
        Texture jumpingLeftSheet = new Texture("jumpingLeft.png");
        Texture fallingSheet = new Texture("falling.png");
        Texture fallingLeftSheet = new Texture("fallingLeft.png");
        Texture attackingSheet = new Texture("attacking.png");
        Texture attackingLeftSheet = new Texture("attackingLeft.png");

        int[][] walkFrames = {
            {0, 0, 2480, 1754},
            {0, 1755, 2480, 1754},
            {2481, 0, 2480, 1754},
            {2481, 1755, 2480, 1754},
            {0, 3510, 2480, 1754},
            {2481, 3510, 2480, 1754},
            {0, 5265, 2480, 1754}
        };
        int[][] walkLeftFrames = {
            {0, 0, 2480, 1754},
            {0, 1755, 2480, 1754},
            {2481, 0, 2480, 1754},
            {2481, 1755, 2480, 1754},
            {0, 3510, 2480, 1754},
            {2481, 3510, 2480, 1754},
            {0, 5265, 2480, 1754}
        };
        int[][] idleFrames = {
            {0, 0, 2480, 1754},
            {0, 1755, 2480, 1754},
            {2481, 0, 2480, 1754},
            {2481, 1755, 2480, 1754}
        };
        int[][] idleLeftFrames = {
            {0, 0, 2480, 1754},
            {0, 1755, 2480, 1754},
            {2481, 0, 2480, 1754},
            {2481, 1755, 2480, 1754}
        };
        int[][] chargeJumpFrames = {
            {0, 0, 2480, 1754},
            {0, 1755, 2480, 1754},
            {2481, 0, 2480, 1754}
        };
        int[][] chargeLeftJumpFrames = {
            {0, 0, 2480, 1754},
            {0, 1755, 2480, 1754},
            {2481, 0, 2480, 1754}
        };
        int[][] jumpingFrames = {
            {0, 0, 2480, 1754},
            {0, 1755, 2480, 1754},
            {2481, 0, 2480, 1754}
        };
        int[][] jumpingLeftFrames = {
            {0, 0, 2480, 1754},
            {0, 1755, 2480, 1754},
            {2481, 0, 2480, 1754}
        };
        int[][] fallingFrames = {
            {0, 0, 2480, 1754},
            {0, 1755, 2480, 1754},
            {2481, 0, 2480, 1754}
        };
        int[][] fallingLeftFrames = {
            {0, 0, 2480, 1754},
            {0, 1755, 2480, 1754},
            {2481, 0, 2480, 1754}
        };
        int[][] attackingFrames = {
            {0, 0, 2480, 1754},
            {0, 1755, 2480, 1754},
            {2481, 0, 2480, 1754},
            {2481, 1755, 2480, 1754},
            {0, 1755, 2480, 1754}
        };
        int[][] attackingLeftFrames = {
            {0, 0, 2480, 1754},
            {0, 1755, 2480, 1754},
            {2481, 0, 2480, 1754},
            {2481, 1755, 2480, 1754},
            {0, 1755, 2480, 1754}
        };
        walkRightAnimation = new AnimationHandler(walkSheet, walkFrames, 0.083f);
        walkLeftAnimation = new AnimationHandler(walkLeftSheet, walkLeftFrames, 0.083f);
        idleRightAnimation = new AnimationHandler(idleSheet, idleFrames, 0.083f);
        idleLeftAnimation = new AnimationHandler(idleLeftSheet, idleLeftFrames, 0.083f);
        chargeJumpAnimation = new AnimationHandler(chargeJumpSheet, chargeJumpFrames, 0.083f);
        chargeLeftJumpAnimation = new AnimationHandler(chargeLeftJumpSheet, chargeLeftJumpFrames, 0.083f);
        jumpingAnimation = new AnimationHandler(jumpingSheet, jumpingFrames, 0.083f);
        jumpingLeftAnimation = new AnimationHandler(jumpingLeftSheet, jumpingLeftFrames, 0.083f);
        fallingAnimation = new AnimationHandler(fallingSheet, fallingFrames, 0.083f);
        fallingLeftAnimation = new AnimationHandler(fallingLeftSheet, fallingLeftFrames, 0.083f);
        attackingAnimation = new AnimationHandler(attackingSheet, attackingFrames, 0.083f);
        attackingLeftAnimation = new AnimationHandler(attackingLeftSheet, attackingLeftFrames, 0.083f);
    }
   

    public void update(float delta) {
    if (isAttacking) {
        attackTimeLeft -= delta;
        if (attackTimeLeft <= 0) {
            isAttacking = false;
        }
    }

        handleInput(delta);
        applyPhysics(delta);
        updateAnimation(delta);
    }



   private void handleInput(float delta) {

    if (isAttacking) return;

    if (Gdx.input.isKeyJustPressed(Input.Keys.X) && onGround) {
        isAttacking = true;
        attackTimeLeft = ATTACK_DURATION;
        velocity.x = 0; 
        return;
    }
    if (facingRight) attackingAnimation.reset();
    else attackingLeftAnimation.reset();
 
    if (Gdx.input.isKeyPressed(Input.Keys.SPACE) && onGround) {
        chargingJump = true;
        velocity.x = 0;
        return;
    } else if (chargingJump) {
        chargingJump = false;
        if (onGround) {
            velocity.y = JUMP_VELOCITY;
            onGround = false;
            jumpState = JumpState.PASS;
        }
    }

    if (onGround) {
        jumpState = JumpState.NONE;
    }

    velocity.x = 0;

    if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
        velocity.x = -SPEED;
        facingRight = false;
    }
    if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
        velocity.x = SPEED;
        facingRight = true;
    }

    bounds.x += velocity.x * delta;
    }





    private void applyPhysics(float delta) {
    velocity.y += GRAVITY * delta;
    bounds.y += velocity.y * delta;

    if (bounds.y <= FLOOR_Y) {
        bounds.y = FLOOR_Y;
        velocity.y = 0;
        onGround = true;
        jumpState = JumpState.NONE; 
    } else if (jumpState == JumpState.PASS && velocity.y > 0) {
        jumpState = JumpState.JUMPING; 
    }
    else if (jumpState == JumpState.JUMPING && velocity.y < 0) {
    jumpState = JumpState.FALLING; 
    } else if (jumpState != JumpState.FALLING && velocity.y < 0) {
        jumpState = JumpState.FALLING; 
    }

}


    public void render(Batch batch) {
    TextureRegion currentFrame = null;

    if (isAttacking) {
        currentFrame = facingRight ? attackingAnimation.getCurrentFrame() : attackingLeftAnimation.getCurrentFrame();
    } else if (chargingJump) {
        currentFrame = facingRight ? chargeJumpAnimation.getCurrentFrame() : chargeLeftJumpAnimation.getCurrentFrame();
    } else if (jumpState == JumpState.PASS) {
        batch.draw(facingRight ? pass : passLeft, bounds.x, bounds.y, bounds.width, bounds.height);
        return;
    } else if (jumpState == JumpState.JUMPING) {
        currentFrame = facingRight ? jumpingAnimation.getCurrentFrame() : jumpingLeftAnimation.getCurrentFrame();
    } else if (jumpState == JumpState.FALLING) {
        currentFrame = facingRight ? fallingAnimation.getCurrentFrame() : fallingLeftAnimation.getCurrentFrame();
    } else {
        boolean isMoving = Math.abs(velocity.x) > 10f;
        if (isMoving) {
            currentFrame = facingRight ? walkRightAnimation.getCurrentFrame() : walkLeftAnimation.getCurrentFrame();
        } else {
            currentFrame = facingRight ? idleRightAnimation.getCurrentFrame() : idleLeftAnimation.getCurrentFrame();
        }
    }

    batch.draw(currentFrame, bounds.x, bounds.y, bounds.width, bounds.height);
}





    private void updateAnimation(float delta) {
    if (isAttacking) {
        if (facingRight) attackingAnimation.update(delta);
        else attackingLeftAnimation.update(delta);
        return;
    }

    if (chargingJump) {
        if (facingRight) chargeJumpAnimation.update(delta);
        else chargeLeftJumpAnimation.update(delta);
        return;
    }

    if (jumpState == JumpState.JUMPING) {
        if (facingRight) jumpingAnimation.update(delta);
        else jumpingLeftAnimation.update(delta);
        return;
    }

    if (jumpState == JumpState.FALLING) {
        if (facingRight) fallingAnimation.update(delta);
        else fallingLeftAnimation.update(delta);
        return;
    }

    boolean isMoving = Math.abs(velocity.x) > 10f;

    if (isMoving) {
        if (facingRight) walkRightAnimation.update(delta);
        else walkLeftAnimation.update(delta);
    } else {
        if (facingRight) idleRightAnimation.update(delta);
        else idleLeftAnimation.update(delta);
    }
}





    public void dispose() {
        walkRightAnimation.dispose();
        walkLeftAnimation.dispose();
        idleRightAnimation.dispose();
        idleLeftAnimation.dispose();
        chargeJumpAnimation.dispose();
        chargeLeftJumpAnimation.dispose();
        jumpingAnimation.dispose();
        jumpingLeftAnimation.dispose();
        attackingAnimation.dispose();
        attackingLeftAnimation.dispose();
        texture.dispose();
    }
}