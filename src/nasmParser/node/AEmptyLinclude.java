/* This file was generated by SableCC (http://www.sablecc.org/). */

package nasmParser.node;

import nasmParser.analysis.*;

@SuppressWarnings("nls")
public final class AEmptyLinclude extends PLinclude
{

    public AEmptyLinclude()
    {
        // Constructor
    }

    @Override
    public Object clone()
    {
        return new AEmptyLinclude();
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAEmptyLinclude(this);
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
