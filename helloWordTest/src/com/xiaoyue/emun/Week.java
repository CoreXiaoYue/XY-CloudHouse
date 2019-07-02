package com.xiaoyue.emun;

public enum Week {
	TUR,MON("星期一"),TUE("星期二"),WEN("星期三");
	private String name;
	
	  private Week() {
	  
	  }
	
	 private Week(String name) {
		 this.name=name;
	 }

	public String getName() {
		return name;
	}
	/*
	 * public String toString() { return name;
	 * 
	 * }
	 */
}
