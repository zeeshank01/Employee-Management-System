package com.jsp.ems.view;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.jsp.ems.controller.Controller;
import com.jsp.ems.model.Department;
import com.jsp.ems.model.Employee;
import com.jsp.ems.model.Project;

public class Driver {

	public static void main(String[] args) {
		
		Scanner myInput = new Scanner(System.in);
		Employee employee = new Employee();
		Department department = new Department();
		Project project = new Project();
		Controller controller = new Controller();
		
		 
		
		do {
			System.out.println("--------------------"
							+"\n|Menu              |"
							+"\n--------------------");
			System.out.println("|1.Insert          |"
							+"\n|2.View            |"
							+"\n|3.Update          |"
							+"\n|4.Delete          |"
							+"\n|0.Exit            |"
							+"\n--------------------");
			
			System.out.println("Enter the desired option: ");
			int menuinput = myInput.nextInt();
			myInput.nextLine();

			switch (menuinput) {
			case 0:
				myInput.close();
				System.out.println("-----------Existed-----------");
				System.exit(0);
				break;
			case 1:
				boolean insertloop = true;
				do {
					System.out.println("------------------------"
									+"\n|Insert                |"
									+"\n------------------------");
					System.out.println("|1.Insert Employee     |"
									+"\n|2.Insert Department   |"
									+"\n|3.Insert Project      |"
									+"\n|0.Exit                |"
									+"\n------------------------");
					System.out.println("Select Desired Insert Operation: ");
					int insertoption = myInput.nextInt();
					myInput.nextLine();
					switch (insertoption) {
					case 0:
						System.out.println("-----------Insert Operation Ended-----------");
						insertloop = false;
						break;
					case 1:
						Employee employee2 = new Employee();
						System.out.println("Enter Employee Name: ");
						String empname = myInput.nextLine();
						System.out.println("Enter Employee Position: ");
						String empposition = myInput.nextLine();
						System.out.println("Enter Employee Salary: ");
						double empsalary = myInput.nextDouble();
						myInput.nextLine();
						
						if (empname == null) {
							System.out.println("Please Enter Employee Name");
						} else if (empposition == null) {
							System.out.println("Please Enter Employee Position");
						} else if (empsalary <= 0) {
							System.out.println("Please Enter Employee Salary");
						} else if (empname!=null && empposition !=null && empsalary!=0) {
							employee2.setName(empname);
							employee2.setPosition(empposition);
							employee2.setSalary(empsalary);
							
							if (controller.addEmployee(employee2)) {
								System.out.println("Employee Data Inserted");
							} else {
								System.out.println("Employee Data Not Inserted");
							}
						}
						
						
						break;
					case 2:

						Department department2 = new Department();
						System.out.println("Enter Department Name: ");
						String deptname = myInput.nextLine();
						
						if (deptname == null) {
							System.out.println("Please Enter Department Name");
						} else {
							department2.setName(deptname);
							if (controller.addDepartment(department2)) {
								System.out.println("Department Data Inserted");
							} else {
								System.out.println("Department Data Not Inserted");
							}
							
						}
						
						break;
					case 3:
						Project project2 = new Project();
						System.out.println("Enter Project Name: ");
						String projectname = myInput.nextLine();
						System.out.println("Enter Project Description: ");
						String projectdesc = myInput.nextLine();
		
						if (projectname == null) {
							System.out.println("Please Enter Project Name");
						} else if (projectdesc == null) {
							System.out.println("Please Enter Project Description");
						} else if (projectname!=null && projectdesc != null) {
							project2.setName(projectname);
							project2.setDescription(projectdesc);
							
							if (controller.addProject(project2)) {
								System.out.println("Project Data Inserted");
							} else {
								System.out.println("Project Data Not Inserted");
							}
						}
					
						break;
						
					default:
						System.out.println("Please Select Valid Option");
						break;
					}
				} while (insertloop);

				break;
			case 2:
				boolean viewloop = true;
				do {
					System.out.println("-----------------------------------"
									+"\n|View                             |"
									+"\n-----------------------------------");
					System.out.println("|1.View Particular Employee       |"
									+"\n|2.View Particular Department     |"
									+"\n|3.View Particular Project        |"
									+"\n|4.View All Employee Detail       |"
									+"\n|5.View All Department Detail     |"
									+"\n|6.View All Project Detail        |"
									+"\n|0.Exit                           |"
									+"\n-----------------------------------");
					System.out.println("Select Desired View Operation: ");
					int viewoption = myInput.nextInt();
					myInput.nextLine();

					switch (viewoption) {
					case 0:
						System.out.println("-----------View Operation Ended-----------");
						viewloop = false;
						break;
					case 1:
						System.out.println("Enter Employee Id To Find Details: ");
						int empid_tofind = myInput.nextInt();
						myInput.nextLine();
						
						if (empid_tofind <= 0) {
							System.out.println("Please Enter The Correct Employee Id");
						} else {
							Employee findEmployee = controller.findEmployee(empid_tofind);
							if (findEmployee!=null) {
								System.out.println("Employee Id: " + findEmployee.getId());
								System.out.println("Employee Name: " + findEmployee.getName());
								System.out.println("Employee Position: " + findEmployee.getPosition());
								System.out.println("Employee Salary: " + findEmployee.getSalary());
								System.out.println("Employee Joining Date: " + findEmployee.getDate_of_joining());
								
								
							} else {
								System.out.println("Employee with the given Id does not exit");
							}
						}
		
						break;
					case 2:
						System.out.println("Enter Department Id To Find: ");
						int dept_tofind = myInput.nextInt();
						myInput.nextLine();
						
						if (dept_tofind<=0) {
							System.out.println("Please Enter The Correct Department Id");
						} else {
							Department findDepartment = controller.findDepartment(dept_tofind);
							if (findDepartment!=null) {
								System.out.println("Department Id: " + findDepartment.getId());
								System.out.println("Department Name: " + findDepartment.getName());
								
								
							} else {
								System.out.println("Department with the given Id does not exit");
							}
						}
						
						
						break;
					case 3:
						System.out.println("Enter Project Id To Find: ");
						int projectid_tofind = myInput.nextInt();
						myInput.nextLine();
						if (projectid_tofind<=0) {
							System.out.println("Please Enter The Correct Project Id");
						} else {
							Project findProject = controller.findProject(projectid_tofind);
							if (findProject!=null) {
								System.out.println("Project Id: " + findProject.getId());
								System.out.println("Project Name: " + findProject.getName());
								System.out.println("Project Description: " + findProject.getDescription());
								
							} else {
								System.out.println("Project with the given Id does not exit");
							}
						}
						
						break;
					case 4:
						
						List<Employee> findAllEmployee = controller.findAllEmployee();
						if (findAllEmployee!=null) {
							for (Employee employee2 : findAllEmployee) {
								System.out.println("---------------------------------------------------");
								System.out.println("Employee Id: " + employee2.getId());
								System.out.println("Employee Name: " + employee2.getName());
								System.out.println("Employee Position: " + employee2.getPosition());
								System.out.println("Employee Salary: " + employee2.getSalary());
								System.out.println("Employee Joining Date: " + employee2.getDate_of_joining());
								System.out.println("---------------------------------------------------");
							}
						} else {
							System.out.println("Employee Data is Empty");
						}
						
						
						break;
					case 5:
						List<Department> findAllDepartment = controller.findAllDepartment();
						if (findAllDepartment!=null) {
							for (Department department2 : findAllDepartment) {
								System.out.println("---------------------------------------------------");
								System.out.println("Department Id: " + department2.getId());
								System.out.println("Department Name: " + department2.getName());
								System.out.println("---------------------------------------------------");
							}
						} else {
							System.out.println("Department Data is Empty");
						}
						
						break;
					case 6:
						List<Project> findAllProject = controller.findAllProject();
						if (findAllProject!=null) {
							for (Project project2 : findAllProject) {
								System.out.println("---------------------------------------------------");
								System.out.println("Project Id: " + project2.getId());
								System.out.println("Project Name: " + project2.getName());
								System.out.println("Project Description: " + project2.getDescription());
								System.out.println("---------------------------------------------------");
								
							}
						} else {
							System.out.println("Department Data is Empty");
						}
						break;
					default:
						System.out.println("Please Select Valid Option");
						break;
					}
				} while (viewloop);

				break;
			case 3:

				boolean updateloop = true;
				do {
					System.out.println("-----------------------------------------"
									+"\n|Update                                 |"
									+"\n-----------------------------------------");
					System.out.println("|1.Update Employee Salary               |"
									+"\n|2.Update Employee Position             |"
									+"\n|3.Assign Employee To Department        |"
									+"\n|4.Assign Employee To Project           |"
									+"\n|5.Update Department Name               |"
									+"\n|6.Update Project Name & Description    |"
									+"\n|0.Exit                                 |"
									+"\n-----------------------------------------");
					System.out.println("Select Desired Update Operation: ");
					int updateoption = myInput.nextInt();
					myInput.nextLine();
					
					switch (updateoption) {
					case 0:
						System.out.println("-----------Update Operation Ended-----------");
						updateloop = false;
						break;
					case 1:
						System.out.println("Enter Employee Id To Update: ");
						int empid_toupdate = myInput.nextInt();
						myInput.nextLine();
						
						System.out.println("Enter Updated Salary: ");
						double updated_salary = myInput.nextDouble();
						myInput.nextLine();
						
						if (empid_toupdate<=0) {
							System.out.println("Please Enter Correct Employee Id");
						} else if (updated_salary<=0) {
							System.out.println("Please Enter Correct Salary");
						} else {
							if (controller.updateSalary(empid_toupdate,updated_salary)) {
								System.out.println("Salary Updated");
							} else {
								System.out.println("Given Employee Does Not Exist");
							}
						}
						
						break;
					case 2:
						System.out.println("Enter Employee Id To Update: ");
						int empid = myInput.nextInt();
						myInput.nextLine();
						
						System.out.println("Enter Updated Position: ");
						String updated_position = myInput.nextLine();
						
						
						if (empid<=0) {
							System.out.println("Please Enter Correct Employee Id");
						} else if (updated_position == null) {
							System.out.println("Please Enter Correct Salary");
						} else {
							if (controller.updatePosition(empid, updated_position)) {
								System.out.println("Salary Updated");
							} else {
								System.out.println("Given Employee Does Not Exist");
							}
						}
						
//						
						break;

					case 3:
						System.out.println("Enter Employee id To Add to the Department: ");
						int empid_toadd = myInput.nextInt();
						myInput.nextLine();
						
						
						List<Department> findAllDepartment = controller.findAllDepartment();
						if (findAllDepartment!=null) {
							for (Department department2 : findAllDepartment) {
								System.out.println("---------------------------------------------------");
								System.out.println("Department Id: " + department2.getId());
								System.out.println("Department Name: " + department2.getName());
								System.out.println("---------------------------------------------------");
							}
						} else {
							System.out.println("Department Data is Empty");
						}
						
						
						
						System.out.println("Enter Department Id to Add Employee: ");
						int dep_idtoadd = myInput.nextInt();
						myInput.nextLine();
						
						Department findDepartment = controller.findDepartment(dep_idtoadd);
						if (findDepartment!=null) {
							if (controller.addEmployeeToDepartment(empid_toadd, findDepartment)) {
								System.out.println("Employee Add To Department");
							} else {
								System.out.println("Employee Couldn't Be Added To Department");
							}
						} else {
							System.out.println("Department Does Not Exist");
						}
						
						
						break;

					case 4:
						
						List<Project> findAllProject = controller.findAllProject();
						if (findAllProject!=null) {
							for (Project project2 : findAllProject) {
								System.out.println("---------------------------------------------------");
								System.out.println("Project Id: " + project2.getId());
								System.out.println("Project Name: " + project2.getName());
								System.out.println("Project Description: " + project2.getDescription());
								System.out.println("---------------------------------------------------");
								
							}
						} else {
							System.out.println("Department Data is Empty");
						}
						
						System.out.println("Enter Employee Id to Assign Project: ");
						int empid_project = myInput.nextInt();
						myInput.nextLine();
						
						System.out.println("Enter Project Id to Assign The Employee: ");
						int projectid_toemp = myInput.nextInt();
						myInput.nextLine();
						
						Project findProject = controller.findProject(projectid_toemp);
						if (findProject!=null) {
							if (controller.addEmployeeToProject(empid_project, findProject)) {
								System.out.println("Employee Add To Project");
							} else {
								System.out.println("Employee Couldn't Be Added To Project");
							}
						} else {
							System.out.println("Project Does Not Exist");
						}
						
						
						
						break;
						
					case 5:
						System.out.println("Enter Department Id to update: ");
						int deptid = myInput.nextInt();
						myInput.nextLine();
						
						System.out.println("Enter Department Name: ");
						String deptNametoupdate = myInput.nextLine();
						
						if (deptid<=0) {
							System.out.println("Please Enter Correct Department Id");
						} else if (deptNametoupdate == null) {
							System.out.println("Please Enter Correct Naame");
						} else {
							if (controller.updateDepartmentName(deptid,deptNametoupdate)) {
								System.out.println("Name Updated");
							} else {
								System.out.println("Given Department Does Not Exist");
							}
						}
						
						break;
					case 6:
						System.out.println("Enter Project Id to update: ");
						int projectid = myInput.nextInt();
						myInput.nextLine();
						
						System.out.println("Enter Project Name: ");
						String projectNametoupdate = myInput.nextLine();
						
						System.out.println("Enter Project Description: ");
						String projectdesctoupdate = myInput.nextLine();
						
						if (projectid<=0) {
							System.out.println("Please Enter Correct Project Id");
						} else if (projectNametoupdate == null) {
							System.out.println("Please Enter Correct Name");
						} else if (projectdesctoupdate == null) {
							System.out.println("Please Enter Description");
						} else {
							if (controller.updateProjectNameandDesc(projectid, projectNametoupdate, projectdesctoupdate)) {
								System.out.println("Name And Description Updated");
							} else {
								System.out.println("Given Project Does Not Exist");
							}
						}
						break;

					default:
						System.out.println("Please Select Valid Option");
						break;
					}
					
				} while (updateloop);
				break;
			case 4:

				boolean removeloop = true;
				
				do {
					System.out.println("----------------------------------------"
									+"\n|Remove                                |"
									+"\n----------------------------------------");
					System.out.println("|1.Remove Employee                     |"
									+"\n|2.Remove Employee From Department     |"
									+"\n|3.Remove Employee From Project        |"
									+"\n|0.Exit                                |"
									+"\n----------------------------------------");
					System.out.println("Select Desired View Operation: ");
					
					int removeoption = myInput.nextInt();
					myInput.nextLine();
					
					switch (removeoption) {
					case 0:
						System.out.println("-----------Remove Operation Ended-----------");
						removeloop = false;
						break;
					case 1:
						System.out.println("Enter Employee Id To Remove: ");
						int empid_toremove = myInput.nextInt();
						myInput.nextLine();
						
						if (empid_toremove<=0) {
							System.out.println("Please Enter Correct Employee Id");
						} else {
							if (controller.removeEmployee(empid_toremove)) {
								System.out.println("Employee Detail Deleted");
							} else {
								System.out.println("Employee with the given Id does not exist");
							}
						}
						
						break;
					case 2:
						System.out.println("Enter Employee Id: ");
						int empid_dep = myInput.nextInt();
						myInput.nextLine();
						
						System.out.println("Enter Department Id To Remove: ");
						int deptid_toremove = myInput.nextInt();
						myInput.nextLine();
						if (empid_dep <=0) {
							System.out.println("Please Enter Correct Employee Id");
						} else if (deptid_toremove<=0) {
							System.out.println("Please Enter Correct Department Id");
						} else {
							if (controller.removeEmployeeFromDepartment(empid_dep, deptid_toremove)) {
								System.out.println("Employee Deleted From Project");
							} else {
								System.out.println("Employee or Department with the given Id does not exist");
							}
						}
						
						break;
					case 3:
						System.out.println("Enter Employee Id: ");
						int empid = myInput.nextInt();
						myInput.nextLine();
						
						System.out.println("Enter Project Id To Remove: ");
						int projectid_toremove = myInput.nextInt();
						myInput.nextLine();
						
						
						if (empid<=0) {
							System.out.println("Please Enter Correct Employee Id");
						} else if (projectid_toremove<=0) {
							System.out.println("Please Enter Correct Project Id");
							
						} else {
							if (controller.removeEmployeeFromProject(empid, projectid_toremove)) {
								System.out.println("Employee Deleted From Project");
							} else {
								System.out.println("Employee or Project with the given Id does not exist");
							}
						}
						
						break;

					default:
						System.out.println("Please Select Valid Option");
						break;
					}
					
				} while (removeloop);
				break;

			default:
				System.out.println("Please Select Valid Option");
				break;
			}
			
		} while (true);
	}
}
