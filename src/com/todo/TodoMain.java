package com.todo;

import java.io.IOException;
import java.util.Scanner;

import com.todo.dao.TodoList;
import com.todo.menu.Menu;
import com.todo.service.TodoUtil;

public class TodoMain {
	
	public static void start() throws IOException {
	
		Scanner sc = new Scanner(System.in);
		TodoList l = new TodoList();
		
		boolean quit = false;
		
		Menu.displaymenu();
		do {
			Menu.prompt();
			String choice = sc.next();
			String keyWord;
			switch (choice) {

			case "add":
				TodoUtil.createItem(l);
				break;
			
			case "del":
				TodoUtil.deleteItem(l);
				break;
				
			case "update":
				TodoUtil.updateItem(l);
				break;
				
			case "find":
				keyWord = sc.nextLine().trim();
				TodoUtil.findList(l, keyWord);
				break;
				
			case "find_cate":
				keyWord = sc.next().trim();
				TodoUtil.findCateList(l, keyWord);
				break;
				
			case "ls":
				TodoUtil.listAll(l);
				break;
				
			case "ls_cate":
				TodoUtil.listCateAll(l);
				break;

			case "ls_name":
				TodoUtil.listAll(l, "title", 1);
				System.out.println("제목순으로 정렬을 완료하였습니다!.");
				break;

			case "ls_name_desc":
				TodoUtil.listAll(l, "title", 0);
				System.out.println("제목역순으로 정렬을 완료하였습니다!.");
				break;
				
			case "ls_date":
				TodoUtil.listAll(l, "due_date", 1);
				System.out.println("날짜순으로 정렬을 완료하였습니다!.");
				break;
				
			case "ls_date_desc":
				TodoUtil.listAll(l, "due_date", 0);
				System.out.println("날짜역순으로 정렬을 완료하였습니다!.");
				break;
				
			case "comp":
				TodoUtil.completeItem(l);
				break;
				
			case "ls_comp":
				TodoUtil.listAll(l, 1);
				break;
				
			case "del_overdue":
				TodoUtil.deleteOverdue(l);
				break;
				
			case "help":
				Menu.displaymenu();
				break;
				
			case "exit":
				quit = true;
				break;

			default:
				System.out.println("정확한 명령어를 입력하세요. (도움말 - help)");
				break;
			}
		} while (!quit);
	}
}
