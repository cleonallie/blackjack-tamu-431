   M S B A M L   `   `   `  ����   BlackJack-CS&     BlackJack_CS.SinglePlayerOptions   \ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     @d2http://schemas.microsoft.com/expression/blend/2008     
��� d �.��� .+���   � Triggers  :�  :� RoutedEvent$ Canvas.Loaded��[��� .����  g� 	BeginTime$ 0X� g� Duration$ ForeverD�.��W�  �� 
TargetName$ e1�� �� TargetProperty$ (Canvas.Right)� W� From$ 0X�	 W� To$	 650X� g� AutoReverse . $ 0:0:0X�$ 0:0:3D�	 g� RepeatBehavior$	 Forever��W� $ e2��$ (Canvas.Left)�$ 0X�$	 650X� . $ 0:0:0X�$ 0:0:2D�$	 Forever��W� $ e3��$ (Canvas.Top)�$ 0X�$	 550X� . $ 0:0:0X�$ 0:0:3D�$	 Forever��W� $ e4��$ (Canvas.Bottom)�$ 0X�$	 550X� . $ 0:0:0X�$ 0:0:2D�$	 Forever��.+��� -   
 ��Name$
 e1��$-��'/BlackJack-CS;component/Images/club.png��$
��Fill=�$��45��$��45���� -   $
 e2��$.��(/BlackJack-CS;component/Images/heart.png��$
��Fill=�$��40��$��40���� -   $
 e3��$.��(/BlackJack-CS;component/Images/spade.png��$
��Fill=�$��45��$��45���� -   $
 e4��$0��*/BlackJack-CS;component/Images/diamond.png��$
��Fill=�$��40��$��40���� -   $��playerNameBlock��$��23��$��Player Name��$��Cooper)�$��16(�$��Normal"�$��Normal$�
���   � �� Left$	 290��
 �� Top$	 188���� -   $��playerNameTextBox��$��23��$	��120��$�� �� �� 
IsReadOnly .  $	 290��$	 218���� -   $��
moneyBlock��$��23��$��Starting Cash��$	��141��$��Cooper)�$��16(�$	 290��$	 253���� -   $��playerStartingCash��$��23��$	��120��$�� �� �� MaxLines$ 6�� �� AutoWordSelection .  }�.  $	 290��$	 283�� �� 
CaretBrush Z� �� -	   $��backButtonImage��$	��100��$
��Fill=�$	��100��$8��2/BlackJack-CS;component/Images/Chip%20-%20back.png��$ 45��$	 396���� -
   $��image1��$	 542��$	 396��$	��100��$
��Fill=�$	��100��$A��;/BlackJack-CS;component/Images/Forward%20-%20dark%20red.png���� -   $��border1��
���   �$��4q�$��44�����	#26000000$��
0,43,0,507q�$	��837��$	 -18��$ 8���� $��	BlackJack��$��50(�$
��Bold"�$��Magneto)� �� TextAlignment$ Center=�$	 220��$ 43����Z� ����  �� EndPoint$ 0.5,1&� �� 
StartPoint$ 0.5,0&�.���  � Color$ Black�� � Offset$ 0Q�� $ 	#FF750303��$ 1Q�� -    �Name$ 	PopupTest�� � AllowsTransparency . $ 19��$ 0��.��(� $	��Top=�.���� .+��� -   $��backName_yes��$��Go Back��$��23��$
��Left=�$	��Top=�$��75���� -   $��backName_no��$��Cancel��$��23��$
��Left=�$	��Top=�$��75���� $��645,500,0,0q�  :� $ Canvas.Loaded��[��� .���� $ 0X�$ ForeverD�.��W� $ e5��$ (Canvas.Right)�$ 0X�$	 650X� . $ 0:0:0X�$ 0:0:2D�$	 Forever��W� $ e6��$ (Canvas.Left)�$
 -650X�$	 000X� . $ 0:0:0X�$ 0:0:3D�$	 Forever��W� $ e7��$ (Canvas.Top)�$
 -500X�$ 50X� . $ 0:0:0X�$ 0:0:2D�$	 Forever��W� $ e8��$ (Canvas.Bottom)�$ 50X�$	 500X� . $ 0:0:0X�$ 0:0:3D�$	 Forever��.+��� -   $
 e5��$.��(/BlackJack-CS;component/Images/spade.png��$
��Fill=�$��45��$��45���� -   $
 e6��$0��*/BlackJack-CS;component/Images/diamond.png��$
��Fill=�$��40��$��40���� -   $
 e7��$-��'/BlackJack-CS;component/Images/club.png��$
��Fill=�$��45��$��45���� -   $
 e8��$.��(/BlackJack-CS;component/Images/heart.png��$
��Fill=�$��40��$��40��