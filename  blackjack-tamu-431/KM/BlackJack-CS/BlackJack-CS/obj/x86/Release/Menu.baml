   M S B A M L   `   `   `  ����   BlackJack-CS    BlackJack_CS.Menu   \ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     @d2http://schemas.microsoft.com/expression/blend/2008     
��� d �.��� .+��� -   $��
homeScreen��$y�Visible=�.+��� -   $��border1��
���   �$��4q�$��45��$
��Left=�$��-16,150,0,0q�$	��Top=�$	��842�����	#26000000
  �� Top$  0��� $	��271��$	��678��$	  106�� � RowDefinitions �� ��  � ColumnDefinitions �� �� .+�� $��0��$��2��.+�� $��	0,6,350,0q�.+��� $c��]C:\Users\KevinsLaptop\Desktop\repository\AY\BlackJack-CS\BlackJack-CS\Images\spades-a-75.png ���� $��	BlackJack��$��Center=�$��Center=�$��50(�$
��Bold"�$��Magneto)� �� TextAlignment$ Center=���Z� ����  �� EndPoint$ 0.5,1&� �� 
StartPoint$ 0.5,0&�.���  � Color$ Black�� � Offset$ 0Q�� $ 	#FF750303��$ 1Q���  � Triggers :� 	 :� RoutedEvent$	 Canvas.Loaded��[��� .���� 
 g� 	BeginTime$
 0X� g� Duration$ ForeverD�.��W�  �� 
TargetName$ e1�� �� TargetProperty$ (Canvas.Right)� W� From$ 0X�	 W� To$	 650X� g� AutoReverse . $
 0:0:0X�$ 0:0:3D� g� RepeatBehavior$ Forever��W� $ e2��$ (Canvas.Left)�$ 0X�$	 650X� . $
 0:0:0X�$ 0:0:3D�$ Forever��W� $ e3��$ (Canvas.Top)�$ 0X�$	 550X� . $
 0:0:0X�$ 0:0:2D�$ Forever��W� $ e4��$ (Canvas.Bottom)�$ 0X�$	 550X� . $
 0:0:0X�$ 0:0:2D�$ Forever��.+��� -    ��Name$ e1��$-��'/BlackJack-CS;component/Images/club.png��$
��Fill=�$��45��$��45���� -   $ e2��$.��(/BlackJack-CS;component/Images/heart.png��$
��Fill=�$��40��$��40���� -   $ e3��$.��(/BlackJack-CS;component/Images/spade.png��$
��Fill=�$��45��$��45���� -   $ e4��$0��*/BlackJack-CS;component/Images/diamond.png��$
��Fill=�$��40��$��40���  �� Left$	 142��$	  279��.+��� -   $?��9/BlackJack-CS;component/Images/Chip%20-%20dark%20blue.png��$	��132��$	��139���� $��Single Player��
�������$
��Bold"�$��16(�$��Center=�$��Center=� J� IsHitTestVisible .  ��Z� ��Z� � $	 384��$	  279��.+��� -   $>��8/BlackJack-CS;component/Images/Chip%20-%20dark%20red.png��$	��132��$	��139���� $��Multiplayer��
�������$
��Bold"�$��16(�$��Center=�$��Center=� .  ��Z� ��Z� �� $��650,500,0,0q� :� $	 Canvas.Loaded��[��� .���� $
 0X�$ ForeverD�.��W� $ e5��$ (Canvas.Right)�$ 0X�$	 650X� . $
 0:0:0X�$ 0:0:2D�$ Forever��W� $ e6��$ (Canvas.Left)�$
 -650X�$ 0X� . $
 0:0:0X�$ 0:0:2D�$ Forever��W� $ e7��$ (Canvas.Top)�$
 -550X�$ 0X� . $
 0:0:0X�$ 0:0:3D�$ Forever��W� $ e8��$ (Canvas.Bottom)�$ 0X�$	 550X� . $
 0:0:0X�$ 0:0:3D�$ Forever��.+��� -	   $ e5��$.��(/BlackJack-CS;component/Images/spade.png��$
��Fill=�$��45��$��45���� -
   $ e6��$0��*/BlackJack-CS;component/Images/diamond.png��$
��Fill=�$��40��$��40���� -   $ e7��$-��'/BlackJack-CS;component/Images/club.png��$
��Fill=�$��45��$��45���� -   $ e8��$.��(/BlackJack-CS;component/Images/heart.png��$
��Fill=�$��40��$��40��