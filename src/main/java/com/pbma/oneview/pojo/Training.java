package com.pbma.oneview.pojo;

import java.util.Objects;

public class Training {

	public int trainingId;
	private String trainingName;
	private String trainingAddress;
	private String trainingLocation;
	private Batch batch;
	
	public int getTrainingId() {
		return trainingId;
	}
	public Batch getBatch() {
		return batch;
	}
	public void setBatch(Batch batch) {
		this.batch = batch;
	}
	public void setTrainingId(int trainingId) {
		this.trainingId = trainingId;
	}
	public String getTrainingName() {
		return trainingName;
	}
	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
	}
	public String getTrainingAddress() {
		return trainingAddress;
	}
	public void setTrainingAddress(String trainingAddress) {
		this.trainingAddress = trainingAddress;
	}
	public String getTrainingLocation() {
		return trainingLocation;
	}
	public void setTrainingLocation(String trainingLocation) {
		this.trainingLocation = trainingLocation;
	}
	
	@Override
	public String toString() {
		return "Training [trainingId=" + trainingId + ", trainingName=" + trainingName + ", trainingAddress="
				+ trainingAddress + ", trainingLocation=" + trainingLocation + ", batch=" + batch + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(batch, trainingAddress, trainingId, trainingLocation, trainingName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Training other = (Training) obj;
		return Objects.equals(batch, other.batch) && Objects.equals(trainingAddress, other.trainingAddress)
				&& trainingId == other.trainingId && Objects.equals(trainingLocation, other.trainingLocation)
				&& Objects.equals(trainingName, other.trainingName);
	}
	
}
