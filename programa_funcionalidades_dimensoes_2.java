import java.util.Scanner;

public class programa_funcionalidades_dimensoes_2 {  

    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);
        double v0;
        double v1 = 1.0;
        v0 = v1;
        int v2;
        int v3 = 2;
        v2 = v3;
        double v4;
        double v5 = 2.2;
        v4 = v5;
        double v6;
        int v7 = 22;
        v6 = v7;
        double v9 = v0;
        int v10 = 3;
        double v8 = v9 / v10;
        v0 = v8;
        double v11 = v0;
        System.out.println(v11 + "m");
        double v13 = v0;
        int v14 = 4;
        double v12 = v13 * v14;
        v0 = v12;
        double v15 = v0;
        System.out.println(v15 + "m");
        double v16;
        double v18 = v0;
        int v19 = v2;
        double v17 = v18 / v19;
        v16 = v17;
        double v20 = v16;
        System.out.println(v20 + "m/s");
        double v21 = v16;
        System.out.println("v DIMENSION : Speed");
        boolean v22;
        boolean v23 = true;
        v22 = v23;
        String v24;
        String v25 = "This string only displays if true!";
        v24 = v25;
        String v26;
        String v27 = "This string only displays if false!";
        v26 = v27;
        boolean v29 = v22;
        boolean v28 = !v29;
        if (v28) {
           String v30 = v24;
           System.out.println(v30);
        }
        else {
           String v31 = v26;
           System.out.println(v31);
        }
    }
}