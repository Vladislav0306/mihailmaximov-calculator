import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class MultiplicationTest {
    @BeforeEach
    void setUp() {
        open("https://mihailmaximov.ru/projects/calc/index.html");
    }

    @Test
    @DisplayName("38. Умножение целых положительных чисел")
    public void multiplicationOfPositiveIntegers() {
        $x("//*[@id=\"num1\"]").setValue("2");
        $x("//*[@id=\"num2\"]").setValue("3");
        $x("//*[@id=\"times\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("6"));
    }

    @Test
    @DisplayName("39. Умножение целых отрицательных чисел")
    public void multiplicationOfNegativeIntegers() {
        $x("//*[@id=\"num1\"]").setValue("-7");
        $x("//*[@id=\"num2\"]").setValue("-3");
        $x("//*[@id=\"times\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("21"));
    }

    @Test
    @DisplayName("40. Умножение целого положительного и целого отрицательного числа")
    public void multiplicationOfAPositiveIntegerAndANegativeInteger() {
        $x("//*[@id=\"num1\"]").setValue("-8");
        $x("//*[@id=\"num2\"]").setValue("4");
        $x("//*[@id=\"times\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("-32"));
    }

    @Test
    @DisplayName("41. Умножение вещественных положительных чисел")
    public void multiplicationOfRealPositiveIntegers() {
        $x("//*[@id=\"num1\"]").setValue("2.2");
        $x("//*[@id=\"num2\"]").setValue("1.1");
        $x("//*[@id=\"times\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("2.4200000000000004"));
        // Обнаружен баг. Ссылка: https://github.com/Vladislav0306/mihailmaximov-calculator/issues/1
    }

    @Test
    @DisplayName("42. Умножение вещественных отрицательных чисел")
    public void multiplicationOfRealNegativeIntegers() {
        $x("//*[@id=\"num1\"]").setValue("-1.1");
        $x("//*[@id=\"num2\"]").setValue("-1.1");
        $x("//*[@id=\"times\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("1.2100000000000002"));
        // Обнаружен баг. Ссылка: https://github.com/Vladislav0306/mihailmaximov-calculator/issues/1
    }

    @Test
    @DisplayName("43. Умножение вещественного положительного и вещественного отрицательного числа")
    public void multiplicationOfARealPositiveAndARealNegativeNumber() {
        $x("//*[@id=\"num1\"]").setValue("-2.2");
        $x("//*[@id=\"num2\"]").setValue("0.5");
        $x("//*[@id=\"times\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("-1.1"));
    }

    @Test
    @DisplayName("44. Умножение вещественного числа с 0 после точки")
    public void multiplyingARealNumberWith0AfterTheDot() {
        $x("//*[@id=\"num1\"]").setValue("5");
        $x("//*[@id=\"num2\"]").setValue("2.0");
        $x("//*[@id=\"times\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("10"));
    }

    @Test
    @DisplayName("45. Умножение на 1.9999999999999999")
    public void multiplyBy1Dot9999999999999999() {
        $x("//*[@id=\"num1\"]").setValue("2");
        $x("//*[@id=\"num2\"]").setValue("1.9999999999999999");
        $x("//*[@id=\"times\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("4"));
    }

    @Test
    @DisplayName("46. Умножение на 0")
    public void multiplyBy0() {
        $x("//*[@id=\"num1\"]").setValue("9");
        $x("//*[@id=\"num2\"]").setValue("0");
        $x("//*[@id=\"times\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("0"));
    }

    @Test
    @DisplayName("47. Умножение на 1")
    public void multiplyBy1() {
        $x("//*[@id=\"num1\"]").setValue("7");
        $x("//*[@id=\"num2\"]").setValue("1");
        $x("//*[@id=\"times\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("7"));
    }

    @Test
    @DisplayName("48. Умножение на 10")
    public void multiplyBy10() {
        $x("//*[@id=\"num1\"]").setValue("9");
        $x("//*[@id=\"num2\"]").setValue("10");
        $x("//*[@id=\"times\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("90"));
    }

    @Test
    @DisplayName("49. Умножение 1e+308 на 10")
    public void multiply1ePlus308To0() {
        $x("//*[@id=\"num1\"]").setValue("1e+308");
        $x("//*[@id=\"num2\"]").setValue("10");
        $x("//*[@id=\"times\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("Infinity"));
    }

    @Test
    @DisplayName("50. Умножение букв")
    public void multiplicationOfLetters() {
        $x("//*[@id=\"num1\"]").setValue("привет");
        $x("//*[@id=\"num2\"]").setValue("абвгд");
        $x("//*[@id=\"times\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("NaN"));
    }

    @Test
    @DisplayName("51. Умножение спецсимволов")
    public void multiplicationOfSpecialCharacters() {
        $x("//*[@id=\"num1\"]").setValue("~!@#$");
        $x("//*[@id=\"num2\"]").setValue("%^&*(");
        $x("//*[@id=\"times\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("NaN"));
    }

    @Test
    @DisplayName("52. Умножение пустой строки")
    public void multiplicationOfAnEmptyString() {
        $x("//*[@id=\"num1\"]").setValue("7");
        $x("//*[@id=\"times\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("0"));
    }

    @Test
    @DisplayName("53. Умножение положительной бесконечности")
    public void multiplicationOfPositiveInfinity() {
        $x("//*[@id=\"num1\"]").setValue("Infinity");
        $x("//*[@id=\"num2\"]").setValue("2");
        $x("//*[@id=\"times\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("Infinity"));
    }

    @Test
    @DisplayName("54. Умножение отрицательной бесконечности")
    public void multiplicationOfNegativeInfinity() {
        $x("//*[@id=\"num1\"]").setValue("-Infinity");
        $x("//*[@id=\"num2\"]").setValue("2");
        $x("//*[@id=\"times\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("-Infinity"));
    }

    @Test
    @DisplayName("55. Умножение положительной и отрицательной бесконечности")
    public void multiplicationOfPositiveAndNegativeInfinity() {
        $x("//*[@id=\"num1\"]").setValue("-Infinity");
        $x("//*[@id=\"num2\"]").setValue("Infinity");
        $x("//*[@id=\"times\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("-Infinity"));
    }

    @Test
    @DisplayName("56. Умножение бесконечности на 0")
    public void multiplyInfinityBy0() {
        $x("//*[@id=\"num1\"]").setValue("Infinity");
        $x("//*[@id=\"num2\"]").setValue("0");
        $x("//*[@id=\"times\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("NaN"));
    }

    @Test
    @DisplayName("57. Умножение NaN")
    public void NaNMultiplication() {
        $x("//*[@id=\"num1\"]").setValue("9");
        $x("//*[@id=\"num2\"]").setValue("NaN");
        $x("//*[@id=\"times\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("NaN"));
    }
}
