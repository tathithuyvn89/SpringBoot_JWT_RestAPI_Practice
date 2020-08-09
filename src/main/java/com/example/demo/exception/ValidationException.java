package com.example.demo.exception;
  public class ValidationException  extends RuntimeException{
      private String msg;
      public ValidationException(String msg) {
          this.msg = msg;
      }

      public String getMsg() {
          return msg;
      }

      public void setMsg(String msg) {
          this.msg = msg;
      }
  }