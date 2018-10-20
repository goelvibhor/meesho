package meesho.invoiceservice.invoiceservice;

import meesho.data.DetailedOderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InvoiceController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private FormaterService formaterService;

    @Autowired
    private PdfService pdfService;

    // add the request validation
    @PostMapping("/generateInvoice/order/{orderId}")
    public Boolean generateInvoiceForOrder(@PathVariable String orderId) {
        //validate input parameter

        if(StringUtils.isEmpty(orderId)){
            // return bad request
            return false;
        }

        DetailedOderDto order = orderService.getDetailedOrder(orderId);
        if(order.getInvoiceUrl() != null && order.getInvoiceUrl().trim().length() > 0){
            return true;
        }

        String pdfData = formaterService.formatPdfData(order);

        String filePath = pdfService.generateFilePath();
        boolean result = pdfService.savePdfData(pdfData, filePath);
        if(!result){
            return false;
        }

        String url = pdfService.uploadPdf(filePath);

        orderService.updateInvoiceUrl(orderId, url);

        return true;
    }
}
