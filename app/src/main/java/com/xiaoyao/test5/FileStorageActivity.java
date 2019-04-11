package com.xiaoyao.test5;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FileStorageActivity extends AppCompatActivity {

    private EditText editText;
    private TextView textView;
    private Button button1,button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filestorage);
        editText = (EditText)findViewById(R.id.editText_fileStorage);
        textView = (TextView)findViewById(R.id.textView_fileStorage_read);
        button1 = (Button)findViewById(R.id.btn_fileStorage_save);
        button2 = (Button)findViewById(R.id.btn_fileStorage_read);
        // 保存内容的按钮
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = editText.getText().toString();
                if(inputText.isEmpty()){
                    Toast.makeText(FileStorageActivity.this,"保存失败，内容为空！",Toast.LENGTH_SHORT).show();
                }else{
                    if (save(inputText)) {
                        Toast.makeText(FileStorageActivity.this, "保存成功！", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(FileStorageActivity.this, "保存失败！", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        // 读取内容的按钮
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String outputText = read();
                if(outputText.isEmpty()){
                    Toast.makeText(FileStorageActivity.this,"读取失败，内容为空！",Toast.LENGTH_SHORT).show();
                }else{
                    textView.setText(outputText);
                }
            }
        });
    }

    /**
     * 保存内容到文件
     * @param inputText
     * @return
     */
    public boolean save(String inputText){
        FileOutputStream out = null;
        BufferedWriter writer = null;
        try{
            out = openFileOutput("data", Context.MODE_PRIVATE); // 覆盖原内容
            writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write(inputText);
            return true;
        }catch (IOException ioe){
            ioe.printStackTrace();
            return false;
        }finally {
            try{
                if (writer != null){
                    writer.close();
                }
            }catch (IOException ioe){
                ioe.printStackTrace();
            }
        }
    }

    /**
     * 从文件读取内容
     * @return
     */
    private String read(){
        FileInputStream fis = null;
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        try{
            fis = openFileInput("data");
            br = new BufferedReader(new InputStreamReader(fis));
            String line = "";
            while ((line = br.readLine())!= null){
                sb.append(line);
            }
            return sb.toString();
        }catch (IOException ioe){
            ioe.printStackTrace();
            return null;
        }finally {
            try{
                if (br != null){
                    br.close();
                }
            }catch (IOException ioe){
                ioe.printStackTrace();
            }
        }
    }

}
