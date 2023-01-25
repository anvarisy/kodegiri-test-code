package me.anvarisy.kodegiri.fibonacci;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
public class FibonacciController {
	
	@PostMapping("/fibonacci")
	public Fibonacci getFibonacci(@Valid @RequestBody Fibonacci f){
		int n1=0 , n2=1, n3, i, count=f.getInput(); 
		List<Integer> res = new ArrayList<>();
		res.add(n2);
		 for(i=2;i<Integer.MAX_VALUE;++i)  
		 {    
		  n3=n1+n2;
		  if(n3%2!=0) {
			  res.add(n3);
		  }
		  n1=n2;    
		  n2=n3;
		  if(res.size()==count) {
			  break;
		  }
		 }
		 Collections.sort(res, Collections.reverseOrder());
		 StringBuilder result = new StringBuilder();
		 for (int ires = 0; ires < res.size(); ires++) {
			 result.append(res.get(ires).toString()).append(" ");
		 }
		 return new Fibonacci(count, result.toString());
	}
}
