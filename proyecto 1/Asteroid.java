import greenfoot.*;

public class Asteroid extends Actor {
    private int speed;
    
    public Asteroid() {
        speed = Greenfoot.getRandomNumber(1) + 1; // Velocidad aleatoria entre 1 y 3
    }

    public void act() {
        moveAsteroid();
        checkCollision();
    }
    
    private void moveAsteroid() {
        // Mover el asteroide en dirección opuesta cuando toca el borde
        if (isAtEdge()) {
            turn(180);
        }
        move(speed);
    }
    
    private void checkCollision() {
        if (isTouching(Spacecraft.class)) {
            World mundo = getWorld();// Detener el juego cuando la nave toca un asteroide
            
            Actor naveTocada = getOneIntersectingObject(Spacecraft.class);
            if (naveTocada != null){
                int lastPosX = ((Spacecraft)naveTocada).lastStarPosX;
                int lastPosY = ((Spacecraft)naveTocada).lastStarPosY;
                mundo.removeObject(naveTocada);
                Spacecraft nuevaNave = new Spacecraft();
                nuevaNave.lastStarPosX = lastPosX;
                nuevaNave.lastStarPosY = lastPosY;
                mundo.addObject(nuevaNave, lastPosX, lastPosY);
            }
        }
    }
}
