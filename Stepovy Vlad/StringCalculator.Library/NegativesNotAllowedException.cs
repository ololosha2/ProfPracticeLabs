namespace StringCalculator.Library
{
    using System;

    public class NegativesNotAllowedException : Exception
    {
        public NegativesNotAllowedException(string message) : base(message)
        {
        }
    }
}