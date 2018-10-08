import buildings.Building;
import workers.WorkersTeam;

public class DevelopmentPlan {
	private Building building;
	WorkersTeam workersTeam;

	public DevelopmentPlan(Building building, WorkersTeam workersTeam) {
		this.building = building;
		this.workersTeam = workersTeam;
	}

	public int getConstructionTime() {
		return (building.getManHoursFloor() * building.getFlorosCount())
				/ (workersTeam.getTotalProductivityPerHour() * 8);
	}

	public int getMaterialsCost() {
		return building.getFloorCost() * building.getFlorosCount();
	}

	public int getDevelopmentCost() {
		return getConstructionTime() + workersTeam.getTotalSalaryPerHour();
	}
}
