package toDoList;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;

import ui.ListElementPanel;

public abstract class ListElement implements Serializable {
	private Date creationDate, finishDate;
	private boolean finished;
	private final String name;
	private ListElementPanel panel;
	protected static DateFormat DATE_FORMATTER = new SimpleDateFormat("HH:mm dd/MM/yyyy");
	
	public ListElement(String name) {
		this.name = name;
		creationDate = new Date();
        try {
            creationDate = DATE_FORMATTER.parse(DATE_FORMATTER.format(creationDate));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        finished = false;
	}



	public Date getFinishDate() {
		return finishDate;
	}

	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
		if(finished) {
            try {
                finishDate = DATE_FORMATTER.parse(DATE_FORMATTER.format(new Date()));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }


            if(panel != null) {
				System.out.println("marking as finished...");
				panel.setFinished(finishDate);
				}
			
		}
		else {
			finishDate = null;
			if(panel!= null) { 
				System.out.println("marking as unfinished...");
				panel.clearFinishState();
				}
		}
	}

	public void setFinished(String finishDate){
		if(finishDate.equals("P")){
			this.setFinished(false);
		}
		else{
            Date finished = null;
            try {
                finished = DATE_FORMATTER.parse(finishDate);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }

            this.finishDate = finished;
			if(panel != null){
				panel.setFinished(this.finishDate);
			}
			this.finished = true;
		}
	}


	public Date getCreationDate() {
		return creationDate;
	}

	public String getName() {
		return name;
	}

	public ListElementPanel getPanel() {
		return panel;
	}
	
	public void setPanel(ListElementPanel panel) {
		this.panel = panel;
	}


	@Override
	public String toString() {
		String name = this.getName();
		String creationDate = DATE_FORMATTER.format(this.getCreationDate());
		String finishDate = "P";
		if(this.isFinished()) {
			finishDate = DATE_FORMATTER.format(this.getFinishDate());
		}
		return String.format("{[%s][%s]%s}", creationDate,finishDate,name);
		
	}
	public void setCreationDate(Date date){
		this.creationDate = date;
	}
	
}
