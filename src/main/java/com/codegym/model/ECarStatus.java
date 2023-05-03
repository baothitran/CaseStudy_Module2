package com.codegym.model;

public enum ECarStatus {
    Rented(1), Unrented(2);
    private int id;
    ECarStatus(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public static ECarStatus findCarStatusByID(long id){
        for (ECarStatus carStatus : ECarStatus.values()){
            if (carStatus.id==id){
                return carStatus;
            }
        }
        return null;
    }
}
