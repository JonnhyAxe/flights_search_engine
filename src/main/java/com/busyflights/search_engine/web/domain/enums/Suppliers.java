package com.busyflights.search_engine.web.domain.enums;


/**
 * Enum that represents the supported suppliers
 *
 */
public enum Suppliers {

    CRAZY_AIR("Crazy Air"), TOUGH_JET("Tough Jet");

    private String supplierName;

    private Suppliers(String supplier) {
        this.supplierName = supplier;
    }

    /**
     * @return the supplierName
     */
    public String getSupplierName() {

        return supplierName;
    }

}
