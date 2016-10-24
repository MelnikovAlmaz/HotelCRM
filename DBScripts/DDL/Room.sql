CREATE TABLE Room(
id SERIAL PRIMARY KEY,
number integer unique not null,
hotelId integer NOT NULL,
categoryId integer NOT NULL,
constraint hotel_fk FOREIGN KEY (hotelId) REFERENCES Hotel (id),
constraint category_fk FOREIGN KEY (categoryId) REFERENCES RoomCategory (id)
)