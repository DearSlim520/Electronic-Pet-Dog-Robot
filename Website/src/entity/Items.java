package entity;

//��Ʒ��
public class Items {
    private String id; // ��Ʒ���
    private String name; // ��Ʒ����
    private int price; // ��Ʒ�۸�
    private String picture; // ��ƷͼƬ
    private String introduct;//��Ʒ����
	private int sum;//���ﳵÿ����Ʒ������
    private int sumprice;//���ﳵÿ����Ʒ��С�Ƽ۸�
    private int orderid;//������
    private String ordertime;//��������ʱ��

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