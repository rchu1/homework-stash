using System;
using System.Windows.Forms;

namespace Excersise_4_Rchu
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
          
        }

        private void Purchace_TextChanged(object sender, EventArgs e)
        {
          
        }
        private void textBox2_TextChanged(object sender, EventArgs e)
        {
            
        }
        private void textBox3_TextChanged(object sender, EventArgs e)
        {
            
        }
        private void textBox4_TextChanged(object sender, EventArgs e)
        {
          
        }
        private void textBox5_TextChanged(object sender, EventArgs e)
        {
            
            
        }
        private void textBox6_TextChanged(object sender, EventArgs e)
        {
            
        }

        private void Calculate_Click(object sender, EventArgs e)
        {
            double price=0;
            double DownPA = 0;
            double IRA = 0;
            int LoanTerm = 0;

            try
            {
                price = Convert.ToDouble(Pprice.Text);
            }
            catch (FormatException a)
            {
                MessageBox.Show("The inputs on this form cannot be empty");

            }

            try
            {
                DownPA = Convert.ToDouble(DPA.Text);
            }
            catch(FormatException a)
            {
                    MessageBox.Show("The inputs on this form cannot be empty"); 

            }
            try
            {
                IRA = Convert.ToDouble(IRAmout.Text);
            }
            catch (FormatException a)
            {
                
                    MessageBox.Show("Please fill in the text box with decimals!");
               
            }
            try
            {
                LoanTerm = Convert.ToInt32(LTerm.Text);
            }
            catch (FormatException a)
            {
                MessageBox.Show("The inputs on this form cannot be empty");

            }

            double MonthlyRate = IRA/100/12;
            double LoanTotal = price - DownPA;
            double AnnualRate = MonthlyRate * LoanTotal * Math.Pow((1 + MonthlyRate), LoanTerm)/(Math.Pow((1+MonthlyRate),LoanTerm)-1);

            MonthlyP.Text = String.Format("{0:C}", (AnnualRate));
            Amount.Text = String.Format("{0:C}", (LoanTotal));
        }

        private void Close_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
