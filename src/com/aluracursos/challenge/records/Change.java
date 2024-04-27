package src.com.aluracursos.challenge.records;

public record Change( String base_code, String target_code, double conversion_rate ) {
    public String calculateChange (double money) {
        return "El valor: %s [%s] corresponde al valor final de → %s [%s]"
                    .formatted(money, base_code, conversion_rate * money, target_code);
    }
}
