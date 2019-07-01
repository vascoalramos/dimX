import java.util.Scanner;

public class BigWomanTest {  

    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);
        int v0;
        int v1 = 0;
        v0 = v1;
        int v3 = v0;
        int v4 = 10;
        boolean v2 = v3 <= v4;
        while (v2) {
            String v6 = "inc = ";
            int v7 = v0;
            String v5 = v6 + v7;
            System.out.println(v5);
            int v9 = v0;
            int v10 = 1;
            int v8 = v9 + v10;
            v0 = v8;

            v3 = v0;v4 = 10;v2 = v3 <= v4; //Recheck Conditions
        }
        int v12 = 10;
        int v13 = 3;
        int v11 = v12 % v13;
        System.out.println(v11);
        int v17 = 2;
        int v18 = 3;
        int v16 = v17 + v18;
        int v15 = -(v16);
        int v14 = -(v15);
        System.out.println(v14);
    }
}