package entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private LocalDateTime moment;
    private OrderStatus status;
    private Client client;
    private List<OrderItem> items = new ArrayList<>();

    public Order(){}

    public Order(LocalDateTime moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public LocalDateTime getMoment() {
        return moment;
    }

    public void setMoment(LocalDateTime moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void addItems(OrderItem item) {
        items.add(item);
    }

    public void removeItems(OrderItem item) {
        items.remove(item);
    }

    public Double total() {
        double sum = 0.0;

        for (OrderItem item : items) {
            sum += item.subTotal();
        }

        return sum;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (OrderItem item : items) {
            sb.append(item.getProduct().getName()
                    + ", $"
                    + String.format("%.2f",item.getPrice())
                    + ", Quantity: "
                    + item.getQuantity()
                    + ", Subtotal: $"
                    + String.format("%.2f",item.subTotal())
                    + "\n"
            );
        }
        sb.append("\nTotal price: $" + String.format("%.2f", total()));
        return sb.toString();
    }
}
