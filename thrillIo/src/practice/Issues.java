package practice;

public class Issues {

	String issueName;

	public String getIssueName() {
		return issueName;
	}

	public void setIssueName(String issueName) {
		this.issueName = issueName;
	}

	public Issues(String issueName) {
		super();
		// TODO Auto-generated constructor stub
		  this.issueName = issueName;

	}

	public void resolveIssueEnum(Severity level)
	 {
	  System.out.println("Resolving "+issueName+ " of "+level.name());
	 }
	 
	 public void resolveIssueClass(String level)
	 {
	  System.out.println("Resolving "+issueName+ " of "+level);
	  System.gc();
	 }
	 
	
}
