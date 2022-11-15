package com.es.enums;

public enum OptionsType {

    LIST(100, "list"),GET(101,"get"),DELETE(104,"delete"),UPDATE(103,"update"),SAVE(102,"save");

    private String op;
    private int code;

    OptionsType(int code, String op){
        this.code = code;
        this.op = op;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
    public static OptionsType getInstance(String op){
        OptionsType[] optionsTypes =  OptionsType.values();
        for(OptionsType ot:optionsTypes){
            if(ot.getOp().equals(op)){
                return ot;
            }
        }
        return null;
    }
}
