package org.memoryextension.java.samples.basicwebapp.controllers;



import javax.validation.Valid;

import org.memoryextension.java.samples.basicwebapp.pojos.PingPong;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class AppController {

	static final String GLOBAL_MESSAGE = "globalMessage";
	static final String URL_FORM = "/pp/";

	
	//private static final Logger log = LoggerFactory.getLogger(AppController.class);
	
	// auto trim the fields
	// per http://stackoverflow.com/questions/2691667/can-spring-mvc-trim-all-strings-obtained-from-forms
	@InitBinder
	public void initBinder ( WebDataBinder binder ){
		StringTrimmerEditor stringtrimmer = new StringTrimmerEditor(true);
	    binder.registerCustomEditor(String.class, stringtrimmer);
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String hw(Model model){
		model.addAttribute("name","world");
		return "hw";
	}
	
	
	@RequestMapping(value=URL_FORM, method=RequestMethod.GET)
	public String showPPForm(Model model){
		model.addAttribute("pp",new PingPong(1,16));
		return "ppForm";
	}
	
	
	@RequestMapping(value={URL_FORM}, method=RequestMethod.POST,params={"!cancel","save"})
	public String ppComputer(@ModelAttribute("pp") @Valid PingPong pp, BindingResult result, Model model,RedirectAttributes redirect){
		model.addAttribute("pp",pp);
		return "ppResult";
	}
	
	
	
	@RequestMapping(value={URL_FORM}, method=RequestMethod.POST,params={"cancel","!save"})
	public String personEditCancel(RedirectAttributes redirect){
		redirect.addFlashAttribute(GLOBAL_MESSAGE, "Editing cancelled");
		return "redirect:/pp/";
	}
	
	
}
