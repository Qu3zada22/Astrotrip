import greenfoot.*;

public class Spacecraft extends Actor {
    private int fuel;
    private int starsCollected;
    
    public int lastStarPosX = 0;
    public int lastStarPosY = 0;
    
    public Spacecraft() {
        fuel = 100; // Inicializar el tanque de combustible
        starsCollected = 0;
    }
    
    public void act() {
        checkKeyPress();
        checkCollision();
        checkWin();
    }
    
    private void checkKeyPress() {
        if (Greenfoot.isKeyDown("up")) {
            // Mover hacia arriba
            setLocation(getX(), getY() - 5);
        }
        if (Greenfoot.isKeyDown("down")) {
            // Mover hacia abajo
            setLocation(getX(), getY() + 5);
        }
        if (Greenfoot.isKeyDown("left")) {
            // Mover hacia la izquierda
            setLocation(getX() - 5, getY());
        }
        if (Greenfoot.isKeyDown("right")) {
            // Mover hacia la derecha
            setLocation(getX() + 5, getY());
        }
    }
    
    private void checkCollision() {
        // Código para verificar colisiones con los asteroides
        // Si colisiona con un asteroide, el jugador pierde y puede mostrar un Game Over
    }
    
    private void checkWin() {
        // Código para verificar si llegó al planeta y pasó al siguiente nivel
        // También se puede verificar si ha recolectado suficientes estrellas para avanzar al siguiente nivel
    }
    
    public void collectStar() {
        starsCollected++;
    }
    
    public void refuel(int amount) {
        fuel += amount;
    }
    
    public void useFuel(int amount) {
        fuel -= amount;
        if (fuel <= 0) {
            // Si se queda sin combustible, el jugador pierde y puede mostrar un Game Over
        }
    }
}