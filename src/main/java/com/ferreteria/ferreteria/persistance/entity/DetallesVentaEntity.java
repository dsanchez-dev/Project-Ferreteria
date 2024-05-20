package com.ferreteria.ferreteria.persistance.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "detalles_venta")
public class DetallesVentaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_detalle", nullable = false)
    private Integer idDetalle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_venta")
    private VentasEntity venta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_producto")
    private ProductosEntity producto;

    @Column(name = "Cantidad")
    private Integer cantidad;

    @Column(name = "precio_unitario")
    private Double precioUnitario;

    @Column(name = "Subtotal")
    private Double subtotal;

    @Override
    public String toString() {
        return "DetallesVentaEntity{" +
                "idDetalle=" + idDetalle +
                ", venta=" + venta +
                ", producto=" + producto +
                ", cantidad=" + cantidad +
                ", precioUnitario=" + precioUnitario +
                ", subtotal=" + subtotal +
                '}';
    }
}
