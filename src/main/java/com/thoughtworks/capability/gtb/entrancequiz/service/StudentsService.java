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
    // TODO GTB-工程实践: - 违反了封装性，字段应该使用private
    // TODO GTB-工程实践: - 为啥要使用三个List保存学生？
    List<Students> studentsList=init() ;
    List<Students> newStudentsList = new ArrayList();
    // TODO GTB-工程实践: - 变量名不符合命名规范，首字母应该小写
    List<Students> AllStudentsList;
    List<Group> groupList;
    // TODO GTB-工程实践: - 应该使用常量
    int studentNum=15;


    private List<Students> init(){
        // TODO GTB-知识点: - 应该使用Repository层保存数据
        // TODO GTB-工程实践: - 变量命名不表意
        List<Students> temp=new ArrayList<>();
        String[] studentsName = {
                "成吉思汗", "鲁班七号", "太乙真人", "钟无艳", "花木兰", "雅典娜", "芈月", "白起", "刘婵",
                "庄周", "马超", "刘备", "哪吒", "大乔", "蔡文姬"
        };
        // TODO GTB-知识点: - 可以使用Java8 Stream简化代码
        for (int i = 0; i < 15; i++) {
            Students students = new Students(i + 1, studentsName[i]);
            temp.add(students);
        }
        return temp;
    }

    // TODO GTB-知识点: - ResponseEntity不应该侵入到Service层
    public ResponseEntity<List<Students>> getStudents() {
        AllStudentsList = new ArrayList();
        AllStudentsList.addAll(studentsList);
        AllStudentsList.addAll(newStudentsList);
        return ResponseEntity.ok(AllStudentsList);
    }

    private void initGroup(){
        groupList = new ArrayList<>();
    }

    // TODO GTB-工程实践: - 长方法，建议抽子方法来提高可读性
    // TODO GTB-知识点: - 分组算法略显复杂，可以想想有没有更简单的方法
    public ResponseEntity<List<Group>> getGroups() {

        Collections.shuffle(AllStudentsList);
        // TODO GTB-工程实践: - Magic Number
        // TODO GTB-工程实践: - 注意代码风格，需要适当的添加空格
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
