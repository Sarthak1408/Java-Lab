package PractiseLab;

import java.util.Scanner;

public class Text {
    static String txt;

    Text(){
        txt = " ";
    }

     public static void readText(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the String : ");
        txt = in.nextLine();
    }

    public static char charAt(int i){
        if (i < txt.length()) {
            char c[] = txt.toCharArray();
            return c[i - 1];
        }
        return 0;
    }

    public static int length() {
        int i = 0;
        char[] ch = txt.toCharArray();

        try
        {
            return ch[i-1];
        }
        catch(Exception e)
        {
            System.out.println("Index out of range");
        }
        return ' ';
    }

    public static int noOfWhiteSpace(){
        int n = length();
        int count = 0;
        for (int i = 0; i<n; i++){
            char ch = charAt(i);

            if (ch == ' ' || ch == '\t' ){
                count++;
            }
        }
        return count;
    }

    public static int noOfWords(){
        int n = length();
        int Words = 0;
        for (int i = 0; i<n ; i++){
            char ch = charAt(i);

            if (ch == ' ' || ch == '.'){
                Words++;
            }
        }
        return Words;
    }

    public static String repeatedWords()
    {
        int i=noOfWords();
        String words[] = txt.split(" ");
        for(int j=0;j<i;j++)
        {
            for(int k =j+1;k<i;k++)
            {
                if(words[j].equalsIgnoreCase((words[k])))
                {
                    return (words[j]);
                }
            }
        }
        return " ";
    }

    public static String pascalCase()
    {
        String[] words = txt.split(" ");
        int n = length();
        StringBuilder builder = new StringBuilder();
        for (String word : words) {
            word = word.isEmpty() ? word : Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase();
            builder.append(word);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int choice;
        do {
            System.out.println();
            System.out.println(" 1. Read String.");
            System.out.println(" 2. Number of White Spaces in String.");
            System.out.println(" 3. Repeated Words.");
            System.out.println(" 4. Convert String to Pascal Case.");
            System.out.println("-1. Exit");

            System.out.print("Enter Your Choice : ");
            choice = in.nextInt();

            switch (choice){
                case 1 : readText();
                    break;

                case 2 : int ws = noOfWhiteSpace();
                    System.out.println("Number of White Spaces : "+ws);
                    break;

                case 3 : String rw = repeatedWords();
                    System.out.println("Number of Repeated Word : "+rw);
                    break;

                case 4 : String Pascal = pascalCase();
                    System.out.println("Pascal Case : "+pascalCase());
                    break;
            }
        }while (choice!= -1);
    }
}
