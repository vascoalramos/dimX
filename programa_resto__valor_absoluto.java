import java.util.Scanner;

public class programa_resto__valor_absoluto {  

    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);
        double v0;
        int v2 = 22;
        int v1 = -(v2);
        v0 = v1;
        double v4 = v0;
        double v3 = Math.abs(v4);
        System.out.println(v3);
        double v5;
        double v6 = 2.2;
        v5 = v6;
        double v8 = 3.0;
        double v9 = v5;
        double v7 = v8 % v9;
        System.out.println(v7);
    }
}