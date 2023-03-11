package project.mypr.web.jdbc;

import java.util.Date;

public class PrsnRecord {
	private long id;
	private String exerciseName;
	private int weights;
	private int sets;
	private int reps;
	private int volume;
	private Date date;
	
	public PrsnRecord(long id, String exerciseName, int weights, int sets, int reps, Date date) {
		super();
		this.id = id;
		this.exerciseName = exerciseName;
		this.weights = weights;
		this.sets = sets;
		this.reps = reps;
		this.volume = sets*reps*weights;
		this.date = date;
	}
	
	public PrsnRecord(String exerciseName, int weights, int sets, int reps, Date date) {
		super();
		this.exerciseName = exerciseName;
		this.weights = weights;
		this.sets = sets;
		this.reps = reps;
		this.volume = sets*reps*weights;
		this.date = date;
	}
	
	public PrsnRecord(String exerciseName, int weights, int sets, int reps) {
		super();
		this.exerciseName = exerciseName;
		this.weights = weights;
		this.sets = sets;
		this.reps = reps;
		this.volume = sets*reps*weights;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getExerciseName() {
		return exerciseName;
	}
	
	public void setExerciseName(String exerciseName) {
		this.exerciseName = exerciseName;
	}
	
	public int getSets() {
		return sets;
	}
	
	public void setSets(int sets) {
		this.sets = sets;
	}
	
	public int getReps() {
		return reps;
	}
	
	public void setReps(int reps) {
		this.reps = reps;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}
	
	public int getWeights() {
		return weights;
	}

	public void setWeights(int weights) {
		this.weights = weights;
	}
}
