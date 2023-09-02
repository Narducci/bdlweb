package com.bdlproject.bdlweb.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tb_employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String employeeNumber;
    private String firstName;
    private String lastName;
    private Workforce workforce;
    private Double salary;
    private Double allocationTime;
    private String job;

    @ManyToOne
    @JoinColumn(name = "regime_id")
    private Regime regime;

    @ManyToOne
    @JoinColumn(name = "sector_id")
    private Sector sector;

   @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
   private User user;

    public Employee() {
    }

    public Employee(Long id, String employeeNumber, String firstName, String lastName, Workforce workforce, Double salary, Double allocationTime, String job, Regime regime, Sector sector, User user, Set<AssetEmployee> employees) {
        this.id = id;
        this.employeeNumber = employeeNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.workforce = workforce;
        this.salary = salary;
        this.allocationTime = allocationTime;
        this.job = job;
        this.regime = regime;
        this.sector = sector;
        this.user = user;
        this.employees = employees;
    }

    @OneToMany(mappedBy = "id.employee")
    private Set<AssetEmployee> employees = new HashSet<>();

    // GETTER AND SETTER
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Workforce getWorkforce() { return workforce; }

    public void setWorkforce(Workforce workforce) {
        this.workforce = workforce;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getAllocationTime() {
        return allocationTime;
    }

    public void setAllocationTime(Double allocationTime) {
        this.allocationTime = allocationTime;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public User getUser() {
        return user;
    }

    public Set<AssetEmployee> getEmployees() {
        return employees;
    }

    public List<Asset> getAssets() {
        return employees.stream().map(x -> x.getAsset()).toList();
    }

    public Regime getRegimes() {
        return regime;
    }

    public void setRegimes(Regime regime) {
        this.regime = regime;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
