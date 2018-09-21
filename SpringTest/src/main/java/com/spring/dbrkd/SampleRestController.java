package com.spring.dbrkd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.domain.SampleVo;

@RestController
@RequestMapping("/sample")
public class SampleRestController {
	
	//stuts 조작
	@RequestMapping("/sendErrorAuth")
	public ResponseEntity<Void> sendListAuth(){
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	//map
	@RequestMapping("/sendVOMap")
	public Map<Integer, SampleVo> sendVoMap(){
		Map<Integer, SampleVo> map = new HashMap<>();
		for(int i=0; i<10; i++){
			SampleVo vo = new SampleVo();
			vo.setFirstName("길동");
			vo.setLastName("홍");
			vo.setMno(i);
			
			map.put(i, vo);
		}
		return map;
	}
	
	//list
	@RequestMapping("/sendVOList")
	public List<SampleVo> sendVoList(){
		// 인터페이스 = 추상클래스
		List<SampleVo> list = new ArrayList<>();
		for(int i=0; i<10; i++){
			SampleVo vo = new SampleVo();
			vo.setFirstName("길동");
			vo.setLastName("홍");
			vo.setMno(i);
			
			list.add(vo);
			//list.get(i).getFirstName();(받을 시)
		}	
		return list;
	}

	//웹 브라우저 상태 코드
	@RequestMapping("/sendVOListErrorNot")
	public ResponseEntity<List<SampleVo>> sendVOListErrorNot(){
		// 인터페이스 = 추상클래스
		List<SampleVo> list = new ArrayList<>();
		for(int i=0; i<10; i++){
			SampleVo vo = new SampleVo();
			vo.setFirstName("길동");
			vo.setLastName("홍");
			vo.setMno(i);
			
			list.add(vo);
			//list.get(i).getFirstName();(받을 시)
		}	
		return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
	}
	
	//값 전송
	@RequestMapping("/sendVO")
	public SampleVo sendVO(){
		SampleVo vo = new SampleVo();
		vo.setFirstName("길동");
		vo.setLastName("홍");
		vo.setMno(123);
		
		return vo;
	}
	
	@RequestMapping("/hello")
	public String sayHello(){
		return("Hello REST API");
	}
}
