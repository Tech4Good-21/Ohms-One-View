package com.pbma.oneview.pojo;

import java.time.LocalDate;
import java.util.Objects;

public class AssesmentDetails {
	private int id;
	private String trainingStatus;
	private double attendance;
	private boolean assessmentConducted;
	private boolean certified;
	private LocalDate dateOfPassing;
	private LocalDate dateOfCertification;
	private String certificateName;
	private double grade;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTrainingStatus() {
		return trainingStatus;
	}
	public void setTrainingStatus(String trainingStatus) {
		this.trainingStatus = trainingStatus;
	}
	public double getAttendance() {
		return attendance;
	}
	public void setAttendance(double attendance) {
		this.attendance = attendance;
	}
	public boolean isAssessmentConducted() {
		return assessmentConducted;
	}
	public void setAssessmentConducted(boolean assessmentConducted) {
		this.assessmentConducted = assessmentConducted;
	}
	public boolean isCertified() {
		return certified;
	}
	public void setCertified(boolean certified) {
		this.certified = certified;
	}
	public LocalDate getDateOfPassing() {
		return dateOfPassing;
	}
	public void setDateOfPassing(LocalDate dateOfPassing) {
		this.dateOfPassing = dateOfPassing;
	}
	public LocalDate getDateOfCertification() {
		return dateOfCertification;
	}
	public void setDateOfCertification(LocalDate dateOfCertification) {
		this.dateOfCertification = dateOfCertification;
	}
	public String getCertificateName() {
		return certificateName;
	}
	public void setCertificateName(String certificateName) {
		this.certificateName = certificateName;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "AssesmentDetails [id=" + id + ", trainingStatus=" + trainingStatus + ", attendance=" + attendance
				+ ", assessmentConducted=" + assessmentConducted + ", certified=" + certified + ", dateOfPassing="
				+ dateOfPassing + ", dateOfCertification=" + dateOfCertification + ", certificateName="
				+ certificateName + ", grade=" + grade + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(assessmentConducted, attendance, certificateName, certified, dateOfCertification,
				dateOfPassing, grade, id, trainingStatus);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AssesmentDetails other = (AssesmentDetails) obj;
		return assessmentConducted == other.assessmentConducted
				&& Double.doubleToLongBits(attendance) == Double.doubleToLongBits(other.attendance)
				&& Objects.equals(certificateName, other.certificateName) && certified == other.certified
				&& Objects.equals(dateOfCertification, other.dateOfCertification)
				&& Objects.equals(dateOfPassing, other.dateOfPassing)
				&& Double.doubleToLongBits(grade) == Double.doubleToLongBits(other.grade) && id == other.id
				&& Objects.equals(trainingStatus, other.trainingStatus);
	}
	
	}
