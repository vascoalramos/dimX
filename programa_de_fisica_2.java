import java.util.Scanner;

public class programa_de_fisica_2 {  

    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);
        int v0;
        int v1 = 30;
        v0 = v1;
        int v2;
        int v3 = 300;
        v2 = v3;
        int v4;
        int v6 = v0;
        int v7 = v2;
        int v5 = v6 + v7;
        v4 = v5;
        int v8 = v0;
        System.out.println("soluto DIMENSION : Massa");
        int v9 = v0;
        System.out.println("soluto UNIT : g");
        double v10;
        double v11 = 0.1;
        v10 = v11;
        double v12;
        double v14 = v10;
        int v15 = 1;
        boolean v13 = v14 < v15;
        while (v13) {
            int v17 = v4;
            double v18 = v10;
            double v16 = v17 / v18;
            v12 = v16;
            String v22 = "Densidade:  ";
            double v23 = v12;
            String v21 = v22 + v23;
            String v24 = "         Volume necessário: ";
            String v20 = v21 + v24;
            double v25 = v10;
            String v19 = v20 + v25;
            System.out.println(v19);
            double v27 = v10;
            double v28 = 0.1;
            double v26 = v27 + v28;
            v10 = v26;

            v14 = v10;v15 = 1;v13 = v14 < v15; //Recheck Conditions
        }
    }
}