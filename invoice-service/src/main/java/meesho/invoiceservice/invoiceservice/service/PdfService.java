package meesho.invoiceservice.invoiceservice.service;

import org.springframework.stereotype.Service;

@Service
public class PdfService {
    public String generateFilePath(){
        return null;
    }

    public Boolean savePdfData(String data, String filePath){
        boolean result = validatePdfFile(filePath);
        return result;
    }

    public boolean validatePdfFile(String filePath){
        return true;
    }

    public String uploadPdf(String filePath){
        //upload the file to cloud storage and return the url

        // throw exception if not able to upload
        return null;
    }
}
