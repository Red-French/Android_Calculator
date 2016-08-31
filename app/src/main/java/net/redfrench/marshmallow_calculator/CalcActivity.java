package net.redfrench.marshmallow_calculator;

import android.app.Activity;  // theme path
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class CalcActivity extends Activity {

    // GLOBALS
    TextView resultsView;

    public enum Operation {
        ADD, SUBTRACT, DIVIDE, MULTIPLY, EQUAL
    }

    String runningNumber = "";  // temp number holder
    String leftValueStr = "";  // first number user enters
    String rightValueStr = "";  // second number user enters
    Operation currentOperation;  // math operation to perform (add, subtract, etc)
    int result = 0;  // result of math operation

    @Override
    protected void onCreate(Bundle savedInstanceState) {  // called when app loads
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        Button oneBtn = (Button)findViewById(R.id.oneBtn);  // must use 'R.id.' in front of the id
        Button twoBtn = (Button)findViewById(R.id.twoBtn);
        Button threeBtn = (Button)findViewById(R.id.threeBtn);
        Button fourBtn = (Button)findViewById(R.id.fourBtn);
        Button fiveBtn = (Button)findViewById(R.id.fiveBtn);
        Button sixBtn = (Button)findViewById(R.id.sixBtn);
        Button sevenBtn = (Button)findViewById(R.id.sevenBtn);
        Button eightBtn = (Button)findViewById(R.id.eightBtn);
        Button nineBtn = (Button)findViewById(R.id.nineBtn);
        Button zeroBtn = (Button)findViewById(R.id.zeroBtn);

        ImageButton calcBtn = (ImageButton)findViewById(R.id.calcBtn);
        ImageButton divideBtn = (ImageButton)findViewById(R.id.divideBtn);
        ImageButton multiplyBtn = (ImageButton)findViewById(R.id.multiplyBtn);
        ImageButton subtractBtn = (ImageButton)findViewById(R.id.subtractBtn);
        ImageButton addBtn = (ImageButton)findViewById(R.id.addBtn);

        Button clearBtn = (Button)findViewById(R.id.clearBtn);
        resultsView = (TextView)findViewById(R.id.resultsText);

        resultsView.setText("");  // clear text area on load


        // ** EVENT LISTENERS ** //
        oneBtn.setOnClickListener(new View.OnClickListener() {  // event listener (this is an anonymous inner class)
            @Override  // override the event below and handle it ourselves
            public void onClick(View v) {
                numberPressed(1);
            }
        });

        twoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(2);
            }
        });

        threeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(3);
            }
        });

        fourBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(4);
            }
        });

        fiveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(5);
            }
        });

        sixBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(6);
            }
        });

        sevenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(7);
            }
        });

        eightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(8);
            }
        });

        nineBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(9);
            }
        });

        zeroBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(0);
            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operation.ADD);

            }
        });

        subtractBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operation.SUBTRACT);

            }
        });

        multiplyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operation.MULTIPLY);
            }
        });

        divideBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operation.DIVIDE);
            }
        });

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leftValueStr = "";
                rightValueStr = "";
                result = 0;
                runningNumber = "";
                currentOperation = null;
                resultsView.setText("0");
            }
        });

        calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operation.EQUAL);
            }
        });
    }

    void processOperation (Operation operation) {  // function takes one parameter of type 'Operation' ('operation' is the math function to perform)
        if (currentOperation != null) {  // if math operator has been selected
            if (runningNumber != "") {  // if user has entered first number of equation
                rightValueStr = runningNumber;  // place second number of the equation
                runningNumber = "";

                switch (currentOperation) {
                    case ADD:
                        result = Integer.parseInt(leftValueStr) + Integer.parseInt(rightValueStr);
                        break;
                    case SUBTRACT:
                        result = Integer.parseInt(leftValueStr) - Integer.parseInt(rightValueStr);
                        break;
                    case MULTIPLY:
                        result = Integer.parseInt(leftValueStr) * Integer.parseInt(rightValueStr);
                        break;
                    case DIVIDE:
                        result = Integer.parseInt(leftValueStr) / Integer.parseInt(rightValueStr);
                        break;
                }

                leftValueStr = String.valueOf(result);  // move to leftValueStr for next potential math function
                resultsView.setText(leftValueStr);  // update DOM
            }
        } else {  // runs when user enters first number of equation (pre selection of math operator)
            leftValueStr = runningNumber;  // place first number of the equation
            runningNumber = "";
        }
         currentOperation = operation;
    }

    void numberPressed(int number) {
        runningNumber += String.valueOf(number);  // add each number pressed to end
        resultsView.setText(runningNumber);  // update DOM
    }
}
