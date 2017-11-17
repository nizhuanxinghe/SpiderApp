package com.example.chuwenbin.spiderapp.ui.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chuwenbin.spiderapp.R;
import com.example.chuwenbin.spiderapp.ui.model.DialogHintInfo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pax1 on 17/3/21.
 */

public class HintDialogUtil {


    public static final int WARNING = 0x32;
    public static final int ERROR = 0x33;
    public static final int SUCCESS = 0x34;
    public static final int INFO = 0x35;

    private static Map<Integer, Integer> mImgMap;

    static {
        mImgMap = new HashMap<>();
        mImgMap.put(SUCCESS, R.mipmap.icon_sucessed_2x);
        mImgMap.put(WARNING, R.mipmap.icon_prompt1_2x);
        mImgMap.put(INFO, R.mipmap.icon_prompt_2x);
    }

    public interface DialogListener {
        void onClick(boolean isOk);
    }

    private static DialogListener dialogListener;

    public void setDialogListener(DialogListener dialogListener) {
        this.dialogListener = dialogListener;
    }

    public static synchronized void showDialog(Context context, DialogHintInfo hintInfo, int mode) {
        final Dialog dialog;

        LayoutInflater inflater = LayoutInflater.from(context);
        dialog = new Dialog(context, R.style.myDialogTheme);

        View dialogView = inflater.inflate(R.layout.dialog_hint, null);

        ImageView imageHint = dialogView.findViewById(R.id.dialog_image_hint);

        TextView title = dialogView.findViewById(R.id.dialog_text_title);

        TextView textContent = dialogView.findViewById(R.id.dialog_text_hint_content);
        if (hintInfo.getContent() == null) {
            textContent.setVisibility(View.GONE);
        }

        TextView textContenTxt = dialogView.findViewById(R.id.dialog_text_hint_txt);
        textContenTxt.setVisibility(View.GONE);

        TextView dialogOk = dialogView.findViewById(R.id.dialog_text_ok);

        TextView dialogCancel = dialogView.findViewById(R.id.dialog_text_cancel);
        if (hintInfo.getSelectorCancel()!=null){
            dialogCancel.setVisibility(View.VISIBLE);
        }

        imageHint.setBackgroundResource(mImgMap.get(mode));
        title.setText(hintInfo.getTitle());
        textContent.setText(hintInfo.getContent());
        dialogOk.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                if (dialogListener != null) {
                    dialogListener.onClick(true);
                }
            }
        });

        dialogCancel.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                dialog.dismiss();
                if (dialogListener != null) {
                    dialogListener.onClick(false);
                }
            }
        });

        Window dialogWindow = dialog.getWindow();
        dialogWindow.setWindowAnimations(R.style.dialog_animation);
        dialog.setContentView(dialogView);
        dialog.show();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes(); // 获取对话框当前的参数值
        dialogView.measure(0, 0);
        lp.height = dialogView.getMeasuredHeight();
        lp.width = WindowManager.LayoutParams.WRAP_CONTENT; // 宽度
        dialogWindow.setAttributes(lp);

    }

}
