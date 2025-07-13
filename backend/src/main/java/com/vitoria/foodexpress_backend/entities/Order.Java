@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private OrderStatus status = OrderStatus.PREPARING;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User client;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> items = new ArrayList<>();

    private LocalDateTime createdAt = LocalDateTime.now();

    // Enum para status do pedido
    public enum OrderStatus {
        PREPARING, ON_THE_WAY, DELIVERED
    }

    // Construtores, getters e setters
}