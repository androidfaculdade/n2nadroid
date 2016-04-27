package augustoperez.formularioprova;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;


public class MainActivity extends Activity {
    private TextWatcher cpfMask;
    private TextWatcher emaill;
    private TextView md;
    private TextView sexoea;
    Button emailButton;
    EditText emailEdittext;
    TextView textviewMessage;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final EditText campo_nome = (EditText) findViewById(R.id.campo_nome);

        final EditText campo_cpf = (EditText) findViewById(R.id.campo_cpf);
        final EditText nc = (EditText) findViewById(R.id.dia);
        campo_cpf.addTextChangedListener(Mask.insert("###.###.###-##", campo_cpf));
        final EditText campo_dia = (EditText) findViewById(R.id.dia);
        campo_dia.addTextChangedListener(Mask.insert("##", campo_dia));
        final EditText campo_mes = (EditText) findViewById(R.id.mes);
        campo_mes.addTextChangedListener(Mask.insert("##", campo_mes));
        final EditText campo_ano = (EditText) findViewById(R.id.ano);
        campo_ano.addTextChangedListener(Mask.insert("####", campo_ano));
        final EditText campo_nm = (EditText) findViewById(R.id.campo_nome);
        campo_nm.addTextChangedListener(Mask.insert("###################################", campo_nm));

        final EditText campo_email = (EditText) findViewById(R.id.campo_email);
        final EditText campo_peso = (EditText) findViewById(R.id.peso);
        final EditText campo_altura = (EditText) findViewById(R.id.alts);
        campo_altura.addTextChangedListener(Mask.insert("#.##",campo_altura));
        campo_peso.addTextChangedListener(Mask.insert("###",campo_peso));

        Button bt_validate = (Button) findViewById(R.id.bt_validate);

        bt_validate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Validator.validateNotNull(campo_cpf, "Preencha o campo CPF");
                boolean cpf_valido = Validator.validateCPF(campo_cpf.getText().toString());
                if (!cpf_valido) {
                    campo_cpf.setError("CPF inválido");
                    campo_cpf.setFocusable(true);
                    campo_cpf.requestFocus();
                }
                boolean email_valido = Validator.validateEmail(campo_email.getText().toString());
                if (!email_valido) {
                    campo_email.setError("Email inválido");
                    campo_email.setFocusable(true);
                    campo_email.requestFocus();
                }
                boolean nome_valido = Validator.validatenome(campo_nome);
                if (!nome_valido) {
                    campo_nome.setFocusable(true);
                    campo_nome.requestFocus();
                }
                double sexo = 0;
                RadioGroup rgEstadoCivil = (RadioGroup) findViewById(R.id.rgsexo);
                switch (rgEstadoCivil.getCheckedRadioButtonId()) {
                    case R.id.radio_feminino:
                        sexo = 1;
                        break;
                    case R.id.radio_masculino:
                        sexo = 2;
                        break;
                }
                  sexoea = (TextView) findViewById(R.id.alertasexo);

                if (sexo==0) {
                    sexoea.setVisibility(View.VISIBLE);
                    sexoea.setError("Campo Obrigatório"); //setText aparece como mensagem
                    sexoea.requestFocus();
                    sexoea.setText("Campo obrigatório");
                }

                boolean peso_valida = Validator.pesoo(campo_peso);
                if(!peso_valida){
                    campo_peso.setFocusable(true);
                    campo_peso.requestFocus();

                }
                boolean valida_altura = Validator.pesoo(campo_altura);
                if(!valida_altura){
                    campo_altura.setFocusable(true);
                    campo_altura.requestFocus();

                }

                boolean valida_dia = Validator.pesoo(campo_dia);
                if(!valida_dia){
                    campo_dia.setFocusable(true);
                    campo_dia.requestFocus();

                }
                boolean valida_mes = Validator.pesoo(campo_mes);
                if(!valida_mes){

                    campo_mes.setFocusable(true);
                    campo_mes.requestFocus();

                }
                boolean valida_ano = Validator.pesoo(campo_ano);
                if(!valida_ano){

                    campo_ano.setFocusable(true);
                    campo_ano.requestFocus();

                }

                md = (TextView) findViewById(R.id.md);

                if (email_valido == true && cpf_valido == true && nome_valido == true && sexo !=0 && peso_valida == true && valida_altura== true && valida_ano == true && valida_mes == true && valida_dia == true )

                {

                    double textnc = (nc.length());
                    md.setText("carregando nova tela aguarde...");

                    Intent troca = new
                            Intent(MainActivity.this, Main2Activity.class);

                    TextView edtTexto = (TextView) findViewById(R.id.alts);
                    String txt1 = "";
                    txt1 = edtTexto.getText().toString();
                    Bundle bundle1 = new Bundle();
                    bundle1.putString("txt1", txt1);
                    troca.putExtras(bundle1);

                    TextView edtTexto2 = (TextView) findViewById(R.id.peso);
                    String txt2 = "";
                    txt2 = edtTexto2.getText().toString();
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("txt2", txt2);
                    troca.putExtras(bundle2);

                    TextView edtTexto3 = (TextView) findViewById(R.id.ano);
                    String txt3 = "";
                    txt3 = edtTexto3.getText().toString();
                    Bundle bundle3 = new Bundle();
                    bundle3.putString("txt3", txt3);
                    troca.putExtras(bundle3);

                    TextView edtTexto5 = (TextView) findViewById(R.id.mes);
                    String txt5 = "";
                    txt5 = edtTexto5.getText().toString();
                    Bundle bundle5 = new Bundle();
                    bundle5.putString("txt5", txt5);
                    troca.putExtras(bundle5);

                    TextView edtTexto6 = (TextView) findViewById(R.id.dia);
                    String txt6 = "";
                    txt6 = edtTexto6.getText().toString();
                    Bundle bundle6 = new Bundle();
                    bundle6.putString("txt6", txt6);
                    troca.putExtras(bundle6);

                    String txt4 = "";
                    txt4 = Double.toString(sexo);
                    Bundle bundle4 = new Bundle();
                    bundle4.putString("txt4", txt4);
                    troca.putExtras(bundle4);

                    MainActivity.this.startActivity(troca);
                    MainActivity.this.finish();

                }
            }
        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://augustoperez.formularioprova/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://augustoperez.formularioprova/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}