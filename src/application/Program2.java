package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = new DaoFactory().createDepartmentDao();

		System.out.println();
		System.out.println("=== TESTE 1: findByID Department ===");
		Department dep = departmentDao.findById(5);
		System.out.println(dep);
		
		
		System.out.println();
		System.out.println("=== TESTE 2: findByID Department ===");
		List<Department> list = departmentDao.findAll();
		for (Department d : list) {
			System.out.println(d);
		}
		
		
		System.out.println();
		System.out.println("=== TESTE 3: insert Department ===");
		Department department = new Department(null, "RH");
		//departmentDao.insert(department);
		System.out.println("Departamento Inserido!");
		
		
		System.out.println();
		System.out.println("=== TESTE 4: update Department ===");
		department = departmentDao.findById(6);
		department.setName("Recursos Humanos");
		departmentDao.update(department);
		System.out.println("Update completo");

		
		System.out.println();
		System.out.println("=== TESTE 5: delete Department ===");
		System.out.println("Digite o id para ser deletado: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Deletado!");
		
	}

}
