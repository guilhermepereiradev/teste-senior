package com.senior.Teste.Models;

public enum TypeItem {
    P("Product"), S("Service");

    private String content;

    TypeItem(String content){
        this.content = content;
    }

    public String getContent(){
        return content;
    }
}
