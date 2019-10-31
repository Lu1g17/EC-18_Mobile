package com.example.home.Boundary;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.media.Image;
import android.os.Bundle;
import android.os.Environment;
import android.se.omapi.Session;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.home.Entity.ClientEntity;
import com.example.home.R;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;
import com.paypal.android.sdk.payments.PaymentConfirmation;

import org.json.JSONException;
import org.w3c.dom.Document;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.sql.DataSource;

public class Data extends AppCompatActivity {

    public static final int PAYPAL_REQUEST_CODE = 7171;

    public static PayPalConfiguration config = new PayPalConfiguration().environment(PayPalConfiguration.ENVIRONMENT_SANDBOX).clientId(Paypal.PAYPAL_CLIENT_ID);

    ImageView Button01;
    String amount="";

    @Override
    protected void onDestroy() {
        stopService(new Intent(this,PayPalService.class));

        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data);

        Intent intent = new Intent(this, PayPalService.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, config);
        startService(intent);

        Button01 = (ImageView) findViewById(R.id.PaypalImageViewData);
        Button01.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                payment();
            }
        });
    }
        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == PAYPAL_REQUEST_CODE) {
                if (resultCode == RESULT_OK) {
                    PaymentConfirmation confirmation = data.getParcelableExtra(PaymentActivity.EXTRA_RESULT_CONFIRMATION);
                    if (confirmation != null) {
                        try {
                            String paymentDetails = confirmation.toJSONObject().toString(4);

                            startActivity(new Intent(this, PaymentDetails.class).putExtra("PaymentDetails", paymentDetails).putExtra("PaymentAmount", amount));


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                } else if (resultCode == Activity.RESULT_CANCELED) {
                    Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show();
                }
            } else if (resultCode == PaymentActivity.RESULT_EXTRAS_INVALID) {
                Toast.makeText(this, "Invalid", Toast.LENGTH_SHORT).show();
            }

        }

        void payment(){
            amount = "1"; //da dove la recuperiamo
            PayPalPayment payPalPayment = new PayPalPayment (new BigDecimal(String.valueOf(amount)),"USD","Donate for EC-18", PayPalPayment.PAYMENT_INTENT_SALE);
            Intent intent = new Intent (this, PaymentActivity.class);
            intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION,config);
            intent.putExtra(PaymentActivity.EXTRA_PAYMENT,payPalPayment);
            startActivityForResult(intent,PAYPAL_REQUEST_CODE);
        }

   /* public  void creaFattura(ClientEntity utente, String totale)
    {

        try
        {
            Calendar c= Calendar.getInstance();
            Integer y=c.get(Calendar.YEAR);
            String ya=y.toString();
            Integer m=c.get(Calendar.MONTH)+1;
            String mo = m.toString();
            Integer d = c.get(Calendar.DAY_OF_MONTH);
            String day = d.toString();
            String file_name= Environment.getExternalStorageDirectory()+"/fattura.pdf";
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(file_name));
            document.open();

            String string =""+utente.getName()+"";
            Paragraph para = new Paragraph(string,null);
            document.add(para);
            string =""+utente.getSurname()+"";
            para = new Paragraph(string,null);
            document.add(para);
            string=""+utente.getShippingAddress();
            para=new Paragraph(string,null);
            document.add(para);
            string=""+utente.getShippingCity();
            para=new Paragraph(string,null);
            document.add(para);
            string="Il tuo ordine del "+ya+"-"+mo+"-"+day+"";//  Ordine numero 402-2722071-8468320";
            para= new Paragraph(string,null);
            document.add(para);
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            // add table
            PdfPTable table = new PdfPTable(4);
            PdfPCell c1 = new PdfPCell(new Phrase("Libri",null));
            table.addCell(c1);
            c1 = new PdfPCell(new Phrase("Prezzo",null));
            table.addCell(c1);
            c1 = new PdfPCell(new Phrase("Quantità",null));
            table.addCell(c1);
            c1 = new PdfPCell(new Phrase("Totale",null));
            table.addCell(c1);
            table.setHeaderRows(1);

            table.addCell(" ");
            table.addCell(" ");
            table.addCell(" ");
            table.addCell(totale+"0€");

            document.add(table);
            //add logo
            document.add(new Paragraph(" "));
            string ="Questa fattura conclude il tuo ordine";
            para = new Paragraph(string,null);
            para.setAlignment(Paragraph.ALIGN_CENTER);
            document.add(para);
            string ="Grazie per il tuo acquisto su EC-18";
            para = new Paragraph(string,null);
            para.setAlignment(Paragraph.ALIGN_CENTER);
            document.add(para);

            document.close();;
        }catch(Exception e){ System.out.println("NO CREATO"); Log.i("eccezione",e.toString());}

    }*/

    /*public boolean sendFattura (String dest) throws MessagingException
    {
        String from = "tilde.ec@gmail.com";//------------------------
        String password = "Matilde2505";
        String host = "smtp.gmail.com";
        String subject ="Fattura acquisto EC-18";
        String text="Ecco la fattura relativa al tuo acquisto.";

        // Creazione di una mail session
        Properties props = System.getProperties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port","587");
        props.put("mail.smtp.starttls.required","true");

        //Security.addProvider(new BouncyCastleProvider());
        Session session = Session.getDefaultInstance(props,null);
        MimeMessage message = new MimeMessage(session);
        try
        {
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, dest);
            message.setSubject(subject);
            message.setText(text);
            // allo file
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            Multipart multipart = new MimeMultipart();
            messageBodyPart = new MimeBodyPart();
            String file = Environment.getExternalStorageDirectory()+"/fattura.pdf";
            String fileName = "FatturaEC-18.pdf";
            DataSource source = new FileDataSource(file);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(fileName);
            multipart.addBodyPart(messageBodyPart);
            message.setContent(multipart);

            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, password);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            System.out.println("Inviata correttamente");
        }
        catch (Exception e){System.out.println(e); return false;}
        return true;
    }*/
}
