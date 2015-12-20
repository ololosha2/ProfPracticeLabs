using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Lab1;

namespace ModuleTest
{
    [TestClass]
    public class UnitTest1
    {
        [TestMethod]
        public void Test1()
        {
            int r1 = Program.Add("");                    // 0
            Assert.AreEqual(r1, 0);
        }
        [TestMethod]
        public void Test2()
        {
            int r2 = Program.Add("1");                   // 1
            Assert.AreEqual(r2, 1);
        }
        [TestMethod]
        public void Test3()
        {
            int r3 = Program.Add("1,2");                 // 3
            Assert.AreEqual(r3, 3);
        }
        [TestMethod]
        public void Test4()
        {
            int r4 = Program.Add("1,2,3\n4,5");          // 15
            Assert.AreEqual(r4, 15);
        }
        [TestMethod]
        public void Test5()
        {
            int r5 = Program.Add("1\n,2\n,3");           // 0
            Assert.AreEqual(r5, 0);
        }
        [TestMethod]
        public void Test6()
        {
            int r6 = Program.Add("//;\n1;2;3");          // 6
            Assert.AreEqual(r6, 6);
        }
        [TestMethod]
        public void Test7()
        {
            int r7 = Program.Add("1,2,10000");           // 3
            Assert.AreEqual(r7, 3);
        }
        [TestMethod]
        public void Test8()
        {
            int r8 = Program.Add("//[***]\n1***2***3");    // 6
            Assert.AreEqual(r8, 6);
        }
        [TestMethod]
        public void Test9()
        {
            int r9 = Program.Add("//[,][%][:][;]\n1,2,4,5:6;7");  // 25
            Assert.AreEqual(r9, 25);
        }
        [TestMethod]
        public void Test10()
        {
            int r10 = Program.Add("//[,][%::][:][;]\n1,2,4,5:6;7%::10");  // 35
            Assert.AreEqual(r10, 35);
        }

        [TestMethod]
        [ExpectedException(typeof(NegativeNumnerException))]
        public void Negativees()
        {
            int res = Program.Add("-1,-2,-3");
        }
    }
}

