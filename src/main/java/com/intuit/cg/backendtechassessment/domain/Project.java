package com.intuit.cg.backendtechassessment.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
public class Project {

    @Id
    @GeneratedValue
    @Column(name = "project_id")
    private Long id;

    @NotNull
    @Size(min = 2)
    private String projectName;

    @NotNull
    @Size(min = 5)
    private String description;

    @DecimalMin("1.0")
    private Double maxBudget;

    private Double minBid = Double.NaN;

    @JsonFormat(pattern = "MM-dd-yyyy")
    private Date deadline;

    private Long sellerId;

    @OneToMany(mappedBy = "project")
    private List<Bid> bids;

    protected Project() {
    }

    public Project(@NotNull @Size(min = 2) String projectName, @NotNull @Size(min = 5) String description, @DecimalMin("1.0") Double maxBudget, Double minBid, Date deadline, Long sellerId) {
        this.projectName = projectName;
        this.description = description;
        this.maxBudget = maxBudget;
        this.minBid = minBid;
        this.deadline = deadline;
        this.sellerId = sellerId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getMaxBudget() {
        return maxBudget;
    }

    public void setMaxBudget(Double maxBudget) {
        this.maxBudget = maxBudget;
    }

    public Double getMinBid() {
        return minBid;
    }

    public void setMinBid(Double minBid) {
        this.minBid = minBid;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public List<Bid> getAllBids() {
        return bids;
    }


    public void addBid(Bid bid){
        bids.add(bid);
    }
}
