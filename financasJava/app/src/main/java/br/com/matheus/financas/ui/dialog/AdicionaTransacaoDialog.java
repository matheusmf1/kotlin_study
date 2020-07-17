package br.com.matheus.financas.ui.dialog;

import android.content.Context;
import android.view.ViewGroup;

import java.util.Calendar;

import androidx.annotation.NonNull;
import br.com.matheus.financas.delegate.TransacaoDelegate;
import br.com.matheus.financas.model.Tipo;
import br.com.matheus.financas.util.DataUtil;


/**
 * Created by alex on 16/08/17.
 */

public class AdicionaTransacaoDialog extends FormularioTransacaoDialog {

    public AdicionaTransacaoDialog(Context context, ViewGroup viewRoot) {
        super(context, viewRoot);
    }

    public void mostraFormulario(final Tipo tipo, final TransacaoDelegate delegate) {
        String titulo = devolveTitulo(tipo);
        adicionaValoresPadrao();
        mostraDialog(tipo, delegate, titulo, "Adicionar", "Cancelar");
    }

    @NonNull
    private String devolveTitulo(Tipo tipo) {
        String titulo = "Adicionar despesa";
        if (tipo.equals(Tipo.RECEITA)) {
            titulo = "Adicionar receita";
        }
        return titulo;
    }

    private void adicionaValoresPadrao() {
        Calendar calendar = Calendar.getInstance();
        String dataFormatada = DataUtil.formataParaBrasileiro(calendar);
        data.setText(dataFormatada);
    }

}
