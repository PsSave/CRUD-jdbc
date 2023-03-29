package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = new DaoFactory().createSellerDao();
		
		System.out.println("=== TESTE 1: findById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println();
		System.out.println("=== TESTE 2: findByDepartment ===");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println();
		System.out.println("=== TESTE 3: findAll ===");
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println();
		System.out.println("=== TESTE 4: insert ===");
		Seller newSeller = new Seller(null, "Gregorio", "gregorio@gmail.com", new Date(), 4000.00, department);
		
		System.out.println();
		System.out.println("=== TESTE 5: update ===");
		seller = sellerDao.findById(1);
		seller.setName("Vitoria Regina");
		sellerDao.update(seller);
		System.out.println("Update completo");
		
		System.out.println();
		System.out.println("=== TESTE 6: delete ===");
		System.out.println("Digite o Id para ser deletado: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Deletado!");
		
		sc.close();
	}

}
