package augustoperez.formularioprova;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.Menu;

import java.util.Calendar;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private EditText etPeso;
    private EditText etAltura;
    private Button bt_Imc;
    private Button bas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //inicio do botão pra calcular imc
        /*final Button[] bt_Imc = {(Button) findViewById(R.id.bt_Imc)};

            bt_Imc[0].setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    etPeso = (EditText) findViewById(R.id.etPeso);
                    etAltura = (EditText) findViewById(R.id.etAltura);
                    bt_Imc[0] = (Button) findViewById(R.id.bt_Imc);


                    //resultado do calculo com alerta
                    AlertDialog.Builder CaixaAlerta = new AlertDialog.Builder(Main2Activity.this);
                    CaixaAlerta.setTitle("Seja caraio");
                    CaixaAlerta.setMessage("HAHHAHAHAHAHHA");
                    CaixaAlerta.setNeutralButton("Ok", null);
                    CaixaAlerta.show();
                }
            });*/

        bt_Imc = (Button) findViewById(R.id.bt_Imc);
        bas = (Button) findViewById(R.id.bas);
        bt_Imc.setOnClickListener(this);
        bas.setOnClickListener(this);



        //TextView txtResultado = (TextView) findViewById(R.id.txtResultado);
    }//fim



    public  void  onClick(View V){
        Intent intent = getIntent();
        Bundle bundle1 = intent.getExtras();
        Bundle bundle2 = intent.getExtras();
        Bundle bundle3 = intent.getExtras();
        Bundle bundle4 = intent.getExtras();
        Bundle bundle5 = intent.getExtras();
        Bundle bundle6 = intent.getExtras();
        String txt = bundle1.getString("txt1");
        String txt2 = bundle2.getString("txt2");
        String txt3 = bundle3.getString("txt3");
        String txt4 = bundle4.getString("txt4");
        String txt5 = bundle4.getString("txt5");
        String txt6 = bundle4.getString("txt6");
        double Altura = Double.parseDouble(txt);
        double peso = Double.parseDouble(txt2);
        double sexo = Double.parseDouble(txt4);
        int idade = Integer.parseInt(txt3);
        int mes = Integer.parseInt(txt5);
        int  dia = Integer.parseInt(txt6);
        Calendar calander = Calendar.getInstance();
        int year = calander.get(Calendar.YEAR);
        int day = calander.get(Calendar.DAY_OF_MONTH);
        int month = calander.get(Calendar.MONTH);

        if( V.getId() == R.id.bt_Imc) {
            double resultado;
            resultado = peso/(Altura*Altura);
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("O seu imc é:" +resultado);
            dlg.setNeutralButton("OK", null);
            dlg.show();


        }
        if( V.getId() == R.id.bas){
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);


            if( sexo == 2 ) {
                double tidade = year - idade;
                if(mes<=month) {
                    if(mes==month) {
                        if (dia>= day) {
                            double resultado = 66 + (13.7 * peso) + (5 * (Altura * 100)) - (6.8 * tidade);
                            dlg = new AlertDialog.Builder(this);
                            dlg.setMessage("Homen  resultad:" + resultado );
                            dlg.setNeutralButton("OK", null);
                            dlg.show();
                        }
                        else{

                            tidade = tidade - 1 ;
                            double resultado = 66 + (13.7 * peso) + (5 * (Altura * 100)) - (6.8 * tidade);
                            dlg = new AlertDialog.Builder(this);
                            dlg.setMessage("Homen  resultad:" + resultado);
                            dlg.setNeutralButton("OK", null);
                            dlg.show();
                        }
                    }
                    if(mes<month){


                        double resultado = 66 + (13.7 * peso) + (5 * (Altura * 100)) - (6.8 * tidade);
                        dlg = new AlertDialog.Builder(this);
                        dlg.setMessage("Homen  resultad:" + resultado);
                        dlg.setNeutralButton("OK", null);
                        dlg.show();
                    }
                    else{

                        tidade = tidade - 1 ;
                        double resultado = 66 + (13.7 * peso) + (5 * (Altura * 100)) - (6.8 * tidade);
                        dlg = new AlertDialog.Builder(this);
                        dlg.setMessage("Homen  resultad:" + resultado);
                        dlg.setNeutralButton("OK", null);
                        dlg.show();
                    }
                }
                else{
                    tidade = tidade - 1 ;
                    double resultado = 66 + (13.7 * peso) + (5 * (Altura * 100)) - (6.8 * tidade);
                    dlg = new AlertDialog.Builder(this);
                    dlg.setMessage("Homen  resultad:" + resultado);
                    dlg.setNeutralButton("OK", null);
                    dlg.show();

                }
            }
            if(sexo == 1  ) {
                double tidade = year - idade;
                if(mes<=month) {
                    if(mes==month) {
                        if (dia>= day) {
                            double resultado = 66 + (13.7 * peso) + (5 * (Altura * 100)) - (6.8 * tidade);
                            dlg = new AlertDialog.Builder(this);
                            dlg.setMessage("Mulher  resultad:" + resultado );
                            dlg.setNeutralButton("OK", null);
                            dlg.show();
                        }
                        else{

                            tidade = tidade - 1 ;
                            double resultado = 66 + (13.7 * peso) + (5 * (Altura * 100)) - (6.8 * tidade);
                            dlg = new AlertDialog.Builder(this);
                            dlg.setMessage("Mulher  resultad:" + resultado);
                            dlg.setNeutralButton("OK", null);
                            dlg.show();
                        }
                    }
                    if(mes<month){


                        double resultado = 66 + (13.7 * peso) + (5 * (Altura * 100)) - (6.8 * tidade);
                        dlg = new AlertDialog.Builder(this);
                        dlg.setMessage("Mulher  resultad:" + resultado);
                        dlg.setNeutralButton("OK", null);
                        dlg.show();
                    }
                    else{

                        tidade = tidade - 1 ;
                        double resultado = 66 + (13.7 * peso) + (5 * (Altura * 100)) - (6.8 * tidade);
                        dlg = new AlertDialog.Builder(this);
                        dlg.setMessage("Mulher  resultad:" + resultado);
                        dlg.setNeutralButton("OK", null);
                        dlg.show();
                    }
                }
                else{
                    tidade = tidade - 1 ;
                    double resultado = 66 + (13.7 * peso) + (5 * (Altura * 100)) - (6.8 * tidade);
                    dlg = new AlertDialog.Builder(this);
                    dlg.setMessage("Mulher  resultad:" + resultado);
                    dlg.setNeutralButton("OK", null);
                    dlg.show();

                }
            }
        }

    }
}
