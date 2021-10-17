package com.todo.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Statement;
import java.util.*;

import com.todo.dao.TodoItem;
import com.todo.dao.TodoList;

public class TodoUtil {
	
	public static void createItem(TodoList list) {
		
		String title, desc, cate, place, supplies, due_date;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("\n[�׸� �߰�]\n" + "���� > ");
		title = sc.next().trim();
		
		if (list.isDuplicate(title)) {
			System.out.println("�̹� ��� ���� �����Դϴ�.");
			return;
		}
		
		System.out.print("ī�װ� > ");
		cate = sc.next().trim();
		
		sc.nextLine();
		System.out.print("���� > ");
		desc = sc.nextLine().trim();
		
		System.out.print("��� > ");
		place = sc.nextLine().trim();
		
		System.out.print("�غ� > ");
		supplies = sc.nextLine().trim();
		
		System.out.print("���� ��¥ > ");
		due_date = sc.next().trim();
		
		TodoItem t = new TodoItem(title, desc, cate, place, supplies, due_date);
		if(list.addItem(t) > 0)
			System.out.println("�׸��� �߰��Ǿ����ϴ�.");
	}

	public static void deleteItem(TodoList l) {
		Scanner sc = new Scanner(System.in);
		boolean check = true;
		
		System.out.print("\n[�׸� ����]\n" + "������ �׸��� �Ϸù�ȣ�� �Է��ϼ��� > ");
		String s = sc.nextLine();
		String[] sNum = s.split(",");
		int[] num = new int[sNum.length];
		
		for(int i = 0; i < sNum.length; i++) {
			num[i] = Integer.parseInt(sNum[i].trim());
			if(!l.isExist(num[i])) {
				check = false;
				break;
			}
		}
		if (check) {
			String yes;
			for(int i = 0; i < num.length; i++) {
				for (TodoItem item : l.getItem(num[i])) {
					System.out.println(item.toString());
				}
			}
			System.out.print("�� �׸�(��)�� �����Ͻðڽ��ϱ�? (y/n) > ");
			
			do {
				yes = sc.next();
				
				switch(yes) {
					case "y":
						for(int i = 0; i < num.length; i++) {
							if(l.deleteItem(num[i]) <= 0) {
								check = false;
								break;
							}
						}
						if(check)
							System.out.println("�ش� �׸�(��)�� �����Ǿ����ϴ�.");
						break;
					
					case "n":
						System.out.println("������ ��� �Ǿ����ϴ�.");
						break;
				
					default:
						System.out.print("�����Ͻ÷��� \"y\", �������� �����÷��� \"n\"�� �Է��ϼ���. > ");
						break;
				}
			}while(!(yes.equals("y") || yes.equals("n")));
		}
		
		else {
			System.out.println("�ش� �Ϸù�ȣ�� �׸��� ã�� �� �����ϴ�.");
		}
	}


	public static void updateItem(TodoList l) {
		
		String new_title, new_description, new_category, new_due_date, new_place, new_supplies;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("\n[�׺� ����]\n" + "������ �׸��� �Ϸù�ȣ�� �Է��ϼ��� > ");
		int num = sc.nextInt();
		
//		if (num <= l.getList().size() && num > 0 ) {
//			System.out.println(num + ". " + l.getList().get(num - 1).toString());
//			l.deleteItem(num - 1);
//		}
//		else {
//			System.out.println("�ش� �Ϸù�ȣ�� �׸��� ã�� �� �����ϴ�.");
//			return;
//		}
		
		System.out.print("���ο� ī�װ� > ");
		new_category = sc.next().trim();
		
		System.out.print("���ο� ���� > ");
		new_title = sc.next().trim();
		if (l.isDuplicate(new_title)) {
			System.out.println("�̹� ��� ���� �����Դϴ�.");
			return;
		}
		
		sc.nextLine();
		System.out.print("���ο� ���� > ");
		new_description = sc.nextLine().trim();
		
		System.out.print("���ο� ��� > ");
		new_place = sc.nextLine().trim();
		
		System.out.print("���ο� �غ� > ");
		new_supplies = sc.nextLine().trim();
		
		System.out.print("���ο� ���� ��¥ > ");
		new_due_date = sc.next().trim();
		
		TodoItem t = new TodoItem(new_title, new_description, new_category, new_place, new_supplies, new_due_date);
		t.setId(num);
		
		if(l.updateItem(t) > 0)
			System.out.println("�׸��� ����Ǿ����ϴ�.");
	}
	
