package model.entities;

import model.exceptions.DomainException;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reservation {
    private Integer roomNumber;
    private LocalDate checkIn;
    private LocalDate checkOut;

    private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Reservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut) {
        if (!checkOut.isAfter(checkIn)) {
            throw new DomainException("Check-out date must be after check-in date");
        }
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public long duration() {
        Duration diff = Duration.between(checkIn.atTime(0, 0), checkOut.atTime(0, 0));
        return diff.toDays();
    }

    public void updateDates(LocalDate checkIn, LocalDate checkOut) { //pode lancar a excecao e programa principal que trata no catch
        LocalDate now = LocalDate.now();
        if (checkIn.isBefore(now) || checkOut.isBefore(now)) {
            throw new DomainException("Reservation dates for update must be future dates");
        }
        if (!checkOut.isAfter(checkIn)) {
            throw new DomainException("Check-out date must be after check-in date");
        }
        this.checkIn = checkIn; // recendo na classe o valor que veio do argumento
        this.checkOut = checkOut;
    }

    @Override
    public String toString(){
        return "Room "
                + roomNumber
                + ", checkIn: "
                + fmt.format(checkIn)
                + ", check-out: "
                + fmt.format(checkOut)
                + ", "
                + duration()
                + " nights";
    }
}
