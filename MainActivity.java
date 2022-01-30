package com.example.mywords;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Environment;
import android.view.Gravity;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

public class MainActivity extends AppCompatActivity {

    EditText edTxt;
    Button btBig;
    Button btSmall;
    TextView txSize;
    CheckBox cbBold;
    CheckBox cbAnderLine;
    Spinner ssColer;
    Spinner ssFont;
    RadioButton rbLTR;
    RadioButton rbRTL;
    EditText edtFileName;
    Button btSave;
    Button btNew;
    Button btGetFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edTxt=(EditText) findViewById(R.id.edWrite);
        txSize= (TextView) findViewById(R.id.txtSize);
        btBig=(Button) findViewById(R.id.btBig);
        btSmall=(Button) findViewById(R.id.btSmall);
        cbBold =(CheckBox) findViewById(R.id.cbBold);
        cbAnderLine =(CheckBox) findViewById(R.id.cbAnderline);
        ssColer =(Spinner) findViewById(R.id.spinnerColer);
        ssFont= (Spinner) findViewById(R.id.spinnerFont);
        rbLTR =(RadioButton) findViewById(R.id.rbLTR);
        rbRTL=(RadioButton) findViewById(R.id.rbRTL);
        edtFileName =(EditText) findViewById(R.id.edFileName);
        btSave=(Button) findViewById(R.id.btSave);
        btNew= (Button)findViewById(R.id.btNew);
        btGetFile=(Button)findViewById(R.id.btGetFile);


