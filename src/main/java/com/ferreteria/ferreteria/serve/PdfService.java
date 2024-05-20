package com.ferreteria.ferreteria.serve;

import com.ferreteria.ferreteria.persistance.entity.ProductosEntity;
import com.ferreteria.ferreteria.persistance.entity.VentasEntity;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.UnitValue;
import com.itextpdf.layout.element.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class PdfService {

    private final ProductosService productosService;

    @Autowired
    public PdfService(ProductosService productosService) {
        this.productosService = productosService;
    }


    public byte[] generarTicket(VentasEntity venta) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter writer = new PdfWriter(baos);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);

        // Agrega la información de la ferretería
        document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
        Text text = new Text("Ferreteria Zapata Xicohtzinco Tlaxcala").setBold();
        Paragraph paragraph = new Paragraph(text);
        document.add(paragraph);
        document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
        document.add(new Paragraph(new Text("Agradece su preferencia! Estimado(a) " + venta.getCliente().getNombre() + ", aquí está su ticket de compra:").setBold()));
        document.add(new Paragraph(new Text("Dirección: Emiliano, E Zapata 36, Cuarta Secc, 90780 Xicohtzinco, Tlax.").setBold()));
        document.add(new Paragraph(new Text("Teléfono: +522222792190").setBold()));
        document.add(new Paragraph(new Text("Email: info@ferreteriazapata.com").setBold()));
        document.add(new Paragraph(new Text("Gracias por su compra!").setBold()));
        document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
        document.add(new Paragraph(new Text("Por favor, guarde este ticket para cualquier aclaración. Este ticket es válido por 30 días a partir de la fecha de compra.").setBold()));
        document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));

        // Agrega los detalles de la venta
        document.add(new Paragraph("Numero de venta: " + venta.getIdVenta()));
        document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
        document.add(new Paragraph("Nombre del cliente: " + venta.getCliente().getNombre()));
        document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
        document.add(new Paragraph("Fecha: " + venta.getFecha()));
        document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
        //document.add(new Paragraph("Total a pagar: " + venta.getTotal()));

        // Agrega los detalles de los productos
        Table table = new Table(3); // Ajusta el número de columnas según tus necesidades
        table.setWidth(UnitValue.createPercentValue(100));
        // Agrega los encabezados de la tabla
        table.addCell("Producto");
        table.addCell("Cantidad");
        table.addCell("Precio");
        // Agrega los datos de los productos
        List<ProductosEntity> productos = productosService.getAll();
        for (ProductosEntity producto : productos) {
            table.addCell(producto.getNombre());
            table.addCell(String.valueOf(producto.getStock()));
            table.addCell("$" + String.valueOf(producto.getPrecio()));
        }

        // Agrega el total a pagar al final de la tabla
        table.addCell("");
        table.addCell("Total a pagar:");
        table.addCell("$" + String.valueOf(venta.getTotal()));
        document.add(table);

        document.close();
        return baos.toByteArray();

    }
}
