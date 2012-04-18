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

namespace BlackJack_CS {
	/// <summary>
	/// Interaction logic for MainWindow.xaml
	/// </summary>
	public partial class MainWindow : Window {

		#region Members and constants
		Canvas activeScreen;
		Stack<Canvas> screenHistory;
		#endregion

		public MainWindow() {
			InitializeComponent();
			activeScreen = homeScreen;
			screenHistory = new Stack<Canvas>();
		}

		/// <summary>
		/// Swap the current active visible Canvas with the one specified as an argument. Functions as a means to display
		/// different screens.
		/// </summary>
		/// <param name="newActiveScreen">New Canvas to visually switch to</param>
		/// <param name="goingBack">Is this function being called as part of the user selecting a "Back" button</param>
		private void swapActiveCanvas(Canvas newActiveScreen, bool goingBack) {
			Canvas oldScreen = activeScreen;
			activeScreen = newActiveScreen;
			if (goingBack) {
				// Remove last screen from history if going back
				screenHistory.Pop();
			} else {
				// Keep track of screen history to allow users to go back
				screenHistory.Push(oldScreen);
			}
			oldScreen.Visibility = Visibility.Hidden;
			activeScreen.Visibility = Visibility.Visible;
		}

		/// <summary>
		/// Event handler for when the "Back" button is clicked. Retreats one screen in the screen history. If
		/// no previous screen exists in the history, this function does nothing.
		/// </summary>
		/// <param name="sender"></param>
		/// <param name="e"></param>
		private void backButton_Click(object sender, MouseButtonEventArgs e) {
			if (screenHistory.Count > 0) {
				Canvas prevScreen = screenHistory.Peek();
				if (prevScreen != null) {
					swapActiveCanvas(prevScreen, true);
				}
			}
		}

		private void gotoSinglePlayerOpsScreen(object sender, MouseButtonEventArgs e) {
			swapActiveCanvas(singePlayerScreen, false);
		}

		private void gotoMultiplayerOpsScreen(object sender, MouseButtonEventArgs e) {
			swapActiveCanvas(multiplayerScreen, false);
		}

	}
}
