package com.example.androidreto2.security;

import android.content.Context;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
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

/**
 * Class that contains the methods required to encode a password asymmetrically with a public key.
 */
public class EncodePassword {

    private Context context;

    /**
     * Construc to get the context of the application.
     *
     * @param context The context of the application.
     */
    public EncodePassword(Context context) {
        this.context = context;
    }

    /**
     * Encodes the users password with a public key and returns it in hexadecimal.
     * <p>
     * It uses RSA algorithm, mode ECB and padding PKCS1Padding.
     *
     * @param password The password to encode.
     */
    public String encodeWithPublicKey(String password) {
        byte[] encodedMessage = null;

        try {
            byte fileKey[] = getPublicKey();

            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(fileKey);
            PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);

            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);

            encodedMessage = cipher.doFinal(password.getBytes());
        } catch (InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            e.printStackTrace();
        }
        return byteToHexadecimal(encodedMessage);
    }

    /**
     * Transforms a byte array into hexadecimal.
     *
     * @param bytes The byte array.
     * @return The byte array in hexadecimal-
     */
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

    /**
     * Reads the file where it is kept the public key and writes it as a byte array.
     *
     * @return The public key.
     */
    public byte[] getPublicKey() {
        int fileID = this.context.getResources().getIdentifier("comicsans_public_key", "raw", this.context.getPackageName());
        InputStream inputStream = this.context.getResources().openRawResource(fileID);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int read = 0;
        byte[] data = new byte[1024];
        try {
            while ((read = inputStream.read(data, 0, data.length)) != -1) {
                byteArrayOutputStream.write(data, 0, read);
            }
            byteArrayOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] fileKey = byteArrayOutputStream.toByteArray();

        return fileKey;
    }
}
