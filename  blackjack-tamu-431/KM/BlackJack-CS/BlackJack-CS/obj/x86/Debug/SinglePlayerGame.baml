   M S B A M L   `   `   `  ����  BlackJack-CS#    BlackJack_CS.SinglePlayerGame   5      \ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5      R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5      Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5      @d2http://schemas.microsoft.com/expression/blend/2008     5      
��� d �  J� OpacityMask  �	#FF690A0A
���   �$	��500��5   a   $	��700��6n   .��5      �� -   5        $��singlePlayerWindow��5      $y�Visible=�6'   .+�5   
   � .+�5
      � -   5        $��grid1��5
   ;   $	��500��6   $
��Left=�6    $	��Top=�6H   $	��800��6`   .+�5      �� -   5        $��border1��5   {   
���   �$��4q�6-   $��46��6A   $
��Left=�6M   $��	-10,6,0,0q�6h   $	��Top=�6�   $	��723��6�   ���	#260000006�   �� 5      $��	BlackJack��6   $��Center=�6-   $��Center=�6J   $��50(�6e   $
��Bold"�6s   $��Magneto)�6�    �� TextAlignment$ Center=�6�   $��203,0,311,440q�6�   ��6�   Z� ��6�   �� 6�    �� EndPoint$ 0.5,1&�6	   �� 
StartPoint$ 0.5,0&�6  .��6.  �  � Color$ Black��6;   � Offset$ 0Q�6I  � 6W  $ 	#FF750303��6d  $ 1Q�6v  6�  6�  �� 5      -   5        $��	hitButton��5   c   $	��Hit��6   $��23��6'   $
��Left=�63   $��163,471,0,0q�6N   $	��Top=�6t   $��75��6�   6�   �� 5      -   5        $��standButton��5   f   $��Stand��6   $��23��6)   $��Right=�65   $��0,471,462,0q�6Q   $	��Top=�6y   $��75��6�   6�   �� 5      -   5        $��doubleButton��5   g   $��Double��6   $��23��6*   $��Right=�66   $��0,471,362,0q�6R   $	��Top=�6{   $��75��6�   6�   �� 5      -   5        $��splitButton��5   f   $��Split��6   $��23��6)   $��Right=�65   $��0,471,262,0q�6Q   $	��Top=�6y   $��75��6�   6�   �� 5      -   5        $��
dealer_box��5   h   $��Dealer��6   $	��300��6+   $��Right=�68   $��
0,50,667,0q�6T   $	��Top=�6z   $	��100��6�   
���������5      �� 5      $ 0.5,1&�6.   $ 0.5,0&�6?   .��5      � $ Black��6+   $ 1Q�69   � 5      $ 	DarkGreen��6+   $ 0Q�6=   5      5      �� 5      -	   5        $8��2/BlackJack-CS;component/Images/Chip%20-%20back.png��5   /   $	��100��6k   $	��100��6w   $��6,394,694,6q�6�   6�   �� 5      -
   5        $��	User1_Box��5   7   $��User1��6   $	��300��6*   $	��100��6H   $��139,50,561,150q�6T   
���������5      �� 5      $ 0.5,1&�6.   $ 0.5,0&�6?   .��5      � $ Black��6+   $ 1Q�69   � 5      $ 	DarkGreen��6+   $ 0Q�6=   5       5"      �� 5$      -   5        $��	User2_Box��5$   7   $��User2��6   $	��300��6*   $	��100��6H   $��245,50,455,150q�6T   
���������5%      �� 5&      $ 0.5,1&�6.   $ 0.5,0&�6?   .��5'      � $ Black��6+   $ 1Q�69   � 5(      $ 	DarkGreen��6+   $ 0Q�6=   5)      5+      �� 5,      -   5        $��	User3_Box��5,   7   $��User3��6   $	��300��6*   $	��100��6H   $��351,50,0,150q�6T   
�������$
��Left=�6}   ��5-      �� 5.      $ 0.5,1&�6.   $ 0.5,0&�6?   .��5/      � $ Black��6+   $ 1Q�69   � 50      $ 	DarkGreen��6+   $ 0Q�6=   51      53      �� 54      -   5        $��	User4_Box��54   7   $��User4��6   $	��300��6*   $	��100��6H   $��457,50,243,150q�6T   
���������55      �� 56      $ 0.5,1&�6.   $ 0.5,0&�6?   .��57      � $ Black��6+   $ 1Q�69   � 58      $ 	DarkGreen��6+   $ 0Q�6=   59      5;      �� 5<      -   5        $��	User5_Box��5<   7   $��User5��6   $	��300��6*   $	��100��6H   $��563,50,137,150q�6T   
���������5=      �� 5>      $ 0.5,1&�6.   $ 0.5,0&�6?   .��5?      � $ Black��6+   $ 1Q�69   � 5@      $ 	DarkGreen��6+   $ 0Q�6=   5A      5C      �� 5E      -   5        $��dealerScore��5E   �    �� AcceptsReturn . $��0q�6/   $��23��6C   $
��Left=�6O    �� 
IsReadOnly . $��
55,356,0,0q�6|   $��0��6�    �� TextAlignment$ Center=�6�   $	��Top=�6�   $��50��6�   �� 5F      -   5        $��
user1Score��5F   �    . $��0q�6/   $��23��6C   $
��Left=�6O    . $��163,356,0,0q�6|   $��0��6�   $ Center=�6�   $	��Top=�6�   $��50��6�   �� 5G      -   5        $��
user2Score��5G   �    . $��0q�6/   $��23��6C   $
��Left=�6O    . $��272,356,0,0q�6|   $��0��6�   $ Center=�6�   $	��Top=�6�   $��50��6�   �� 5H      -   5        $��
user3Score��5H   �    . $��0q�6/   $��23��6C   $
��Left=�6O    . $��377,356,0,0q�6|   $��0��6�   $ Center=�6�   $	��Top=�6�   $��50��6�   �� 5I      -   5        $��
user4Score��5I   �    . $��0q�6/   $��23��6C   $
��Left=�6O    . $��483,356,0,0q�6|   $��0��6�   $ Center=�6�   $	��Top=�6�   $��50��6�   �� 5J      -   5        $��
user5Score��5J   �    . $��0q�6/   $��23��6C   $��Right=�6O    . $��0,356,163,0q�6}   $��0��6�   $ Center=�6�   $	��Top=�6�   $��50��6�   �� 5K      -   5        $��stackPanel1��5K      $��139,76,562,150q�60   5L      5M      5N      5O      