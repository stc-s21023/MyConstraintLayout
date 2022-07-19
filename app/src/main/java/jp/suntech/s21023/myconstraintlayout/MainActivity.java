package jp.suntech.s21023.myconstraintlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HellowListener listener = new HellowListener();
        Button btsend = findViewById(R.id.btSend);
        btsend.setOnClickListener(listener);

        Button btconfirm = findViewById(R.id.btConfirm);
        btconfirm.setOnClickListener(listener);

        Button btClear = findViewById(R.id.btClear);
        btClear.setOnClickListener(listener);
    }

    private class HellowListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            //名前入力欄であるEditTextオブジェクトの作成
            EditText input = findViewById(R.id.etName);
            EditText a = findViewById(R.id.etMail);
            EditText c = findViewById(R.id.meiltaitoru);
            EditText b = findViewById(R.id.etCommetnt);

            String name = input.getText().toString();
            String mail = a.getText().toString();
            String taitol = c.getText().toString();
            String comment = b.getText().toString();

            int id = view.getId();

            switch (id){
                case R.id.btSend:
                    String show = "名前: " + name +'\n'+ "メールアドレス: " + mail +'\n'+ "タイトル: " + taitol +'\n'+ "質問内容: " + comment;
                    Toast.makeText(MainActivity.this,show,Toast.LENGTH_LONG).show();
                    break;

                case R.id.btConfirm:
                    OrderConfirmDialogFragment dialogFragment = new OrderConfirmDialogFragment();
                    dialogFragment.show(getSupportFragmentManager(),"OrderConfirmDialogFragment");
                    break;

                case R.id.btClear:
                    input.setText("");
                    a.setText("");
                    c.setText("");
                    b.setText("");
                    break;
            }
        }
    }
}