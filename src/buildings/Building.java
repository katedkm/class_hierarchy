package buildings;

public abstract class Building {
	protected int florosCount;
	protected int floorCost;
	protected int manHoursFloor;

	public int getFlorosCount() {
		return florosCount;
	}

	public void setFlorosCount(int florosCount) {
		this.florosCount = florosCount;
	}

	public int getFloorCost() {
		return floorCost;
	}

	public void setFloorCost(int floorCost) {
		this.floorCost = floorCost;
	}

	public int getManHoursFloor() {
		return manHoursFloor;
	}

	public void setManHoursFloor(int manHoursFloor) {
		this.manHoursFloor = manHoursFloor;
	}

	@Override
	public String toString() {
		return "Building [florosCount=" + florosCount + ", floorCost=" + floorCost + ", manHoursFloor=" + manHoursFloor
				+ "]";
	}
}
