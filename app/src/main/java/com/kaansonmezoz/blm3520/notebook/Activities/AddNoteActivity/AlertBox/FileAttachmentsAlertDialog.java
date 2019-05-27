package com.kaansonmezoz.blm3520.notebook.Activities.AddNoteActivity.AlertBox;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;

import java.util.ArrayList;

public class FileAttachmentsAlertDialog {
    private ArrayList<String> filePathsList;
    private ArrayList<String> selectedItems;

    public FileAttachmentsAlertDialog(ArrayList<String> filePathsList){
        this.filePathsList = filePathsList;
    }

    public void showDialog(Activity activity){
        onCreateDialog(activity).show();
    }

    private Dialog onCreateDialog(Activity activity) {
        final String[] filePaths = filePathsList.toArray(new String[filePathsList.size()]);

        selectedItems = new ArrayList<String>();  // Where we track the selected items
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        builder.setTitle("Files")
               .setMultiChoiceItems(filePaths, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which,  boolean isChecked) {
                        if (isChecked) {
                            // If the user checked the item, add it to the selected items
                            selectedItems.add(filePaths[which]);
                        }
                        else if (selectedItems.contains(filePaths[which])) {
                            // Else, if the item is already in the array, remove it
                            selectedItems.remove(Integer.valueOf(filePaths[which]));
                        }
                    }
               })
                .setPositiveButton("ADD", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                })
                .setNegativeButton("DELETE", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        for(String selected: selectedItems){
                            if(filePathsList.contains(selected)){
                                filePathsList.remove(selected);
                            }
                        }
                    }
                });

        return builder.create();
    }
}
