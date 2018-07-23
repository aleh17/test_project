package com.training.test_project.controllers;

import com.training.test_project.beans.Vacation;
import com.training.test_project.beans.VacationStatus;
import com.training.test_project.exceptions.ResourceItemNotFoundException;
import com.training.test_project.repository.VacationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/vacations")
public class VacationsController {

    @Autowired
    VacationsRepository vacationsRepository;

    @PostMapping("/request")
    public Vacation requestVacation(@Valid @RequestBody Vacation vacation) {
        return vacationsRepository.save(vacation);
    }

    @PutMapping("/approve/{id}")
    public Vacation approveVacation(@PathVariable(value = "id") Long vacationId) {
        Vacation storedVacation = vacationsRepository.findById(vacationId).orElseThrow(() -> new ResourceItemNotFoundException("Vacation", "id", vacationId));
        storedVacation.setVacationStatus(VacationStatus.APPROVED);
        return vacationsRepository.save(storedVacation);
    }

    @PutMapping("/decline/{id}")
    public Vacation declineVacation(@PathVariable(value = "id") Long vacationId) {
        Vacation storedVacation = vacationsRepository.findById(vacationId).orElseThrow(() -> new ResourceItemNotFoundException("Vacation", "id", vacationId));
        storedVacation.setVacationStatus(VacationStatus.DECLINED);
        return vacationsRepository.save(storedVacation);
    }
}
