package com.eteam.web03.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SampleMapper {
	void insertSample(String sampleName);
}
