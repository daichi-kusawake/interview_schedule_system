package models;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "schedules")
@NamedQueries({
    @NamedQuery(
            name = "getAllSchedules",
            query = "SELECT s FROM Schedule AS s ORDER BY s.id DESC"
            ),
    @NamedQuery(
            name = "getSchedulesCount",
            query = "SELECT COUNT(s) FROM Schedule AS s"
            ),
    @NamedQuery(
            name = "getMyAllSchedules",
            query = "SELECT s FROM Schedule AS s WHERE s.employee = :employee ORDER BY s.id DESC"
            ),
    @NamedQuery(
            name = "getMySchedulesCount",
            query = "SELECT COUNT(s) FROM Schedule AS s WHERE s.employee = :employee"
            ),
})
@Entity
public class Schedule {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @Column(name = "project_title", length = 255, nullable = false)
    private String project_title;

    @Column(name = "place", length = 255)
    private String place;

    @Column(name = "vendor", length = 255)
    private String vendor;

    @Column(name = "ordering_company", length = 255, nullable = false)
    private String ordering_company;

    @ManyToOne
    @JoinColumn(name = "sales_employee_id", nullable = false)
    private Employee sales_employee;

    @Column(name = "introduce_date")
    private Date introduce_date;

    @Lob
    @Column(name = "project_overview", nullable = false)
    private String project_overview;

    @Column(name = "number_of_interviews")
    private Integer number_of_interviews;

    @Column(name = "priority")
    private Integer priority;

    @Column(name = "aspiration_situation")
    private Integer aspiration_situation;

    @Column(name = "interview_situation")
    private Integer interview_situation;

    @Column(name = "pass_fail_status")
    private Integer pass_fail_status;

    @Column(name = "first_interview_scheduled_date")
    private Date first_interview_scheduled_date;

    @Column(name = "first_interview_scheduled_time")
    private Time first_interview_scheduled_time;

    @Column(name = "first_interview_format")
    private Integer first_interview_format;

    @Column(name = "first_interview_tool", length = 255)
    private String first_interview_tool;

    @Column(name = "first_interview_url", length = 255)
    private String first_interview_url;

    @Column(name = "first_interview_id", length = 255)
    private String first_interview_id;

    @Column(name = "first_interview_password", length = 255)
    private String first_interview_password;

    @Column(name = "first_interview_date")
    private Date first_interview_date;

    @Column(name = "first_interview_time")
    private Time first_interview_time;

    @Column(name = "second_interview_scheduled_date")
    private Date second_interview_scheduled_date;

    @Column(name = "second_interview_scheduled_time")
    private Time second_interview_scheduled_time;

    @Column(name = "second_interview_format")
    private Integer second_interview_format;

    @Column(name = "second_interview_tool", length = 255)
    private String second_interview_tool;

    @Column(name = "second_interview_url", length = 255)
    private String second_interview_url;

    @Column(name = "second_interview_id", length = 255)
    private String second_interview_id;

    @Column(name = "second_interview_password", length = 255)
    private String second_interview_password;

    @Column(name = "second_interview_date")
    private Date second_interview_date;

    @Column(name = "second_interview_time")
    private Time second_interview_time;

    @Lob
    @Column(name = "supplement", nullable = false)
    private String supplement;

    @Column(name = "created_at", nullable = false)
    private Timestamp created_at;

    @Column(name = "updated_at", nullable = false)
    private Timestamp updated_at;

    @Column(name = "is_deleted", nullable = false)
    private Integer is_deleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getProject_title() {
        return project_title;
    }

