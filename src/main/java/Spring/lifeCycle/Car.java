package Spring.lifeCycle;

public class Car {
    private String brand;
    private double price;

    public Car() {
        System.out.println("=========>1.调用构造器创建bean对象");
    }
    /*
    * 初始化方法
    * 需要用init-method来指定初始化方法
    * */
    public void init(){
        System.out.println("=========>3.调用初始化方法");
    }

    /*
    * 销毁方法：IOC容器关闭，bean对象被销毁
    * */
    public void destroy(){
        System.out.println("=========>5.调用销毁方法");
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        System.out.println("=========>2.调用set方法给对象属性赋值");
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
