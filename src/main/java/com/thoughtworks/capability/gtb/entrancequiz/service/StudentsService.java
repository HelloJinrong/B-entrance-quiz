package com.thoughtworks.capability.gtb.entrancequiz.service;


import com.thoughtworks.capability.gtb.entrancequiz.domain.Students;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentsService {
    List<Students> studentsList;
    String[] studentsName = {
            "成吉思汗", "鲁班七号", "太乙真人", "钟无艳", "花木兰", "雅典娜", "芈月", "白起", "刘婵",
            "庄周", "马超", "刘备", "哪吒", "大乔", "蔡文姬"
    };

    public ResponseEntity<List<Students>> getStudents() {
        studentsList = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            Students students = new Students(i + 1, studentsName[i]);
            studentsList.add(students);
        }
        return ResponseEntity.ok(studentsList);
    }
}
