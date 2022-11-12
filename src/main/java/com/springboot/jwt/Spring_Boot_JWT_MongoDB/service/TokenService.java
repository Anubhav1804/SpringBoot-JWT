package com.springboot.jwt.Spring_Boot_JWT_MongoDB.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Service
public class TokenService {
    public static final String Token_Secret = "fjfehkldca2u3288494";

    public String createToken(ObjectId userId) {
        try{
            Algorithm algorithm = Algorithm.HMAC256(Token_Secret);
            String token = JWT.create().
                    withClaim("userId",userId.toString()).
                    withClaim("createdAt", new Date()).
                    sign(algorithm);

            return token;
        }
        catch(UnsupportedEncodingException exception){
            exception.printStackTrace();
        }
        catch(JWTCreationException exception) {
            exception.printStackTrace();
        }
        return null;
    }
}
