package cn.guimei_mall.entity;

public class All {

    public All() {

    }

    private BigClass bigClass;
    private Customer customer;

    private Goods goods;
    private Orderse orderse;
    private Seller seller;
    private ShoppingCar shoppingCar;
    private SmallClass smallClass;
    private SuperUser superUser;
    private double cheapPrice;

    public double getCheapPrice() {
        return cheapPrice;
    }

    public void setCheapPrice(double cheapPrice) {
        this.cheapPrice = cheapPrice;
    }

    public BigClass getBigClass() {
        return bigClass;
    }

    public void setBigClass(BigClass bigClass) {
        this.bigClass = bigClass;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }



    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
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

    public ShoppingCar getShoppingCar() {
        return shoppingCar;
    }

    public void setShoppingCar(ShoppingCar shoppingCar) {
        this.shoppingCar = shoppingCar;
    }

    public SmallClass getSmallClass() {
        return smallClass;
    }

    public void setSmallClass(SmallClass smallClass) {
        this.smallClass = smallClass;
    }

    public SuperUser getSuperUser() {
        return superUser;
    }

    public void setSuperUser(SuperUser superUser) {
        this.superUser = superUser;
    }
}
