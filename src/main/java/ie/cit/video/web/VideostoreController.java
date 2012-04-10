package ie.cit.video.web;

import ie.cit.video.JdbcVideoRepository;
import ie.cit.video.Videostore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RequestMapping("videostore")
@Controller
public class VideostoreController {

	@Autowired
	private JdbcVideoRepository repo;
	
	@RequestMapping(method = RequestMethod.GET)
	public void listVideostore(Model model) {
		model.addAttribute("videostore", repo.getAll());
	}

	@RequestMapping(method = RequestMethod.POST)
	public void createVideo(Model model, @RequestParam String text, @RequestParam int stocknum){
		
		Videostore videostore = new Videostore();
		videostore.setText(text);
		videostore.setStocknum(stocknum);
		repo.save(videostore);
		model.addAttribute("videostore", repo.getAll());
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public void deleteVideo(Model model, @RequestParam int videostoreId) {
		repo.delete(videostoreId);
		model.addAttribute("videostore", repo.getAll());
		
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void increaseVideoStock(Model model, @RequestParam int videostoreId) {
		Videostore videostore = repo.get(videostoreId);
		int stocknum = videostore.getStocknum();
		
		//videostore.setStocknum(stocknum + 1);
		repo.update(videostore);
		model.addAttribute("videostore", repo.getAll());
	}
	/*
	@RequestMapping(method = RequestMethod.PUT)
	public void decreaseVideoStock(Model model, @RequestParam int videostoreId) {
		Videostore videostore = repo.get(videostoreId);
		int stocknum = videostore.getStocknum();
		
		videostore.setStocknum(stocknum -1);
		repo.update(videostore);
		model.addAttribute("videostore", repo.getAll());
	}*/


}
