package pojoclasses;

public class User {
	/* Declaration */
	
	private String name;
	private String job;
	/* Initialization */
	public User() {
		
	}
	public User(String name, String job) {
		super();
		this.name = name;
		this.job = job;
	}
	/* Utilization */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}	
}
