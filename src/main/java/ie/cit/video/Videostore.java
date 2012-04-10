package ie.cit.video;

public class Videostore {
	
	private int id;
	private String text;
	private int stocknum;
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStocknum() {
		return stocknum;
	}

	public void setStocknum(int stocknum) {
		this.stocknum = stocknum;
	}

}
