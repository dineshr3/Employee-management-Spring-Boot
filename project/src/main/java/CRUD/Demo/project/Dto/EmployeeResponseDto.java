package CRUD.Demo.project.Dto;

public class EmployeeResponseDto {

    private Long id;
    private String employee_name;
    private String employee_email;

    public Long getId() {
        return id;
    }

    public String getName() {
        return employee_name;
    }

    public String getEmail() {
        return employee_email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String employee_name) {
        this.employee_name = employee_name;
    }

    public void setEmail(String employee_email) {
        this.employee_email = employee_email;
    }
}
