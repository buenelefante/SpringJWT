package com.example.jwttest.jwtbase.common;

import lombok.Getter;

@Getter
public enum ResultEnum {
    SUCCESS(101,"OK"),
    FAILURE(102,"fuck"),
    USER_NEED_AUTHORITIES(201,"Пользователь не вошел в систему"),
    USER_LOGIN_FAILED(202,"wrong login/password"),
    USER_LOGIN_SUCCESS(203,"Вход пользователя выполнен успешно"),
    USER_NO_ACCESS(204,"У пользователя нет разрешения на доступ"),
    USER_LOGOUT_SUCCESS(205,"user gone the wind"),
    TOKEN_IS_BLACKLIST(206,"blacklist token"),
    LOGIN_IS_OVERDUE(207,"token not valid"),
            ;
    private Integer code;
    private String message;
    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    public static ResultEnum parse(int code){
        ResultEnum[] values = values();
        for (ResultEnum value : values) {
            if(value.getCode() == code){
                return value;
            }
        }
        throw  new RuntimeException("Unknown code of ResultEnum");
    }
}
