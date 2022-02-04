package com.phung.helloWorld.model.Entities;

import javax.persistence.*;
import java.util.Date;

@Entity()
@Table(name="users")
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

    public Users(String firstName, String lastName, String employeeId, String password, String permissionRole, String gender, String email, Date createDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeId = employeeId;
        this.password = password;
        this.permissionRole = permissionRole;
        this.gender = gender;
        this.email = email;
        this.createDate = createDate;
    }

    public Users(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPermissionRole() {
        return permissionRole;
    }

    public void setPermissionRole(String permissionRole) {
        this.permissionRole = permissionRole;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
