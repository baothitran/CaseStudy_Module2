package com.codegym.model;

public enum EOrderStatus {
    Paid(1), Unpaid(2);
    private int id;

    EOrderStatus(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public static EOrderStatus findOrderStatusByID(long id){
        for (EOrderStatus orderStatus : EOrderStatus.values()){
            if (orderStatus.id==id){
                return orderStatus;
            }
        }
        return null;
    }
}
