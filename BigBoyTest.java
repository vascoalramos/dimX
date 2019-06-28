import java.util.Scanner;

public class BigBoyTest {  

    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);
        int v2 = 6;
        int v3 = 5;
        boolean v1 = v2 > v3;
        int v5 = 4;
        int v6 = 3;
        boolean v4 = v5 < v6;
        boolean v0 = v1 && v4;
        if (v0) {
           String v7 = "oi";
           System.out.println(v7);
        }
        else {
           int v9 = 3;
           int v10 = 2;
           boolean v8 = v9 > v10;
           if (v8) {
              String v11 = "boi";
              System.out.println(v11);
           }
        }
    }
}
