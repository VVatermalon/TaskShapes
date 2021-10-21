package util;

public class IdGenerator {
    static int counter = 0;
    public static int GenerateId() {
        return counter++;
    }
}
