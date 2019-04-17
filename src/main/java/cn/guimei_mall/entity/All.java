package cn.guimei_mall.entity;

/**
 *所有
 */
public class All extends SmallClass {
    private BigClass bigclass;
    private Announcement announcement;
    private CustomerNew customer;
    private Discount discount;
    private GoodsNew goods;
    private Orderse orderse;
    private Seller seller;
    private ShoppingCar shoppingcar;
    private SuperUser superuser;
    private double cheapPrice;
    private double allCheapPrice;
    private double allPrice;

    public BigClass getBigclass() {
        return bigclass;
    }

    public void setBigclass(BigClass bigclass) {
        this.bigclass = bigclass;
    }

    public Announcement getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(Announcement announcement) {
        this.announcement = announcement;
    }

    public CustomerNew getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerNew customer) {
        this.customer = customer;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public GoodsNew getGoods() {
        return goods;
    }

    public void setGoods(GoodsNew goods) {
        this.goods = goods;
    }

    public Orderse getOrderse() {
        return orderse;
    }

    public void setOrderse(Orderse orderse) {
        this.orderse = orderse;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public ShoppingCar getShoppingcar() {
        return shoppingcar;
    }

    public void setShoppingcar(ShoppingCar shoppingcar) {
        this.shoppingcar = shoppingcar;
    }

    public SuperUser getSuperuser() {
        return superuser;
    }

    public void setSuperuser(SuperUser superuser) {
        this.superuser = superuser;
    }

    public double getCheapPrice() {
        return cheapPrice;
    }

    public void setCheapPrice(double cheapPrice) {
        this.cheapPrice = cheapPrice;
    }

    public double getAllCheapPrice() {
        return allCheapPrice;
    }

    public void setAllCheapPrice(double allCheapPrice) {
        this.allCheapPrice = allCheapPrice;
    }

    public double getAllPrice() {
        return allPrice;
    }

    public void setAllPrice(double allPrice) {
        this.allPrice = allPrice;
    }
}
