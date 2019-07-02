import java.util.Scanner;

public class programa_de_fisica_1 {  

    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);
        double v0;
        int v1;
        int v2 = 3600;
        v1 = v2;
        double v3;
        double v4 = 150000.0;
        v3 = v4;
        double v6 = v3;
        int v7 = v1;
        double v5 = v6 / v7;
        v0 = v5;
        double v9 = v0;
        double v10 = 33.5;
        boolean v8 = v9 > v10;
        if (v8) {
           String v11 = "Excesso de velocidade! Multado.";
           System.out.println(v11);
        }
        else {
           String v12 = "Não houve excesso de velocidade. Não multado.";
           System.out.println(v12);
        }
    }
}