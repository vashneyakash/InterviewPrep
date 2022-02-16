package google.java;

import google.java.RobotRoomCleaner.Coordinate.Direction;
import javafx.util.Pair;

import java.util.*;
import java.util.stream.Collectors;

import static google.java.RobotRoomCleaner.Coordinate.Direction.*;

public class RobotRoomCleaner {
    /*
    * Brute force:
    * Start with current cell, do dfs, maintain visited set
    * try all possible directions. If no move left backtrack
    * */
    private final Coordinate robotStartCoordinates;
    private final Set<Coordinate> visitedCoordinates = new HashSet<>();
    private final Set<Coordinate> blockedCoordinates;
    public RobotRoomCleaner(Coordinate robotStartCoordinates, List<Coordinate> blockedCoordinates) {
        this.robotStartCoordinates = robotStartCoordinates;
        this.blockedCoordinates = new HashSet<>(blockedCoordinates);
    }

    void cleanRoom(Coordinate currentCoordinates) {
        if (visitedCoordinates.contains(currentCoordinates)) {
            return;
        }

        // clean
        for (Direction direction: Direction.values()) {
            switch (direction) {
                case up:
                    if (!blockedCoordinates.contains(currentCoordinates.moveUp())) {
                        cleanRoom(currentCoordinates.moveUp());
                    }
                case right:
                    if (!blockedCoordinates.contains(currentCoordinates.moveRight())) {
                        cleanRoom(currentCoordinates.moveRight());
                    }
                case down:
                    if (!blockedCoordinates.contains(currentCoordinates.moveDown())) {
                        cleanRoom(currentCoordinates.moveDown());
                    }
                case left:
                    if (!blockedCoordinates.contains(currentCoordinates.moveLeft())) {
                        cleanRoom(currentCoordinates.moveLeft());
                    }
            }
        }
    }

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

        public Coordinate moveUp() {
            return new Coordinate(x, y + 1, direction);
        }

        public Coordinate moveDown() {
            return new Coordinate(x, y - 1, direction);
        }

        public Coordinate moveLeft() {
            return new Coordinate(x - 1, y, direction);
        }

        public Coordinate moveRight() {
            return new Coordinate(x + 1, y, direction);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Coordinate)) return false;
            Coordinate that = (Coordinate) o;
            return x == that.x && y == that.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
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
