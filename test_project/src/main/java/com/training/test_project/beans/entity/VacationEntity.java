package com.training.test_project.beans.entity;

import com.training.test_project.beans.VacationStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "vacations")
public class VacationEntity implements Serializable {

    @Id
    @Column(name = "vacation_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="employee_id", nullable=false)
    private EmployeeEntity employee;

    private Date fromDate;

    private Date toDate;

    @Enumerated(EnumType.STRING)
    private VacationStatus vacationStatus;


    public VacationEntity() {
    }

    public VacationEntity(Long id, EmployeeEntity employee, Date fromDate, Date toDate, VacationStatus vacationStatus) {
        this.id = id;
        this.employee = employee;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.vacationStatus = vacationStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public VacationStatus getVacationStatus() {
        return vacationStatus;
    }

    public void setVacationStatus(VacationStatus vacationStatus) {
        this.vacationStatus = vacationStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VacationEntity that = (VacationEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
