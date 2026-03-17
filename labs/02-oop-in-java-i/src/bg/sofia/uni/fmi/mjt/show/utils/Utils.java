package bg.sofia.uni.fmi.mjt.show.utils;

public class Utils {
    public static int clamp(int value, int min, int max){
        if(value < min) return min;
        else if(value > max) return max;
        return value;
    }
}
