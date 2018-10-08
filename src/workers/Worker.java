package workers;

public abstract class Worker {
	protected String name;
	protected int salary;
	protected int productivity;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getProductivity() {
		return productivity;
	}

	public void setProductivity(int productivity) {
		this.productivity = productivity;
	}

	@Override
	public String toString() {
		return "Worker [name=" + name + ", salary=" + salary + ", productivity=" + productivity + "]";
	}
}
