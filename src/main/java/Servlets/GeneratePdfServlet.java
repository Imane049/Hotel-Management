package Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
@WebServlet("/generatePdf")
public class GeneratePdfServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve reservation details from request parameters
        String roomId = request.getParameter("roomId");
        String checkinDate = request.getParameter("checkinDate");
        String checkoutDate = request.getParameter("checkoutDate");
        String firstName = request.getParameter("firstName");
        String familyName = request.getParameter("familyName");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");

        // Create PDF document using Apache PDFBox
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);
        PDPageContentStream contentStream = new PDPageContentStream(document, page);


        contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.COURIER_BOLD), 14);
        contentStream.beginText();
        contentStream.newLineAtOffset(50, 700);
        contentStream.showText("Reservation Recap");
        contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.COURIER), 14);
        contentStream.newLineAtOffset(0, -40);
        contentStream.showText("Room ID: " + roomId);
        contentStream.newLineAtOffset(0, -20);
        contentStream.showText("Check-in Date: " + checkinDate);
        contentStream.newLineAtOffset(0, -20);
        contentStream.showText("Check-out Date: " + checkoutDate);
        contentStream.newLineAtOffset(0, -20);
        contentStream.showText("First Name: " + firstName);
        contentStream.newLineAtOffset(0, -20);
        contentStream.showText("Family Name: " + familyName);
        contentStream.newLineAtOffset(0, -20);
        contentStream.showText("Address: " + address);
        contentStream.newLineAtOffset(0, -20);
        contentStream.showText("Email: " + email);
        contentStream.newLineAtOffset(0, -20);
        contentStream.showText("Phone Number: " + phoneNumber);
        contentStream.endText();
        contentStream.close();



        // Set response headers for PDF file
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=reservation_recap.pdf");

        // Send PDF document to the client
        document.save(response.getOutputStream());
        document.close();
    }
}
