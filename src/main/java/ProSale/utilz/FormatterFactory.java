package ProSale.utilz;

import javafx.scene.control.TextFormatter;

public class FormatterFactory {
    public static TextFormatter<String> createIntegerFormatter() {
        return new TextFormatter<>(change -> {
            String newText = change.getControlNewText();

            // Nếu xóa hết, tự động đặt lại "0"
            if (newText.isEmpty()) {
                change.setText("0");
                change.setCaretPosition(1);  // Đưa con trỏ về cuối
                change.setAnchor(1);
                return change;
            }

            // Chỉ cho phép nhập số
            if (newText.matches("\\d*")) {
                return change;
            }

            return null; // Từ chối nếu nhập ký tự không hợp lệ
        });
    }
}
