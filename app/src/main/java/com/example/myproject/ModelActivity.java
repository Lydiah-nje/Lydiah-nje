package com.example.myproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myproject.ml.RandomForestApproximatorModel3;
import org.tensorflow.lite.DataType;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ModelActivity extends AppCompatActivity {

    private EditText etAge, etBodyTemp, etHeartRate, etSystolicBP, etDiastolicBP;
    private Button btnPredict;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_model);

        etAge = findViewById(R.id.et_age);
        etBodyTemp = findViewById(R.id.et_body_temp);
        etHeartRate = findViewById(R.id.et_heart_rate);
        etSystolicBP = findViewById(R.id.et_systolic_bp);
        etDiastolicBP = findViewById(R.id.et_diastolic_bp);
        btnPredict = findViewById(R.id.btn_predict);
        tvResult = findViewById(R.id.tv_result);


        btnPredict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    predictRisk();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void predictRisk() throws IOException {
        int age = Integer.parseInt(etAge.getText().toString());
        float bodyTemp = Float.parseFloat(etBodyTemp.getText().toString());
        int heartRate = Integer.parseInt(etHeartRate.getText().toString());
        int systolicBP = Integer.parseInt(etSystolicBP.getText().toString());
        int diastolicBP = Integer.parseInt(etDiastolicBP.getText().toString());

        // Create input buffer
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(5 * 4);
        byteBuffer.order(ByteOrder.nativeOrder());
        byteBuffer.putFloat(age);
        byteBuffer.putFloat(bodyTemp);
        byteBuffer.putFloat(heartRate);
        byteBuffer.putFloat(systolicBP);
        byteBuffer.putFloat(diastolicBP);

        // Load the model
        RandomForestApproximatorModel3 model = RandomForestApproximatorModel3.newInstance(getApplicationContext());

        // Create input tensor
        TensorBuffer inputFeature0 = TensorBuffer.createFixedSize(new int[]{1, 5}, DataType.FLOAT32);
        inputFeature0.loadBuffer(byteBuffer);

        // Run the model and get the result
        RandomForestApproximatorModel3.Outputs outputs = model.process(inputFeature0);
        TensorBuffer outputFeature0 = outputs.getOutputFeature0AsTensorBuffer();

        // Get the prediction probabilities
        float[] probabilities = outputFeature0.getFloatArray();

        // Find the index of the maximum probability
        int predictedClass = -1;
        float maxProbability = -1;
        for (int i = 0; i < probabilities.length; i++) {
            if (probabilities[i] > maxProbability) {
                maxProbability = probabilities[i];
                predictedClass = i;
            }
        }

        // Display the result
        tvResult.setText(String.format("Predicted Risk Class: %d (Probability: %.2f)", predictedClass, maxProbability));
        tvResult.setVisibility(View.VISIBLE);

        // Close the model
        model.close();
    }
}
