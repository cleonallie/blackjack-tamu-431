﻿#pragma checksum "..\..\..\SinglePlayerOptions.xaml" "{406ea660-64cf-4c82-b6f0-42d48172a799}" "5C06475D0AF39D9715E1278630694F36"
//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//     Runtime Version:4.0.30319.261
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

using System;
using System.Diagnostics;
using System.Windows;
using System.Windows.Automation;
using System.Windows.Controls;
using System.Windows.Controls.Primitives;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Ink;
using System.Windows.Input;
using System.Windows.Markup;
using System.Windows.Media;
using System.Windows.Media.Animation;
using System.Windows.Media.Effects;
using System.Windows.Media.Imaging;
using System.Windows.Media.Media3D;
using System.Windows.Media.TextFormatting;
using System.Windows.Navigation;
using System.Windows.Shapes;
using System.Windows.Shell;


namespace BlackJack_CS {
    
    
    /// <summary>
    /// SinglePlayerOptions
    /// </summary>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("PresentationBuildTasks", "4.0.0.0")]
    public partial class SinglePlayerOptions : System.Windows.Controls.UserControl, System.Windows.Markup.IComponentConnector {
        
        
        #line 9 "..\..\..\SinglePlayerOptions.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.TextBlock playerNameBlock;
        
        #line default
        #line hidden
        
        
        #line 10 "..\..\..\SinglePlayerOptions.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.TextBox playerNameTextBox;
        
        #line default
        #line hidden
        
        
        #line 11 "..\..\..\SinglePlayerOptions.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.TextBlock moneyBlock;
        
        #line default
        #line hidden
        
        
        #line 12 "..\..\..\SinglePlayerOptions.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.TextBox playerStartingCash;
        
        #line default
        #line hidden
        
        
        #line 13 "..\..\..\SinglePlayerOptions.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.ListBox listBox1;
        
        #line default
        #line hidden
        
        
        #line 19 "..\..\..\SinglePlayerOptions.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.TextBlock textBlock1;
        
        #line default
        #line hidden
        
        private bool _contentLoaded;
        
        /// <summary>
        /// InitializeComponent
        /// </summary>
        [System.Diagnostics.DebuggerNonUserCodeAttribute()]
        public void InitializeComponent() {
            if (_contentLoaded) {
                return;
            }
            _contentLoaded = true;
            System.Uri resourceLocater = new System.Uri("/BlackJack-CS;component/singleplayeroptions.xaml", System.UriKind.Relative);
            
            #line 1 "..\..\..\SinglePlayerOptions.xaml"
            System.Windows.Application.LoadComponent(this, resourceLocater);
            
            #line default
            #line hidden
        }
        
        [System.Diagnostics.DebuggerNonUserCodeAttribute()]
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Never)]
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Design", "CA1033:InterfaceMethodsShouldBeCallableByChildTypes")]
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Maintainability", "CA1502:AvoidExcessiveComplexity")]
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1800:DoNotCastUnnecessarily")]
        void System.Windows.Markup.IComponentConnector.Connect(int connectionId, object target) {
            switch (connectionId)
            {
            case 1:
            this.playerNameBlock = ((System.Windows.Controls.TextBlock)(target));
            return;
            case 2:
            this.playerNameTextBox = ((System.Windows.Controls.TextBox)(target));
            
            #line 10 "..\..\..\SinglePlayerOptions.xaml"
            this.playerNameTextBox.TextChanged += new System.Windows.Controls.TextChangedEventHandler(this.PlayerNameTextBox_TextChanged);
            
            #line default
            #line hidden
            return;
            case 3:
            this.moneyBlock = ((System.Windows.Controls.TextBlock)(target));
            return;
            case 4:
            this.playerStartingCash = ((System.Windows.Controls.TextBox)(target));
            
            #line 12 "..\..\..\SinglePlayerOptions.xaml"
            this.playerStartingCash.TextChanged += new System.Windows.Controls.TextChangedEventHandler(this.playerStartingCash_TextChanged);
            
            #line default
            #line hidden
            return;
            case 5:
            this.listBox1 = ((System.Windows.Controls.ListBox)(target));
            return;
            case 6:
            
            #line 14 "..\..\..\SinglePlayerOptions.xaml"
            ((System.Windows.Controls.ListBoxItem)(target)).Selected += new System.Windows.RoutedEventHandler(this.ListBoxItem_Selected);
            
            #line default
            #line hidden
            return;
            case 7:
            
            #line 15 "..\..\..\SinglePlayerOptions.xaml"
            ((System.Windows.Controls.ListBoxItem)(target)).Selected += new System.Windows.RoutedEventHandler(this.ListBoxItem_Selected_1);
            
            #line default
            #line hidden
            return;
            case 8:
            
            #line 16 "..\..\..\SinglePlayerOptions.xaml"
            ((System.Windows.Controls.ListBoxItem)(target)).Selected += new System.Windows.RoutedEventHandler(this.ListBoxItem_Selected_2);
            
            #line default
            #line hidden
            return;
            case 9:
            
            #line 17 "..\..\..\SinglePlayerOptions.xaml"
            ((System.Windows.Controls.ListBoxItem)(target)).Selected += new System.Windows.RoutedEventHandler(this.ListBoxItem_Selected_3);
            
            #line default
            #line hidden
            return;
            case 10:
            this.textBlock1 = ((System.Windows.Controls.TextBlock)(target));
            return;
            }
            this._contentLoaded = true;
        }
    }
}

