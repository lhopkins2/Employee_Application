import java.util.ArrayList;

/**
 * This is a class with methods used mostly for validation
 */
public class Utilities {

    public static boolean validPPS(String str) {
        return str.matches("[0-9]{7}[A-Z a-z]{2}");
    }

    public static String max10Chars(String str){
        if(str.length() < 10)
            return str;
        else
            return str.substring(0,10);
    }
    public static boolean validIntRange(int a, int b,int  c){
        if(c > a && c < b || c == b || c == a)
            return true;
        else return false;
    }
    public static boolean validIntNonNegative(int a){
        if(a >= 0) return true;
        else return false;
    }

    public static boolean validDoubleNonNegative(double a){
        if(a >= 0) return true;
        else return false;
    }


    public static boolean validIndex(int a, ArrayList<Employee> strs){
        if( a < 0) return false;
        if(strs.size()  > a && strs.size() >= 0)
        return true;
        else return false;
    }

    public static boolean validPercentBonus(double a){
        if(a >=0 && a <= 20)
            return true;
        else return false;
    }

}
