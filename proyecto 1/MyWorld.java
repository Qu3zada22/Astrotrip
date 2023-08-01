import greenfoot.*;

public class MyWorld extends World {
    private static final int NUM_ASTEROIDS = 5;
    private static final int NUM_STARS = 5;
    private static final int ASTEROID_SPEED_INCREMENT = 1;

    private int collectedStars;
    private int currentLevel;

    public MyWorld() {
        super(800, 600, 1);
        currentLevel = 1;
        collectedStars = 0;
        prepare();
    }

    private void prepare() {
        // Generar las estrellas y la nave espacial para el nivel actual
        generateLevel(currentLevel);

        // Generar el planeta en una posición específica para el nivel actual
        addObject(new Planet(), getWidth() - 50, getHeight() - 50);
    }

    public void starCollected(int x, int y) {
        collectedStars++;
        if (collectedStars == NUM_STARS) {
            // Si todas las estrellas fueron recolectadas, pasa al siguiente nivel
            currentLevel++;
            if (currentLevel <= 3) {
                generateLevel(currentLevel);
            } else {
                // Aquí puedes implementar el código para mostrar un mensaje de victoria
                Greenfoot.stop();
            }
        }
    }

    public void respawnSpacecraft(int x, int y) {
        Spacecraft spacecraft = new Spacecraft();
        addObject(spacecraft, x, y);
    }

    private void generateLevel(int level) {
        // Eliminar todos los asteroides y estrellas del nivel anterior
        removeObjects(getObjects(Asteroid.class));
        removeObjects(getObjects(Star.class));

        // Generar las estrellas aleatoriamente en diferentes partes de la pantalla
        for (int i = 0; i < NUM_STARS; i++) {
            int starX = Greenfoot.getRandomNumber(getWidth());
            int starY = Greenfoot.getRandomNumber(getHeight());
            addObject(new Star(), starX, starY);
        }

        // Generar la nave espacial en una posición específica para el nivel actual
        Spacecraft spacecraft = new Spacecraft();
        int spacecraftX = getWidth() / 2;
        int spacecraftY = getHeight() / 2;
        addObject(spacecraft, spacecraftX, spacecraftY);

        // Generar asteroides según el nivel
        if (level == 2) {
            // Nivel 2: asteroides que se mueven de arriba a abajo
            for (int i = 0; i < NUM_ASTEROIDS; i++) {
                int x = Greenfoot.getRandomNumber(getWidth());
                int y = Greenfoot.getRandomNumber(getHeight() / 2);
                int direction = Greenfoot.getRandomNumber(180) + 90; // Angulo entre 90 y 270 grados
                addObject(new Asteroid(), x, y);
                Asteroid asteroid = (Asteroid) getObjects(Asteroid.class).get(getObjects(Asteroid.class).size() - 1);
                asteroid.setRotation(direction);
            }
        } else if (level == 3) {
            // Nivel 3: asteroides estáticos
            for (int i = 0; i < NUM_ASTEROIDS; i++) {
                int x = Greenfoot.getRandomNumber(getWidth());
                int y = Greenfoot.getRandomNumber(getHeight());
                addObject(new Asteroid(), x, y);
            }
        } else {
            // Nivel 1: asteroides que se mueven en dirección aleatoria (como en versiones anteriores)
            for (int i = 0; i < NUM_ASTEROIDS; i++) {
                int x = Greenfoot.getRandomNumber(getWidth());
                int y = Greenfoot.getRandomNumber(getHeight());
                int direction = Greenfoot.getRandomNumber(360);
                addObject(new Asteroid(), x, y);
                Asteroid asteroid = (Asteroid) getObjects(Asteroid.class).get(getObjects(Asteroid.class).size() - 1);
                asteroid.setRotation(direction);
            }
        }
    }

    public void nextLevel() {
        // Elimina todos los asteroides, estrellas y la nave espacial del nivel actual
        removeObjects(getObjects(Asteroid.class));
        removeObjects(getObjects(Star.class));
        removeObjects(getObjects(Spacecraft.class));

        // Genera el siguiente nivel
        generateLevel(currentLevel);
    }
}
