package google.java;

public class RobotRoomCleaner {
    /*
    * Brute force:
    * Start with current cell, do dfs, maintain visited set
    * try all possible directions. If no move left backtrack
    * */

    public static class Coordinate {
        private final int x;
        private final int y;
        private final Direction direction;

        public Coordinate(int x, int y, Direction direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }

        public int x() {
            return x;
        }

        public int y() {
            return y;
        }

        public Direction direction() {
            return direction;
        }

        public static enum Direction {
            up, right, down, left;

            public Direction turnRight() {
                return switch (this) {
                    case up -> right;
                    case right -> down;
                    case down -> left;
                    case left -> up;
                };
            }

            public Direction turnLeft() {
                return switch (this) {
                    case up -> left;
                    case left -> down;
                    case down -> right;
                    case right -> up;
                };
            }
        }
    }
}
