using System;

namespace Excerise1
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Randy Floor Cost Estomator n/");
            
            Console.WriteLine("PLease enter the lenght of the floor: ");
            int lenght = Convert.ToInt32(Console.ReadLine());
            
            Console.WriteLine("PLease enter the width of the floor");
            int width = Convert.ToInt32(Console.ReadLine());

            Console.WriteLine("Please enter the cost per square foot for the flooring selected: ");
            double cost = Convert.ToDouble(Console.ReadLine());

            int area = lenght * width;

            double total1 = cost * Convert.ToDouble(area);

            double total2 = (Convert.ToDouble(area)/40)*35.75;

            double total3 = total1 + total2;

            double hour = ( Convert.ToDouble(area)/40);

            Console.WriteLine("For the total Floor size is:" + area);
            Console.WriteLine(" With the floor cost is " + total1.ToString("C") + " If you do this by yourself it will take you: "+ Math.Round(hour,2,MidpointRounding.ToEven) +" hours to do" );
            Console.WriteLine("If you do installation that will add to a total of: " + total2.ToString("C") + " with of a totla of: " + "$" + total3.ToString("C")); 

        }
    }
}
