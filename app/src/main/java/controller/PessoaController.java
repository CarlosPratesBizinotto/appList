package controller;

import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import model.Pessoa;
import view.MainActivity;

public class PessoaController {

    SharedPreferences preferences;
    public static final String NOME_PREFERENCES = "pref_listavip";
    SharedPreferences.Editor listas;

    public PessoaController(MainActivity mainActivity) {
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        listas = preferences.edit();

    }


    @NonNull
    @Override
    public String toString() {

        Log.d("MVC_Controller", "Controller iniciada...");

        return super.toString();
    }

    public void criarSharedPreferences() {


    }

    public Pessoa salvar(Pessoa pessoa) {

        Log.d("MVC_Controller", "Salvo:" + pessoa.toString());

        listas.putString("PrimeiroNome", pessoa.getPrimeiroNome());
        listas.putString("Sobrenome", pessoa.getSobrenome());
        listas.putString("Curso", pessoa.getCursoDesejado());
        listas.putString("Telefone", pessoa.getTelefone());
        listas.apply();

        return pessoa;

    }

    public void buscar(Pessoa pessoa) {

        pessoa.setPrimeiroNome(preferences.getString("PrimeiroNome", "N/A"));
        pessoa.setSobrenome(preferences.getString("Sobrenome", "N/A"));
        pessoa.setCursoDesejado(preferences.getString("Curso", "N/A"));
        pessoa.setTelefone(preferences.getString("Telefone", "N/A"));

    }

    public void limpar() {

        listas.clear();
        listas.apply();
    }
}
