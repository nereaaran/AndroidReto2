package com.example.androidreto2.security;

import android.os.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;




public class EncodePassword {


    private static final String filePath = new File("").getAbsolutePath();

    public void cifrarConClavePublica(String contraseña) {
        byte[] encodedMessage = null;

        try {
        byte fileKey[] = fileReader(filePath + "com/example/androidreto2/security/ComicSansAsimetricPublic.key");

            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(fileKey);
            PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);

            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);

            encodedMessage = cipher.doFinal(contraseña.getBytes());
        } catch (InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            e.printStackTrace();
        }
        String aaa=byteToHexadecimal(encodedMessage);

        //return "Holaaaa";
    }



    private String byteToHexadecimal(byte[] bytes) {
        String HEX = "";
        for (int i = 0; i < bytes.length; i++) {
            String h = Integer.toHexString(bytes[i] & 0xFF);
            if (h.length() == 1) {
                HEX += "0";
            }
            HEX += h;
        }
        return HEX.toUpperCase();
    }


    private byte[] fileReader(String path) {
        byte ret[] = null;
        File file = new File(path);

        /*FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);

            byte buffer[] = new byte[4096];
            int read = 0;

            while((read = fis.read(buffer)) != -1) {
                // Do what you want with the buffer of bytes here.
                // Make sure you only work with bytes 0 - read.
                // Sending it with your protocol for example.
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.toString());
        } catch (IOException e) {
            System.out.println("Exception reading file: " + e.toString());
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException ignored) {
            }
        }
       return ret;*/


        byte[] getBytes = {};
        try {
            getBytes = new byte[(int) file.length()];
            InputStream is = new FileInputStream(file);
            is.read(getBytes);
            is.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return getBytes;

    }




}
