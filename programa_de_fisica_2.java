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
        double v8;
        double v9 = 0.1;
        v8 = v9;
        double v10;
        double v12 = v8;
        int v13 = 1;
        boolean v11 = v12 < v13;
        while (v11) {
            int v15 = v4;
            double v16 = v8;
            double v14 = v15 / v16;
            v10 = v14;
            String v20 = "Densidade:  ";
            double v21 = v10;
            String v19 = v20 + v21;
            String v22 = "         Volume necessário: ";
            String v18 = v19 + v22;
            double v23 = v8;
            String v17 = v18 + v23;
            System.out.println(v17);
            double v25 = v8;
            double v26 = 0.1;
            double v24 = v25 + v26;
            v8 = v24;

            v12 = v8;v13 = 1;v11 = v12 < v13; //Recheck Conditions
        }
    }
}