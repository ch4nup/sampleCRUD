package com.eteam.web03.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eteam.web03.service.SampleService;
import com.eteam.web03.vo.Sample;

@Controller
public class SampleController {
	@Autowired 
	private SampleService sampleService;
	
	
	// 1. 입력폼 - 포워드방식으로 addSample.html 화면 출력
	@GetMapping("/addSample")
	public String addSample() {
		return "addSample";	//view 이름은 template폴더의 addSample.html, 포워드
	}
	
	// 2. 입력 액션 - insert처리과정 후 리다이렉트방식으로 sampleList으로 이동
	@PostMapping
	public String addSample(@RequestParam(value="sampleName") String sampleName) {
		
		int result = sampleService.addSample(sampleName);
		if(result == 0) {
			return "redirect:/sampleList";	//리다이렉트
		} else {
			return "redirect:/addSample";
		}
	}
	
	// 3. 목록 - selectList처리과정 후 포워드방식으로 sampleList.html화면 출력
	@GetMapping("sampleList")
	public String sampleList(Model model) {
		List<Sample> listSample = sampleService.getSampleList();
		model.addAttribute("listSample", listSample);
		return "sampleList";
	}
	
	// 4. 삭제 액션
	@GetMapping
	public String deleteSample(@RequestParam(value="sampleId") int sampleId) {
		System.out.println(sampleId + "<-sampleId deleteSample.SampleController");
		
		int result = sampleService.removeSample(sampleId);
		if(result == 0) {
			return "redirect:/sampleList";
		} else {
			return "redirect:/sampleList";
		}
		
	}
	
	// 5. 수정 폼
	
	// 6. 수정 액션
}
