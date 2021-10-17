package com.todo.dao;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TodoItem {
	private int id;
    private String title;
    private String desc;
    private String cate;
    private String current_date;
    private String due_date;
    private int is_completed;
    private String place;
    private String supplies;

	public TodoItem(String title, String desc, String cate, String place, String supplies, String due_date){
        this.title=title;
        this.desc=desc;
        this.cate = cate;
        this.due_date = due_date;
        SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd kk:mm:ss");
        this.current_date = f.format(new Date());
        this.place = place;
        this.supplies = supplies;
    }
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    public String getCate() {
		return cate;
	}

	public void setCate(String cate) {
		this.cate = cate;
	}

    public String getCurrent_date() {
        return current_date;
    }

    public void setCurrent_date(String current_date) {
        this.current_date = current_date;
    }
    
	public String getDue_date() {
		return due_date;
	}

	public void setDue_date(String due_date) {
		this.due_date = due_date;
	}
	
	public int getIs_completed() {
		return is_completed;
	}

	public void setIs_completed(int is_completed) {
		this.is_completed = is_completed;
	}
	
	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getSupplies() {
		return supplies;
	}

	public void setSupplies(String supplies) {
		this.supplies = supplies;
	}
	
    public String toSaveString() {
    	return cate + "##" + title + "##" + desc + "##" + due_date + "##" + current_date + "\n";
    }

	public String toString() {
		if(is_completed == 0)
			return id + ". " + "[" + cate + "] " + title + " - " + desc + " - " + place + " - " + supplies + " - " + due_date + "(" + current_date + ")";
		else
			return id + ". " + "[" + cate + "] " + title + " [V]" + " - " + desc + " - " + place + " - " + supplies + " - " + due_date + "(" + current_date + ")";
	}
}
