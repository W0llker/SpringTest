package org.example.hibernate.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
@Data
@ToString(exclude = "student")
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "street", nullable = false, length = 50)
    private String street;

    @Column(name = "building_number", nullable = false)
    private int buildingNumber;

    @Column(name = "apartment_number", nullable = false)
    private int apartmentNumber;

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public Address(int apartmentNumber, int buildingNumber, String street) {
        this.apartmentNumber = apartmentNumber;
        this.buildingNumber = buildingNumber;
        this.street = street;
    }
}
