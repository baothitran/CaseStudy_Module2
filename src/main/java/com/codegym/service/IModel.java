package com.codegym.service;

public interface IModel<T>{
    T parseData(String line);
}
