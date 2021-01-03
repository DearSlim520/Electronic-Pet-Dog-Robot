package entity;

//商品类
public class Items {
    private String id; // 商品编号
    private String name; // 商品名称
    private int price; // 商品价格
    private String picture; // 商品图片
    private String introduct;//商品介绍
	private int sum;//购物车每种商品的数量
    private int sumprice;//购物车每种商品的小计价格
    private int orderid;//订单号
    private String ordertime;//订单生成时间

    public String getIntroduct() {
		return introduct;
	}

	public String getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(String ordertime) {
		this.ordertime = ordertime;
	}

	public void setIntroduct(String introduct) {
		this.introduct = introduct;
	}

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

  

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}