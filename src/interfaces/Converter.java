package com.java_mentor.interfaces;

public interface Converter<T1,T2> {
    T2 convert(T1 entity);
}
