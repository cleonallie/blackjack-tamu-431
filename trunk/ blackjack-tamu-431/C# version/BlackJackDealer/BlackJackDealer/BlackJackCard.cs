using System;
using System.Collections.Generic;


namespace engine
{

    public class BlackJackCard : Card
    {
        public BlackJackCard(): base()
        {
        //{
        //    //super()
        }

        public BlackJackCard(int f, string s): base(f,s)
        {

        //    //super(v,s)
        }

        new public int getValue()
        {
            int value = 0;
        
            if (base.getFace() > 10 && base.getFace() != 1)
                value = 10;
            else if (base.getFace() == 1)
                value = 11;
            else
                value = base.getFace();

            return value;
        }
    }
}

