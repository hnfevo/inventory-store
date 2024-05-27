package utils;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import entity.Product;
import entity.Transaction;
import service.ProductService;
import service.TransactionService;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class PDFGenerator {
    private ProductService productService;
    private TransactionService transactionService;

    public PDFGenerator() {
        productService = new ProductService();
        transactionService = new TransactionService();
    }

    public void generateProductReport(String filePath) throws DocumentException, IOException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(filePath));
        document.open();

        Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);

        Paragraph title = new Paragraph("Laporan Data Barang", boldFont);
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);

        document.add(new Paragraph(" ")); // Add an empty line

        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100);
        table.setWidths(new float[]{1, 3, 2, 2});

        PdfPCell cell;

        cell = new PdfPCell(new Phrase("ID", boldFont));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Name", boldFont));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Price", boldFont));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Stock", boldFont));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        List<Product> products = productService.getAllProducts();
        for (Product product : products) {
            table.addCell(String.valueOf(product.getId()));
            table.addCell(product.getName());
            table.addCell(String.valueOf(product.getPrice()));
            table.addCell(String.valueOf(product.getStock()));
        }

        document.add(table);
        document.close();
    }

    public void generateTransactionReport(String filePath) throws DocumentException, IOException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(filePath));
        document.open();

        Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);

        Paragraph title = new Paragraph("Laporan Transaksi Masuk", boldFont);
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);

        document.add(new Paragraph(" ")); // Add an empty line

        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100);
        table.setWidths(new float[]{1, 3, 2, 2, 2});

        PdfPCell cell;

        cell = new PdfPCell(new Phrase("ID", boldFont));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Date", boldFont));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Type", boldFont));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Product", boldFont));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Quantity", boldFont));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        List<Transaction> transactions = transactionService.getAllTransactions();
        for (Transaction transaction : transactions) {
            if ("in".equals(transaction.getType())) {
                table.addCell(String.valueOf(transaction.getId()));
                table.addCell(transaction.getDate().toString());
                table.addCell(transaction.getType());
                table.addCell(transaction.getProduct().getName());
                table.addCell(String.valueOf(transaction.getQuantity()));
            }
        }

        document.add(table);
        document.close();
    }

    public void generateTransactionOutReport(String filePath) throws DocumentException, IOException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(filePath));
        document.open();

        Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);

        Paragraph title = new Paragraph("Laporan Transaksi Keluar", boldFont);
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);

        document.add(new Paragraph(" ")); // Add an empty line

        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100);
        table.setWidths(new float[]{1, 3, 2, 2, 2});

        PdfPCell cell;

        cell = new PdfPCell(new Phrase("ID", boldFont));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Date", boldFont));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Type", boldFont));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Product", boldFont));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Quantity", boldFont));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        List<Transaction> transactions = transactionService.getAllTransactions();
        for (Transaction transaction : transactions) {
            if ("out".equals(transaction.getType())) {
                table.addCell(String.valueOf(transaction.getId()));
                table.addCell(transaction.getDate().toString());
                table.addCell(transaction.getType());
                table.addCell(transaction.getProduct().getName());
                table.addCell(String.valueOf(transaction.getQuantity()));
            }
        }

        document.add(table);
        document.close();
    }
}
