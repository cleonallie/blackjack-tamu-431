   M S B A M L   `   `   `  ����   BlackJack-CS    BlackJack_CS.SinglePlayer   \ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     @d2http://schemas.microsoft.com/expression/blend/2008       N� Title$  SinglePlayer�� N� ShowsNavigationUI .   N� 
Background
 � d � J� OpacityMask �	#FF690A0A N� 
Foreground
 �   �.��� .+�� -   $��grid1��$	��500��$
��Left=�$	��Top=�$	��800��.+��� -   $��	hitButton��$	��Hit��$��23��$
��Left=�$��163,471,0,0q�$	��Top=�$��75���� -   $��standButton��$��Stand��$��23��$��Right=�$��0,471,462,0q�$	��Top=�$��75���� -   $��doubleButton��$��Double��$��23��$��Right=�$��0,471,362,0q�$	��Top=�$��75���� -   $��splitButton��$��Split��$��23��$��Right=�$��0,471,262,0q�$	��Top=�$��75���� -   $��
dealer_box��$��Dealer��$	��300��$��Right=�$��
0,50,667,0q�$	��Top=�$	��100��
�����������  �� EndPoint$ 0.5,1&� �� 
StartPoint$ 0.5,0&�.���  � Color$ Black�� � Offset$ 1Q�� $ 	DarkGreen��$ 0Q��� -   $8��2/BlackJack-CS;component/Images/Chip%20-%20back.png��$	��100��$	��100��$��6,394,694,6q��� -   $��	User1_Box��$��User1��$	��300��$	��100��$��139,50,561,150q�
����������� $ 0.5,1&�$ 0.5,0&�.��� $ Black��$ 1Q�� $ 	DarkGreen��$ 0Q��� -	   $��	User2_Box��$��User2��$	��300��$	��100��$��245,50,455,150q�
����������� $ 0.5,1&�$ 0.5,0&�.��� $ Black��$ 1Q�� $ 	DarkGreen��$ 0Q��� -
   $��	User3_Box��$��User3��$	��300��$	��100��$��351,50,0,150q�
�������$
��Left=����� $ 0.5,1&�$ 0.5,0&�.��� $ Black��$ 1Q�� $ 	DarkGreen��$ 0Q��� -   $��	User4_Box��$��User4��$	��300��$	��100��$��457,50,243,150q�
����������� $ 0.5,1&�$ 0.5,0&�.��� $ Black��$ 1Q�� $ 	DarkGreen��$ 0Q��� -   $��	User5_Box��$��User5��$	��300��$	��100��$��563,50,137,150q�
����������� $ 0.5,1&�$ 0.5,0&�.��� $ Black��$ 1Q�� $ 	DarkGreen��$ 0Q��� -   $��dealerScore��	 �� AcceptsReturn	 . $��0q�$��23��$
��Left=�
 �� 
IsReadOnly
 . $��
55,356,0,0q�$��0�� �� TextAlignment$ Center=�$	��Top=�$��50���� -   $��
user1Score��	 . $��0q�$��23��$
��Left=�
 . $��163,356,0,0q�$��0��$ Center=�$	��Top=�$��50���� -   $��
user2Score��	 . $��0q�$��23��$
��Left=�
 . $��272,356,0,0q�$��0��$ Center=�$	��Top=�$��50���� -   $��
user3Score��	 . $��0q�$��23��$
��Left=�
 . $��377,356,0,0q�$��0��$ Center=�$	��Top=�$��50���� -   $��
user4Score��	 . $��0q�$��23��$
��Left=�
 . $��483,356,0,0q�$��0��$ Center=�$	��Top=�$��50���� -   $��
user5Score��	 . $��0q�$��23��$��Right=�
 . $��0,356,163,0q�$��0��$ Center=�$	��Top=�$��50��