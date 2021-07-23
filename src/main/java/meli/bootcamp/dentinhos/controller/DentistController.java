package meli.bootcamp.dentinhos.controller;

import meli.bootcamp.dentinhos.domain.Dentist;
import meli.bootcamp.dentinhos.domain.User;
import meli.bootcamp.dentinhos.dto.DentistDTO;
import meli.bootcamp.dentinhos.service.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/dentist")
public class DentistController {

    public DentistService dentistService;

    @Autowired
    public DentistController(DentistService dentistService) {
        this.dentistService = dentistService;
    }

    @GetMapping("/agenda/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public DentistDTO getId(@PathVariable Integer id) {
        return dentistService.findById(id);
    }


    @GetMapping("/twoturns")
    public List<String> getTwoTurnsInOneDay(@RequestBody Date data) {
       return dentistService.getTwoTurnsInOneDayAtDentist(data);
    }
}
