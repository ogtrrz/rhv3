package wf.rh.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * A Employee.
 */
@Entity
@Table(name = "employee")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "job_id")
    private Long jobId;

    @NotNull
    @Size(max = 100)
    @Column(name = "jhi_user", length = 100, nullable = false)
    private String user;

    @NotNull
    @Size(max = 100)
    @Column(name = "first_name", length = 100, nullable = false)
    private String firstName;

    @NotNull
    @Size(max = 100)
    @Column(name = "last_name", length = 100, nullable = false)
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "hire_date")
    private Instant hireDate;

    @Size(max = 100)
    @Column(name = "emergency_contact", length = 100)
    private String emergencyContact;

    @Column(name = "emergency_phone")
    private String emergencyPhone;

    @Size(max = 2)
    @Column(name = "blode_type", length = 2)
    private String blodeType;

    @Size(max = 500)
    @Column(name = "allergies", length = 500)
    private String allergies;

    @Column(name = "birth_date")
    private Instant birthDate;

    @Size(max = 2000)
    @Column(name = "note", length = 2000)
    private String note;

    @OneToMany(mappedBy = "employee")
    @JsonIgnoreProperties(value = { "evidences", "course", "employee" }, allowSetters = true)
    private Set<Training> trainings = new HashSet<>();

    @OneToMany(mappedBy = "employee")
    @JsonIgnoreProperties(value = { "employee" }, allowSetters = true)
    private Set<ToDo> todos = new HashSet<>();

    @OneToMany(mappedBy = "employee")
    @JsonIgnoreProperties(value = { "employee" }, allowSetters = true)
    private Set<HistoricData> historicData = new HashSet<>();

    @OneToMany(mappedBy = "employee")
    @JsonIgnoreProperties(value = { "trainings", "todos", "historicData", "managers", "job", "employee" }, allowSetters = true)
    private Set<Employee> managers = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties(value = { "courses", "employees" }, allowSetters = true)
    private Job job;

    @ManyToOne
    @JsonIgnoreProperties(value = { "trainings", "todos", "historicData", "managers", "job", "employee" }, allowSetters = true)
    private Employee employee;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Employee id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getJobId() {
        return this.jobId;
    }

    public Employee jobId(Long jobId) {
        this.setJobId(jobId);
        return this;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getUser() {
        return this.user;
    }

    public Employee user(String user) {
        this.setUser(user);
        return this;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public Employee firstName(String firstName) {
        this.setFirstName(firstName);
        return this;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public Employee lastName(String lastName) {
        this.setLastName(lastName);
        return this;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public Employee email(String email) {
        this.setEmail(email);
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public Employee phoneNumber(String phoneNumber) {
        this.setPhoneNumber(phoneNumber);
        return this;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Instant getHireDate() {
        return this.hireDate;
    }

    public Employee hireDate(Instant hireDate) {
        this.setHireDate(hireDate);
        return this;
    }

    public void setHireDate(Instant hireDate) {
        this.hireDate = hireDate;
    }

    public String getEmergencyContact() {
        return this.emergencyContact;
    }

    public Employee emergencyContact(String emergencyContact) {
        this.setEmergencyContact(emergencyContact);
        return this;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public String getEmergencyPhone() {
        return this.emergencyPhone;
    }

    public Employee emergencyPhone(String emergencyPhone) {
        this.setEmergencyPhone(emergencyPhone);
        return this;
    }

    public void setEmergencyPhone(String emergencyPhone) {
        this.emergencyPhone = emergencyPhone;
    }

    public String getBlodeType() {
        return this.blodeType;
    }

    public Employee blodeType(String blodeType) {
        this.setBlodeType(blodeType);
        return this;
    }

    public void setBlodeType(String blodeType) {
        this.blodeType = blodeType;
    }

    public String getAllergies() {
        return this.allergies;
    }

    public Employee allergies(String allergies) {
        this.setAllergies(allergies);
        return this;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public Instant getBirthDate() {
        return this.birthDate;
    }

    public Employee birthDate(Instant birthDate) {
        this.setBirthDate(birthDate);
        return this;
    }

    public void setBirthDate(Instant birthDate) {
        this.birthDate = birthDate;
    }

    public String getNote() {
        return this.note;
    }

    public Employee note(String note) {
        this.setNote(note);
        return this;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Set<Training> getTrainings() {
        return this.trainings;
    }

    public void setTrainings(Set<Training> trainings) {
        if (this.trainings != null) {
            this.trainings.forEach(i -> i.setEmployee(null));
        }
        if (trainings != null) {
            trainings.forEach(i -> i.setEmployee(this));
        }
        this.trainings = trainings;
    }

    public Employee trainings(Set<Training> trainings) {
        this.setTrainings(trainings);
        return this;
    }

    public Employee addTraining(Training training) {
        this.trainings.add(training);
        training.setEmployee(this);
        return this;
    }

    public Employee removeTraining(Training training) {
        this.trainings.remove(training);
        training.setEmployee(null);
        return this;
    }

    public Set<ToDo> getTodos() {
        return this.todos;
    }

    public void setTodos(Set<ToDo> toDos) {
        if (this.todos != null) {
            this.todos.forEach(i -> i.setEmployee(null));
        }
        if (toDos != null) {
            toDos.forEach(i -> i.setEmployee(this));
        }
        this.todos = toDos;
    }

    public Employee todos(Set<ToDo> toDos) {
        this.setTodos(toDos);
        return this;
    }

    public Employee addTodo(ToDo toDo) {
        this.todos.add(toDo);
        toDo.setEmployee(this);
        return this;
    }

    public Employee removeTodo(ToDo toDo) {
        this.todos.remove(toDo);
        toDo.setEmployee(null);
        return this;
    }

    public Set<HistoricData> getHistoricData() {
        return this.historicData;
    }

    public void setHistoricData(Set<HistoricData> historicData) {
        if (this.historicData != null) {
            this.historicData.forEach(i -> i.setEmployee(null));
        }
        if (historicData != null) {
            historicData.forEach(i -> i.setEmployee(this));
        }
        this.historicData = historicData;
    }

    public Employee historicData(Set<HistoricData> historicData) {
        this.setHistoricData(historicData);
        return this;
    }

    public Employee addHistoricData(HistoricData historicData) {
        this.historicData.add(historicData);
        historicData.setEmployee(this);
        return this;
    }

    public Employee removeHistoricData(HistoricData historicData) {
        this.historicData.remove(historicData);
        historicData.setEmployee(null);
        return this;
    }

    public Set<Employee> getManagers() {
        return this.managers;
    }

    public void setManagers(Set<Employee> employees) {
        if (this.managers != null) {
            this.managers.forEach(i -> i.setEmployee(null));
        }
        if (employees != null) {
            employees.forEach(i -> i.setEmployee(this));
        }
        this.managers = employees;
    }

    public Employee managers(Set<Employee> employees) {
        this.setManagers(employees);
        return this;
    }

    public Employee addManager(Employee employee) {
        this.managers.add(employee);
        employee.setEmployee(this);
        return this;
    }

    public Employee removeManager(Employee employee) {
        this.managers.remove(employee);
        employee.setEmployee(null);
        return this;
    }

    public Job getJob() {
        return this.job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Employee job(Job job) {
        this.setJob(job);
        return this;
    }

    public Employee getEmployee() {
        return this.employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Employee employee(Employee employee) {
        this.setEmployee(employee);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Employee)) {
            return false;
        }
        return id != null && id.equals(((Employee) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Employee{" +
            "id=" + getId() +
            ", jobId=" + getJobId() +
            ", user='" + getUser() + "'" +
            ", firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", email='" + getEmail() + "'" +
            ", phoneNumber='" + getPhoneNumber() + "'" +
            ", hireDate='" + getHireDate() + "'" +
            ", emergencyContact='" + getEmergencyContact() + "'" +
            ", emergencyPhone='" + getEmergencyPhone() + "'" +
            ", blodeType='" + getBlodeType() + "'" +
            ", allergies='" + getAllergies() + "'" +
            ", birthDate='" + getBirthDate() + "'" +
            ", note='" + getNote() + "'" +
            "}";
    }
}
