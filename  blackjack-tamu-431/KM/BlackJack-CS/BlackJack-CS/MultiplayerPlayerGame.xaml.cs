using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace BlackJack_CS
{
    /// <summary>
    /// Interaction logic for SinglePlayerGame.xaml
    /// </summary>
    public partial class MultiPlayerGame: UserControl
    {
        public MultiPlayerGame(List<string> names, List<Visibility> bools, int cash)
        {

            InitializeComponent();
            User1_Box.Header = names[0];
            User2_Box.Header = names[1];
            User3_Box.Header = names[2];
            User4_Box.Header = names[3];
            User5_Box.Header = names[4];
            
            User2_Box.Visibility = bools[0];
            User3_Box.Visibility = bools[1];
            User4_Box.Visibility = bools[2];
            User5_Box.Visibility = bools[3];
            
            user2Score.Visibility = bools[0];
            user3Score.Visibility = bools[1];
            user4Score.Visibility = bools[2];
            user5Score.Visibility = bools[3];

            user2Cash.Visibility = bools[0];
            user3Cash.Visibility = bools[1];
            user4Cash.Visibility = bools[2];
            user5Cash.Visibility = bools[3];

            user1Cash.Text = cash.ToString();
            user2Cash.Text = cash.ToString();
            user3Cash.Text = cash.ToString();
            user4Cash.Text = cash.ToString();
            user5Cash.Text = cash.ToString();
        }


        private void hitButton_Click(object sender, RoutedEventArgs e)
        {

        }

        private void standButton_Click(object sender, RoutedEventArgs e)
        {

        }

        private void doubleButton_Click(object sender, RoutedEventArgs e)
        {

        }

        private void splitButton_Click(object sender, RoutedEventArgs e)
        {

        }

        private void Image_ImageFailed(object sender, ExceptionRoutedEventArgs e)
        {

        }

        private void backButton(object sender, MouseButtonEventArgs e)
        {

            Switcher.Switch(new SinglePlayerOptions());
        }

        private void richTextBox1_TextChanged(object sender, TextChangedEventArgs e)
        {

        }


    }
}
