package com.thoughtworks.capability.gtb.entrancequiz.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


public class Group {
    private String name;
    private List<Students> students;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Students> getStudents() {
        return students;
    }

    public void setStudents(List<Students> students) {
        this.students = students;
    }

    public Group(String name, List<Students> students) {
        this.name = name;
        this.students = students;
    }
}
