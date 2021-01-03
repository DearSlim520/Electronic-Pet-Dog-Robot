package entity;

//商品类
public class Items {
    private String id; // 商品编号
    private String name; // 商品名称
    private String city; // 商品产地
    private int price; // 商品价格
    private int number; // 商品数量
    private String picture; // 商品图片
    private int sum;
    private int sumprice;
    private int orderid;

    public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public int getSumprice() {
		return sumprice;
	}

	public void setSumprice(int sumprice) {
		this.sumprice = sumprice;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}