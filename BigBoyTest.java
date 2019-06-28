import java.util.Scanner;

public class BigBoyTest {  

    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);
        int v2 = 6;
        boolean v1 = !v2;
        int v3 = 5;
        boolean v0 = v1 < v3;
        if (v0) {
           String v4 = "oi";
           System.out.println(v4);
        }
        else {
           String v5 = "rip";
           System.out.println(v5);
        }
    }
}
