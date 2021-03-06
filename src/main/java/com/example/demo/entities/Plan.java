package com.example.demo.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "plan")
public class Plan {
    @Id
    @Column(name = "planNumber")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int planNumber;
    private String planName;
    private String subgroup;
    private String type;
    private LocalDate effectiveDate;
    private LocalDate terminationDate;
    private String policyNumber;
    private String groupNumber;
    
    @ManyToOne(optional = true)
    private Employee member;

    public Plan(){}

    public Plan(String planName, String subgroup){
        this.planName = planName;
        this.subgroup = subgroup;
    }
    
    /**
     * @return the member
     */
    public Employee getMember() {
        return member;
    }
    /**
     * @param member the member to set
     */
    public void setMember(Employee member) {
        this.member = member;
    }
    /**
     * @return the planName
     */
    public String getPlanName() {
        return planName;
    }
    /**
     * @param planName the planName to set
     */
    public void setPlanName(String planName) {
        this.planName = planName;
    }
    /**
     * @return the planNumber
     */
    public int getPlanNumber() {
        return planNumber;
    }
    /**
     * @param planNumber the planNumber to set
     */
    public void setPlanNumber(int planNumber) {
        this.planNumber = planNumber;
    }
    /**
     * @return the subgroup
     */
    public String getSubgroup() {
        return subgroup;
    }
    /**
     * @param subgroup the subgroup to set
     */
    public void setSubgroup(String subgroup) {
        this.subgroup = subgroup;
    }
    /**
     * @return the type
     */
    public String getType() {
        return type;
    }
    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }
    /**
     * @return the effectiveDate
     */
    public LocalDate getEffectiveDate() {
        return effectiveDate;
    }
    /**
     * @param effectiveDate the effectiveDate to set
     */
    public void setEffectiveDate(LocalDate effectiveDate) {
        this.effectiveDate = effectiveDate;
    }
    /**
     * @return the terminationDate
     */
    public LocalDate getTerminationDate() {
        return terminationDate;
    }
    /**
     * @param terminationDate the terminationDate to set
     */
    public void setTerminationDate(LocalDate terminationDate) {
        this.terminationDate = terminationDate;
    }

    /**
     * @return the policyNumber
     */
    public String getPolicyNumber() {
        return policyNumber;
    }
    /**
     * @param policy the policyNumber to set
     */
    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }
    /**
     * @return the groupNumber
     */
    public String getGroupNumber() {
        return groupNumber;
    }
    /**
     * @param groupNumber the group to set
     */
    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    
}
