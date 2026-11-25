package com.perkvault.app;
import android.app.*;import android.content.*;import android.os.*;import android.service.quicksettings.*;
public class QuickTile extends TileService {public void onClick(){super.onClick();Intent i=new Intent(this,MainActivity.class).putExtra("quick",true).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);if(Build.VERSION.SDK_INT>=34)startActivityAndCollapse(PendingIntent.getActivity(this,2,i,PendingIntent.FLAG_IMMUTABLE|PendingIntent.FLAG_UPDATE_CURRENT));else startActivityAndCollapse(i);}}
