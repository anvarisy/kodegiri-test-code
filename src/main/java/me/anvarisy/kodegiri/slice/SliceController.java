package me.anvarisy.kodegiri.slice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

@RestController
public class SliceController {

	@PostMapping("/slice")
	public Slice getSlice(@Valid @RequestBody Slice s) {
		String input = s.getInput();
		String sort = "";
		List<Integer> sum = new ArrayList<>();
		for(int i = 0; i<input.length(); i++) {
			int c = input.charAt(i);
			try{
				/*
				 * if(c+1 == input.charAt(i+1)) { char w = (char)c; sort +=
				 * Character.toString(w); }else { sum.add(sort.length()); sort = ""; }
				 */
				if(c-1 == input.charAt(i-1)) {
					sort += Character.toString((char)input.charAt(i));
				}else {
					sort+="";
				}
				sum.add(sort.length());
			}catch(IndexOutOfBoundsException e) {
				sort += Character.toString((char)input.charAt(i));
			}
			
		}
		return new Slice(input, Collections.max(sum));
	}
	
}
