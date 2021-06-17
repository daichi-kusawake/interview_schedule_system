package models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "departments")
@NamedQueries({
    @NamedQuery(
        name = "getAllDepartments",
        query = "select d from Department as d order by d.id desc"
    ),
    @NamedQuery(
        name = "getDepartmentsCount",
        query = "select count(d) from Department as d"
    ),
    @NamedQuery(
        name = "checkRegisteredDepartmentCode",
        query = "select count(d) from Department as d where d.department_code = :department_code"
    ),
    @NamedQuery(
        name = "getAllDepartmentsNotDeleted",
        query = "select d from Department as d where d.is_deleted = 0 order by d.id desc"
    )
})

@Entity
public class Department {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "department_code", nullable = false, unique = true)
    private String department_code;

    @Column(name = "department_name", nullable = false)
    private String department_name;



    @Column(name = "created_at", nullable = false)
    private Timestamp created_at;

    @Column(name = "updated_at", nullable = false)
    private Timestamp updated_at;

    @Column(name = "is_deleted", nullable = false)
    private Integer is_deleted;

    //ゲッターとセッター
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	public String getDepartment_code() {
		return department_code;
	}

	public void setDepartment_code(String department_code) {
		this.department_code = department_code;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
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