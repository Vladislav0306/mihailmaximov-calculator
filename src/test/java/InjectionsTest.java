import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class InjectionsTest {
    @BeforeEach
    void setUp() {
        open("https://mihailmaximov.ru/projects/calc/index.html");
    }

    @Test
    @DisplayName("89. XSS-инъекция в полях ввода")
    public void XSSInjectionInInputFields() {
        $x("//*[@id=\"num1\"]").setValue("<script>alert(123)</script>");
        $x("//*[@id=\"num2\"]").setValue("<script>alert(123)</script>");
        $x("//*[@id=\"plus\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("NaN"));
    }

    @Test
    @DisplayName("90. SQL-инъекция в полях ввода")
    public void SQLInjectionInInputFields() {
        $x("//*[@id=\"num1\"]").setValue("1 or sleep(5)#");
        $x("//*[@id=\"num2\"]").setValue("1 or sleep(5)#");
        $x("//*[@id=\"plus\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("NaN"));
    }
}
