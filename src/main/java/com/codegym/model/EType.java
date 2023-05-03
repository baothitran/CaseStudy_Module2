package com.codegym.model;

public enum EType {
    FourSeats(1), FiveSeats(2), SevenSeats(3);
    public int idType;
    EType (int idType) {
        this.idType = idType;
    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }
    public static EType findTypeByID(long id){
        for (EType type : EType.values()){
            if (type.idType == id){
                return type;
            }
        }
        return null;
    }
}
