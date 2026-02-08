import java.util.*;
public class RSA {
    public static void main(String args[]) {
        int p=3;
        int q=11;
        int n=p*q;
        int phin=(p-1)*(q-1);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the public key");
        int e=sc.nextInt();
        int d=0;
        while (true) {
            if ((e*d)%phin==1) {
                break;
            }
            else{
                d=d+1;
            }
        }
        int M=19;
        int C=(int)(Math.pow(M,e)%n);

        System.out.println("The encrypted value is: "+C);
    }
}
