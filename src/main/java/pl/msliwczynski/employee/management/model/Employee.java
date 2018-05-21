package pl.msliwczynski.employee.management.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate workStartDate;
    private LocalDate workEndDate;
    private Double salary;

    @OneToOne
    private ContactDetails contactDetails;

    public Employee() {
    }

    public Employee(String firstName, String lastName, LocalDate workStartDate, LocalDate workEndDate, Double salary, ContactDetails contactDetails) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.workStartDate = workStartDate;
        this.workEndDate = workEndDate;
        this.salary = salary;
        this.contactDetails = contactDetails;
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

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public ContactDetails getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(ContactDetails contactDetails) {
        this.contactDetails = contactDetails;
    }

    public LocalDate getWorkStartDate() {
        return workStartDate;
    }

    public void setWorkStartDate(LocalDate workStartDate) {
        this.workStartDate = workStartDate;
    }

    public LocalDate getWorkEndDate() {
        return workEndDate;
    }

    public void setWorkEndDate(LocalDate workEndDate) {
        this.workEndDate = workEndDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", workStartDate=" + workStartDate +
                ", workEndDate=" + workEndDate +
                ", salary=" + salary +
                ", contactDetails=" + contactDetails +
                '}';
    }
}