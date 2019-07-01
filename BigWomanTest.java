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
        int v11 = 0;
        v0 = v11;

        int v13 = v0;
        int v14 = 100;
        boolean v12 = v13 < v14;

        int v16 = v0;
        int v17 = 1;
        v0 = v16 + v17;
        for(v0 = v11;v12;v0 = v16 + v17){
            v13 = v0;v14 = 100;v12 = v13 < v14; //Recheck Break Condition
            if(!v12){
                break;
            }

            String v18 = "hello";
            System.out.println(v18);
            int v20 = v0;
            int v21 = 9;
            int v19 = v20 + v21;
            v0 = v19;

            v16 = v0;v17 = 1; //Update Increment variable
        }
    }
}