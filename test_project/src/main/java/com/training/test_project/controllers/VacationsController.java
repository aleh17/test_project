package com.training.test_project.controllers;

import com.training.test_project.beans.dto.Vacation;
import com.training.test_project.beans.entity.EmployeeEntity;
import com.training.test_project.beans.entity.VacationEntity;
import com.training.test_project.beans.VacationStatus;
import com.training.test_project.repository.EmployeesRepository;
import com.training.test_project.repository.VacationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/vacations")
public class VacationsController {

    @Autowired
    VacationsRepository vacationsRepository;

    @Autowired
    EmployeesRepository employeesRepository;

    @PostMapping("/request")
    public Vacation requestVacation(@Valid @RequestBody Vacation vacation) {
        EmployeeEntity employee = employeesRepository.getOne(vacation.getEmployee().getId());
        return new Vacation(
                vacationsRepository.save(new VacationEntity(vacation.getId(), employee, vacation.getFromDate(), vacation.getToDate(), vacation.getVacationStatus()))
        );
    }

    @PostMapping("/approve/{id}")
    public Vacation approveVacation(@PathVariable(value = "id") Long vacationId) {
        VacationEntity storedVacation = vacationsRepository.getOne(vacationId);
        storedVacation.setVacationStatus(VacationStatus.APPROVED);

        return new Vacation(
                vacationsRepository.save(storedVacation)
        );
    }

    @PostMapping("/decline/{id}")
    public Vacation declineVacation(@PathVariable(value = "id") Long vacationId) {
        VacationEntity storedVacation = vacationsRepository.getOne(vacationId);
        storedVacation.setVacationStatus(VacationStatus.DECLINED);

        return new Vacation(
                vacationsRepository.save(storedVacation)
        );
    }
}
