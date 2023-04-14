package com.example.springencryption;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;

@Entity
@Table(name = "proof_user")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String username;
  private String password;
  
  public User(){}
  
  public User(Long id, String username, String password) {
    this.id = id;
    this.username = username;
    this.password = new BCryptPasswordEncoder().encode(password);
  }
  
  public Long getId() {
    return id;
  }
  
  public String getUsername() {
    return username;
  }
  
  public void setUsername(String username) {
    this.username = username;
  }
  
  public String getPassword() {
    return password;
  }
  
  public void setPassword(String password) {
    this.password = password;
  }
}