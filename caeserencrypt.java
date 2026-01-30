import java.util.Scanner;

public class caeserencrypt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter plaintext: ");
        String text = sc.nextLine();
        text=text.toUpperCase();
        System.out.print("Enter shift key: ");
        int key = sc.nextInt();

        String cipherText = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if(ch<='Z' && ch>='A')
            {
                ch=(char)((ch-'A'+key)%26+'A');
            }
            cipherText+=ch;
        }

        System.out.println("Encrypted Text: " + cipherText);
        sc.close();
    }
}
