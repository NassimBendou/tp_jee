package base;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

import annotation.Id;
import annotation.Table;
import bean.Livre;
import bean.Livre2;

public class BaseAvecEnregistrer extends Base {

	public void enregistrer(Object o) {
		try {
			Class c = o.getClass();
			System.out.println("classe = "+c.getSimpleName());
		
			String sql = "insert into ";
			
			Table t = (Table)c.getAnnotation(Table.class);
			System.out.println("table = "+t.name());
			
			sql += t.name() + "(";
			
			Field[] fields = c.getDeclaredFields();
			int count = 0;
			for (int i=0 ; i<fields.length ; i++) {
				if (!fields[i].isAnnotationPresent(Id.class)) {
					if (count > 0) sql += ",";
						sql += fields[i].getName();
						count++;
					}
			}
			
			sql += ") values (";
			
			count = 0;
			for (int i=0 ; i<fields.length ; i++) {
				if (!fields[i].isAnnotationPresent(Id.class)) {
					if (count > 0) sql += ",";
						String nom = "get" +
								fields[i].getName().substring(0, 1).toUpperCase() +
								fields[i].getName().substring(1);
						Method m = c.getMethod(nom);
						if (m.getReturnType() == String.class) {
							sql += "'";
						}
						sql += m.invoke(o);
						if (m.getReturnType() == String.class) {
							sql += "'";
						}

						count++;
					}
			}
	
			sql += ")";
		
			co.createStatement().execute(sql);
			System.out.println("Exec sql : "+sql);
		}
		catch (Exception e) {
			System.out.println("Erreur enregistrer "+e.getMessage());
		}
	}
			

public static void main(String [] args) {

	System.out.println("BaseEnregistrer");
	BaseAvecEnregistrer base = new BaseAvecEnregistrer();
	base.ouvrir();
	
	
	Livre2 l2 = new Livre2("jdbc2","bbb",2019);
	base.enregistrer(l2);
	
	ArrayList<Livre> res = base.listerLivres();
	for (Livre livre : res) {
		System.out.println("livre "+livre.getTitre());
	}
	
	base.fermer();
}

}

			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			/*
			
			
			
			
			
			Class c = o.getClass();
			//System.out.println("class = "+c.getSimpleName());
		
		
			String sql = "insert into ";
			Table t = (Table)c.getAnnotation(Table.class);
			//System.out.println("table = "+t.name());
			
			sql += t.name() + "(";
			
			Field[] fields = c.getDeclaredFields();
			int count = 0;
			for (int i=0 ; i<fields.length ; i++) {
				if (fields[i].isAnnotationPresent(Id.class)) {
				}
				else {
					if (count>0) sql += ",";
					sql += fields[i].getName();
					count++;
				}
			}
			
			sql += ") values (";
			
			count = 0;
			for (int i=0 ; i<fields.length ; i++) {
				if (fields[i].isAnnotationPresent(Id.class)) {
				}
				else {
					if (count>0) sql += ",";
					String nom = fields[i].getName();
					nom = "get" +
							nom.substring(0, 1).toUpperCase() +
							nom.substring(1);
					Method m = c.getMethod(nom);
					if (m.getReturnType() == String.class) {
						sql += "'";
					}
					sql += m.invoke(o);
					if (m.getReturnType() == String.class) {
						sql += "'";
					}

					
					count++;
				}
			}
	
			sql += ")";
			
			
		*/
		
