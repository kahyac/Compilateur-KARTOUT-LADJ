/* This file was generated by SableCC (http://www.sablecc.org/). */

package nasmParser.node;

import nasmParser.analysis.*;

@SuppressWarnings("nls")
public final class TEcx extends Token
{
    public TEcx()
    {
        super.setText("ecx");
    }

    public TEcx(int line, int pos)
    {
        super.setText("ecx");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TEcx(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTEcx(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TEcx text.");
    }
}
