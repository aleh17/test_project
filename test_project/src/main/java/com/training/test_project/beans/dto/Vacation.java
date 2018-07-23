package com.training.test_project.beans.dto;

import com.training.test_project.beans.VacationStatus;
import com.training.test_project.beans.entity.VacationEntity;

import java.util.Date;

public class Vacation {

    private Long id;

    private Employee employee;

    private Date fromDate;

    private Date toDate;

    private VacationStatus vacationStatus;

    public Vacation() {
    }

    public Vacation(VacationEntity vacation) {
        this.id = vacation.getId();
        this.employee = new Employee(vacation.getEmployee().getId(), vacation.getEmployee().getFirstName(), vacation.getEmployee().getLastName());
        this.fromDate = vacation.getFromDate();
        this.toDate = vacation.getToDate();
        this.vacationStatus = vacation.getVacationStatus();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
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
}
