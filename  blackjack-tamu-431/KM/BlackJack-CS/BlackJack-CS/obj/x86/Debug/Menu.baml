   M S B A M L   `   `   `  ����  BlackJack-CS    BlackJack_CS.Menu   5      \ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5      R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5      Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5      @d2http://schemas.microsoft.com/expression/blend/2008     5      
��� d �.��5	      � .+�5   
   �� -   5        $��
homeScreen��5      $y�Visible=�6#   .+�5      �� -   5        $��border1��5   y   
���   �$��4q�6)   $��45��6=   $
��Left=�6I   $��-16,150,0,0q�6d   $	��Top=�6�   $	��842��6�   ���	#26000000
  �� Top$  0��6�   � 5      $	��271��6   $	��678��6    $	  106��6,    � RowDefinitions 5      �� 5      �� 5       � ColumnDefinitions 5      �� 5      �� 5      .+�5      � $��0��6   $��2��6$   .+�5      � $��	0,6,350,0q�6   .+�5      �� $c��]C:\Users\KevinsLaptop\Desktop\repository\AY\BlackJack-CS\BlackJack-CS\Images\spades-a-75.png ��6    5      �� 5      $��	BlackJack��6    $��Center=�61   $��Center=�6N   $��50(�6i   $
��Bold"�6w   $��Magneto)�6�    �� TextAlignment$ Center=�6�   ��6�   Z� ��6�   �� 6�    �� EndPoint$ 0.5,1&�6�    �� 
StartPoint$ 0.5,0&�6  .��6  �  � Color$ Black��6(   � Offset$ 0Q�66  � 6D  $ 	#FF750303��6Q  $ 1Q�6c  6r  6�  5      5      5      �� 5   
    � Triggers 5       :� 5!      	 :� RoutedEvent$	 Canvas.Loaded��6   [�5"      �� 5#      .��5$      �� 
 g� 	BeginTime$
 0X�6)    g� Duration$ ForeverD�67   .��5%   "   W�  �� 
TargetName$ e1��62    �� TargetProperty$ (Canvas.Right)�6M    W� From$ 0X�6x   	 W� To$	 400X�6�    g� AutoReverse . $
 0:0:0X�6�   $ 0:0:1D�6�    g� RepeatBehavior$ Forever��6�   W� 5&   "   $ e2��62   $ (Canvas.Left)�6M   $ 0X�6w   $	 400X�6�    . $
 0:0:0X�6�   $ 0:0:1D�6�   $ Forever��6�   W� 5'   "   $ e3��62   $ (Canvas.Top)�6M   $ 0X�6v   $	 300X�6    . $
 0:0:0X�6�   $ 0:0:1D�6�   $ Forever��6�   W� 5(   "   $ e4��62   $ (Canvas.Bottom)�6M   $ 0X�6y   $	 300X�6�    . $
 0:0:0X�6�   $ 0:0:1D�6�   $ Forever��6�   5*      5+      5-      .+�50      �� -   5         ��Name$ e1��50      $-��'/BlackJack-CS;component/Images/club.png��6    $
��Fill=�6Q   $��45��6`   $��45��6k   �� 51      -   5        $ e2��51      $.��(/BlackJack-CS;component/Images/heart.png��6    $
��Fill=�6R   $��40��6a   $��40��6l   �� 53      -   5        $ e3��53      $.��(/BlackJack-CS;component/Images/spade.png��6    $
��Fill=�6R   $��45��6a   $��45��6l   �� 54      -   5        $ e4��54      $0��*/BlackJack-CS;component/Images/diamond.png��6    $
��Fill=�6T   $��40��6c   $��40��6n   � 55       �� Left$	 142��6   $	  279��6%   .+�56      �� -   5        $?��9/BlackJack-CS;component/Images/Chip%20-%20dark%20blue.png��56   7   $	��132��6z   $	��139��6�   �� 57      $��Single Player��6   
�������$
��Bold"�6B   $��16(�6�   $��Center=�6�   $��Center=�6�    J� IsHitTestVisible .  ��6T   Z� ��6j   Z� 6�   58      � 59      $	 384��6   $	  279��6%   .+�5:      �� -   5        $>��8/BlackJack-CS;component/Images/Chip%20-%20dark%20red.png��5:      $	��132��6Z   $	��139��6g   6s   �� 5;      $��Multiplayer��6   
�������$
��Bold"�6@   $��16(�6   $��Center=�6�   $��Center=�6�    .  ��6R   Z� ��6h   Z� 6�   5<      5=      �� 5?   
   $��650,500,0,0q�6    5@      :� 5A      $	 Canvas.Loaded��6   [�5B      �� 5C      .��5D      �� $
 0X�6)   $ ForeverD�67   .��5E   "   W� $ e5��62   $ (Canvas.Right)�6M   $ 0X�6x   $	 400X�6�    . $
 0:0:0X�6�   $ 0:0:1D�6�   $ Forever��6�   W� 5F   "   $ e6��62   $ (Canvas.Left)�6M   $
 -600X�6w   $
 -200X�6�    . $
 0:0:0X�6�   $ 0:0:1D�6�   $ Forever��6�   W� 5G   "   $ e7��62   $ (Canvas.Top)�6M   $
 -500X�6v   $
 -200X�6�    . $
 0:0:0X�6�   $ 0:0:1D�6�   $ Forever��6�   W� 5H   "   $ e8��62   $ (Canvas.Bottom)�6M   $ 0X�6y   $	 300X�6�    . $
 0:0:0X�6�   $ 0:0:1D�6�   $ Forever��6�   5J      5K      5M      .+�5P      �� -	   5        $ e5��5P      $.��(/BlackJack-CS;component/Images/spade.png��6    $
��Fill=�6R   $��45��6a   $��45��6l   �� 5Q      -
   5        $ e6��5Q      $0��*/BlackJack-CS;component/Images/diamond.png��6    $
��Fill=�6T   $��40��6c   $��40��6n   �� 5S      -   5        $ e7��5S      $-��'/BlackJack-CS;component/Images/club.png��6    $
��Fill=�6Q   $��45��6`   $��45��6k   �� 5T      -   5        $ e8��5T      $.��(/BlackJack-CS;component/Images/heart.png��6    $
��Fill=�6R   $��40��6a   $��40��6l   5V      5W      5Z      