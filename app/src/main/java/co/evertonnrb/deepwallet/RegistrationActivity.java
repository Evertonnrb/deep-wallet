package co.evertonnrb.deepwallet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import co.evertonnrb.deepwallet.db.DespesaRepository;
import co.evertonnrb.deepwallet.model.Despeda;

public class RegistrationActivity extends AppCompatActivity  {

    //desc, valor, data, tipo
    private EditText edtDesc;
    private EditText edtTipo;
    private EditText edtData;
    private EditText edtValor;

    private DespesaRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        repository = new DespesaRepository(this);

        edtDesc = findViewById(R.id.edtDesc);
        edtTipo = findViewById(R.id.edtTipo);
        edtData = findViewById(R.id.edtData);
        edtValor = findViewById(R.id.edtValor);

        Button btnCadstrar = findViewById(R.id.btnCadastrarDespesa);
        btnCadstrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Despeda despeda = new Despeda();
                despeda.setDesc(edtDesc.getText().toString());
                despeda.setData(edtData.getText().toString());
                despeda.setTipo(edtTipo.getText().toString());
                despeda.setValor(Double.parseDouble(edtValor.getText().toString()));
                repository.save(despeda);
                Toast.makeText(getApplicationContext(),"Casdastro realizado com sucesso",Toast.LENGTH_SHORT).show();
            }
        });

    }
}