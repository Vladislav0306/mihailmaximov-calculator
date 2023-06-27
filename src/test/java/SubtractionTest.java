import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class SubtractionTest {
    @BeforeEach
    void setUp() {
        open("https://mihailmaximov.ru/projects/calc/index.html");
    }

    @Test
    @DisplayName("19. Вычитание целых положительных чисел")
    public void subtractionOfPositiveIntegers() {
        $x("//*[@id=\"num1\"]").setValue("7");
        $x("//*[@id=\"num2\"]").setValue("3");
        $x("//*[@id=\"minus\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("4"));
    }

    @Test
    @DisplayName("20. Вычитание целых отрицательных чисел")
    public void subtractionOfNegativeIntegers() {
        $x("//*[@id=\"num1\"]").setValue("-6");
        $x("//*[@id=\"num2\"]").setValue("-2");
        $x("//*[@id=\"minus\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("-4"));
    }

    @Test
    @DisplayName("21. Вычитание целого положительного и целого отрицательного числа")
    public void subtractionOfAPositiveIntegerAndANegativeInteger() {
        $x("//*[@id=\"num1\"]").setValue("-8");
        $x("//*[@id=\"num2\"]").setValue("5");
        $x("//*[@id=\"minus\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("-13"));
    }

    @Test
    @DisplayName("22. Вычитание вещественных положительных чисел")
    public void subtractionOfRealPositiveIntegers() {
        $x("//*[@id=\"num1\"]").setValue("6.6");
        $x("//*[@id=\"num2\"]").setValue("1.5");
        $x("//*[@id=\"minus\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("5.1"));
    }

    @Test
    @DisplayName("23. Вычитание вещественных отрицательных чисел")
    public void subtractionOfRealNegativeIntegers() {
        $x("//*[@id=\"num1\"]").setValue("-3.5");
        $x("//*[@id=\"num2\"]").setValue("-2.4");
        $x("//*[@id=\"minus\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("-1.1"));
    }

    @Test
    @DisplayName("24. Вычитание вещественного положительного и вещественного отрицательного числа")
    public void subtractionOfARealPositiveAndARealNegativeNumber() {
        $x("//*[@id=\"num1\"]").setValue("-2.2");
        $x("//*[@id=\"num2\"]").setValue("0.4");
        $x("//*[@id=\"minus\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("-2.6"));
    }

    @Test
    @DisplayName("25. Вычитание равных чисел")
    public void subtractionOfEqualNumbers() {
        $x("//*[@id=\"num1\"]").setValue("5");
        $x("//*[@id=\"num2\"]").setValue("5");
        $x("//*[@id=\"minus\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("0"));
    }

    @Test
    @DisplayName("26. Вычитание вещественного числа с 0 после точки")
    public void subtractionARealNumberWith0AfterTheDot() {
        $x("//*[@id=\"num1\"]").setValue("5");
        $x("//*[@id=\"num2\"]").setValue("2.0");
        $x("//*[@id=\"minus\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("3"));
    }

    @Test
    @DisplayName("27. Вычитание 1.9999999999999999")
    public void subtraction1Dot9999999999999999() {
        $x("//*[@id=\"num1\"]").setValue("8");
        $x("//*[@id=\"num2\"]").setValue("1.9999999999999999");
        $x("//*[@id=\"minus\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("6"));
    }

    @Test
    @DisplayName("28. Вычитание 0")
    public void subtraction0() {
        $x("//*[@id=\"num1\"]").setValue("1");
        $x("//*[@id=\"num2\"]").setValue("0");
        $x("//*[@id=\"minus\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("1"));
    }

    @Test
    @DisplayName("29. Вычитание отрицательного числа из 308 цифр 9 и 1")
    public void subtractingANegativeNumberFrom308Digits9And1() {
        $x("//*[@id=\"num1\"]").setValue("-99999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999");
        $x("//*[@id=\"num2\"]").setValue("1");
        $x("//*[@id=\"minus\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("-1e+308"));
    }

    @Test
    @DisplayName("30. Вычитание отрицательного числа из 309 цифр 9 и 1")
    public void subtractingANegativeNumberFrom309Digits9And1() {
        $x("//*[@id=\"num1\"]").setValue("-999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999");
        $x("//*[@id=\"num2\"]").setValue("1");
        $x("//*[@id=\"minus\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("-Infinity"));
    }

    @Test
    @DisplayName("31. Вычитание букв")
    public void subtractionOfLetters() {
        $x("//*[@id=\"num1\"]").setValue("привет");
        $x("//*[@id=\"num2\"]").setValue("абвгд");
        $x("//*[@id=\"minus\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("NaN"));
    }

    @Test
    @DisplayName("32. Вычитание спецсимволов")
    public void subtractionOfSpecialCharacters() {
        $x("//*[@id=\"num1\"]").setValue("~!@#$");
        $x("//*[@id=\"num2\"]").setValue("%^&*(");
        $x("//*[@id=\"minus\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("NaN"));
    }

    @Test
    @DisplayName("33. Вычитание пустой строки")
    public void subtractionOfAnEmptyString() {
        $x("//*[@id=\"num1\"]").setValue("6");
        $x("//*[@id=\"minus\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("6"));
    }

    @Test
    @DisplayName("34. Вычитание положительной бесконечности")
    public void subtractionOfPositiveInfinity() {
        $x("//*[@id=\"num1\"]").setValue("6");
        $x("//*[@id=\"num2\"]").setValue("Infinity");
        $x("//*[@id=\"minus\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("-Infinity"));
    }

    @Test
    @DisplayName("35. Вычитание отрицательной бесконечности")
    public void subtractionOfNegativeInfinity() {
        $x("//*[@id=\"num1\"]").setValue("6");
        $x("//*[@id=\"num2\"]").setValue("-Infinity");
        $x("//*[@id=\"minus\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("Infinity"));
    }

    @Test
    @DisplayName("36. Вычитание положительного числа из 309 цифр 9 и бесконечности")
    public void subtractingANegativeNumberFrom309Digits9AndInfinity() {
        $x("//*[@id=\"num1\"]").setValue("999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999");
        $x("//*[@id=\"num2\"]").setValue("Infinity");
        $x("//*[@id=\"minus\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("NaN"));
        // Обнаружен баг. Ссылка: https://github.com/Vladislav0306/mihailmaximov-calculator/issues/2
    }

    @Test
    @DisplayName("37. Вычитание NaN")
    public void NaNSubtraction() {
        $x("//*[@id=\"num1\"]").setValue("9");
        $x("//*[@id=\"num2\"]").setValue("NaN");
        $x("//*[@id=\"minus\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("NaN"));
    }
}
