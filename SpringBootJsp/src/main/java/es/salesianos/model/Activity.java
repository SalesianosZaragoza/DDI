package es.salesianos.model;

public class Activity {
	
	private Integer aforo;
	private String activityName;
	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	public Integer getAforo() {
		return aforo;
	}
	public void setAforo(Integer aforo) {
		this.aforo = aforo;
	}
	
	@Override
	public String toString() {
		return "aforo:"+aforo+" name"+activityName;
	}

}
