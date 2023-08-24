/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import Domain.Transactions;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.*;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

/**
 *
 * @author Moise Niyonkuru
 */
public class ExportPdf {

    public void generateRaport(List<Transactions> transactions) {
        try {
            PDDocument document = new PDDocument();
            PDPage page = new PDPage();
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            PDFont font = PDType1Font.HELVETICA_BOLD;
            contentStream.setFont(font, 12);

            // Title: "STATION RUBUS GITARAMA"
            contentStream.beginText();
            contentStream.newLineAtOffset(50, 750);
            contentStream.setFont(font, 10);
            contentStream.showText("STATION RUBUS GITARAMA");
            contentStream.endText();

            // "TEL :" with dots
            contentStream.beginText();
            contentStream.setFont(font, 10);
            contentStream.newLineAtOffset(50, 730);
            contentStream.showText("TEL : " + "............................");
            contentStream.endText();

            // Title: "FICHE DE CONSOMMATION DU CARBURANT"
            contentStream.beginText();
            contentStream.setFont(font, 16);
            contentStream.newLineAtOffset(150, 700);
            contentStream.showText("FICHE DE CONSOMMATION DU CARBURANT");
            contentStream.endText();
            
            String plaque  = transactions.get(0).getCar().getPlaque();
            String vehicleType = transactions.get(0).getCar().getCarType();
            String driverName = transactions.get(0).getCar().getNom();
            // Fields: "NOM DU CHAUFFEUR:", "TYPE DE VEHICLE:", "PLAQUE NO:"
            contentStream.beginText();
            contentStream.setFont(PDType1Font.HELVETICA, 12);
            contentStream.newLineAtOffset(50, 670);
            contentStream.showText("NOM DU CHAUFFEUR: " + ( driverName != null ? driverName: "......................."));
            contentStream.newLineAtOffset(0, -20);
            contentStream.showText("TYPE DE VEHICLE: " + ( vehicleType != null ? vehicleType: "......................."));
            contentStream.newLineAtOffset(0, -20);
            contentStream.showText("PLAQUE NO: " + ( plaque != null ? plaque: "......................."));
            contentStream.endText();

            // Table header
            contentStream.beginText();
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
            contentStream.newLineAtOffset(50, 600);
            contentStream.showText("DATE");
            contentStream.newLineAtOffset(130, 0);
            contentStream.showText("PRODUIT");
            contentStream.newLineAtOffset(140, 0);
            contentStream.showText("QUANTITE");
            contentStream.newLineAtOffset(160, 0);
            contentStream.showText("SIGNATURE");
            contentStream.endText();

            // Draw table lines
            contentStream.moveTo(50, 598);
            contentStream.lineTo(550, 598);
            contentStream.stroke();

            // Draw table rows
            float y = 596; // Initial Y position for rows
            for (int i = 0; i < transactions.size(); i++) {
                y -= 20; // Adjust Y position for each row

                contentStream.beginText();
                contentStream.setFont(PDType1Font.HELVETICA, 12);
                contentStream.newLineAtOffset(50, y);
                contentStream.showText(transactions.get(i).getDate().toString());
                contentStream.newLineAtOffset(130, 0);
                contentStream.showText(transactions.get(i).getProduct());
                contentStream.newLineAtOffset(140, 0);
                contentStream.showText(String.valueOf(transactions.get(i).getQuantity()));
                contentStream.newLineAtOffset(160, 0);
                contentStream.showText("");
                contentStream.endText();

                // Draw row separator line
                contentStream.moveTo(50, y - 5);
                contentStream.lineTo(550, y - 5);
                contentStream.stroke();
            }
            // Close content stream
            contentStream.close();

            // Save the document
            String fileName = driverName +" document "+ String.valueOf(new Random().nextInt(1000));
            document.save(fileName+".pdf");
            document.close();

            System.out.println("PDF created successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
