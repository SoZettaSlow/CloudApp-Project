package ie.cit.video.web;

import ie.cit.video.JdbcVideoRepository;
import ie.cit.video.Videostore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RequestMapping(value={"videostore", "productcatalog"})

@Controller
public class VideostoreController {

	@Autowired
	private JdbcVideoRepository repo;
	
	@RequestMapping(method = RequestMethod.GET)
	public void listVideostore(Model model) {
		model.addAttribute("videostore", repo.getAll());
	}

	@RequestMapping(method = RequestMethod.POST)
	public String addToBasket(Model model, @RequestParam String text, @RequestParam int stocknum){
		
		Videostore videostore = new Videostore();
		videostore.setText(text);
		videostore.setStocknum(stocknum);
		repo.save(videostore);
		model.addAttribute("videostore", repo.getAll());
		
		return "videostore";
	}
	
	@RequestMapping(value="videostore", method = RequestMethod.GET)
	public String returnToPage() {
		
		return "productcatalog";
		
	}
	
	
	@RequestMapping(method = RequestMethod.DELETE)
	public String deleteItem(Model model, @RequestParam int videoId) {

		repo.delete(videoId);
		model.addAttribute("videostore", repo.getAll());
		
		return "videostore";
		
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public String increaseStock(Model model, @RequestParam int videoId, @RequestParam int stocknum) {
		//System.out.println("dddd" +videoId+ " aaaa " +stocknum);
		Videostore videostore = repo.get(videoId);
		videostore.setStocknum(stocknum);
		
		repo.update(videostore);
		model.addAttribute("videostore", repo.getAll());
		
		return "videostore";
	}

}
