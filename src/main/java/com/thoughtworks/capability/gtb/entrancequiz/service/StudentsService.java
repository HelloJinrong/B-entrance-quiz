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
    List<Students> studentsList=init() ;
    List<Students> newStudentsList = new ArrayList();
    List<Students> AllStudentsList;
    List<Group> groupList;
    int studentNum=15;


    private List<Students> init(){
        List<Students> temp=new ArrayList<>();
        String[] studentsName = {
                "成吉思汗", "鲁班七号", "太乙真人", "钟无艳", "花木兰", "雅典娜", "芈月", "白起", "刘婵",
                "庄周", "马超", "刘备", "哪吒", "大乔", "蔡文姬"
        };
        for (int i = 0; i < 15; i++) {
            Students students = new Students(i + 1, studentsName[i]);
            temp.add(students);
        }
        return temp;
    }

    public ResponseEntity<List<Students>> getStudents() {
        AllStudentsList = new ArrayList();
        AllStudentsList.addAll(studentsList);
        AllStudentsList.addAll(newStudentsList);
        return ResponseEntity.ok(AllStudentsList);
    }

    private void initGroup(){
        groupList = new ArrayList<>();
    }
    public ResponseEntity<List<Group>> getGroups() {

        Collections.shuffle(AllStudentsList);
        int GroupSize = AllStudentsList.size()/6;
        int restNum = AllStudentsList.size()%6;
        initGroup();
        for (int i = 0; i < 6; i++) {
            boolean flag=true;
            List<Students> tmp = new ArrayList<>();
            for (int k = 0; k < GroupSize ; k++) {
                tmp.add(AllStudentsList.get(i *  GroupSize + k));
                if(restNum>0&&flag==true)
                {
                    tmp.add(AllStudentsList.get(GroupSize*6 +i));
                    restNum--;
                    flag=false;
                }
            }

                Group temp = new Group("team " + (i + 1), tmp);
                groupList.add(temp);


        }
        return ResponseEntity.ok(groupList);
    }

    public ResponseEntity addStudents(Students s ){
        Students students = new Students(studentNum + 1,s.getName());
        studentNum++;
        newStudentsList.add(students);
        return ResponseEntity.ok().build();
    }

}
