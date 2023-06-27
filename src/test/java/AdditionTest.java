import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class AdditionTest {
    @BeforeEach
    void setUp() {
        open("https://mihailmaximov.ru/projects/calc/index.html");
    }

    @Test
    @DisplayName("1. Сложение целых положительных чисел")
    public void additionOfPositiveIntegers() {
        $x("//*[@id=\"num1\"]").setValue("5");
        $x("//*[@id=\"num2\"]").setValue("5");
        $x("//*[@id=\"plus\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("10"));
    }

    @Test
    @DisplayName("2. Сложение целых отрицательных чисел")
    public void additionOfNegativeIntegers() {
        $x("//*[@id=\"num1\"]").setValue("-7");
        $x("//*[@id=\"num2\"]").setValue("-9");
        $x("//*[@id=\"plus\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("-16"));
    }

    @Test
    @DisplayName("3. Сложение целого положительного и целого отрицательного числа")
    public void additionOfAPositiveIntegerAndANegativeInteger() {
        $x("//*[@id=\"num1\"]").setValue("-9");
        $x("//*[@id=\"num2\"]").setValue("5");
        $x("//*[@id=\"plus\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("-4"));
    }

    @Test
    @DisplayName("4. Сложение вещественных положительных чисел")
    public void additionOfRealPositiveIntegers() {
        $x("//*[@id=\"num1\"]").setValue("2.2");
        $x("//*[@id=\"num2\"]").setValue("5.5");
        $x("//*[@id=\"plus\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("7.7"));
    }

    @Test
    @DisplayName("5. Сложение вещественных отрицательных чисел")
    public void additionOfRealNegativeIntegers() {
        $x("//*[@id=\"num1\"]").setValue("-1.4");
        $x("//*[@id=\"num2\"]").setValue("-8.6");
        $x("//*[@id=\"plus\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("-10"));
    }

    @Test
    @DisplayName("6. Сложение вещественного положительного и вещественного отрицательного числа")
    public void additionOfARealPositiveAndARealNegativeNumber() {
        $x("//*[@id=\"num1\"]").setValue("-2.2");
        $x("//*[@id=\"num2\"]").setValue("0.9");
        $x("//*[@id=\"plus\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("-1.3000000000000003"));
        // Обнаружен баг. Ссылка: https://github.com/Vladislav0306/mihailmaximov-calculator/issues/1
    }

    @Test
    @DisplayName("7. Сложение вещественного числа с 0 после точки")
    public void addingARealNumberWith0AfterTheDot() {
        $x("//*[@id=\"num1\"]").setValue("5");
        $x("//*[@id=\"num2\"]").setValue("8.0");
        $x("//*[@id=\"plus\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("13"));
    }

    @Test
    @DisplayName("8. Сложение 2.9999999999999999")
    public void addition2Dot9999999999999999() {
        $x("//*[@id=\"num1\"]").setValue("5");
        $x("//*[@id=\"num2\"]").setValue("2.9999999999999999");
        $x("//*[@id=\"plus\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("8"));
    }

    @Test
    @DisplayName("9. Сложение 0")
    public void addition0() {
        $x("//*[@id=\"num1\"]").setValue("6");
        $x("//*[@id=\"num2\"]").setValue("0");
        $x("//*[@id=\"plus\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("6"));
    }

    @Test
    @DisplayName("10. Сложение положительного числа из 308 цифр 9 и 1")
    public void addingAPositiveNumberFrom308Digits9And1() {
        $x("//*[@id=\"num1\"]").setValue("99999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999");
        $x("//*[@id=\"num2\"]").setValue("1");
        $x("//*[@id=\"plus\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("1e+308"));
    }

    @Test
    @DisplayName("11. Сложение положительного числа из 309 цифр 9 и 1")
    public void addingAPositiveNumberFrom309Digits9And1() {
        $x("//*[@id=\"num1\"]").setValue("999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999");
        $x("//*[@id=\"num2\"]").setValue("1");
        $x("//*[@id=\"plus\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("Infinity"));
    }

    @Test
    @DisplayName("12. Сложение букв")
    public void additionOfLetters() {
        $x("//*[@id=\"num1\"]").setValue("привет");
        $x("//*[@id=\"num2\"]").setValue("абвгд");
        $x("//*[@id=\"plus\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("NaN"));
    }

    @Test
    @DisplayName("13. Сложение спецсимволов")
    public void additionOfSpecialCharacters() {
        $x("//*[@id=\"num1\"]").setValue("~!@#$");
        $x("//*[@id=\"num2\"]").setValue("%^&*(");
        $x("//*[@id=\"plus\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("NaN"));
    }

    @Test
    @DisplayName("14. Сложение пустой строки")
    public void additionOfAnEmptyString() {
        $x("//*[@id=\"num1\"]").setValue("4");
        $x("//*[@id=\"plus\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("4"));
    }

    @Test
    @DisplayName("15. Сложение положительной бесконечности")
    public void additionOfPositiveInfinity() {
        $x("//*[@id=\"num1\"]").setValue("Infinity");
        $x("//*[@id=\"num2\"]").setValue("1");
        $x("//*[@id=\"plus\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("Infinity"));
    }

    @Test
    @DisplayName("16. Сложение отрицательной бесконечности")
    public void additionOfNegativeInfinity() {
        $x("//*[@id=\"num1\"]").setValue("-Infinity");
        $x("//*[@id=\"num2\"]").setValue("1");
        $x("//*[@id=\"plus\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("-Infinity"));
    }

    @Test
    @DisplayName("17. Сложение положительной и отрицательной бесконечности")
    public void additionOfPositiveAndNegativeInfinity() {
        $x("//*[@id=\"num1\"]").setValue("-Infinity");
        $x("//*[@id=\"num2\"]").setValue("Infinity");
        $x("//*[@id=\"plus\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("NaN"));
    }

    @Test
    @DisplayName("18. Сложение NaN")
    public void NaNAddition() {
        $x("//*[@id=\"num1\"]").setValue("NaN");
        $x("//*[@id=\"num2\"]").setValue("1");
        $x("//*[@id=\"plus\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("NaN"));
    }
}
