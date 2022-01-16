using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Exercise5_Rchu
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void textBox2_TextChanged(object sender, EventArgs e)
        {

        }

        private void textBox3_TextChanged(object sender, EventArgs e)
        {

        }
        private void button1_Click(object sender, EventArgs e)
        {
          
            string alphabet = "abcdefghiklmnopqrstuvwxyz".ToUpper();
            char[,] newAlphabet = new char[5, 5];
            string cipher = textBox1.Text + alphabet;
         
            RemoveDuplicate(ref cipher);
            char[] cipher2 = cipher.ToCharArray();

            Alphabet(ref newAlphabet, cipher);


            string output = "";
            Output(ref output, newAlphabet);

            textBox3.Text = output;
        }

        private void button2_Click(object sender, EventArgs e)
        {
            textBox1.Clear();
            textBox2.Clear();
            textBox3.Clear();
        }

        private void button3_Click(object sender, EventArgs e)
        {
            this.Close();
        }
        static char TransposedLetter(char[] cipher)
        {
            for (int i = 0; cipher.Length > i; i++)
            {

                if (cipher[i] == 'J')
                {
                    cipher[i] = 'I';
                }
            }
            return cipher[];
        }
        static string RemoveDuplicate(ref string dupe)
        {
            string noDupe = "";
            foreach (char chara in dupe)
            {
                if (noDupe.IndexOf(chara) == -1)
                {
                    noDupe += chara;
                }
            }
            dupe = noDupe;
            return noDupe;
        }

        static char[,] Alphabet(ref char[,] newAlphabet, string cipher)
        {
            string a = cipher.Substring(0, 5);
            string b = cipher.Substring(5, 5);
            string c = cipher.Substring(10, 5);
            string d = cipher.Substring(15, 5);
            string f = cipher.Substring(20, 5);
            for (int i = 0; i < 5; i++)
            {
                for (int j = 0; j < 5; j++)
                {
                    if (i == 0)
                        newAlphabet[i, j] = a[j];
                    if (i == 1)
                        newAlphabet[i, j] = b[j];
                    if (i == 2)
                        newAlphabet[i, j] = c[j];
                    if (i == 3)
                        newAlphabet[i, j] = d[j];
                    if (i == 4)
                        newAlphabet[i, j] = f[j];
                }
            }
            return newAlphabet;
        }

        static string Output(ref string output, char[,] newAlphabet, char[] cipher)
        {
            foreach (char cha in cipher)
            {
                for (int k = 0; k < 5; k++)
                {
                    for (int l = 0; l < 5; l++)
                    {
                        if (newAlphabet[k, l].Equals(cha))
                        {
                            output += newAlphabet[l, k];
                        }
                    }
                }
            }
            return output;
        }
    }
}
