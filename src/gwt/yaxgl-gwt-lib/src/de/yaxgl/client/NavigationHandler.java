package de.yaxgl.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

import de.yaxgl.client.Container.Page;

public class NavigationHandler {
	
	private Map pageMap = new HashMap(); 
	private List listNavigationPages = new ArrayList();
	private List listStandalonePages = new ArrayList();
	private Page visiblePage = null;
	private static NavigationHandler instance = null;
	
	private NavigationListener navigationListener = null;
	
	private HorizontalPanel buttonPanel;
	private Button buttonPrevious = new Button("previous");
	private Button buttonNext = new Button("next");
	private Button buttonFinish = new Button("finish");

	
	private NavigationHandler() {
		buttonPanel = new HorizontalPanel();
		buttonPrevious.addClickListener(new ClickListener() {
			public void onClick(Widget sender) {
				setPreviousPage();
			}
		});
		buttonNext.addClickListener(new ClickListener() {
			public void onClick(Widget sender) {
				setNextPage();
			}
		});
		buttonFinish.addClickListener(new ClickListener() {
			public void onClick(Widget sender) {
				setFinish();
			}
		});
		buttonPanel.add(buttonPrevious);
		buttonPanel.add(buttonNext);
		buttonPanel.add(buttonFinish);
	}
	
	
	public static NavigationHandler getInstance() {
		if (instance==null)
			instance = new NavigationHandler();
		return instance;
	}
	
	
	public void addPage(Page page) {
		pageMap.put(page.getID(), page);
		if (page.isPageWithNavigation())
			listNavigationPages.add(page);
		else
			listStandalonePages.add(page);
	}
	
	
	
	public void startNavigation() {
		setVisiblePage( (Page)listNavigationPages.get(0) );
	}
	
	public String getVisiblePageID() {
		return visiblePage.getID();
	}

	public void setVisiblePageByID(String pageID) {
		Page page = (Page)pageMap.get(pageID);
		setVisiblePage(page);
	}
	
	public void setVisiblePage(Page page) {
		if(visiblePage!=null)
			visiblePage.setPageVisible(false);
		visiblePage = page;
		visiblePage.setPageVisible(true);
		
		
		
		
		if (page.isPageWithNavigation()) {
			// change Position of the buttonPanel depending on current page size
			RootPanel.get().add(buttonPanel, 100, (visiblePage.getNativeComponent().getAbsoluteTop()+visiblePage.getNativeComponent().getOffsetHeight()));
			buttonPanel.setVisible(true);
			
			// if the new page is the first page
			if (((Page)listNavigationPages.get(0)).equals(page)) {
				//isFirstPage = true;
				buttonPrevious.setEnabled(false);
			}
			else {
				//isFirstPage = false;
				buttonPrevious.setEnabled(true);
			}
			
			// if the new page is the last page
			if (((Page)listNavigationPages.get(listNavigationPages.size()-1)).equals(page)) {
				//isLastPage = true;
				buttonNext.setEnabled(false);
				buttonFinish.setEnabled(true);
			}
			else {
				//isLastPage = false;
				buttonNext.setEnabled(true);
				buttonFinish.setEnabled(false);
			}
		}
		else {
			buttonPanel.setVisible(false);
		}
		
		
	}
	
	
	
	public void setNextPage() {
		if (navigationListener!=null)
			if (!navigationListener.onClickForNextPage(visiblePage.getID()))
				return;
		//if(!isLastPage) {
			int index = listNavigationPages.indexOf(visiblePage) + 1;
			setVisiblePage( (Page)listNavigationPages.get(index) );
	}
	
	public void setPreviousPage() {
		if (navigationListener!=null)
			if (!navigationListener.onClickForPreviousPage(visiblePage.getID()))
				return;
		//if(!isFirstPage) {
			int index = listNavigationPages.indexOf(visiblePage) - 1;
			setVisiblePage( (Page)listNavigationPages.get(index) );
	}
	
	public void setFinish() {
		if (navigationListener!=null)
			navigationListener.onClickForFinish(visiblePage.getID());
	}
	
	
	
	
	public void removeNavigationListener() {
		navigationListener = null;
	}
	public void setNavigationListener(NavigationListener navigationListener) {
		this.navigationListener = navigationListener;
	}
	
	
}
