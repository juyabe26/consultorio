package com.perficient.consultorio.excepcion;

public class BusinessException extends RuntimeException{
  public BusinessException(String mensaje, Object... args){
    super(String.format(mensaje, args));
  }
}
