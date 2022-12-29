package com.phung.helloWorld.model.inventory;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="users")
@Data
public class Users {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name="first_name", length=20, nullable=false)
    private String firstName;
    @Column(name="last_name", length=20, nullable=false)
    private String lastName;
    @Column(name="employee_id", length=20, nullable=false)
    private String employeeId;
    @Column(name="password", length=20, nullable=false)
    private String password;
    @Column(name="permission_role", length=10, nullable=false)
    private String permissionRole;
    @Column(name="gender", length=7, nullable=false)
    private String gender;
    @Column(name="email", length=7, nullable=false)
    private String email;
    @Column(name="create_date", nullable=false)
    private Date createDate;
}
