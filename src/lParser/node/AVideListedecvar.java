/* This file was generated by SableCC (http://www.sablecc.org/). */

package lParser.node;

import lParser.analysis.*;

@SuppressWarnings("nls")
public final class AVideListedecvar extends PListedecvar
{

    public AVideListedecvar()
    {
        // Constructor
    }

    @Override
    public Object clone()
    {
        return new AVideListedecvar();
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAVideListedecvar(this);
    }

    @Override
    public String toString()
    {
        return "";
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        throw new RuntimeException("Not a child.");
    }
}
