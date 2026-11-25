package org.example.hibernate.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastname;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "middle_name", length = 50)
    private String middleName;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "student")
    private Address address;
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    public Student(int age, String middleName, String firstName, String lastname) {
        this.middleName = middleName;
        this.firstName = firstName;
        this.age = age;
        this.lastname = lastname;
    }
}
