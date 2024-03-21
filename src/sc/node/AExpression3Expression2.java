/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.node;

import sc.analysis.*;

@SuppressWarnings("nls")
public final class AExpression3Expression2 extends PExpression2
{
    private PExpression3 _expression3_;

    public AExpression3Expression2()
    {
        // Constructor
    }

    public AExpression3Expression2(
        @SuppressWarnings("hiding") PExpression3 _expression3_)
    {
        // Constructor
        setExpression3(_expression3_);

    }

    @Override
    public Object clone()
    {
        return new AExpression3Expression2(
            cloneNode(this._expression3_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAExpression3Expression2(this);
    }

    public PExpression3 getExpression3()
    {
        return this._expression3_;
    }

    public void setExpression3(PExpression3 node)
    {
        if(this._expression3_ != null)
        {
            this._expression3_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._expression3_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._expression3_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._expression3_ == child)
        {
            this._expression3_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._expression3_ == oldChild)
        {
            setExpression3((PExpression3) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
