package com.eteam.web03.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eteam.web03.mapper.SampleMapper;
import com.eteam.web03.vo.Sample;

@Service
public class SampleService {
	@Autowired 
	private SampleMapper sampleMapper;
	
	//SampleMapper객체 내 selectSampleList메서드 호출
	public List<Sample> getSampleList() {
		List<Sample> listSample = sampleMapper.selectSampleList();
		return listSample;
	}
	
	public List<Sample> getSampleOne() {
		return null;
	}
	
	//SampleMapper객체 내 insertSample메서드 호출
	public int addSample(String sampleName) {
		sampleMapper.insertSample(sampleName);
		return 0;
	}
	
	public int removeSample(int sampleId) {
		sampleMapper.deleteSample(sampleId);
		return 0;
	}
	
	public int modifySample(Sample sample) {
		return 0;
	}
}
