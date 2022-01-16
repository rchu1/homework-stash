using System;

namespace Excercise_2
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("BMI and Karvonen Calculator");
            Console.WriteLine("Please enter the following values for the user...");
            Console.WriteLine("Height in inches: ");
            int height = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine("Weight in pounds: ");
            int weight = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine("Age: ");
            int age = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine("Resting heart rate: ");
            int hRate = Convert.ToInt32(Console.ReadLine());


            double meter = height / 39.37;
            double kg = weight / 2.205;
            double BMI = kg / Math.Pow(meter, 2);
            if (BMI >= 30)
            {
                Console.WriteLine("You BMI is: " + String.Format("{0:0.00}", BMI) + " --- Obesity ");
            }
            else if (BMI >= 25 && BMI <= 29.9)
            {
                Console.WriteLine("You BMI is: " + String.Format("{0:0.00}", BMI) + " --- Over weight");
            }
            else if (BMI >= 18.5 && BMI <= 24.9)
            {
                Console.WriteLine("You BMI is: " + String.Format("{0:0.00}", BMI) + " --- Normal weight");
            }
            else
            {
                Console.WriteLine("You BMI is: " + String.Format("{0:0.00}", BMI) + " --- Under weight");
            }

        }
        public double Hbeat( int age, int hRate)
        {
            int mhr = 220 - age;
            int hrr = mhr - hRate;
            double mtz = hrr * .50;
            double ttz = mtz + hRate;

            return maxHeartBeat;
        }
    }
}
