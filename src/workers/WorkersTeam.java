package workers;

public class WorkersTeam {
	private String name;
	private Helper[] helpers;
	private MidWorker[] midWorkers;
	private SeniorWorker[] seniorWorkers;

	public WorkersTeam(String name, Helper[] helpers, MidWorker[] midWorkers, SeniorWorker[] seniorWorkers) {
		super();
		this.name = name;
		this.helpers = helpers;
		this.midWorkers = midWorkers;
		this.seniorWorkers = seniorWorkers;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Helper[] getHelpers() {
		return helpers;
	}

	public void setHelpers(Helper[] helpers) {
		this.helpers = helpers;
	}

	public MidWorker[] getMidWorkers() {
		return midWorkers;
	}

	public void setMidWorkers(MidWorker[] midWorkers) {
		this.midWorkers = midWorkers;
	}

	public SeniorWorker[] getSeniorWorkers() {
		return this.seniorWorkers;
	}

	public void setSeniorWorkers(SeniorWorker[] seniorWorkers) {
		this.seniorWorkers = seniorWorkers;
	}

	public int getTotalProductivityPerHour() {
		int totalProductivity = 0;

		for (int i = 0; i < helpers.length; i++) {
			totalProductivity = totalProductivity + helpers[i].productivity;
		}

		for (int i = 0; i < midWorkers.length; i++) {
			totalProductivity = totalProductivity + midWorkers[i].productivity;
		}

		for (int i = 0; i < seniorWorkers.length; i++) {
			totalProductivity = totalProductivity + seniorWorkers[i].productivity;
		}
		return totalProductivity;
	}

	public int getTotalSalaryPerHour() {
		int totalSalary = 0;

		for (int i = 0; i < helpers.length; i++) {
			totalSalary = totalSalary + helpers[i].salary;
		}

		for (int i = 0; i < midWorkers.length; i++) {
			totalSalary = totalSalary + midWorkers[i].salary;
		}

		for (int i = 0; i < seniorWorkers.length; i++) {
			totalSalary = totalSalary + seniorWorkers[i].salary;
		}
		return totalSalary;
	}

}
