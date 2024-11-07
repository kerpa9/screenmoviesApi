package com.kevenreyes.searchmovies.services;

public interface IConverterDataInt {
    <T> T obtainData(String json, Class<T> clase);

}
