package br.com.migueldelgado.cursos_crud.modules.course.entities;

public enum EnumActive {

    ATIVO(1),
    INATIVO(2);

    private int code;

    private EnumActive(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static EnumActive valueOf(int code) {
        for (EnumActive value : EnumActive.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid EnumActive code.");
    }
}
