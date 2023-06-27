import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class DivisionTest {
    @BeforeEach
    void setUp() {
        open("https://mihailmaximov.ru/projects/calc/index.html");
    }

    @Test
    @DisplayName("58. Деление целых положительных чисел")
    public void divisionOfPositiveIntegers() {
        $x("//*[@id=\"num1\"]").setValue("2");
        $x("//*[@id=\"num2\"]").setValue("5");
        $x("//*[@id=\"divide\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("0.4"));
    }

    @Test
    @DisplayName("59. Деление целых отрицательных чисел")
    public void divisionOfNegativeIntegers() {
        $x("//*[@id=\"num1\"]").setValue("-10");
        $x("//*[@id=\"num2\"]").setValue("-2");
        $x("//*[@id=\"divide\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("5"));
    }

    @Test
    @DisplayName("60. Деление целого положительного и целого отрицательного числа")
    public void divisionOfAPositiveIntegerAndANegativeInteger() {
        $x("//*[@id=\"num1\"]").setValue("-8");
        $x("//*[@id=\"num2\"]").setValue("4");
        $x("//*[@id=\"divide\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("-2"));
    }

    @Test
    @DisplayName("61. Деление вещественных положительных чисел")
    public void divisionOfRealPositiveIntegers() {
        $x("//*[@id=\"num1\"]").setValue("2.2");
        $x("//*[@id=\"num2\"]").setValue("1.1");
        $x("//*[@id=\"divide\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("2"));
    }

    @Test
    @DisplayName("62. Деление вещественных отрицательных чисел")
    public void divisionOfRealNegativeIntegers() {
        $x("//*[@id=\"num1\"]").setValue("-1.1");
        $x("//*[@id=\"num2\"]").setValue("-2.2");
        $x("//*[@id=\"divide\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("0.5"));
    }

    @Test
    @DisplayName("63. Деление вещественного положительного и вещественного отрицательного числа")
    public void divisionOfARealPositiveAndARealNegativeNumber() {
        $x("//*[@id=\"num1\"]").setValue("-2.2");
        $x("//*[@id=\"num2\"]").setValue("0.5");
        $x("//*[@id=\"divide\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("-4.4"));
    }

    @Test
    @DisplayName("64. Деление вещественного числа с 0 после точки")
    public void divisionARealNumberWith0AfterTheDot() {
        $x("//*[@id=\"num1\"]").setValue("5");
        $x("//*[@id=\"num2\"]").setValue("2.0");
        $x("//*[@id=\"divide\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("2.5"));
    }

    @Test
    @DisplayName("65. Деление на 1.9999999999999999")
    public void divisionBy1Dot9999999999999999() {
        $x("//*[@id=\"num1\"]").setValue("10");
        $x("//*[@id=\"num2\"]").setValue("1.9999999999999999");
        $x("//*[@id=\"divide\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("5"));
    }

    @Test
    @DisplayName("66. Деление 0 на число")
    public void divide0ByANumber() {
        $x("//*[@id=\"num1\"]").setValue("0");
        $x("//*[@id=\"num2\"]").setValue("7");
        $x("//*[@id=\"divide\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("0"));
    }
    @Test
    @DisplayName("67. Деление положительного числа на 0")
    public void divisionOfAPositiveNumberBy0() {
        $x("//*[@id=\"num1\"]").setValue("9");
        $x("//*[@id=\"num2\"]").setValue("0");
        $x("//*[@id=\"divide\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("Infinity"));
    }

    @Test
    @DisplayName("68. Деление отрицательного числа на 0")
    public void divisionOfANegativeNumberBy0() {
        $x("//*[@id=\"num1\"]").setValue("-2");
        $x("//*[@id=\"num2\"]").setValue("0");
        $x("//*[@id=\"divide\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("-Infinity"));
    }

    @Test
    @DisplayName("69. Деление 0 на 0")
    public void divisionOf0By0() {
        $x("//*[@id=\"num1\"]").setValue("0");
        $x("//*[@id=\"num2\"]").setValue("0");
        $x("//*[@id=\"divide\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("NaN"));
    }

    @Test
    @DisplayName("70. Деление на 1")
    public void divisionBy1() {
        $x("//*[@id=\"num1\"]").setValue("7");
        $x("//*[@id=\"num2\"]").setValue("1");
        $x("//*[@id=\"divide\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("7"));
    }

    @Test
    @DisplayName("71. Деление равных чисел")
    public void divisionOfEqualNumbers() {
        $x("//*[@id=\"num1\"]").setValue("7");
        $x("//*[@id=\"num2\"]").setValue("7");
        $x("//*[@id=\"divide\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("1"));
    }

    @Test
    @DisplayName("72. Деление на 10")
    public void divisionBy10() {
        $x("//*[@id=\"num1\"]").setValue("80");
        $x("//*[@id=\"num2\"]").setValue("10");
        $x("//*[@id=\"divide\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("8"));
    }

    @Test
    @DisplayName("73. Деление 1e-15 на 1e+308")
    public void dividing1eMinus15By1ePlus308() {
        $x("//*[@id=\"num1\"]").setValue("1e-15");
        $x("//*[@id=\"num2\"]").setValue("1e+308");
        $x("//*[@id=\"divide\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("1e-323"));
    }

    @Test
    @DisplayName("74. Деление 1e-15 на 1e+309")
    public void dividing1eMinus15By1ePlus309() {
        $x("//*[@id=\"num1\"]").setValue("1e-15");
        $x("//*[@id=\"num2\"]").setValue("1e+309");
        $x("//*[@id=\"divide\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("0"));
    }

    @Test
    @DisplayName("75. Деление букв")
    public void divisionOfLetters() {
        $x("//*[@id=\"num1\"]").setValue("привет");
        $x("//*[@id=\"num2\"]").setValue("абвгд");
        $x("//*[@id=\"divide\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("NaN"));
    }

    @Test
    @DisplayName("76. Деление спецсимволов")
    public void divisionOfSpecialCharacters() {
        $x("//*[@id=\"num1\"]").setValue("~!@#$");
        $x("//*[@id=\"num2\"]").setValue("%^&*(");
        $x("//*[@id=\"divide\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("NaN"));
    }

    @Test
    @DisplayName("77. Деление пустой строки")
    public void divisionOfAnEmptyString() {
        $x("//*[@id=\"num1\"]").setValue("7");
        $x("//*[@id=\"divide\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("Infinity"));
    }

    @Test
    @DisplayName("78. Деление положительной бесконечности на число")
    public void divisionOfPositiveInfinityByANumber() {
        $x("//*[@id=\"num1\"]").setValue("Infinity");
        $x("//*[@id=\"num2\"]").setValue("10");
        $x("//*[@id=\"divide\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("Infinity"));
    }

    @Test
    @DisplayName("79. Деление числа на положительную бесконечность")
    public void divisionOfANumberByPositiveInfinity() {
        $x("//*[@id=\"num1\"]").setValue("10");
        $x("//*[@id=\"num2\"]").setValue("Infinity");
        $x("//*[@id=\"divide\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("0"));
    }

    @Test
    @DisplayName("80. Деление отрицательной бесконечности на число")
    public void divisionOfNegativeInfinityByANumber() {
        $x("//*[@id=\"num1\"]").setValue("-Infinity");
        $x("//*[@id=\"num2\"]").setValue("10");
        $x("//*[@id=\"divide\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("-Infinity"));
    }

    @Test
    @DisplayName("81. Деление числа на отрицательную бесконечность")
    public void divisionOfANumberByNegativeInfinity() {
        $x("//*[@id=\"num1\"]").setValue("10");
        $x("//*[@id=\"num2\"]").setValue("-Infinity");
        $x("//*[@id=\"divide\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("0"));
    }

    @Test
    @DisplayName("82. Деление положительной бесконечности на 0")
    public void divisionOfPositiveInfinityBy0() {
        $x("//*[@id=\"num1\"]").setValue("Infinity");
        $x("//*[@id=\"num2\"]").setValue("0");
        $x("//*[@id=\"divide\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("Infinity"));
    }

    @Test
    @DisplayName("83. Деление 0 на положительную бесконечность")
    public void divisionOf0ByPositiveInfinity() {
        $x("//*[@id=\"num1\"]").setValue("0");
        $x("//*[@id=\"num2\"]").setValue("Infinity");
        $x("//*[@id=\"divide\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("0"));
    }

    @Test
    @DisplayName("84. Деление отрицательной бесконечности на 0")
    public void divisionOfNegativeInfinityBy0() {
        $x("//*[@id=\"num1\"]").setValue("-Infinity");
        $x("//*[@id=\"num2\"]").setValue("0");
        $x("//*[@id=\"divide\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("-Infinity"));
    }

    @Test
    @DisplayName("85. Деление 0 на отрицательную бесконечность")
    public void divisionOf0ByNegativeInfinity() {
        $x("//*[@id=\"num1\"]").setValue("0");
        $x("//*[@id=\"num2\"]").setValue("-Infinity");
        $x("//*[@id=\"divide\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("0"));
    }

    @Test
    @DisplayName("86. Деление бесконечности на бесконечность")
    public void divisionOfInfinityByInfinity() {
        $x("//*[@id=\"num1\"]").setValue("Infinity");
        $x("//*[@id=\"num2\"]").setValue("Infinity");
        $x("//*[@id=\"divide\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("NaN"));
    }

    @Test
    @DisplayName("87. Деление NaN")
    public void NaNDivision() {
        $x("//*[@id=\"num1\"]").setValue("9");
        $x("//*[@id=\"num2\"]").setValue("NaN");
        $x("//*[@id=\"divide\"]").click();
        $x("//*[@onclick=\"func()\"]").click();
        $x("//*[@id=\"result\"]").shouldBe(visible, Duration.ofSeconds(11)).shouldHave(exactText("NaN"));
    }
}