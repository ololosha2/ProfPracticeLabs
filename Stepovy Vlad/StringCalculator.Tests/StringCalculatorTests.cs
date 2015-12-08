namespace StringCalculator.Tests
{
    using System;
    using System.Linq;
    using Microsoft.VisualStudio.TestTools.UnitTesting;
    using StringCalculator.Library;
    using Calculator = StringCalculator.Library.StringCalculator;

    [TestClass]
    public class StringCalculatorTests
    {
        [TestMethod]
        public void AddCanTakeEmptyStringAsArgument()
        {
            // Arrange
            var calculator = new Calculator();

            // Act
            int result = calculator.Add("");

            // Assert
            Assert.AreEqual(0, result);
        }

        [TestMethod]
        public void AddCanTakeStringWithOneNumberAsArgument()
        {
            // Arrange
            var calculator = new Calculator();

            // Act
            int result = calculator.Add("1");

            // Assert
            Assert.AreEqual(1, result);
        }

        [TestMethod]
        public void AddCanTakeStringWithMultipleNumbersAsArgument()
        {
            // Arrange
            var calculator = new Calculator();

            // Act
            int result = calculator.Add("1,2");

            // Assert
            Assert.AreEqual(3, result);
        }

        [TestMethod]
        public void AddCanTakeStringWithUnknownAmountOfNumbersAsArgument()
        {
            // Arrange
            var calculator = new Calculator();
            var numbers = new int[10];
            var random = new Random();
            for (int i = 0; i < numbers.Length; i++)
            {
                numbers[i] = random.Next(0, 35);
            }
            var sum = numbers.Sum();
            var numbersString = string.Join(",", numbers.Select(n => n.ToString()));

            // Act
            int result = calculator.Add(numbersString);

            // Assert
            Assert.AreEqual(sum, result);
        }

        [TestMethod]
        public void AddCanTakeStringWithNewLineOrCommaDelimetersAsArgument()
        {
            // Arrange
            var calculator = new Calculator();

            // Act
            int result = calculator.Add("1\n2,3");

            // Assert
            Assert.AreEqual(6, result);
        }

        [TestMethod]
        public void AddCanSupportDifferentDelimeters()
        {
            // Arrange
            var calculator = new Calculator();

            // Act
            int result = calculator.Add("//;\n1;2");

            // Assert
            Assert.AreEqual(3, result);
        }
        
        [TestMethod]
        public void CallingAddWithNegativeNumbersWillThrowAnExceptionWithPassedNegativesAsMessage()
        {
            // Arrange
            var calculator = new Calculator();
            var result1 = string.Empty;
            var result2 = string.Empty;

            // Act 1
            try
            {
                calculator.Add("-1,2");
            }
            catch (NegativesNotAllowedException exception)
            {
                result1 = exception.Message;
            }

            // Act 2
            try
            {
                calculator.Add("-1,2,-183");
            }
            catch (NegativesNotAllowedException exception)
            {
                result2 = exception.Message;
            }

            // Assert
            Assert.AreEqual("-1", result1);
            Assert.AreEqual("-1,-183", result2);
        }

        [TestMethod]
        public void AddSkipNumbersBiggerThanThousand()
        {
            // Arrange
            var calculator = new Calculator();

            // Act
            int result = calculator.Add("2,1001");

            // Assert
            Assert.AreEqual(2, result);
        }

        [TestMethod]
        public void DelimetersCanBeOfAnyLength()
        {
            // Arrange
            var calculator = new Calculator();

            // Act
            int result = calculator.Add("//[***]\n1***2***3");

            // Assert
            Assert.AreEqual(6, result);
        }

        [TestMethod]
        public void CalculatorAllowMultipleDelimeters()
        {
            // Arrange
            var calculator = new Calculator();

            // Act
            int result = calculator.Add("//[*][%]\n1***2***3");

            // Assert
            Assert.AreEqual(6, result);
        }

        [TestMethod]
        public void CalculatorAllowMultipleDelimetersOfAnyLength()
        {
            // Arrange
            var calculator = new Calculator();

            // Act
            int result = calculator.Add("//[***][%&@]\n1***2***3%&@5");

            // Assert
            Assert.AreEqual(11, result);
        }
    }
}