package prove02;


public enum Direction {
    RIGHT, LEFT, ABOVE, BELOW, UNKNOWN;

    public static Direction fromInt(int i) {
        switch (i) {
            case 0:
                return Direction.RIGHT;
            case 1:
                return Direction.LEFT;
            case 2:
                return Direction.ABOVE;
            case 3:
                return Direction.BELOW;
            default:
                return Direction.UNKNOWN;
        }
    }
}