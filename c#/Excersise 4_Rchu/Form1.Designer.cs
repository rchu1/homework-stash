namespace Excersise_4_Rchu
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.Pprice = new System.Windows.Forms.TextBox();
            this.DPA = new System.Windows.Forms.TextBox();
            this.IRAmout = new System.Windows.Forms.TextBox();
            this.LTerm = new System.Windows.Forms.TextBox();
            this.Amount = new System.Windows.Forms.TextBox();
            this.MonthlyP = new System.Windows.Forms.TextBox();
            this.Calculate = new System.Windows.Forms.Button();
            this.Close = new System.Windows.Forms.Button();
            this.Price = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.label7 = new System.Windows.Forms.Label();
            this.label8 = new System.Windows.Forms.Label();
            this.label9 = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // Pprice
            // 
            this.Pprice.Location = new System.Drawing.Point(219, 52);
            this.Pprice.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.Pprice.Name = "Pprice";
            this.Pprice.Size = new System.Drawing.Size(132, 22);
            this.Pprice.TabIndex = 0;
            this.Pprice.TextChanged += new System.EventHandler(this.Purchace_TextChanged);
            // 
            // DPA
            // 
            this.DPA.Location = new System.Drawing.Point(219, 98);
            this.DPA.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.DPA.Name = "DPA";
            this.DPA.Size = new System.Drawing.Size(132, 22);
            this.DPA.TabIndex = 1;
            this.DPA.TextChanged += new System.EventHandler(this.textBox2_TextChanged);
            // 
            // IRAmout
            // 
            this.IRAmout.Location = new System.Drawing.Point(219, 151);
            this.IRAmout.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.IRAmout.Name = "IRAmout";
            this.IRAmout.Size = new System.Drawing.Size(132, 22);
            this.IRAmout.TabIndex = 2;
            this.IRAmout.TextChanged += new System.EventHandler(this.textBox3_TextChanged);
            // 
            // LTerm
            // 
            this.LTerm.Location = new System.Drawing.Point(219, 196);
            this.LTerm.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.LTerm.Name = "LTerm";
            this.LTerm.Size = new System.Drawing.Size(132, 22);
            this.LTerm.TabIndex = 3;
            this.LTerm.TextChanged += new System.EventHandler(this.textBox4_TextChanged);
            // 
            // Amount
            // 
            this.Amount.AcceptsReturn = true;
            this.Amount.Location = new System.Drawing.Point(520, 50);
            this.Amount.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.Amount.Name = "Amount";
            this.Amount.ReadOnly = true;
            this.Amount.Size = new System.Drawing.Size(132, 22);
            this.Amount.TabIndex = 4;
            this.Amount.TextChanged += new System.EventHandler(this.textBox5_TextChanged);
            // 
            // MonthlyP
            // 
            this.MonthlyP.Location = new System.Drawing.Point(520, 150);
            this.MonthlyP.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.MonthlyP.Name = "MonthlyP";
            this.MonthlyP.ReadOnly = true;
            this.MonthlyP.Size = new System.Drawing.Size(132, 22);
            this.MonthlyP.TabIndex = 5;
            this.MonthlyP.TextChanged += new System.EventHandler(this.textBox6_TextChanged);
            // 
            // Calculate
            // 
            this.Calculate.Location = new System.Drawing.Point(51, 480);
            this.Calculate.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.Calculate.Name = "Calculate";
            this.Calculate.Size = new System.Drawing.Size(100, 28);
            this.Calculate.TabIndex = 6;
            this.Calculate.Text = "Calculate";
            this.Calculate.UseVisualStyleBackColor = true;
            this.Calculate.Click += new System.EventHandler(this.Calculate_Click);
            // 
            // Close
            // 
            this.Close.DialogResult = System.Windows.Forms.DialogResult.Cancel;
            this.Close.Location = new System.Drawing.Point(643, 480);
            this.Close.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.Close.Name = "Close";
            this.Close.Size = new System.Drawing.Size(100, 28);
            this.Close.TabIndex = 7;
            this.Close.Text = "Close";
            this.Close.UseVisualStyleBackColor = true;
            this.Close.Click += new System.EventHandler(this.Close_Click);
            // 
            // Price
            // 
            this.Price.Location = new System.Drawing.Point(0, 0);
            this.Price.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.Price.Name = "Price";
            this.Price.Size = new System.Drawing.Size(133, 28);
            this.Price.TabIndex = 12;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(53, 102);
            this.label2.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(154, 17);
            this.label2.TabIndex = 9;
            this.label2.Text = "Down Payment Amount";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(21, 160);
            this.label3.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(190, 17);
            this.label3.TabIndex = 10;
            this.label3.Text = "Intrest Rate Amount (annual)";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(76, 199);
            this.label4.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(137, 17);
            this.label4.TabIndex = 11;
            this.label4.Text = "Loan Term (months)";
            // 
            // label5
            // 
            this.label5.Location = new System.Drawing.Point(0, 0);
            this.label5.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(133, 28);
            this.label5.TabIndex = 1;
            // 
            // label6
            // 
            this.label6.Location = new System.Drawing.Point(0, 0);
            this.label6.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(133, 28);
            this.label6.TabIndex = 0;
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Location = new System.Drawing.Point(97, 55);
            this.label7.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(104, 17);
            this.label7.TabIndex = 14;
            this.label7.Text = "Purchase Price";
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.Location = new System.Drawing.Point(379, 55);
            this.label8.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(123, 17);
            this.label8.TabIndex = 15;
            this.label8.Text = "Amount To Finace";
            // 
            // label9
            // 
            this.label9.AutoSize = true;
            this.label9.Location = new System.Drawing.Point(395, 155);
            this.label9.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label9.Name = "label9";
            this.label9.Size = new System.Drawing.Size(116, 17);
            this.label9.TabIndex = 16;
            this.label9.Text = "Monthly Payment";
            // 
            // Form1
            // 
            this.AcceptButton = this.Calculate;
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.Info;
            this.CancelButton = this.Close;
            this.ClientSize = new System.Drawing.Size(1067, 554);
            this.Controls.Add(this.label9);
            this.Controls.Add(this.label8);
            this.Controls.Add(this.label7);
            this.Controls.Add(this.label6);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.Price);
            this.Controls.Add(this.Close);
            this.Controls.Add(this.Calculate);
            this.Controls.Add(this.MonthlyP);
            this.Controls.Add(this.Amount);
            this.Controls.Add(this.LTerm);
            this.Controls.Add(this.DPA);
            this.Controls.Add(this.Pprice);
            this.Controls.Add(this.IRAmout);
            this.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.Name = "Form1";
            this.Text = "Monthly Payment Calculator";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox Pprice;
        private System.Windows.Forms.TextBox DPA;
        private System.Windows.Forms.TextBox IRAmout;
        private System.Windows.Forms.TextBox LTerm;
        private System.Windows.Forms.TextBox Amount;
        private System.Windows.Forms.TextBox MonthlyP;
        private System.Windows.Forms.Button Calculate;
        private System.Windows.Forms.Button Close;
        private System.Windows.Forms.Label Price;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.Label label9;
    }
}

