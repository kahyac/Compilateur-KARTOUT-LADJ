/* This file was generated by SableCC (http://www.sablecc.org/). */

package l.node;

import l.analysis.*;

@SuppressWarnings("nls")
public final class AVarExpression7 extends PExpression7
{
    private PVar _var_;

    public AVarExpression7()
    {
        // Constructor
    }

    public AVarExpression7(
        @SuppressWarnings("hiding") PVar _var_)
    {
        // Constructor
        setVar(_var_);

    }

    @Override
    public Object clone()
    {
        return new AVarExpression7(
            cloneNode(this._var_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAVarExpression7(this);
    }

    public PVar getVar()
    {
        return this._var_;
    }

    public void setVar(PVar node)
    {
        if(this._var_ != null)
        {
            this._var_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._var_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._var_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._var_ == child)
        {
            this._var_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._var_ == oldChild)
        {
            setVar((PVar) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
