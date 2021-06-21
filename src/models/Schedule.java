package models;

import java.sql.Date;
import java.sql.Time;

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
        query = "SELECT r FROM Schedule AS r ORDER BY r.id DESC"
    ),
    @NamedQuery(
        name = "getSchedulesCount",
        query = "SELECT COUNT(r) from Schedule AS r"
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
	private Employee sales_emloyee;

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


	public Employee getSales_emloyee() {
		return sales_emloyee;
	}


	public void setSales_emloyee(Employee sales_emloyee) {
		this.sales_emloyee = sales_emloyee;
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

}
