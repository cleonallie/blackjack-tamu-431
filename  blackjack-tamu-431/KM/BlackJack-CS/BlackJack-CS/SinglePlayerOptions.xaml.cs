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
        string username, comp1name,  comp2name,  comp3name,  comp4name;
        Visibility comp1Active, comp2Active, comp3Active, comp4Active;
        int startingCash;
        List<string> names = new List<string>();
        List<Visibility> bools = new List<Visibility>();

        public SinglePlayerOptions()
        {
            username = ""; comp1name = ""; comp2name = ""; comp3name = ""; comp4name = "";

            comp1Active = System.Windows.Visibility.Hidden;
            comp2Active = System.Windows.Visibility.Hidden;
            comp3Active = System.Windows.Visibility.Hidden;
            comp4Active = System.Windows.Visibility.Hidden;
            startingCash = 0;
            InitializeComponent();
        }

        private void PlayerNameTextBox_TextChanged(object sender, TextChangedEventArgs e)
        {
            username = playerNameTextBox.Text;
        }

        private void playerStartingCash_TextChanged(object sender, TextChangedEventArgs e)
        {
            int startcash;
            char[] trimChars = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' ,'$',
                               'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','!','@','#','%','^','&','*','(',')','`','~',':','"','{','}'
                                ,'[',']','<','>','?','/','_','-','+','='};
            if (int.TryParse(playerStartingCash.Text, out startcash))
            {
                startingCash = startcash;
            }
            else
            {
                playerStartingCash.Text = playerStartingCash.Text.Trim(trimChars);
             
            }
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
            names.Add(username); names.Add(comp1name); names.Add(comp2name); names.Add(comp3name); names.Add(comp4name);
            bools.Add(comp1Active); bools.Add(comp2Active); bools.Add(comp3Active); bools.Add(comp4Active);
            Switcher.Switch(new SinglePlayerGame(names, bools, startingCash));
        }

        private void PopupTest_Opened(object sender, EventArgs e)
        {

        }
    }
}
