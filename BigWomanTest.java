import java.util.Scanner;

public class BigWomanTest {  

    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);
        int v1 = 2;
        int v2 = 5;
        boolean v0 = v1 < v2;
        System.out.println(v0);
        int v4 = 2;
        int v5 = 5;
        boolean v3 = v4 > v5;
        System.out.println(v3);
        int v7 = 5;
        int v8 = 5;
        boolean v6 = v7 <= v8;
        System.out.println(v6);
        int v10 = 5;
        int v11 = 5;
        boolean v9 = v10 >= v11;
        System.out.println(v9);
        int v13 = 5;
        int v14 = 5;
        boolean v12 = v13 == v14;
        System.out.println(v12);
        int v16 = 2;
        int v17 = 5;
        boolean v15 = v16 != v17;
        System.out.println(v15);
        int v19 = 2;
        String v20 = "string";
        boolean v18 = v19 != v20;
        System.out.println(v18);
    }
}