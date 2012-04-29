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
    /// Interaction logic for Menu.xaml
    /// </summary>
    public partial class Menu : UserControl
    {

        public Menu()
        {
            InitializeComponent();
        }

        private void backButton_Click(object sender, MouseButtonEventArgs e)
        {

        }

        private void gotoSinglePlayerOpsScreen(object sender, ExceptionRoutedEventArgs e)
        {

        }

        private void gotoMultiplayerOpsScreen(object sender, ExceptionRoutedEventArgs e)
        {

        }

        private void TextBox_TextChanged(object sender, TextChangedEventArgs e)
        {

        }

        private void singlePlayerButton(object sender, MouseButtonEventArgs e)
        {
            Switcher.Switch(new SinglePlayerOptions());
        }

        private void multiPlayerButton(object sender, MouseButtonEventArgs e)
        {
            Switcher.Switch(new MultiPlayerOptions());
        }

        private void Image_ImageFailed_1(object sender, ExceptionRoutedEventArgs e)
        {

        }



    }
}
