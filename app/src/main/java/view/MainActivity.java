package view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.applist.R;


import java.util.List;

import controller.CursoController;
import controller.PessoaController;
import model.Curso;
import model.Pessoa;

public class MainActivity extends AppCompatActivity {


    PessoaController controller;
    CursoController cursoController;

    Pessoa pessoa;

    List<Curso> listaDeCursos;

    EditText editTextPrimeiroNome;
    EditText editTextSobrenome;
    EditText editTextCurso;
    EditText editTextTel;

    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //Atribuir conteúdo, dados, valores para o Objeto
        //Conforme o modelo, o Layout

        controller = new PessoaController(MainActivity.this);
        controller.toString();
        pessoa = new Pessoa();
        controller.buscar(pessoa);

        cursoController = new CursoController();
        listaDeCursos = cursoController.getListDeCursos();


        /*
        pessoa.setPrimeiroNome("Carlos");
        pessoa.setSobrenome("Prates");
        pessoa.setCursoDesejado("Androd");
        pessoa.setTelefone("981557842");
         */


        //Link entre o xml com a activity

        editTextPrimeiroNome = findViewById(R.id.editTextPrimeiroNome);
        editTextSobrenome = findViewById(R.id.editTextSobrenome);
        editTextCurso = findViewById(R.id.editTextCurso);
        editTextTel = findViewById(R.id.editTextTel);

        editTextPrimeiroNome.setText(pessoa.getPrimeiroNome());
        editTextSobrenome.setText(pessoa.getSobrenome());
        editTextCurso.setText(pessoa.getCursoDesejado());
        editTextTel.setText(pessoa.getTelefone());

        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        //Pegando as informações do layout(xml)

       /*
        editTextPrimeiroNome.setText(pessoa.getPrimeiroNome());
        editTextSobrenome.setText(pessoa.getSobrenome());
        editTextCurso.setText(pessoa.getCursoDesejado());
        editTextTel.setText(pessoa.getTelefone());
        */

        //Acoes com os botoes

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextPrimeiroNome.setText("");
                editTextSobrenome.setText("");
                editTextCurso.setText("");
                editTextTel.setText("");

                controller.limpar();

            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Volte sempre!",Toast.LENGTH_LONG).show();
                finish();
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pessoa.setPrimeiroNome(editTextPrimeiroNome.getText().toString());
                pessoa.setSobrenome(editTextSobrenome.getText().toString());
                pessoa.setCursoDesejado(editTextCurso.getText().toString());
                pessoa.setTelefone(editTextTel.getText().toString());


               
                Toast.makeText(MainActivity.this,"Salvo!",Toast.LENGTH_LONG).show();

               controller.salvar(pessoa);
            }
        });


        Log.i("OOP_ANDROID","Dados da pesssoa"+pessoa.toString());





    }
}