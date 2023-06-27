import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class UndefinedTest {
    @BeforeEach
    void setUp() {
        open("https://mihailmaximov.ru/projects/calc/index.html");
    }

    @Test
    @DisplayName("88. Расчёт без заданного вычисления")
    public void calculationWithoutSpecifiedCalculation() {
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("undefined"));
    }
}
