import greenfoot.*;

public class Star extends Actor {
    public void act() {
        checkCollection();
    }

    private void checkCollection() {
        Spacecraft spacecraft = (Spacecraft) getOneIntersectingObject(Spacecraft.class);
        if (spacecraft != null) {
            // Si la nave recolecta una estrella, aumentar el contador y eliminar la estrella
            spacecraft.lastStarPosX = this.getX();
            spacecraft.lastStarPosY = this.getY();
            getWorld().removeObject(this);
            spacecraft.collectStar();
        }
    }
}
