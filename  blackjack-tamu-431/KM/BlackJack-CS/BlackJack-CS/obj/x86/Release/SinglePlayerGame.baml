   M S B A M L   `   `   `  ����   BlackJack-CS#    BlackJack_CS.SinglePlayerGame   \ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     @d2http://schemas.microsoft.com/expression/blend/2008     
��� d �  J� OpacityMask  �	#FF690A0A
���   �$	��500��$	��700��.���� -   $��singlePlayerWindow��$y�Visible=�.+�� .+�� -   $��grid1��$	��500��$
��Left=�$	��Top=�$	��800��.+��� -   $��border1��
���   �$��4q�$��46��$
��Left=�$��	-10,6,0,0q�$	��Top=�$	��723�����	#26000000�� $��	BlackJack��$��Center=�$��Center=�$��50(�$
��Bold"�$��Magneto)� �� TextAlignment$ Center=�$��203,0,311,440q���Z� ����  �� EndPoint$ 0.5,1&� �� 
StartPoint$ 0.5,0&�.���  � Color$ Black�� � Offset$ 0Q�� $ 	#FF750303��$ 1Q��� -   $��
dealer_box��$��Dealer��$	��300��$��Right=�$��
0,50,667,0q�$	��Top=�$	��100��
����������� $ 0.5,1&�$ 0.5,0&�.��� $ Black��$ 1Q�� $ 	DarkGreen��$ 0Q��� -   $8��2/BlackJack-CS;component/Images/Chip%20-%20back.png��$	��100��$	��100��$��6,394,694,6q��� -   $��	User1_Box��$��User1��$	��300��$	��100��$��139,50,561,150q�
����������� $ 0.5,1&�$ 0.5,0&�.��� $ Black��$ 1Q�� $ 	DarkGreen��$ 0Q��� -   $��	User2_Box��$��User2��$	��300��$	��100��$��245,50,455,150q�
����������� $ 0.5,1&�$ 0.5,0&�.��� $ Black��$ 1Q�� $ 	DarkGreen��$ 0Q��� -   $��	User3_Box��$��User3��$	��300��$	��100��$��351,50,0,150q�
�������$
��Left=����� $ 0.5,1&�$ 0.5,0&�.��� $ Black��$ 1Q�� $ 	DarkGreen��$ 0Q��� -	   $��	User4_Box��$��User4��$	��300��$	��100��$��457,50,243,150q�
����������� $ 0.5,1&�$ 0.5,0&�.��� $ Black��$ 1Q�� $ 	DarkGreen��$ 0Q��� -
   $��	User5_Box��$��User5��$	��300��$	��100��$��563,50,137,150q�
����������� $ 0.5,1&�$ 0.5,0&�.��� $ Black��$ 1Q�� $ 	DarkGreen��$ 0Q��� -   $��dealerScore�� �� AcceptsReturn . $��0q�$��23��$
��Left=� �� 
IsReadOnly . $��
55,356,0,0q�$��0�� �� TextAlignment$ Center=�$	��Top=�$��50���� -   $��
user1Score�� . $��0q�$��23��$
��Left=� . $��163,356,0,0q�$��0��$ Center=�$	��Top=�$��50���� -   $��
user2Score�� . $��0q�$��23��$
��Left=� . $��272,356,0,0q�$��0��$ Center=�$	��Top=�$��50���� -   $��
user3Score�� . $��0q�$��23��$
��Left=� . $��377,356,0,0q�$��0��$ Center=�$	��Top=�$��50���� -   $��
user4Score�� . $��0q�$��23��$
��Left=� . $��483,356,0,0q�$��0��$ Center=�$	��Top=�$��50���� -   $��
user5Score�� . $��0q�$��23��$��Right=� . $��0,356,163,0q�$��0��$ Center=�$	��Top=�$��50���� -   $��stackPanel1��$��139,76,562,150q��� -   $��	user1Cash��$��23��$
��Left=�$��163,394,0,0q�$�� ��$	��Top=�$��Cooper)�$��16(��� -   $��	user2Cash��$��23��$
��Left=�$��272,394,0,0q�$�� ��$	��Top=�$��Cooper)�$��16(��� -   $��	user3Cash��$��23��$
��Left=�$��377,394,0,0q�$�� ��$	��Top=�$��Cooper)�$��16(��� -   $��	user4Cash��$��23��$
��Left=�$��483,394,0,0q�$�� ��$	��Top=�$��Cooper)�$��16(��� -   $��	user5Cash��$��23��$
��Left=�$��587,394,0,0q�$�� ��$	��Top=�$��Cooper)�$��16(�� $��169,407,193,22q�	 � 	Resources	 
 �� 
TargetType �� Property �� Value �� 
TargetType ��Name �� CornerRadius �� Triggers P� Property P� Value �� 
TargetName��%  '��       �� "
 ��.���  � �� �� " ��.R��� $ Border�����	#FF52CF32$	 100��._��� $��Center=�$��Center=� P�  �@J�IsMouseOver . . ��� $ Border�� � ��
 � ���P�  � �� . . ��� $ Border�� � ��
 �  ��.+���  �� Orientation$ 
Horizontal=� � DataContext �� .+��� -   $��	hitButton��$	��Hit��$��30��$��80���� -   $��doubleButton��$��Double��$��30��$��80��$��10q��� -   $��standButton��$��Stand��$��30��$��80���� -   $��splitButton��$��Split��$��30��$��80��$��10q� �� 