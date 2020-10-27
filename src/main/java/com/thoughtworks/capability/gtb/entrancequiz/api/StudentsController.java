package com.thoughtworks.capability.gtb.entrancequiz.api;


import com.thoughtworks.capability.gtb.entrancequiz.domain.Group;
import com.thoughtworks.capability.gtb.entrancequiz.domain.Students;
import com.thoughtworks.capability.gtb.entrancequiz.service.StudentsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentsController {
    private final StudentsService studentsService;

    public StudentsController(StudentsService studentsService) {
        this.studentsService = studentsService;
    }

    @GetMapping("/students")
    @CrossOrigin
    public ResponseEntity<List<Students>> getStudent() {
        return studentsService.getStudents();
    }

    @GetMapping("/groups")
    @CrossOrigin
    public ResponseEntity<List<Group>> getGroups() {
        return studentsService.getGroups();
    }


}
