package com.mantenimiento.vehicular.Enum;

import jakarta.persistence.Table;

@Table(name = "rango")
public enum Rango_Tipo {
    CAPITAN,
    TENIENTE,
    SUBTENIENTE,
    SARGENTO_PRIMERO,
    SARGENTO_SEGUNDO,
    CABO_PRIMERO,
    CABO_SEGUNDO;
}
