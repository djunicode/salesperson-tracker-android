package io.github.djunicode.salespersontracker;

public class DailyTask {

    private String Assigned_Date;
    private String Assigned_Time;
    private String Quantity;
    private String Completed;
    private String Notes;
    private String Assigned_By;
    private String Assigned_To;
    private String Item_Ref;
    private String id;

    public DailyTask(String assigned_Date, String assigned_Time, String quantity, String completed, String notes, String assigned_By, String assigned_To, String item_Ref, String id) {
        Assigned_Date = assigned_Date;
        Assigned_Time = assigned_Time;
        Quantity = quantity;
        Completed = completed;
        Notes = notes;
        Assigned_By = assigned_By;
        Assigned_To = assigned_To;
        Item_Ref = item_Ref;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getAssigned_Date() {
        return Assigned_Date;
    }

    public String getAssigned_Time() {
        return Assigned_Time;
    }

    public String getQuantity() {
        return Quantity;
    }

    public String getCompleted() {
        return Completed;
    }

    public String getNotes() {
        return Notes;
    }

    public String getAssigned_By() {
        return Assigned_By;
    }

    public String getAssigned_To() {
        return Assigned_To;
    }

    public String getItem_Ref() {
        return Item_Ref;
    }
}
