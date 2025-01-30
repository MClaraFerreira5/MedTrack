package com.medtrack.medtrack.service.conversor;


public interface IConverteDados {
    <T> T obterDados(String json, Class<T> classe);
}

