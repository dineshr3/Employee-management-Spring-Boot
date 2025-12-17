package CRUD.Demo.project.entity;

import jakarta.persistence.*;


@Entity
@Table(name="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String employee_name;
    private String employee_email;
    private String password;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return employee_name;
    }
    public void setName(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getEmail() {
        return employee_email;
    }
    public void setEmail(String employee_email) {
        this.employee_email = employee_email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
