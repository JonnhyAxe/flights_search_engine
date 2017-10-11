package com.busyflights.search_engine.web.domain.enums;


/**
 * Enum that represents the supported suppliers
 *
 */
public enum Suppliers {

    CRAZY_AIR("CrazyAir"), TOUGH_JET("ToughJet");

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
