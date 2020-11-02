package com.thoughtworks.capability.gtb.entrancequiz.api;


import com.thoughtworks.capability.gtb.entrancequiz.domain.Group;
import com.thoughtworks.capability.gtb.entrancequiz.domain.Students;
import com.thoughtworks.capability.gtb.entrancequiz.service.StudentsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentsController {
    private final StudentsService studentsService;

    public StudentsController(StudentsService studentsService) {
        this.studentsService = studentsService;
    }

    @GetMapping("/students")
    // TODO GTB-知识点: - @CrossOrigin可以放在类上
    @CrossOrigin
    public ResponseEntity<List<Students>> getStudent() {
        return studentsService.getStudents();
    }

    @GetMapping("/groups")
    @CrossOrigin
    public ResponseEntity<List<Group>> getGroups() {
        return studentsService.getGroups();
    }

    @PostMapping("/students")
    @CrossOrigin
    // TODO GTB-知识点: - 没有使用泛型
    // TODO GTB-知识点: - 违反Restful实践, Post请求成功后应该返回201
    public ResponseEntity addStudent(@RequestBody Students students) {
        return studentsService.addStudents(students);
    }


}
