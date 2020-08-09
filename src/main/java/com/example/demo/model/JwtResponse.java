package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
  public class JwtResponse {
    private final String jwtoken;

    public JwtResponse(String jwtoken) {
        this.jwtoken = jwtoken;
    }

}
