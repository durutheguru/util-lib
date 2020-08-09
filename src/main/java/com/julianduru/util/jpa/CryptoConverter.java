package com.julianduru.util.jpa;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.security.Key;
import java.util.Base64;


@Converter
@RequiredArgsConstructor
public class CryptoConverter implements AttributeConverter<String, String> {


    @Value("${code.config.crypto.default-key}")
    private String defaultKey;


    @Value("${code.config.crypto.default-algorithm}")
    private String defaultAlgorithm;


    @Override
    public String convertToDatabaseColumn(String entityString) {
        var key = getKey();
        try {
            var c = Cipher.getInstance(defaultAlgorithm);
            c.init(Cipher.ENCRYPT_MODE, key);
            return Base64.getEncoder().encodeToString(c.doFinal(entityString.getBytes()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public String convertToEntityAttribute(String dbData) {
        var key = getKey();
        try {
            var c = Cipher.getInstance(defaultAlgorithm);
            c.init(Cipher.DECRYPT_MODE, key);
            return new String(c.doFinal(Base64.getDecoder().decode(dbData)));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    private Key getKey() {
        return new SecretKeySpec(defaultKey.getBytes(), 0, 16, "AES");
    }



}