package com.dailycodework.sbqrcode.utils;

import com.dailycodework.sbqrcode.model.student.Student;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class QRCodeGenrater {

    public static void generateQRCode(Student student) throws WriterException, IOException {
        String qrCodePath= "C:\\Users\\suraj\\Desktop\\Code\\SPRING-BOOT\\QR-Code\\IMG";

        String qrCodeName= qrCodePath+" "+student.getFirstName()+" "+student.getId()+"-QRCode.png";
        var qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode("ID: "+student.getId()+"\n"+
                "First Name: "+ student.getFirstName() + "\n"+
                "Last Name: "+student.getSecondName() + "\n"+
                "Email: "+student.getEmail() + "\n"+
                "Phone Number: "+student.getMobile(), BarcodeFormat.QR_CODE, 400,400);
        Path path = FileSystems.getDefault().getPath(qrCodeName);
        MatrixToImageWriter.writeToPath(bitMatrix,"PNG",path);
    }
}
