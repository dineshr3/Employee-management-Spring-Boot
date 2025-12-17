package CRUD.Demo.project.Dto;

public class UpdateEmployeeDto {

    //    private Long id;
    private String employee_name;
    private String employee_email;
    private String password;

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
