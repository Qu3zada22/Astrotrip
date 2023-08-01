import greenfoot.*;

public class Planet extends Actor {
    public void act() {
        checkCollision();
    }

    private void checkCollision() {
        Spacecraft spacecraft = (Spacecraft) getOneIntersectingObject(Spacecraft.class);
        if (spacecraft != null) {
            MyWorld world = (MyWorld) getWorld();
            world.nextLevel(); // Pasar al siguiente nivel cuando la nave toque el planeta
        }
    }
}
