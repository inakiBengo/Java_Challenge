package src.com.aluracursos.challenge;

import java.text.DecimalFormat;

public record Change(String base_code, String target_code, double conversion_rate ) {
    public String calculateChange (double money) {
        DecimalFormat df = new DecimalFormat("#.00");
        String value = df.format(conversion_rate * money);
        return "El valor: %s [%s] corresponde al valor final de → %s [%s]"
                    .formatted(money, base_code, value, target_code);
    }
}
