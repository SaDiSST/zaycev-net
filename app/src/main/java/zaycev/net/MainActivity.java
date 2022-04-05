package zaycev.net;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import zaycev.net.interfaces.DiscountsApplier;

public class MainActivity extends AppCompatActivity implements DiscountsApplier {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_applyDiscounts).setOnClickListener(view -> launchDiscounts());
    }

    private void launchDiscounts() {
        DiscountsApplier.applyDiscounts(new int[]{0, 100, 4, 30, 25, 120, 493, 75, 21, 97, 365},
                01, 1, 3);
        DiscountsApplier.applyDiscounts(new int[]{0, 100, 4, 30, 25, 120, 493, 75, 21, 97, 365},
                10, 2, 4);
        DiscountsApplier.applyDiscounts(new int[]{0, 100, 4, 30, 25, 120, 493, 75, 21, 97, 365},
                25, 2, 2);
        DiscountsApplier.applyDiscounts(new int[]{0, 100, 4, 30, 25, 120, 493, 75, 21, 97, 365},
                33, 1, 3);
        DiscountsApplier.applyDiscounts(new int[]{0, 100, 4, 30, 25, 120, 493, 75, 21, 97, 365},
                50, 3, 4);
        DiscountsApplier.applyDiscounts(new int[]{0, 100, 4, 30, 25, 120, 493, 75, 21, 97, 365},
                75, 4, 3);
        DiscountsApplier.applyDiscounts(new int[]{0, 100, 4, 30, 25, 120, 493, 75, 21, 97, 365},
                99, 4, 2);
    }
}