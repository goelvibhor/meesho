package meesho.invoiceservice.invoiceservice.controller;

import meesho.data.DetailedOderDto;
import meesho.invoiceservice.invoiceservice.service.FormaterService;
import meesho.invoiceservice.invoiceservice.service.OrderService;
import meesho.invoiceservice.invoiceservice.service.PdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class InvoiceController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private FormaterService formaterService;

    @Autowired
    private PdfService pdfService;

    // add the request validation
    @PostMapping(value = "/generateInvoice/order/{orderId}", produces = "application/json")
    public ResponseEntity<Boolean> generateInvoiceForOrder(@PathVariable String orderId) {
        //validate input parameter
        if(StringUtils.isEmpty(orderId)){
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }

        DetailedOderDto order = orderService.getDetailedOrder(orderId);
        if(order == null){
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }

        // it will indicate that it didn't generate the invoice but it was already present
        if(order.getInvoiceUrl() != null && order.getInvoiceUrl().trim().length() > 0){
            return new ResponseEntity<>(false, HttpStatus.ACCEPTED);
        }

        String pdfData = formaterService.formatPdfData(order);

        String filePath = pdfService.generateFilePath();
        boolean result = pdfService.savePdfData(pdfData, filePath);
        if(!result){
            return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        String url = pdfService.uploadPdf(filePath);

        if(url == null || url.trim().length() == 0){
            return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        orderService.updateInvoiceUrl(orderId, url);

        return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
    }
}
