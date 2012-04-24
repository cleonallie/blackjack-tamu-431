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
    public partial class SinglePlayerGame : UserControl
    {
         public SinglePlayerGame()
        {
            InitializeComponent();
            
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
