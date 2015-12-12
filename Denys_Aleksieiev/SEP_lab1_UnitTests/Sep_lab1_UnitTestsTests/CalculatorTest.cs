using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using SEP_lab1_UnitTests;

namespace Sep_lab1_UnitTestsTests
{
    [TestClass]
    public class CalculatorTest
    {
        [TestMethod]
        public void AddEmptyStringTest()
        {
            Calculator calc = new Calculator();
            int result = calc.Add(String.Empty);
            Assert.AreEqual<int>(0, result);
        }

        [TestMethod]
        public void AddOneArgumentTest()
        {
            Calculator calc = new Calculator();
            Random rand = new Random(10);
            int arg = rand.Next();
            int result = calc.Add(arg.ToString());
            Assert.AreEqual<int>(arg, result);
        }

        [TestMethod]
        public void AddTwoArgumentsTest()
        {
            Calculator calc = new Calculator();
            Random rand = new Random(10);
            int arg1 = rand.Next();
            int arg2 = rand.Next();
            int result = calc.Add(arg1.ToString() + "," + arg2.ToString());
            Assert.AreEqual<int>(arg1 + arg2, result);
        }

        [TestMethod]
        public void AddMultipleArgumentsTest()
        {
            Calculator calc = new Calculator();
            string strNums = "1,5,6,10,105,5,8,0";
            int result = calc.Add(strNums);
            Assert.AreEqual<int>(140, result);
        }

        [TestMethod]
        public void AddNewLinesAndCommasTest()
        {
            Calculator calc = new Calculator();
            string strNums = "1\n10,4\n1";
            int result = calc.Add(strNums);
            Assert.AreEqual<int>(16, result);
        }

        [TestMethod]
        public void AddChangeDelimiterTest()
        {
            Calculator calc = new Calculator();
            string strNums = "//:\n10:4:1";
            int result = calc.Add(strNums);
            Assert.AreEqual<int>(15, result);
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentException))]
        public void AddNegativeThrowsExceptionTest()
        {
            Calculator calc = new Calculator();
            string strNums = "-10,-2,1";
            int result = calc.Add(strNums);
        }
    }
}
