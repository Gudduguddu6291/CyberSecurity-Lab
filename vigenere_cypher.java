public class vigenere_cypher {
    public static void main(String[] args) {
        String s="Hello";
        String key="keyyo";
        s=s.toUpperCase();
        key=key.toUpperCase();
        String cipher="";
        // Encryption
        for (int i = 0; i < s.length(); i++) {
            int chk=key.charAt(i)-'A';
            int ch=s.charAt(i)-'A';
            cipher+=(char)((ch+chk)%26+'A');
        }
        System.out.println(cipher);
        // Decryption
        String decipher="";
        for (int i = 0; i < cipher.length(); i++) {
            int chk=key.charAt(i)-'A';
            int ch=cipher.charAt(i)-'A';
            decipher+=(char)((ch-chk+26)%26+'A');
            
        }
        System.out.println(decipher);
    }
}
