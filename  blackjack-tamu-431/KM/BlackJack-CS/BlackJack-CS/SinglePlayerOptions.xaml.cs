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
    /// Interaction logic for SinglePlayerOptions.xaml
    /// </summary>
    public partial class SinglePlayerOptions : UserControl
    {
        String username;
        String  comp1name,  comp2name,  comp3name,  comp4name;
        bool    comp1Active, comp2Active, comp3Active, comp4Active;
        int startingCash;

        public SinglePlayerOptions()
        {
            InitializeComponent();
        }

        private void PlayerNameTextBox_TextChanged(object sender, TextChangedEventArgs e)
        {
            username = playerNameTextBox.Text;
        }

        private void playerStartingCash_TextChanged(object sender, TextChangedEventArgs e)
        {
            int startcash;
            if (int.TryParse(playerStartingCash.Text, out startcash))
            {
                startingCash = startcash;
            }
            else
            {
                playerStartingCash.Text = "";
            }
        }

        private void ListBoxItem_Selected_0(object sender, RoutedEventArgs e)
        {

        }

        private void ListBoxItem_Selected_1(object sender, RoutedEventArgs e)
        {

        }

        private void ListBoxItem_Selected_2(object sender, RoutedEventArgs e)
        {

        }

        private void ListBoxItem_Selected_3(object sender, RoutedEventArgs e)
        {

        }

        private void ListBoxItem_Selected_4(object sender, RoutedEventArgs e)
        {

        }

        private void backButton(object sender, MouseButtonEventArgs e)
        {
            PopupTest.Placement = System.Windows.Controls.Primitives.PlacementMode.Center;
            PopupTest.Height = 100;
            PopupTest.Width = 100;
            PopupTest.IsOpen = true;
            PopupTest.StaysOpen = true;
        }

        private void backButton_yes(object sender, RoutedEventArgs e)
        {
            PopupTest.StaysOpen = false;
            Switcher.Switch(new Menu());

        }
       
        private void backButton_no(object sender, RoutedEventArgs e)
        {
            PopupTest.StaysOpen = false;
            PopupTest.IsOpen = false;
            
        }
        

        private void startButton(object sender, MouseButtonEventArgs e)
        {
            Switcher.Switch(new SinglePlayerGame());
        }

        private void PopupTest_Opened(object sender, EventArgs e)
        {

        }

 





    }
}
