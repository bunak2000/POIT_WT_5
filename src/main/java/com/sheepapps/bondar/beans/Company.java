package com.sheepapps.bondar.beans;

import java.io.Serializable;
import java.util.Objects;

public class Company implements Serializable, Comparable {

    private String name;
    private String taxNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return name.equals(company.name) &&
                taxNumber.equals(company.taxNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, taxNumber);
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", taxNumber='" + taxNumber + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Company company = (Company) o;
        return this.name.compareTo(company.name);
    }

}
