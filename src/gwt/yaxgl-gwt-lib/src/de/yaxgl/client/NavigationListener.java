package de.yaxgl.client;

public interface NavigationListener {
	
	public boolean onClickForNextPage(String pageID);
	public boolean onClickForPreviousPage(String pageID);
	public void onClickForFinish(String pageID);
	
}
