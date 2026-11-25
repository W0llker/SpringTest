package org.example.hibernate.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "group_number", nullable = false, length = 10)
    private String groupNumber;

    @Column(name = "faculty_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private FacultyType facultyType;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private List<Student> students;

    public Group() {
    }

    public Group(String groupNumber, FacultyType facultyType) {
        this.groupNumber = groupNumber;
        this.facultyType = facultyType;
    }

    public void addStudentToGroup(Student student) {
        if (students == null)
            students = new ArrayList<>();
        students.add(student);
        student.setGroup(this);
    }
}
