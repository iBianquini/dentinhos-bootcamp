package meli.bootcamp.dentinhos.controller;

import meli.bootcamp.dentinhos.domain.Turn;
import meli.bootcamp.dentinhos.domain.User;
import meli.bootcamp.dentinhos.dto.UserContactResponseDTO;
import meli.bootcamp.dentinhos.service.TurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import meli.bootcamp.dentinhos.service.TurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("turns")
public class TurnController {

    @Autowired
    private TurnService turnService;

    @GetMapping("/completed")
    public List<Turn> completedTurns() {
        return turnService.findCompletedTurns();
    }

    @GetMapping("/completed/{day}/patients")
    public List<UserContactResponseDTO> completedTurns(@PathVariable String day) {
        LocalDate days = LocalDate.parse(day);
        List<UserContactResponseDTO> users = new ArrayList<>();
        List<Turn> turns = turnService.findCompletedTurnsOnAGivingDay(days);
        turns.forEach(turn -> users.add(new UserContactResponseDTO(turn.getPatient())));
        return users;
    }
}

