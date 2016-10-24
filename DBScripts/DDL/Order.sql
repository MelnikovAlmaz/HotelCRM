CREATE TABLE "Order"(
id SERIAL PRIMARY KEY,
orderTime timestamp not null,
arrivalTime timestamp not null,
departureTime timestamp not null,
clientId integer NOT NULL,
roomId integer NOT NULL,
constraint client_fk FOREIGN KEY (clientId) REFERENCES Client (id) ON DELETE SET NULL ON UPDATE CASCADE,
constraint room_fk FOREIGN KEY (roomId) REFERENCES Room (id) ON DELETE SET NULL ON UPDATE CASCADE
)