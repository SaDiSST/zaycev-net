package zaycev.net.interfaces;

import android.util.Log;

import androidx.annotation.IntRange;
import androidx.annotation.Nullable;

public interface DiscountsApplier {
    /**
     * Метод "скидка". Применяет скидку discount к цене price, начиная с позиции offset
     * на количество позиций readLength. Новые цены округляем “вниз”,
     * до меньшего целого числа.
     * @param prices - исходные цены.
     * @param discount - % скидки, от 1 до 99.
     * @param offset - номер позиции, с которой нужно применить скидку.
     * @param applyLength - количество позиций, к которым нужно применить скидку.
     * @return - массив новых цен.
     */
    static int[] applyDiscounts(
            @Nullable int[] prices,
            @IntRange(from = 1, to = 99) int discount,
            @IntRange(from = 0) int offset,
            @IntRange(from = 1) int applyLength
    ) {

        if (prices == null) {
            Log.d("zaycev.net.absolutely", "prices = null");
            return null;
        }

        Log.d("zaycev.net.absolutely", "/////////////////////////////////////////////");
        Log.d("zaycev.net.absolutely","discount = " + discount +
                "; offset = " + offset +
                "; applyLength = " + applyLength);

        int value;
        int[] resultArray = new int[prices.length];

        for (int i = 0; i < prices.length; i++){
            value = prices[i];

            if (i >= offset && i <= offset + applyLength - 1) {
                value -= (int) Math.floor((float) (value) / 100 * discount);

                Log.d("zaycev.net.absolutely", "index = " + i +
                        "; previous value = " + prices[i] +
                        "; current value = " + value +
                        "; discount amount = " + (value - prices[i])
                );
            } else {
                Log.d("zaycev.net.absolutely","index = " + i +
                        "; current value = " + prices[i]);
            }

            resultArray[i] = value;
        }

        return resultArray;
    }
}
