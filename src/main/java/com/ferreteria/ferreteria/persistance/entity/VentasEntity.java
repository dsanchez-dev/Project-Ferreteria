package com.ferreteria.ferreteria.persistance.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Ventas")
public class VentasEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_venta", nullable = false)
    private Integer idVenta;

    @ManyToOne
    @JoinColumn(name = "Id_cliente")
    private ClientesEntity cliente;

    @Column(name = "Fecha")
    private LocalDateTime fecha;

    @Column(name = "Total")
    private Double total;

    @OneToMany(mappedBy = "venta")
    private List<DetallesVentaEntity> DetallesVenta;

    @Override
    public String toString() {
        return "VentasEntity{" +
                "idVenta=" + idVenta +
                ", cliente=" + cliente +
                ", fecha=" + fecha +
                ", total=" + total +
                '}';
    }
}

