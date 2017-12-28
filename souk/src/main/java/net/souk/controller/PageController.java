package net.souk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.soukBackend.dao.CategoryDAO;
import net.soukBackend.dto.Category;

@Controller
public class PageController {
	
	
	@Autowired 
	private CategoryDAO categoryDAO;

	@RequestMapping(value={"/","home","index"})
	public ModelAndView index(){
		ModelAndView mv  = new ModelAndView("page");
		
		// passing the list of categories 
		mv.addObject("categories",categoryDAO.list());
		mv.addObject("title","Home");
		mv.addObject("userClickedHome",true);
		return mv;
	}
	
	@RequestMapping(value="/about")
	public ModelAndView about(){
		ModelAndView mv  = new ModelAndView("page");
		mv.addObject("title","About us");
		mv.addObject("userClickedAbout",true);
		return mv;
	}
	
	
	@RequestMapping(value="/contact")
	public ModelAndView contact(){
		ModelAndView mv  = new ModelAndView("page");
		mv.addObject("title","Contact");
		mv.addObject("userClickedContact",true);
		return mv;
	}
	
	
	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts() {		
		ModelAndView mv = new ModelAndView("page");		
		mv.addObject("title","All Products");
		
		//passing the list of categories
		mv.addObject("categories", categoryDAO.list());
		
		mv.addObject("userClickedAllProducts",true);
		return mv;				
	}	
	
	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {		
		ModelAndView mv = new ModelAndView("page");
		
		// categoryDAO to fetch a single category
		Category category = null;
		
		category = categoryDAO.get(id);
		
		mv.addObject("title",category.getName());
		
		//passing the list of categories
		mv.addObject("categories", categoryDAO.list());
		
		// passing the single category object
		mv.addObject("category", category);
		
		mv.addObject("userClickedCategoryProducts",true);
		return mv;				
	}

}




//@RequestMapping(value={"/test"})
//public ModelAndView test(@RequestParam(value = "greeting" ,required = false)String greeting){
//	
//	if(greeting  == null ){
//		greeting  = "default value";
//	}
//	ModelAndView mv  = new ModelAndView("page");
//	mv.addObject("greeting",greeting);
//	return mv;
//}
//
//@RequestMapping(value={"/test/{greeting}"})
//public ModelAndView test(@PathVariable("greeting")String greeting){
//	if(greeting  == null ){
//		greeting  = "default value";
//	}
//	ModelAndView mv  = new ModelAndView("page");
//	mv.addObject("greeting",greeting);
//	return mv;
//}
