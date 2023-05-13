package com.codegym.model;

public enum ERole {
    ADMIN("Admin") , USER("User");
    private String value;

    ERole(String value){
        this.value = value;
    }
    public static ERole findRoleByString (String name){
        for (ERole role : values()) {
            String temp = String.valueOf(role);
            if (temp.equals(name)) {
                return role;
            }
        }
        return null;
    }

}
