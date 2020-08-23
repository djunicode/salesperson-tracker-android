package io.github.djunicode.salespersontracker;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BillResponseModel
{
    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("Issued_To")
    @Expose
    private String issuedTo;

    @SerializedName("Quantity")
    @Expose
    private int quantity;

    @SerializedName("Buyer_Contact")
    @Expose
    private long buyerContact;

    @SerializedName("Buyer_email")
    @Expose
    private String buyerEmail;

    @SerializedName("SoftCopy")
    @Expose
    private String softCopy;

    @SerializedName("Target_ref")
    @Expose
    private int targetRef;

    @SerializedName("item_ref")
    @Expose
    private int itemRef;

    @SerializedName("Salesperson_Ref")
    @Expose
    private int salespersonRef;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIssuedTo() {
        return issuedTo;
    }

    public void setIssuedTo(String issuedTo) {
        this.issuedTo = issuedTo;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getBuyerContact() {
        return buyerContact;
    }

    public void setBuyerContact(long buyerContact) {
        this.buyerContact = buyerContact;
    }

    public String getBuyerEmail() {
        return buyerEmail;
    }

    public void setBuyerEmail(String buyerEmail) {
        this.buyerEmail = buyerEmail;
    }

    public String getSoftCopy() {
        return softCopy;
    }

    public void setSoftCopy(String softCopy) {
        this.softCopy = softCopy;
    }

    public int getTargetRef() {
        return targetRef;
    }

    public void setTargetRef(int targetRef) {
        this.targetRef = targetRef;
    }

    public int getItemRef() {
        return itemRef;
    }

    public void setItemRef(int itemRef) {
        this.itemRef = itemRef;
    }

    public int getSalespersonRef() {
        return salespersonRef;
    }

    public void setSalespersonRef(int salespersonRef) {
        this.salespersonRef = salespersonRef;
    }
}

