package system.library;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.swing.filechooser.FileSystemView;
import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;

public class ExportToPDF {
    
    public ExportToPDF() throws IOException {
        try {
            this.appPath = new File(".").getCanonicalPath();
        } catch (IOException e) {
            System.err.println(e.getMessage());
            this.appPath = "";
        }
        FileSystemView view = FileSystemView.getFileSystemView();
        File file = view.getHomeDirectory();
        this.desktopPath = file.getPath();
    }
    
    public void generate(Map<String, Object> map, int type) {
        Date now = new Date();
        String dest = null;
        String tmpFile = null;
        
        switch (type) {
            // laporan pembayaran
            case 1:
                dest = this.desktopPath + "\\laporan_pembayaran_"+(now.getTime()/1000)+".pdf";
                tmpFile = makePaymentReport(map);
                break;
            // laporan pengajuan lunas
            case 2:
                dest = this.desktopPath + "\\laporan_pengajuan_lunas_"+(now.getTime()/1000)+".pdf";
                tmpFile = makeSubmissionOfPaidReport(map);
                break;
        }
        
        if (tmpFile != null) {
            try {
                // generate pdf
                // step 1
                com.itextpdf.text.Document document = new com.itextpdf.text.Document();
                // step 2
                PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(dest));
                // step 3
                document.open();
                // step 4
                XMLWorkerHelper.getInstance().parseXHtml(writer, document, new FileInputStream(tmpFile));
                // step 5
                document.close();
                
                // deleted temp file
                File tmp = new File(tmpFile);
                tmp.deleteOnExit();

                System.out.println("Report Created");
            } catch (FileNotFoundException e) {
                System.err.println("FileNotFoundException: " + e.getMessage());
            } catch (DocumentException e) {
                System.err.println("DocumentException: " + e.getMessage());
            } catch (IOException e) {
                System.err.println("IOException: " + e.getMessage());
            }
        } else {
            System.err.println("Err export!!");
        }
    }
    
    private String makePaymentReport(Map<String, Object> map) {
        Date now = new Date();
        
        // path of file
        String reportPurchase = this.appPath + "\\templates\\laporan_pembayaran.html";
        String tempFile = this.appPath + "\\temp\\temp_"+(now.getTime()/1000)+".html";
        
        // parse template file
        try {
            File input = new File(reportPurchase);
            org.jsoup.nodes.Document doc = Jsoup.parse(input, "UTF-8", "");
            
            // set data to parse file
            doc.getElementById("no_pengajuan").text((String) map.get("no_pengajuan"));
            doc.getElementById("nama_nasabah").text((String) map.get("nama_nasabah"));
            doc.getElementById("nama_barang").text((String) map.get("nama_barang"));
            doc.getElementById("sisa_cicilan").text((String) map.get("sisa_cicilan"));
            doc.getElementById("lama_angsuran").text((String) map.get("lama_angsuran"));
            doc.getElementById("harga_jual").text((String) map.get("harga_jual"));
            doc.getElementById("status_pembiayaan").text((String) map.get("status_pembiayaan"));

            Locale locale = new Locale("id", "ID");
            SimpleDateFormat sdf = new SimpleDateFormat("EEEE dd MMMM y", locale);
            doc.getElementById("tanggal_buat").text(sdf.format(now));
            
            String listTable = null;
            int no = 1;

            for (Map<String, Object> mapList : (List<Map<String, Object>>) map.get("data_laporan")) {
                listTable += "<tr> \n" +
                        "<td class=\"text-center\">" + no + "</td>\n" +
                        "<td class=\"text-right\">" + String.format("%,d", mapList.get("nominal")) + "</td>\n" +
                        "<td class=\"text-center\">" + mapList.get("date") +"</td>\n" +
                        "<td>" + mapList.get("notes") +"</td>\n" +
                        "</tr> \n";
                no++;
            }
            doc.getElementById("data_laporan").html(listTable);

            // generate to temporary file
            String head = doc.head().children().outerHtml();
            String body = doc.body().children().toString();
            String outerHTML = head + "\n" + body;
            File tmp = new File(tempFile);
            FileUtils.writeStringToFile(tmp, outerHTML, StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            tempFile = null;
        }
        
        return tempFile;
    }
    
    private String makeSubmissionOfPaidReport(Map<String, Object> map) {
        Date now = new Date();
        
        // path of file
        String reportPurchase = this.appPath + "\\templates\\laporan_pengajuan_lunas.html";
        String tempFile = this.appPath + "\\temp\\temp_"+(now.getTime()/1000)+".html";
        
        // parse template file
        try {
            File input = new File(reportPurchase);
            org.jsoup.nodes.Document doc = Jsoup.parse(input, "UTF-8", "");
            
            // set data to parse file
            Locale locale = new Locale("id", "ID");
            SimpleDateFormat sdf = new SimpleDateFormat("EEEE dd MMMM y", locale);
            doc.getElementById("tanggal_buat").text(sdf.format(now));
            
            String listTable = null;
            int no = 1;

            for (Map<String, Object> mapList : (List<Map<String, Object>>) map.get("data_laporan")) {
                listTable += "<tr> \n" +
                        "<td class=\"text-center\">" + mapList.get("no_pengajuan") +"</td>\n" +
                        "<td>" + mapList.get("nasabah") +"</td>\n" +
                        "<td class=\"text-right\">" + String.format("%,d", mapList.get("modal")) +"</td>\n" +
                        "<td class=\"text-right\">" + String.format("%,d", mapList.get("est_laba")) +"</td>\n" +
                        "<td class=\"text-center\">" + mapList.get("lfn_date") +"</td>\n" +
                        "<td class=\"text-center\">" + mapList.get("est_end") + "</td>\n" +
                        "</tr> \n";
                no++;
            }
            doc.getElementById("data_laporan").html(listTable);

            // generate to temporary file
            String head = doc.head().children().outerHtml();
            String body = doc.body().children().toString();
            String outerHTML = head + "\n" + body;
            File tmp = new File(tempFile);
            FileUtils.writeStringToFile(tmp, outerHTML, StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            tempFile = null;
        }
        
        return tempFile;
    }
    
    private String appPath;
    private String desktopPath;
}
