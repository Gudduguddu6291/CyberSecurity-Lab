import java.security.MessageDigest;
import java.util.*;
public class SHA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String");
        String input = sc.nextLine();
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] messageDigest = md.digest(input.getBytes());
            StringBuilder hexString = new StringBuilder();
            for(int i=0;i<messageDigest.length;i++)
            {
                String hex = Integer.toHexString(0xff & messageDigest[i]);
                if(hex.length()==1) hexString.append('0');
                hexString.append(hex);
            }
            System.out.print(hexString);
        }
        catch(Exception e)
        {
            System.out.print(e);
        }
    }
}
