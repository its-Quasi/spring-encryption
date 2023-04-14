package com.example.springencryption;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

public class EncryptionTest {
  //Codificador de contraseñas
  PasswordEncoder passwordEncoder;
  //Contraseña de ejemplo
  String password = "admin";
  
  
  //Metodo "Dummy" para comprobar y ver el funcionamiento del hash Bcrypt
  @Test
  void bcryptTest(){
    passwordEncoder = new BCryptPasswordEncoder();
    String hashPassword = passwordEncoder.encode(password);
    boolean checkPassword = passwordEncoder.matches(password, hashPassword);
    assert checkPassword;
  }
  
  /**
   *No siempre se devuelve el mismo hash, con el fin de que no se comprometan contraseñas iguales en crudo
   */
  @Test
  void generateMultiplePasswords(){
    passwordEncoder = new BCryptPasswordEncoder();
    for(int i = 0; i < 10; i++){
      System.out.println( (i + 1) + " --> " + passwordEncoder.encode(password) );
    }
  }
  
  /**
   * Metodo "Dummy" para comprobar y ver el funcionamiento del hash pbkdf2
   */
  @Test
  void pbkdf2Test(){
    passwordEncoder = new Pbkdf2PasswordEncoder();
    String hashPassword = passwordEncoder.encode(password);
    boolean checkPassword = passwordEncoder.matches(password, hashPassword);
    assert checkPassword;
  }
  
  @Test
  void generateMultiplePasswordsPbkdf2(){
    passwordEncoder = new Pbkdf2PasswordEncoder();
    for(int i = 0; i < 10; i++){
      System.out.println( (i + 1) + " --> " + passwordEncoder.encode(password) );
    }
  }
  
}
