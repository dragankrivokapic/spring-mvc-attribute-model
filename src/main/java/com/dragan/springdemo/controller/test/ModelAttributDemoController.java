package com.dragan.springdemo.controller.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dragan.springdemo.domain.Address;

@Controller
public class ModelAttributDemoController {

    private static Logger LOOGER = LoggerFactory.getLogger(ModelAttributDemoController.class);

    @RequestMapping("/home")
    public String home() {
	LOOGER.info("Inside home: " + System.currentTimeMillis());
	return "modelAttributeHome";
    }

    // version 2 of our home method
    @RequestMapping("/home2")
    public ModelAndView home2() {
	ModelAndView mav = new ModelAndView();
	mav.setViewName("modelAttributeHome");
	mav.addObject("command", new Address());
	return mav;
    }

    // version 3 of our home method
    @RequestMapping("/home3")
    public ModelAndView home3() {
	ModelAndView mav = new ModelAndView("modelAttributeHome");
	mav.addObject("anAddress", new Address());
	return mav;
    }

    // version 4 of our home method
    @RequestMapping("/home4")
    public ModelAndView home4() {
	return new ModelAndView("modelAttributeHome", "anAddress", new Address("Los Angeles", "2565"));
    }

    // version 5 of our home method
    @RequestMapping("/home5")
    public String home5(Model model) {
	model.addAttribute("anAddress", new Address("Bangladesh", "8585"));
	return "modelAttributeHome";
    }

    /*
     * Test series to determine the nature of the @ModelAttribute annotaion (on
     * a method)
     */

    // Test 1: Demonstrating the usage of @ModelAttribute annotation (on a
    // method)
    // to add multiple attributes
    @ModelAttribute
    public void modelAttributeTest1(Model model) {
	LOOGER.info("Inside modelAttributeTest1" + System.currentTimeMillis());
	model.addAttribute("testdata1A", "Welcome to the @ModelAttribute test bed!");
	model.addAttribute("testdata1B",
		"We will test both usages of the @ModelAttribute, on methods and on method arguments.");

    }

    // Demonstrating the usage of the 'name' attribute of the
    // @ModelAttributeannotation (on method)
    @ModelAttribute("testdata2")
    public String modelAttributeTest2() {
	LOOGER.info("Inside modelAttributeTest2");
	return "We will conduct a series of test here.";
    }

    // Test 3: Demonstrating the usage of the @ModelAttribute annotation (on a
    // method) to implicity add an attribute
    // by returning it and also demonstrating the usage of the 'value' attribute
    // of the @ModelAttribute annotation (on a method)
    @ModelAttribute(value = "testdata3")
    public Address modelAttributeTest3() {
	LOOGER.info("Inside test3");
	return new Address("Lovcenac", "24322");
    }

    // Test 4: Demonstrate the default naming strategy of the @ModelAttribute
    // annotation (on a method
    @ModelAttribute
    public Address modelAttributeTest4() {
	LOOGER.info("Inside test 4");
	return new Address("Beograd", "11000");
    }

    // test 5: Testing @ModelAttribute with 'value' attribute and default
    // binding
    @RequestMapping(value = "/test5", method = RequestMethod.POST)
    public String modelAttributeTest5(@ModelAttribute(value = "anAddress") Address anAddress, ModelMap model) {
	model.addAttribute("testdata5", anAddress.getCity());
	model.addAttribute("testdada5", anAddress.getZipCode());
	return "modelAttributeTest";

    }

}
