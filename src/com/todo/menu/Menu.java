package com.todo.menu;
public class Menu {

    public static void displaymenu()
    {
        System.out.println();
        System.out.println("<ToDoList ���� ��ɾ� ����>");
        System.out.println("1. add - �׸� �߰�");
        System.out.println("2. del - �׸� ����");
        System.out.println("3. update - �׸� ����");
        System.out.println("4. find - �׸�(����, ����) ã��");
        System.out.println("5. find_cate - �׸�(ī�װ�) ã��");
        System.out.println("6. ls - ��ü ���");
        System.out.println("7. ls_cate - ��ü ī�װ�");
        System.out.println("8. ls_name - �׸� ����� ����");
        System.out.println("9. ls_name_desc - �׸� ���񿪼� ����");
        System.out.println("10. ls_date - �׸� ��¥�� ����");
        System.out.println("11. ls_date_desc - �׸� ��¥���� ����");
        System.out.println("12. comp - �׸� �Ϸ�");
        System.out.println("13. ls_comp - �Ϸ�� �׸� ã��");
        System.out.println("14. del_overdue - ����� �׸� ����");
        System.out.println("15. exit - ����");
    }
    
    public static void prompt() {
    	System.out.print("\n��ɾ� �Է� > ");
    }
}
