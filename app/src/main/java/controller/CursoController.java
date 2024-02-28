package controller;

import java.util.ArrayList;
import java.util.List;

import kotlin.collections.ArrayDeque;
import model.Curso;

public class CursoController {

    private List listCursos;

    public List getListDeCursos() {
        listCursos = new ArrayList<Curso>();

        listCursos.add(new Curso("Android"));
        listCursos.add(new Curso("Java"));
        listCursos.add(new Curso("JavaScript"));
        listCursos.add(new Curso("Dart"));
        listCursos.add(new Curso("SQL"));
        listCursos.add(new Curso("Python"));
        listCursos.add(new Curso("C#"));

        return listCursos;

    }

    public ArrayList<String> dadosParaSpinner() {

        ArrayList<String> dados = new ArrayList<>();

        for (int i = 0; i < getListDeCursos().size(); i++) {

            Curso objeto = (Curso) getListDeCursos().get(i);
            dados.add(objeto.getNomeDoCursoDsejado());
        }

        return dados;

    }

}
