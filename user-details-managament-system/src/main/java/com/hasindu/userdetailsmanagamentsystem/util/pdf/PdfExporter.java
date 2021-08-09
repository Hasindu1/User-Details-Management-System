package com.hasindu.userdetailsmanagamentsystem.util.pdf;

import com.hasindu.userdetailsmanagamentsystem.dto.LoginHistoryDTO;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.*;

import javax.servlet.http.HttpServletResponse;

import java.awt.*;
import java.io.IOException;
import java.util.List;
import static com.hasindu.userdetailsmanagamentsystem.Constants.*;

/**
 * PDF exporter class
 */
public class PdfExporter {
    private List<LoginHistoryDTO> loginHistoryDTOList;


    public PdfExporter() {

    }
    public PdfExporter(List<LoginHistoryDTO> loginHistoryDTOList) {
        this.loginHistoryDTOList = loginHistoryDTOList;
    }
    private void writeTableHeader( PdfPTable pdfpTable){
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);
        cell.setPhrase(new Phrase(RECORD_ID,font));
        pdfpTable.addCell(cell);
        cell.setPhrase(new Phrase(USER_NAME,font));
        pdfpTable.addCell(cell);
        cell.setPhrase(new Phrase(DATE,font));
        pdfpTable.addCell(cell);
        cell.setPhrase(new Phrase(TIME,font));
        pdfpTable.addCell(cell);
        cell.setPhrase(new Phrase(DEVICE_TYPE,font));
        pdfpTable.addCell(cell); cell.setPhrase(new Phrase(BROWSER_NAME,font));
        pdfpTable.addCell(cell);


    }
    private void writeTableData( PdfPTable pdfpTable){
        for(LoginHistoryDTO currentLoginHistoryDTO :loginHistoryDTOList){
            pdfpTable.addCell(String.valueOf(currentLoginHistoryDTO.getRecordId()));
            pdfpTable.addCell(currentLoginHistoryDTO.getUser().getUserName());
            pdfpTable.addCell(currentLoginHistoryDTO.getLoggedInDate().toString());
            pdfpTable.addCell(currentLoginHistoryDTO.getLoggedInTime().toString());
            pdfpTable.addCell(currentLoginHistoryDTO.getDeviceType());
            pdfpTable.addCell(currentLoginHistoryDTO.getBrowserName());

        }
    }
    public void export(HttpServletResponse response) throws IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document,response.getOutputStream());
        document.open();
        document.add(new Paragraph("                                                               User Login History"));
        PdfPTable pdfpTable = new PdfPTable(6);
        pdfpTable.setWidthPercentage(100);
        pdfpTable.setSpacingBefore(15);

        writeTableHeader(pdfpTable);
        writeTableData(pdfpTable);
        document.add(pdfpTable);
        document.close();



    }
}
