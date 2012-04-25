﻿using System;
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
            char[] trimChars = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' ,'$'};
            if (int.TryParse(playerStartingCash.Text, out startcash))
            {
                startingCash = startcash;
            }
            else
            {
                playerStartingCash.Text = playerStartingCash.Text.Trim(trimChars);
             
            }
        }

        private void ListBoxItem_Selected_0(object sender, RoutedEventArgs e)
        {
            comp1Active = System.Windows.Visibility.Hidden;
            comp2Active = System.Windows.Visibility.Hidden;
            comp3Active = System.Windows.Visibility.Hidden;
            comp4Active = System.Windows.Visibility.Hidden;

            opponent1.Visibility = System.Windows.Visibility.Hidden;
            opponent1textBox.Visibility = System.Windows.Visibility.Hidden;
            opponent1.IsEnabled = false;
            opponent2.Visibility = System.Windows.Visibility.Hidden;
            opponent2textBox.Visibility = System.Windows.Visibility.Hidden;
            opponent2.IsEnabled = false;
            opponent3.Visibility = System.Windows.Visibility.Hidden;
            opponent3textBox.Visibility = System.Windows.Visibility.Hidden;
            opponent3.IsEnabled = false;
            opponent4.Visibility = System.Windows.Visibility.Hidden;
            opponent4textBox.Visibility = System.Windows.Visibility.Hidden;
            opponent4.IsEnabled = false;

        }

        private void ListBoxItem_Selected_1(object sender, RoutedEventArgs e)
        {
            comp1Active = System.Windows.Visibility.Visible;
            comp2Active = System.Windows.Visibility.Hidden;
            comp3Active = System.Windows.Visibility.Hidden;
            comp4Active = System.Windows.Visibility.Hidden;
            opponent1.Visibility = System.Windows.Visibility.Visible;
            opponent1textBox.Visibility = System.Windows.Visibility.Visible;
            opponent1.IsEnabled = true;
            opponent2.Visibility = System.Windows.Visibility.Hidden;
            opponent2textBox.Visibility = System.Windows.Visibility.Hidden;
            opponent2.IsEnabled = false;
            opponent3.Visibility = System.Windows.Visibility.Hidden;
            opponent3textBox.Visibility = System.Windows.Visibility.Hidden;
            opponent3.IsEnabled = false;
            opponent4.Visibility = System.Windows.Visibility.Hidden;
            opponent4textBox.Visibility = System.Windows.Visibility.Hidden;
            opponent4.IsEnabled = false;
        }

        private void ListBoxItem_Selected_2(object sender, RoutedEventArgs e)
        {
            comp1Active = System.Windows.Visibility.Visible;
            comp2Active = System.Windows.Visibility.Visible;
            comp3Active = System.Windows.Visibility.Hidden;
            comp4Active = System.Windows.Visibility.Hidden;
            opponent1.Visibility = System.Windows.Visibility.Visible;
            opponent1textBox.Visibility = System.Windows.Visibility.Visible;
            opponent1.IsEnabled = true;
            opponent2.Visibility = System.Windows.Visibility.Visible;
            opponent2textBox.Visibility = System.Windows.Visibility.Visible;
            opponent2.IsEnabled = true;
            opponent3.Visibility = System.Windows.Visibility.Hidden;
            opponent3textBox.Visibility = System.Windows.Visibility.Hidden;
            opponent3.IsEnabled = false;
            opponent4.Visibility = System.Windows.Visibility.Hidden;
            opponent4textBox.Visibility = System.Windows.Visibility.Hidden;
            opponent4.IsEnabled = false;
        }

        private void ListBoxItem_Selected_3(object sender, RoutedEventArgs e)
        {
            comp1Active = System.Windows.Visibility.Visible;
            comp2Active = System.Windows.Visibility.Visible;
            comp3Active = System.Windows.Visibility.Visible;
            comp4Active = System.Windows.Visibility.Hidden;
            opponent1.Visibility = System.Windows.Visibility.Visible;
            opponent1textBox.Visibility = System.Windows.Visibility.Visible;
            opponent1.IsEnabled = true;
            opponent2.Visibility = System.Windows.Visibility.Visible;
            opponent2textBox.Visibility = System.Windows.Visibility.Visible;
            opponent2.IsEnabled = true;
            opponent3.Visibility = System.Windows.Visibility.Visible;
            opponent3textBox.Visibility = System.Windows.Visibility.Visible;
            opponent3.IsEnabled = true;
            opponent4.Visibility = System.Windows.Visibility.Hidden;
            opponent4textBox.Visibility = System.Windows.Visibility.Hidden;
            opponent4.IsEnabled = false;
        }

        private void ListBoxItem_Selected_4(object sender, RoutedEventArgs e)
        {
            comp1Active = System.Windows.Visibility.Visible;
            comp2Active = System.Windows.Visibility.Visible;
            comp3Active = System.Windows.Visibility.Visible;
            comp4Active = System.Windows.Visibility.Visible;
            opponent1.Visibility = System.Windows.Visibility.Visible;
            opponent1textBox.Visibility = System.Windows.Visibility.Visible;
            opponent1.IsEnabled = true;
            opponent2.Visibility = System.Windows.Visibility.Visible;
            opponent2textBox.Visibility = System.Windows.Visibility.Visible;
            opponent2.IsEnabled = true;
            opponent3.Visibility = System.Windows.Visibility.Visible;
            opponent3textBox.Visibility = System.Windows.Visibility.Visible;
            opponent3.IsEnabled = true;
            opponent4.Visibility = System.Windows.Visibility.Visible;
            opponent4textBox.Visibility = System.Windows.Visibility.Visible;
            opponent4.IsEnabled = true;
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

        private void opponent1textBox_TextChanged(object sender, TextChangedEventArgs e)
        {
            comp1name = opponent1textBox.Text;
        }

        private void opponent2textBox_TextChanged(object sender, TextChangedEventArgs e)
        {
            comp2name = opponent2textBox.Text;
        }

        private void opponent3textBox_TextChanged(object sender, TextChangedEventArgs e)
        {
            comp3name = opponent3textBox.Text;
        }

        private void opponent4textBox_TextChanged(object sender, TextChangedEventArgs e)
        {
            comp4name = opponent4textBox.Text;
        }


      


 





    }
}