    public void setProject_title(String project_title) {
        this.project_title = project_title;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getOrdering_company() {
        return ordering_company;
    }

    public void setOrdering_company(String ordering_company) {
        this.ordering_company = ordering_company;
    }

    public Employee getSales_employee() {
        return sales_employee;
    }

    public void setSales_employee(Employee sales_employee) {
        this.sales_employee = sales_employee;
    }

    public Date getIntroduce_date() {
        return introduce_date;
    }

    public void setIntroduce_date(Date introduce_date) {
        this.introduce_date = introduce_date;
    }

    public String getProject_overview() {
        return project_overview;
    }

    public void setProject_overview(String project_overview) {
        this.project_overview = project_overview;
    }

    public Integer getNumber_of_interviews() {
        return number_of_interviews;
    }

    public void setNumber_of_interviews(Integer number_of_interviews) {
        this.number_of_interviews = number_of_interviews;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getAspiration_situation() {
        return aspiration_situation;
    }

    public void setAspiration_situation(Integer aspiration_situation) {
        this.aspiration_situation = aspiration_situation;
    }

    public Integer getInterview_situation() {
        return interview_situation;
    }

    public void setInterview_situation(Integer interview_situation) {
        this.interview_situation = interview_situation;
    }

    public Integer getPass_fail_status() {
        return pass_fail_status;
    }

    public void setPass_fail_status(Integer pass_fail_status) {
        this.pass_fail_status = pass_fail_status;
    }

    public Date getFirst_interview_scheduled_date() {
        return first_interview_scheduled_date;
    }

    public void setFirst_interview_scheduled_date(Date first_interview_scheduled_date) {
        this.first_interview_scheduled_date = first_interview_scheduled_date;
    }

    public Time getFirst_interview_scheduled_time() {
        return first_interview_scheduled_time;
    }

    public void setFirst_interview_scheduled_time(Time first_interview_scheduled_time) {
        this.first_interview_scheduled_time = first_interview_scheduled_time;
    }

    public Integer getFirst_interview_format() {
        return first_interview_format;
    }

    public void setFirst_interview_format(Integer first_interview_format) {
        this.first_interview_format = first_interview_format;
    }

    public String getFirst_interview_tool() {
        return first_interview_tool;
    }

    public void setFirst_interview_tool(String first_interview_tool) {
        this.first_interview_tool = first_interview_tool;
    }

    public String getFirst_interview_url() {
        return first_interview_url;
    }

    public void setFirst_interview_url(String first_interview_url) {
        this.first_interview_url = first_interview_url;
    }

    public String getFirst_interview_id() {
        return first_interview_id;
    }

    public void setFirst_interview_id(String first_interview_id) {
        this.first_interview_id = first_interview_id;
    }

    public String getFirst_interview_password() {
        return first_interview_password;
    }

    public void setFirst_interview_password(String first_interview_password) {
        this.first_interview_password = first_interview_password;
    }

    public Date getFirst_interview_date() {
        return first_interview_date;
    }

    public void setFirst_interview_date(Date first_interview_date) {
        this.first_interview_date = first_interview_date;
    }

    public Time getFirst_interview_time() {
        return first_interview_time;
    }

    public void setFirst_interview_time(Time first_interview_time) {
        this.first_interview_time = first_interview_time;
    }

    public Date getSecond_interview_scheduled_date() {
        return second_interview_scheduled_date;
    }

    public void setSecond_interview_scheduled_date(Date second_interview_scheduled_date) {
        this.second_interview_scheduled_date = second_interview_scheduled_date;
    }

    public Time getSecond_interview_scheduled_time() {
        return second_interview_scheduled_time;
    }

    public void setSecond_interview_scheduled_time(Time second_interview_scheduled_time) {
        this.second_interview_scheduled_time = second_interview_scheduled_time;
    }

    public Integer getSecond_interview_format() {
        return second_interview_format;
    }

    public void setSecond_interview_format(Integer second_interview_format) {
        this.second_interview_format = second_interview_format;
    }

    public String getSecond_interview_tool() {
        return second_interview_tool;
    }

    public void setSecond_interview_tool(String second_interview_tool) {
        this.second_interview_tool = second_interview_tool;
    }

    public String getSecond_interview_url() {
        return second_interview_url;
    }

    public void setSecond_interview_url(String second_interview_url) {
        this.second_interview_url = second_interview_url;
    }

    public String getSecond_interview_id() {
        return second_interview_id;
    }

    public void setSecond_interview_id(String second_interview_id) {
        this.second_interview_id = second_interview_id;
    }

    public String getSecond_interview_password() {
        return second_interview_password;
    }

    public void setSecond_interview_password(String second_interview_password) {
        this.second_interview_password = second_interview_password;
    }

    public Date getSecond_interview_date() {
        return second_interview_date;
    }

    public void setSecond_interview_date(Date second_interview_date) {
        this.second_interview_date = second_interview_date;
    }

    public Time getSecond_interview_time() {
        return second_interview_time;
    }

    public void setSecond_interview_time(Time second_interview_time) {
        this.second_interview_time = second_interview_time;
    }

    public String getSupplement() {
        return supplement;
    }

    public void setSupplement(String supplement) {
        this.supplement = supplement;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    public Integer getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(Integer is_deleted) {
        this.is_deleted = is_deleted;
    }

}