package scor.passwordmanage;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.dialog, (ViewGroup)findViewById(R.id.root));
        final EditText et1 = (EditText)findViewById(R.id.password);
        final EditText et2 = (EditText)findViewById(R.id.password2);

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(R.string.first);
        builder.setIcon(android.R.drawable.ic_dialog_info);
        builder.setView(layout);
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context,et1.getText().toString(), Toast.LENGTH_LONG).show();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(R.string.clear, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                et1.setText("");
                et2.setText("");
            }
        });
        builder.create().show();
    }
}
