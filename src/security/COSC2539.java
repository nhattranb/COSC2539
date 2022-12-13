/*
  RMIT University Vietnam - SSET
  Course: COSC2539 Security for Computing and Information Technology (IT) Systems
  Semester: 2022s3
  Produced for: Assignment 1 (Security Service and Cryptography)
  Student's name: Tran Minh Nhat
  Student's ID: s3926629
  Date of work: 14/11/2022
  Acknowledgement: https://stackoverflow.com/questions/31915617/how-to-encrypt-string-with-public-key-and-decrypt-with-private-key
 */

package security;

import javax.crypto.*;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Scanner;

public class COSC2539 {
    public static String getEncrypted(String data, String Key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        PublicKey publicKey = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.getDecoder().decode(Key.getBytes())));
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedbytes = cipher.doFinal(data.getBytes());
        return new String(Base64.getEncoder().encode(encryptedbytes));
    }
    public static String getDecrypted(String data, String Key) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        PrivateKey pk = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(Base64.getDecoder().decode(Key.getBytes())));
        cipher.init(Cipher.DECRYPT_MODE, pk);
        byte[] encryptedbytes = cipher.doFinal(Base64.getDecoder().decode(data.getBytes()));
        return new String(encryptedbytes);
    }
    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        // TODO code application logic here
        KeyGenerator keyGenerator = KeyGenerator.getInstance("Blowfish");
        keyGenerator.init(448);
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(1024);
        KeyPair keyPair = keyPairGenerator.genKeyPair();
        String pubKey = new String(Base64.getEncoder().encode(keyPair.getPublic().getEncoded()));
        String priKey = new String(Base64.getEncoder().encode(keyPair.getPrivate().getEncoded()));
        System.out.println("The Public Key is:" + pubKey);
        System.out.println("The Private Key is:" + priKey);
        Scanner q4 = new Scanner(System.in);
        System.out.println("Please type in your string:");
        String str = q4.nextLine();
        String cipherText = getEncrypted(str, pubKey);
        System.out.println("CIPHER:" + cipherText);
        Scanner q4plus = new Scanner(System.in);
        System.out.println("Please type in your cipher:");
        String source = q4plus.nextLine();
        System.out.println("SOURCE TEXT: " + source);
        String decryptedText = getDecrypted(source, priKey);
        System.out.println("DECRYPTED STRING:" + decryptedText);
    }
}
