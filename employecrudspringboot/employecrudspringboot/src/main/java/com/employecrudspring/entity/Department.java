package com.employecrudspring.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dId;

    @Column(length = 50)
    private String deptName;

    @Column(length = 100)
    private String deptAdd;

    @OneToOne
    private Employee noEmp;

    
    public Department() {
        super();
    }

   
    public Department(int dId, String deptName, String deptAdd, Employee noEmp) {
        super();
        this.dId = dId;
        this.deptName = deptName;
        this.deptAdd = deptAdd;
        this.noEmp = noEmp;
    }

   
    public int getDId() {
        return dId;
    }

    public void setDId(int dId) {
        this.dId = dId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptAdd() {
        return deptAdd;
    }

    public void setDeptAdd(String deptAdd) {
        this.deptAdd = deptAdd;
    }

    public Employee getNoEmp() {
        return noEmp;
    }

    public void setNoEmp(Employee noEmp) {
        this.noEmp = noEmp;
    }

    @Override
    public String toString() {
        return "Department [dId=" + dId + ", deptName=" + deptName + ", deptAdd=" + deptAdd + ", noEmp=" + noEmp + "]";
    }
}
