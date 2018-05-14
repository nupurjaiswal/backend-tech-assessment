package com.intuit.cg.backendtechassessment.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Seller {

    @Id
    @GeneratedValue
    private Long  id;

    private String companyName;

    public Seller() {
        super();
    }

    public Seller(String companyName) {
        super();
        this.companyName = companyName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Seller{");
        sb.append("id=").append(id);
        sb.append(", companyName='").append(companyName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
