package com.jsp.ems.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.jsp.ems.model.Department;
import com.jsp.ems.model.Employee;
import com.jsp.ems.model.Project;

public class Controller {

	public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pgadmin");
	public static EntityManager entityManager = entityManagerFactory.createEntityManager();
	public static EntityTransaction entityTransaction = entityManager.getTransaction();
	
	public boolean addEmployee(Employee employee) {
		if (employee!=null) {
			entityTransaction.begin();
			entityManager.persist(employee);
			entityTransaction.commit();
			return true;
		}
		return false;
	}
	
	public boolean addDepartment(Department department) {
		if (department!=null) {
			entityTransaction.begin();
			entityManager.persist(department);
			entityTransaction.commit();
			return true;
		}
		return false;
		
	}

	public boolean addProject(Project project) {
		if (project!=null) {
			entityTransaction.begin();
			entityManager.persist(project);
			entityTransaction.commit();
			return true;
		}
		return false;

	}
	
	public  Employee findEmployee(int employee_id) {
		return entityManager.find(Employee.class, employee_id);
		
	}
	
	public Department findDepartment(int department_id) {
		return entityManager.find(Department.class, department_id);
	}
	
	public Project findProject(int project_id) {
		return entityManager.find(Project.class, project_id);
	}
	
	public boolean updateSalary(int employee_id, double updatedSalary) {
		Employee findEmployee = findEmployee(employee_id);
		if (findEmployee!=null) {
			findEmployee.setSalary(updatedSalary);
			entityTransaction.begin();
			entityManager.merge(findEmployee);
			entityTransaction.commit();
			return true;
		}
		return false;

	}

	public boolean updatePosition(int employee_id, String updatedPostion) {
		Employee findEmployee = findEmployee(employee_id);
		if (findEmployee!=null) {
			findEmployee.setPosition(updatedPostion);
			entityTransaction.begin();
			entityManager.merge(findEmployee);
			entityTransaction.commit();
			return true;
		}
		return false;

	}
	 
	public boolean addEmployeeToDepartment(int empidAdd,Department department) {
		Employee employee = findEmployee(empidAdd);
		if (employee!=null && department!=null) {
			ArrayList<Employee> employees = new ArrayList<Employee>();
			employees.add(employee);
			
			entityTransaction.begin();
			employee.setDepartment(department);
			department.setEmployees(employees);
			entityManager.merge(employee);
			entityManager.merge(department);
			entityTransaction.commit();
			return true;
		}
		return false;
	}
	
	public boolean addEmployeeToProject(int empidAdd, Project project) {
		Employee employee = entityManager.find(Employee.class, empidAdd);
		if (employee!=null && project!=null) {
			ArrayList<Employee> employees = new ArrayList<Employee>();
			ArrayList<Project> projects = new ArrayList<Project>();
			employees.add(employee);
			projects.add(project);
			
			entityTransaction.begin();
			employee.setProjects(projects);
			project.setEmployees(employees);
			entityManager.merge(employee);
			entityManager.merge(project);
			entityTransaction.commit();
			return true;
		}
		return false;
		
	}
	
	public boolean updateDepartmentName(int deptid,String updatedname) {
		Department findDepartment = findDepartment(deptid);
		if (findDepartment!=null) {
			findDepartment.setName(updatedname);
			entityTransaction.begin();
			entityManager.merge(findDepartment);
			entityTransaction.commit();
			return true;
		}
		return false;
	}
	
	public boolean updateProjectNameandDesc(int projectid,String updatedname, String updatedesc) {
		Project project = findProject(projectid);
		
		if (project!=null) {
			project.setName(updatedname);
			project.setDescription(updatedesc);
			entityTransaction.begin();
			entityManager.merge(project);
			entityTransaction.commit();
			return true;
		}
		return false;
	}
	
	
	public boolean removeEmployee(int employee_id) {
		Employee find = findEmployee(employee_id);
		if (find!=null) {
			entityTransaction.begin();
			
			Department department = find.getDepartment();
			department.getEmployees().remove(find);
			for (Project project : find.getProjects()) {
				project.getEmployees().remove(find);
			}
			
			find.setDepartment(null);
			find.setProjects(null);
			
			entityManager.remove(find);
			
			entityTransaction.commit();
			return true;
		}
		return false;
		
	}
	
	public boolean removeEmployeeFromDepartment(int empid, int department_id) {
		Employee findEmployee = findEmployee(empid);
		
		Department department = findDepartment(department_id);
		if (department!=null && findEmployee!=null) {
			entityTransaction.begin();
			department.getEmployees().remove(findEmployee);
			findEmployee.setDepartment(null);
			entityManager.merge(department);
			entityManager.merge(findEmployee);
			entityTransaction.commit();
			return true;
		}
		return false;
		
	}
	
	public boolean removeEmployeeFromProject(int empid, int project_id) {
		Employee findEmployee = findEmployee(empid);
		Project findProject = findProject(project_id);
		if (findEmployee!=null && findProject!=null) {
			entityTransaction.begin();
			findProject.getEmployees().remove(findEmployee);
			findEmployee.getProjects().remove(findProject);
			entityManager.merge(findProject);
			entityManager.merge(findEmployee);
			entityTransaction.commit();
			return true;
		}
		
		return false;
	}
	
	
	
	public List<Employee> findAllEmployee() {
		TypedQuery<Employee> query = entityManager.createQuery("Select e From Employee e",Employee.class);
		return query.getResultList();
	}
	
	public List<Department> findAllDepartment() {
		TypedQuery<Department> query = entityManager.createQuery("Select e from Department e",Department.class);
		return query.getResultList();
	}
	
	public List<Project> findAllProject() {
		TypedQuery<Project> query = entityManager.createQuery("Select e from Project e",Project.class);
		return query.getResultList();
	}
	
}
