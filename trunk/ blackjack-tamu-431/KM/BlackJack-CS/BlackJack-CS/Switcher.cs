using System;
using System.Collections.Generic;
using System.Windows.Controls;
using System.Linq;
using System.Text;

namespace BlackJack_CS
{
    class Switcher
    {
        public static MainWindow pageSwitcher;

        public static void Switch(UserControl newPage)
        {
            pageSwitcher.Navigate(newPage);
        }

        public static void Switch(UserControl newPage, object state)
        {
            pageSwitcher.Navigate(newPage, state);
        }
    }
}