	public static void completeItem(TodoList l) {
		Scanner sc = new Scanner(System.in);
		boolean check = true;
		
		System.out.print("\n[�׸� �Ϸ�]\n" + "�Ϸ��� �׸��� �Ϸù�ȣ�� �Է��ϼ��� > ");
		String s = sc.nextLine();
		String[] sNum = s.split(",");
		int[] num = new int[sNum.length];
		
		for(int i = 0; i < sNum.length; i++) {
			num[i] = Integer.parseInt(sNum[i].trim());
			if(!l.isExist(num[i])) {
				check = false;
				break;
			}
		}
		if (check) {
			String yes;
			for(int i = 0; i < num.length; i++) {
				for (TodoItem item : l.getItem(num[i])) {
					System.out.println(item.toString());
				}
			}
			System.out.print("�� �׸�(��)�� �Ϸ��Ͻðڽ��ϱ�? (y/n) > ");
			
			do {
				yes = sc.next();
				
				switch(yes) {
					case "y":
						for(int i = 0; i < num.length; i++) {
							if(l.completeItem(num[i]) <= 0) {
								check = false;
								break;
							}
						}
						if(check)
							System.out.println("��" + num.length +"���� �׸��� �Ϸ�Ǿ����ϴ�.");
						break;
					
					case "n":
						break;
				
					default:
						System.out.print("�����Ͻ÷��� \"y\", �������� �����÷��� \"n\"�� �Է��ϼ���. > ");
						break;
				}
			}while(!(yes.equals("y") || yes.equals("n")));
		}
		
		else {
			System.out.println("�ش� �Ϸù�ȣ�� �׸��� ã�� �� �����ϴ�.");
		}
	}
	
	public static void deleteOverdue(TodoList l) {
		Scanner sc = new Scanner(System.in);
		int count = 0;
		String yes;
		ArrayList<TodoItem> list = l.getOverdue();
		for(TodoItem item : list) {
			System.out.println(item.toString());
			count++;
		}
		
		if(count == 0) System.out.println("�Ⱓ�� ����� �׸��� ã�� �� �����ϴ�.");
		else System.out.println("�� " + count + "���� �׸��� ã�ҽ��ϴ�.");
		
		System.out.print("�� �׸�(��)�� �����Ͻðڽ��ϱ�? (y/n) > ");
		
		do {
			yes = sc.next();
			
			switch(yes) {
				case "y":
					for(TodoItem item : list) {
						if(l.deleteItem(item.getId()) <= 0) {
							break;
						}
					}
					System.out.println("�ش� �׸�(��)�� �����Ǿ����ϴ�.");
					break;
				
				case "n":
					System.out.println("������ ��� �Ǿ����ϴ�.");
					break;
			
				default:
					System.out.print("�����Ͻ÷��� \"y\", �������� �����÷��� \"n\"�� �Է��ϼ���. > ");
					break;
			}
		}while(!(yes.equals("y") || yes.equals("n")));
	}
	
	public static void findList(TodoList l, String keyWord) {
		int count = 0;
		
		for(TodoItem item : l.getList(keyWord)) {
			System.out.println(item.toString());
			count++;
		}
		
		if(count == 0) System.out.println("�ش� Ű���带 �����ϴ� �׸��� ã�� �� �����ϴ�.");
		else System.out.println("�� " + count + "���� �׸��� ã�ҽ��ϴ�.");
	}
	
	public static void findCateList(TodoList l, String keyword) {
		int count = 0;
		
		for(TodoItem item : l.getListCategory(keyword)) {
			System.out.println(item.toString());
			count++;
		}
		
		if(count == 0) System.out.println("�ش� Ű���带 �����ϴ� �׸��� ã�� �� �����ϴ�.");
		else System.out.println("�� " + count + "���� �׸��� ã�ҽ��ϴ�.");
	}

	public static void listAll(TodoList l) {
		System.out.printf("[��ü ���, �� %d��]\n", l.getCount());
		for (TodoItem item : l.getList()) {
			System.out.println(item.toString());
		}
	}
	
	public static void listAll(TodoList l, String orderBy, int ordering) {
		System.out.printf("[��ü ���, �� %d��]\n", l.getCount());
		for (TodoItem item : l.getOrderedList(orderBy, ordering)) {
			System.out.println(item.toString());
		}
	}
	
	public static void listAll(TodoList l, int num) {
		int count = 0;
		
		for (TodoItem item : l.getList(num)) {
			System.out.println(item.toString());
			count++;
		}
		
		if(count == 0) System.out.println("�Ϸ�� �׸��� ã�� �� �����ϴ�.");
		else System.out.println("�� " + count + "���� �׸��� ã�ҽ��ϴ�.");
	}
	
	public static void listCateAll(TodoList l) {
		int count = 0;
		
		for (String item : l.getCategories()) {
		    System.out.print(item + " ");
		    count++;
		}
		
		System.out.println("�� " + count + "���� ī�װ��� ��ϵǾ� �ֽ��ϴ�.");
	}

	public static void loadList(TodoList l, String file) throws IOException {
		String s;
		int i = 0;
		
		File f = new File(file);
		if(!f.exists()) {
			f.createNewFile();
			System.out.println(file + " ������ �����ϴ�.");
			return;
		}
		
		BufferedReader bf = new BufferedReader(new FileReader(f));
		
		while ((s = bf.readLine()) != null) {
			StringTokenizer token = new StringTokenizer(s, "##");
			TodoItem t = new TodoItem(token.nextToken(), token.nextToken(), token.nextToken(), token.nextToken(), token.nextToken(), token.nextToken());
			t.setCurrent_date(token.nextToken());
			l.addItem(t);
			i++;
		}
		
		System.out.println(i + "���� �׸��� �о����ϴ�.");
	}

	public static void saveList(TodoList l, String file) throws IOException {
		FileWriter fw = new FileWriter(file);
		
		for(TodoItem item : l.getList()) {
			fw.write(item.toSaveString());
		}
		System.out.println("��� �����Ͱ� ����Ǿ����ϴ�.");
		fw.close();
	}
}
