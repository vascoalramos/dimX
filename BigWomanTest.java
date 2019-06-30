import java.util.Scanner;

public class BigWomanTest {  

    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);
        int v0;
        int v1 = 5;
        v0 = v1;
        int v2;
        int v3 = 2;
        v2 = v3;
        String v4 = "a < b? ";
        System.out.println(v4);
        int v6 = v0;
        int v7 = v2;
        boolean v5 = v6 < v7;
        System.out.println(v5);
        String v8 = "a > b? ";
        System.out.println(v8);
        int v10 = v0;
        int v11 = v2;
        boolean v9 = v10 > v11;
        System.out.println(v9);
        String v12 = "a <= b? ";
        System.out.println(v12);
        int v14 = v0;
        int v15 = v2;
        boolean v13 = v14 <= v15;
        System.out.println(v13);
        String v16 = "a >= b? ";
        System.out.println(v16);
        int v18 = v0;
        int v19 = v2;
        boolean v17 = v18 >= v19;
        System.out.println(v17);
        String v20 = "a == b? ";
        System.out.println(v20);
        int v22 = v0;
        int v23 = v2;
        boolean v21 = v22 == v23;
        System.out.println(v21);
        String v24 = "a != b? ";
        System.out.println(v24);
        int v27 = v0;
        int v28 = v2;
        boolean v26 = v27 != v28;
        boolean v25 = !v26;
        System.out.println(v25);
        String v29;
        System.out.print("prompt>>");
        String v30 = userInput.nextLine();
        v29 = v30;
        String v32 = v29;
        String v33 = "Ola";
        boolean v31 = v32.equals(v33);
        if (v31) {
           String v34 = "Hello";
           System.out.println(v34);
           boolean v35 = true;
           if (v35) {
              String v36 = "World";
              System.out.println(v36);
           }
        }
        else {
           String v38 = v29;
           String v39 = "Mundo";
           boolean v37 = v38.equals(v39);
           if (v37) {
              String v40 = "World";
              System.out.println(v40);
           }
           else {
              String v42 = v29;
              String v43 = "outra coisa qualquer";
              boolean v41 = v42.equals(v43);
              if (v41) {
                 String v44 = "Outra coisa qualquer";
                 System.out.println(v44);
              }
              else {
                 String v45 = "Outra coisa qualquer2";
                 System.out.println(v45);
              }
           }
        }
        int v46;
        int v47 = 0;
        v46 = v47;

        int v49 = v46;
        int v50 = 5;
        boolean v48 = v49 < v50;

        int v52 = v46;
        int v53 = 1;
        boolean v51 = v52 + v53;
        for(v47 = v47;v48;v47 = v52 + v53){
            String v54 = "hello";
            System.out.println(v54);

            v52 = v46;v53 = 1;v51 = v52 + v53;
            v49 = v46;v50 = 5;v48 = v49 < v50;
        }
    }
}