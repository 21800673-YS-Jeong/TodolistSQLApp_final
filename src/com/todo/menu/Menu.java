package com.todo.menu;
public class Menu {

    public static void displaymenu()
    {
        System.out.println();
        System.out.println("<ToDoList 관리 명령어 사용법>");
        System.out.println("1. add - 항목 추가");
        System.out.println("2. del - 항목 삭제");
        System.out.println("3. update - 항목 변경");
        System.out.println("4. find - 항목(제목, 내용) 찾기");
        System.out.println("5. find_cate - 항목(카테고리) 찾기");
        System.out.println("6. ls - 전체 목록");
        System.out.println("7. ls_cate - 전체 카테고리");
        System.out.println("8. ls_name - 항목 제목순 정렬");
        System.out.println("9. ls_name_desc - 항목 제목역순 정렬");
        System.out.println("10. ls_date - 항목 날짜순 정렬");
        System.out.println("11. ls_date_desc - 항목 날짜역순 정렬");
        System.out.println("12. comp - 항목 완료");
        System.out.println("13. ls_comp - 완료된 항목 찾기");
        System.out.println("14. del_overdue - 만료된 항목 삭제");
        System.out.println("15. exit - 종료");
    }
    
    public static void prompt() {
    	System.out.print("\n명령어 입력 > ");
    }
}
