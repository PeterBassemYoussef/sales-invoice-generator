package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class InvoiceHeader {
    private int invoiceNum;
    private Date invoiceDate;
    private String customerName;
    private ArrayList<InvoiceLine> lines;
    private final DateFormat dateF = new SimpleDateFormat("dd-MM-yyyy");

    public InvoiceHeader() {
    }
    public InvoiceHeader(int invoiceNum, Date invoiceDate, String customerName) {
        this.invoiceNum = invoiceNum;
        this.invoiceDate = invoiceDate;
        this.customerName = customerName;
    }

    public int getInvoiceNum() {
        return invoiceNum;
    }

    public void setInvoiceNum(int invoiceNum) {
        this.invoiceNum = invoiceNum;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public ArrayList<InvoiceLine> getLines() {
        if (lines == null){
            lines = new ArrayList<>();
        }
        return lines;
    }

    public void setLines(ArrayList<InvoiceLine> Lines) {
        this.lines = Lines;
    }

    public double getInvoicesTotal(){
        double total =0.0;
        for (int i=0; i< getLines().size(); i++) {
            total += getLines().get(i).getInvoiceAmount();
        }
        return total;
    }

    @Override
    public String toString() {
        return   invoiceNum +"," + dateF.format(invoiceDate) + "," +  customerName;
    }
}
