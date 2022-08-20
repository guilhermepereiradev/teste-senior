package com.senior.Teste.Models;

public enum TypeItem {
    P('P'), S('S');

    private Character content;

    TypeItem(Character content){
        this.content = content;
    }

    public Character getContent(){
        return content;
    }
}
