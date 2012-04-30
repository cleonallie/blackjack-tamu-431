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
using engine;

namespace BlackJack_CS
{

    /// <summary>
    /// Interaction logic for SinglePlayerGame.xaml
    /// </summary>
    public partial class MultiPlayerGame: UserControl
    {
        List<double> Player1CardPos;
        List<double> Player2CardPos;
        List<double> Player3CardPos;
        List<double> Player4CardPos;
        List<double> Player5CardPos;
        public int startingCash;
        double b = 20;
        
        public MultiPlayerGame(List<string> names, List<Visibility> bools, int cash)
        {
            startingCash = cash;
            //Player1CardPos.Add(150); Player1CardPos.Add(40); Player1CardPos.Add(578); Player1CardPos.Add(170);
            //Player2CardPos.Add(150); Player2CardPos.Add(40); Player2CardPos.Add(578); Player2CardPos.Add(170);
            //Player3CardPos.Add(150); Player3CardPos.Add(40); Player3CardPos.Add(578); Player3CardPos.Add(170);
            //Player4CardPos.Add(150); Player4CardPos.Add(40); Player4CardPos.Add(578); Player4CardPos.Add(170);
            //Player5CardPos.Add(150); Player5CardPos.Add(40); Player5CardPos.Add(578); Player5CardPos.Add(170);

            InitializeComponent();
            User1_Box.Header = names[0];
            User2_Box.Header = names[1];
            User3_Box.Header = names[2];
            User4_Box.Header = names[3];
            User5_Box.Header = names[4];

            User1_Box.Visibility = bools[0];
            User2_Box.Visibility = bools[1];
            User3_Box.Visibility = bools[2];
            User4_Box.Visibility = bools[3];
            User5_Box.Visibility = bools[4];

            user1Score.Visibility = bools[0];
            user2Score.Visibility = bools[1];
            user3Score.Visibility = bools[2];
            user4Score.Visibility = bools[3];
            user5Score.Visibility = bools[4];

            user1Cash.Visibility = bools[0];
            user2Cash.Visibility = bools[1];
            user3Cash.Visibility = bools[2];
            user4Cash.Visibility = bools[3];
            user5Cash.Visibility = bools[4];

            user1Cash.Text = cash.ToString();
            user2Cash.Text = cash.ToString();
            user3Cash.Text = cash.ToString();
            user4Cash.Text = cash.ToString();
            user5Cash.Text = cash.ToString();
        }

        private void displayCard(List<double> Player,Card card)
        {
            b= b + 40;
            StackPanel newCard = new StackPanel();
            newCard.Margin = new Thickness(150,b, 578, 170);
            newCard.Visibility = System.Windows.Visibility.Visible;
            grid1.Children.Add(newCard);
            System.Windows.Controls.Image img = new System.Windows.Controls.Image();
            img.Source = new BitmapImage(new Uri("../Images/clubs-10-75.png",UriKind.RelativeOrAbsolute));//"../Images/" + card.getSuit() + "-" + card.getValue() + "-75.png", UriKind.RelativeOrAbsolute));
            newCard.Children.Add(img);
        }

        private void hitButton_Click(object sender, RoutedEventArgs e)
        {
            b = b + 40;
            StackPanel newCard = new StackPanel();
            newCard.Margin = new Thickness(150, b, 578, 170);
            newCard.Visibility = System.Windows.Visibility.Visible;
            grid1.Children.Add(newCard);
            System.Windows.Controls.Image img = new System.Windows.Controls.Image();
            img.Source = new BitmapImage(new Uri("../Images/clubs-10-75.png", UriKind.RelativeOrAbsolute));//"../Images/" + card.getSuit() + "-" + card.getValue() + "-75.png", UriKind.RelativeOrAbsolute));
            newCard.Children.Add(img);

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

            Switcher.Switch(new MultiPlayerOptions());
        }

        private void betTextBox_TextChanged(object sender, TextChangedEventArgs e)
        {

        }


    }
}