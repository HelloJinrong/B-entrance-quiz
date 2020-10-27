package com.thoughtworks.capability.gtb.entrancequiz.service;


import com.thoughtworks.capability.gtb.entrancequiz.domain.Group;
import com.thoughtworks.capability.gtb.entrancequiz.domain.Students;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class StudentsService {
    List<Students> studentsList;
    List<Group> groupList;
    int studentNum=15;
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

    private void initGroup(){
        groupList = new ArrayList<>();
    }
    public ResponseEntity<List<Group>> getGroups() {

        Collections.shuffle(studentsList);
        int GroupSize = studentsList.size()/6;
        int restNum = studentsList.size()%6;
        initGroup();
        for (int i = 0; i < 6; i++) {
            boolean flag=true;
            List<Students> tmp = new ArrayList<>();
            for (int k = 0; k < GroupSize ; k++) {
                tmp.add(studentsList.get(i *  GroupSize + k));
                if(restNum>0&&flag==true)
                {
                    tmp.add(studentsList.get(GroupSize*6 +i));
                    restNum--;
                    flag=false;
                }
            }

                Group temp = new Group("team " + (i + 1), tmp);
                groupList.add(temp);


        }
        return ResponseEntity.ok(groupList);
    }

    public ResponseEntity addStudents(Students newstudent){
        Students students = new Students(studentNum + 1, newstudent.getName());
        studentNum++;
        studentsList.add(students);
        return ResponseEntity.ok().build();
    }

}
