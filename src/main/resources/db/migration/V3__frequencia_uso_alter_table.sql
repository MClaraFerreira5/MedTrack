CREATE TABLE frequencia_uso_dias_semana
(
    frequencia_uso_id BIGINT NOT NULL,
    dias_semana       VARCHAR(255)
);

CREATE TABLE frequencia_uso_horarios_especificos
(
    frequencia_uso_id    BIGINT NOT NULL,
    horarios_especificos time WITHOUT TIME ZONE
);

ALTER TABLE frequencia_uso_horarios_especificos
    ADD CONSTRAINT fk_frequenciauso_horariosespecificos_on_frequencia_uso FOREIGN KEY (frequencia_uso_id) REFERENCES frequencia_uso (id);

ALTER TABLE frequencia_uso_dias_semana
    ADD CONSTRAINT fk_frequenciauso_diassemana_on_frequencia_uso FOREIGN KEY (frequencia_uso_id) REFERENCES frequencia_uso (id);