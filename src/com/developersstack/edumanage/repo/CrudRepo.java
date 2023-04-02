package com.developersstack.edumanage.repo;

import java.util.ArrayList;

public interface CrudRepo<T, ID> { //facade Pattern
    public boolean save(T t);
    public boolean update(T t);
    public boolean delete(T t);
    public T find(ID id);
    public ArrayList<T> findAll();
}
