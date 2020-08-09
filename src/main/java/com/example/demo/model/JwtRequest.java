package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
public class JwtRequest implements Serializable {
      private String username;
      private String password;
  }