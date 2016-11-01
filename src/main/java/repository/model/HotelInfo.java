package repository.model;

import entity.Hotel;

public class HotelInfo extends Hotel{
    private Integer price;

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
