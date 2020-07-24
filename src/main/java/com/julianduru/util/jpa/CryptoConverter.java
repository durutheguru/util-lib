package com.julianduru.util.jpa;

import com.julianduru.util.config.CryptoConfig;
import lombok.RequiredArgsConstructor;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.security.Key;
import java.util.Base64;

@Converter
@RequiredArgsConstructor
public class CryptoConverter implements AttributeConverter<String, String> {


    private final CryptoConfig cryptoConfig;


    @Override
    public String convertToDatabaseColumn(String entityString) {
        Key key = getKey();
        try {
            Cipher c = Cipher.getInstance(cryptoConfig.getDefaultAlgorithm());
            c.init(Cipher.ENCRYPT_MODE, key);
            return Base64.getEncoder().encodeToString(c.doFinal(entityString.getBytes()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public String convertToEntityAttribute(String dbData) {
        Key key = getKey();
        try {
            Cipher c = Cipher.getInstance(cryptoConfig.getDefaultAlgorithm());
            c.init(Cipher.DECRYPT_MODE, key);
            return new String(c.doFinal(Base64.getDecoder().decode(dbData)));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    private Key getKey() {
        return new SecretKeySpec(cryptoConfig.getDefaultKey().getBytes(), 0, 16, "AES");
    }


}