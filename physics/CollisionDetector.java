package physics;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CollisionDetector {

    private List<Collidable> collidables = new CopyOnWriteArrayList<>();

    public void detectCollisions() {
        for (Collidable col : collidables) {
            col.collided();
        }
    }

    public void addCollidable(Collidable collidable) {
        collidables.add(collidable);
    }

    public void removeCollidable(Collidable collidable) {
        collidables.remove(collidable);

    }

}