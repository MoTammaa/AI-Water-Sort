package code.entites;

public enum Color {
    red, green, blue, yellow, orange, EMPTY;

    public static Color getColor(String color){
        return switch (color) {
            case "r" -> red;
            case "g" -> green;
            case "b" -> blue;
            case "y" -> yellow;
            case "o" -> orange;
            default -> EMPTY;
        };
    }
}
