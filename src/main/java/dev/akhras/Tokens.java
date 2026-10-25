package dev.akhras;
import com.auth0.jwt.JWT;import com.auth0.jwt.algorithms.Algorithm;import java.time.*;import java.security.*;import java.util.*;
public class Tokens{
 static Algorithm algorithm(){String key=System.getenv().getOrDefault("JWT_SECRET","local-development-key-change-before-deployment-12345");if(key.length()<32)throw new IllegalStateException("JWT_SECRET needs 32 characters");return Algorithm.HMAC256(key);}
 public static String issue(String id){return JWT.create().withIssuer("expense").withSubject(id).withExpiresAt(Instant.now().plusSeconds(900)).sign(algorithm());}
 public static String verify(String token){return JWT.require(algorithm()).withIssuer("expense").build().verify(token).getSubject();}
 public static String digest(String text){try{return HexFormat.of().formatHex(MessageDigest.getInstance("SHA-256").digest(text.getBytes(java.nio.charset.StandardCharsets.UTF_8)));}catch(Exception e){throw new IllegalStateException(e);}}
}
