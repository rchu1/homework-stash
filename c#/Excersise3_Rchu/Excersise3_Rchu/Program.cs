using System;

namespace Excersise3_Rchu
{
    class Program
    {
        static Int32 iterations;
        static double piValue;
        static double iterationValue;
        static void Main(string[] args)
        {
            numberOfCalculations();
            calculations(iterations);

        }

        public static void numberOfCalculations()
        {
            Int32 input;
            bool parseNum = false;
            String inputValidation;
            Console.WriteLine("Randy Chu Implementation of the the Leibniz Formula");
            Console.WriteLine();
            Console.WriteLine("Please enter the number of times to run this calculation");
            do
            {
                Console.Write("Please enter value > 1 million: ");
                inputValidation = Console.ReadLine();
                parseNum = int.TryParse(inputValidation, out input);
            } while (input <= 1000000 || parseNum == false);

            iterations = input;

            Console.WriteLine("{0}", input);
            Console.WriteLine("-----------------------------------------------------------");
            Console.WriteLine("");
        }
        public static void calculations(Int32 iterations)
        {

            for (int i = 0; i < iterations; i++)
            {
                piValue = (Math.Pow(-1, i) / ((2 * i) + 1));
                iterationValue += piValue;
                if (i == 9)
                {
                    Console.WriteLine("At 10 iterations, the value of pi is {0}", string.Format("{0:#,0.0000000000}", iterationValue * 4));
                }
                if (i == 999)
                {
                    Console.WriteLine("At 1,000 iterations, the value of pi is {0}", string.Format("{0:#,0.0000000000}", iterationValue * 4));
                }
                if (i == 99999)
                {
                    Console.WriteLine("At 100,000 iterations, the value of pi is {0}", string.Format("{0:#,0.0000000000}", iterationValue * 4));
                }
                if (i == 499999)
                {
                    Console.WriteLine("At 500,000 iterations, the value of pi is {0}", string.Format("{0:#,0.0000000000}", iterationValue * 4));
                }
                if (i == 999999)
                {
                    Console.WriteLine("At 1,000,000 iterations, the value of pi is {0}", string.Format("{0:#,0.0000000000}", iterationValue * 4));
                }
                if (i == (iterations - 1))
                {
                    Console.WriteLine("At {0} iterations, the value of pi is {1}", string.Format("{0:#,0}", iterations), string.Format("{0:#,0.0000000000}", iterationValue * 4));
                }
            }
            Console.WriteLine();
        }
    }
}
