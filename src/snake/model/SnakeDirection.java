package snake.model;

/**
 * Created by Miroslav on 23.04.2017.
 */
public enum SnakeDirection {
    
    LEFT() {      
        public SnakeDirection opposite() {
            return RIGHT;
        }
    },
    RIGHT() {       
        public SnakeDirection opposite() {
            return LEFT;
        }
    },
    UP(){      
        public SnakeDirection opposite() {
            return DOWN;
        }        
    },
    DOWN() {       
        public SnakeDirection opposite() {
            return UP;
        }             
    };

    SnakeDirection() {
    }
    
    public abstract SnakeDirection opposite();
      
}
