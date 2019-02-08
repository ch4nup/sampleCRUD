package com.eteam.web03.vo;

public class Sample {
	private int sampleId; //sample.sample_id
	private String smapleName;
	
	public int getSampleId() {
		return sampleId;
	}
	public void setSampleId(int sampleId) {
		this.sampleId = sampleId;
	}
	public String getSmapleName() {
		return smapleName;
	}
	public void setSmapleName(String smapleName) {
		this.smapleName = smapleName;
	}
	@Override
	public String toString() {
		return "Sample [sampleId=" + sampleId + ", smapleName=" + smapleName + "]";
	}
}
