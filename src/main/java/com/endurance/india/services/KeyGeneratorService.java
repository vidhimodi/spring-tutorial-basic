package com.endurance.india.services;

import com.google.common.hash.Hashing;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
public class KeyGeneratorService {

    public String generateNewKey(String longUrl) {
        return Hashing.murmur3_32().hashString(longUrl, StandardCharsets.UTF_8).toString();
    }

}