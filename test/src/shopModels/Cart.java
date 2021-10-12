package shopModels;

public class Cart {
	private String userId; // 구입한 유저 id
	private String itemName; // 구입한 item
	
	public Cart(String userId, String itemName) {
		this.userId=userId;
		this.itemName=itemName;
	}
	
	public String getUserId() {
		return this.userId;
	}
	public String getItemName() {
		return this.itemName;
	}
	public void setUserId(String userI) {
		this.userId = userId;
	}
	public void setItemName(String itemName){
		this.itemName = itemName;
	}

}
