package com.Entity.www;

public class Menu {

	private String menu_id;
	private String menu;
	private String link;
	
	public Menu() {
		
	}
	
	public Menu(String menu_id, String menu, String link) {
		this.menu_id = menu_id;
		this.menu = menu;
		this.link = link;
	}
	
	public String getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(String menu_id) {
		this.menu_id = menu_id;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public String toString() {
		return "Menu [menu_id=" + menu_id + ", menu=" + menu + ", link=" + link + "]";
	}
	
	
	
}
