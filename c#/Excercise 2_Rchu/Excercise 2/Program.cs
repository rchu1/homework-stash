using System;

namespace Excercise_2
{
    class Program
    {
        private static readonly bool GetHbeat;
        private static Int16 Height;
        private static Int16 Weight;
        private static Int16 age;
        private static Int16 heartRate;

        static void Main(string[] args)
        {

            beginningInput();
            bmiCalculation(Height, Weight);
            HeartRate(age, heartRate);
            Console.WriteLine();
        }

        static void beginningInput()
        {
            Console.WriteLine("BMI and Karvonen Calculator    Randy Chu");

            Console.WriteLine();
            Console.WriteLine("Please Enter the following values for the user");
            Console.WriteLine();

            Console.Write("Height in inches: ");
            Height = Convert.ToInt16(Console.ReadLine());

            Console.Write("Weight in pounds: ");
            Weight = Convert.ToInt16(Console.ReadLine());

            Console.Write("Age: ");
            age = Convert.ToInt16(Console.ReadLine());

            Console.Write("Resting heart rate: ");
            heartRate = Convert.ToInt16(Console.ReadLine());

            Console.Write("");
        }
        static void bmiCalculation(Int16 Height, Int16 Weight)
        {
            double inches = Height * .0254;
            double kg = Weight * .4536;

            double Total = kg / Math.Pow(inches, 2);

            Console.WriteLine("Results. . .");

            if (Total < 18.5)
                Console.WriteLine("Your BMI is: {0} -- Underweight", string.Format("{0:,0.00}", Total));
            if (Total >= 18.5 && Total < 25)
                Console.WriteLine("Your BMI is: {0} -- Normal weight", string.Format("{0:,0.00}", Total));
            if (Total >= 25 && Total < 30)
                Console.WriteLine("Your BMI is: {0} -- Overweight", string.Format("{0:,0.00}", Total));
            if (Total >= 30)
                Console.WriteLine("Your BMI is: {0} -- Obesity", string.Format("{0:,0.00}", Total));
            Console.WriteLine();
        }
        /* Got help from line 71 down I got help for a friend */
        static void HeartRate(Int16 age, Int16 heartRate)
        {
            Int32 maxHeartRate = 220 - age;
            Int32 heartRateReserve = maxHeartRate - heartRate;
            Console.WriteLine("Exercise Intensity Heart Rates:");
            Console.WriteLine("Intensity        Max Heart Rate");
            Console.WriteLine();
            for (Int16 i = 50; i <= 95; i += 5)
            {
                double decimalIntensity = heartRateReserve * (Convert.ToDouble(i) / 100);
                double targetZone = decimalIntensity + heartRate;
                Console.WriteLine("{0}%      --     {1}", i, targetZone);
            }
        }
    }
}
