/* This file was generated by SableCC (http://www.sablecc.org/). */

package lParser.node;

import lParser.analysis.*;

@SuppressWarnings("nls")
public final class TNon extends Token
{
    public TNon()
    {
        super.setText("!");
    }

    public TNon(int line, int pos)
    {
        super.setText("!");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TNon(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTNon(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TNon text.");
    }
}
