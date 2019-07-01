import java.util.Scanner;

public class BigWomanTest {  

    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);
        int v0;
        int v1 = 0;
        v0 = v1;
        int v3 = v0;
        int v4 = 1;
        boolean v2 = v3 != v4;
        while (v2) {
            String v6 = "inc = ";
            int v7 = v0;
            String v5 = v6 + v7;
            System.out.println(v5);
            int v8 = 1;
            v0 = v8;

            v3 = v0;v4 = 1;v2 = v3 != v4; //Recheck Conditions
        }
        int v9 = 0;
        v0 = v9;

        int v11 = v0;
        int v12 = 5;
        boolean v10 = v11 < v12;

        int v14 = v0;
        int v15 = 1;
        v0 = v14 + v15;
        for(v0 = v9;v10;v0 = v14 + v15){
            v11 = v0;v12 = 5;v10 = v11 < v12; //Recheck Break Condition
            if(!v10){
                break;
            }

            String v16 = "hello";
            System.out.println(v16);

            v14 = v0;v15 = 1; //Update Increment variable
        }
    }
}