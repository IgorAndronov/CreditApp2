package com.mycompany.credit.dao.entity.commons;

import javax.persistence.Entity;

/**
 * Created by igor on 06.09.15.
 */
@Entity
public class KeyValueResult <K,V> {
    private K key;
    private V value;

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
