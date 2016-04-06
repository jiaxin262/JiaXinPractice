package com.example.jiaxin.animationdemo.activity;

import android.os.Bundle;

import com.example.jiaxin.animationdemo.R;

/**
 * Created by xin.jia
 * since 2016/1/29
 */
public class MatrixActivity extends BaseActivity {

    private static final int MATRIX_WIDTH = 6;
    private static final int MATRIX_HEIGHT = 6;


    boolean[][] isReached = new boolean[MATRIX_HEIGHT][MATRIX_WIDTH];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.matrix);

        calculate();
    }

    private void calculate() {
        initMatrix();

    }

    private void initMatrix() {
        isReached[1][2] = true;
        for (int i=0; i<MATRIX_HEIGHT; i++) {
            for (int j=0; j<MATRIX_WIDTH; j++) {
                if (i == 0 || i ==MATRIX_HEIGHT-1 || j == 0 || j == MATRIX_WIDTH-1) {
                    isReached[i][j] = true;
                    continue;
                }
                isReached[i][j] = false;
            }
        }
    }


}