        //BT_onClik_in_BtBig
        btBig.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                OnClik_buttonBig();

            }
        });

        //BT_onClik_in_BtSmall
        btSmall.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                OnClik_buttonSmall();

            }
        });

        // OnSelect_spinnerColer
        FillColor();
        ssColer.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            WhenChose_colorType();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // onSelect_spinnerFont
         FillFont();
         ssFont.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                 WhenChose_FontType();
             }

             @Override
             public void onNothingSelected(AdapterView<?> parent) {

             }
         });
         // ONchose_chekbox_Bold
         cbBold.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                OnChose_cbBold();
             }
         });
         // OnChose_chekbox_AnderLine
        cbAnderLine.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                OnChose_cbAnderline();
            }
        });
        // OnChose_RB_LTR
        rbLTR.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Alinment();
            }
        });
        // OnChose_RB_RTL
        rbRTL.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Alinment();
            }
        });

        // onClik_Botton_New
        btNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnClik_btNew();
            }
        });
        // onclik_button_SAVE
        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            OnCLik_btSave();
            }
        });
        // onclik_button_GET_File
        btGetFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnClik_btGet();
            }
        });


    }







    protected void OnClik_buttonBig(){
       int passed=Integer.parseInt( txSize.getText().toString());
       passed++;
       edTxt.setTextSize(passed);
       txSize.setText(passed+"");
    }
    protected void OnClik_buttonSmall(){
        int passed =Integer.parseInt( txSize.getText().toString());
        passed--;
        edTxt.setTextSize(passed);
        txSize.setText(passed+"");
    }
    protected void FillColor(){
        String[] sColors={"black","red","yello","blue","pink","orange","green","nile","white"};
        ArrayAdapter<String> adapterCol =new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,sColors);
        ssColer.setAdapter(adapterCol);

    }
    protected  void WhenChose_colorType()
    {
        String GetColor=ssColer.getSelectedItem().toString();
        switch (GetColor)
        {
            case "red":
                edTxt.setTextColor(getColor(R.color.red));
                break;
            case "black":
                edTxt.setTextColor(getColor(R.color.black));
                break;
            case "yello":
                edTxt.setTextColor(getColor(R.color.yello));
                break;
            case "blue":
                edTxt.setTextColor(getColor(R.color.blue));
                break;
            case "pink":
                edTxt.setTextColor(getColor(R.color.pink));
                break;
            case "orange":
                edTxt.setTextColor(getColor(R.color.orange));
                break;
            case "nile":
                edTxt.setTextColor(getColor(R.color.nile));
                break;
            case "white":
                edTxt.setTextColor(getColor(R.color.white));
                break;
            default:
                edTxt.setTextColor(getColor(R.color.green));
                break;


        }
    }

    protected void FillFont()
    {
        String[]sFont={ "SANS_SERIF","arial","BROADW","BRUSHSCI","CURLZ___","JOKERMAN","DUBAI_MEDIUM"};
        ArrayAdapter<String> adapterFont=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,sFont);
        ssFont.setAdapter(adapterFont);

    }
    protected void WhenChose_FontType( )
    {
        String getFont=ssFont.getSelectedItem().toString();
            Typeface tf= Typeface.SANS_SERIF;


            switch (getFont)
            {
                case "SANS_SERIF":
                    tf=Typeface.SANS_SERIF;
                case "arial":
                     tf =Typeface.createFromAsset(getAssets(),"arial.ttf");
                    break;
                case "BROADW":
                    tf=Typeface.createFromAsset(getAssets(),"BROADW.TTF");
                    break;
                case "BRUSHSCI":
                     tf=Typeface.createFromAsset(getAssets(),"BRUSHSCI.TTF");
                    break;
                case "CURLZ___":
                    tf=Typeface.createFromAsset(getAssets(),"CURLZ___.TTF");
                    break;
                case "JOKERMAN":
                    tf=Typeface.createFromAsset(getAssets(),"JOKERMAN.TTF");
                    break;
                default:
                    tf=Typeface.createFromAsset(getAssets(),"DUBAI-MEDIUM.TTF");
                    break;

            }
            if(cbBold.isChecked()) {
                edTxt.setTypeface(tf,Typeface.BOLD);
            }
            else{
                edTxt.setTypeface(tf,Typeface.NORMAL);
            }

    }
    protected void OnChose_cbBold()
    {
        /*
        if(cbBold.isChecked())
        {
            edTxt.setTypeface(null,Typeface.BOLD);
        }
        else{
            edTxt.setTypeface(null,Typeface.NORMAL);
        }
        */
        WhenChose_FontType();


    }
    protected void OnChose_cbAnderline()
    {
        if(cbAnderLine.isChecked())
        {
            edTxt.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        }
        else{
            edTxt.setPaintFlags(Paint.LINEAR_TEXT_FLAG);
        }
    }

    protected void Alinment()
    {
        if(rbLTR.isChecked()){
            edTxt.setGravity(Gravity.LEFT);
        }
        else{
            edTxt.setGravity(Gravity.RIGHT);
        }
    }
    protected void OnClik_btNew()
    {
        edTxt.setText("");
        edTxt.setTextSize(14);
        txSize.setText("14");
        cbBold.setChecked(false);
        cbAnderLine.setChecked(false);
        rbLTR.setChecked(true);
        rbRTL.setChecked(false);
        ssFont.setSelection(0);
        ssColer.setSelection(0);
        edtFileName.setText("fileName");
        edTxt.requestFocus();

    }
    protected void OnCLik_btSave()
    {
        if("".equals(edtFileName.getText().toString().trim()))
        {
            Toast.makeText(this, "File name is Empty !", Toast.LENGTH_SHORT).show();
            edtFileName.requestFocus();
        }
      else{
            try {
                String strPath= Environment.getExternalStorageDirectory().getPath()+"/MyWords";


                File f=new File(strPath);

                   f.mkdirs();

                PrintWriter pw =new PrintWriter(strPath+"/"+edtFileName.getText()+".txt");
                pw.write(edTxt.getText().toString());
                pw.close();

                PrintWriter pwSitting= new PrintWriter(strPath+"/"+edtFileName.getText()+"set.txt");
                String strSitting = txSize.getText()
                        +"\n"+cbBold.isChecked()
                        +"\n"+cbAnderLine.isChecked()
                        +"\n"+ssColer.getSelectedItem()
                        +"\n"+ssFont.getSelectedItem()
                        +"\n"+rbLTR.isChecked()
                        + "\n"+rbRTL.isChecked();
                pwSitting.write(strSitting);
                pwSitting.close();
                Toast.makeText(this, "File Is Saved ", Toast.LENGTH_SHORT).show();
            }
            catch (Exception e)
            {
                Toast.makeText(this,e.getMessage(), Toast.LENGTH_LONG).show();
            }

        }
    }
    protected void OnClik_btGet()
    {
        try {
            String strpath=Environment.getExternalStorageDirectory().getPath()+"/MyWords";
            FileReader fileRead =new FileReader(strpath +"/"+ edtFileName.getText()+".txt");
            BufferedReader br=new BufferedReader(fileRead);
            String strContact="";
            String lline="";
            while ((lline=br.readLine())!=null)
            {
                strContact +=lline+"\n";
            }
            fileRead=new FileReader(strpath+"/"+edtFileName.getText()+"set.txt");
            br=new BufferedReader(fileRead);
            String[] strSet=new String[7];
            int x=0;
            while((lline=br.readLine())!=null)
            {
                strSet[x]=lline;
                x++;
            }
            fileRead.close();
            br.close();
            txSize.setText(strSet[0]);
            edTxt.setTextSize(Integer.parseInt(strSet[0]));
            cbBold.setChecked(Boolean.parseBoolean(strSet[1]));
            cbAnderLine.setChecked(Boolean.parseBoolean(strSet[2]));
            ssColer.setSelection(( (ArrayAdapter<String>)ssColer.getAdapter() ).getPosition(strSet[3])   );
            ssFont.setSelection(( (ArrayAdapter<String>)ssColer.getAdapter() ).getPosition(strSet[4])   );
            if("true".equals(strSet[5]))
                rbRTL.setChecked(true);
            else
                rbLTR.setChecked(true);




            edTxt.setText(strContact);



        }
        catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }



}