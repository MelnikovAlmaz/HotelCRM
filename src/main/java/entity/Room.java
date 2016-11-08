package entity;

public class Room {
    private Integer id;
    private Integer number;
    private Boolean isCleaned;
    private Boolean isAvailable;
    private Hotel hotel;
    private RoomCategory category;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Boolean getCleaned() {
        return isCleaned;
    }

    public void setCleaned(Boolean cleaned) {
        isCleaned = cleaned;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public RoomCategory getCategory() {
        return category;
    }

    public void setCategory(RoomCategory category) {
        this.category = category;
    }
}
