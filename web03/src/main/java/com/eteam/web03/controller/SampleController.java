package com.eteam.web03.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.eteam.web03.service.SampleService;
import com.eteam.web03.vo.Sample;

@Controller
public class SampleController {
	@Autowired 
	private SampleService sampleService;
	@Autowired 
	private Sample sample;
	
	// 1. 입력폼 - 포워드방식으로 addSample.html 화면 출력
	@GetMapping("/addSample")
	public String addSample() {
		return "addSample";	//view 이름은 template폴더의 addSample.html, 포워드
	}
	
	// 2. 입력 액션 - 화면에서 보낸 sampleName값 받기, insert처리과정 후 리다이렉트방식으로 sampleList으로 이동
	@PostMapping
	public String addSample(@RequestParam(value="sampleName") String sampleName) {
		sample.setSampleName(sampleName);
		int result = sampleService.addSample(sample);
		if(result == 0) {
			System.out.println("등록 완료");
		} else {
			System.out.println("등록 실패");
		}
		return "redirect:/sampleList"; //리다이렉트
	}
	
	// 3. 목록 - selectList처리과정 후 포워드방식으로 sampleList.html화면 출력
	@GetMapping("sampleList")
	public String sampleList(Model model) {
		List<Sample> listSample = sampleService.getSampleList();
		model.addAttribute("listSample", listSample);
		if(listSample != null) {
			System.out.println("리스트 처리 완료");
		} else {
			System.out.println("리스트 처리 실패");
		}
		return "sampleList";
	}
	
	// 4. 삭제 액션 - 화면에서 보낸 sampleId값 받기, SampleService객체 내 removeSample메서드 호출, delete처리 후 sampleList로 이동
	@GetMapping
	public String deleteSample(@RequestParam(value="sampleId") int sampleId) {
		System.out.println(sampleId + "<-sampleId deleteSample.SampleController");
		sample.setSampleId(sampleId);
		int result = sampleService.removeSample(sample);
		if(result == 0) {
			System.out.println("삭제 완료");
		} else {
			System.out.println("삭제 실패");
		}
		return "redirect:/sampleList";
	}
	
	// 5. 수정 폼
	
	// 6. 수정 액션
}
