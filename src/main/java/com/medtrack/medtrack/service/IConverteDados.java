package com.medtrack.medtrack.service;


public interface IConverteDados {
    <T> T obterDados(String json, Class<T> classe);
}

