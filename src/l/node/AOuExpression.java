/* This file was generated by SableCC (http://www.sablecc.org/). */

package l.node;

import l.analysis.*;

@SuppressWarnings("nls")
public final class AOuExpression extends PExpression
{
    private PExpression _expression_;
    private TOu _ou_;
    private PExpression2 _expression2_;

    public AOuExpression()
    {
        // Constructor
    }

    public AOuExpression(
        @SuppressWarnings("hiding") PExpression _expression_,
        @SuppressWarnings("hiding") TOu _ou_,
        @SuppressWarnings("hiding") PExpression2 _expression2_)
    {
        // Constructor
        setExpression(_expression_);

        setOu(_ou_);

        setExpression2(_expression2_);

    }

    @Override
    public Object clone()
    {
        return new AOuExpression(
            cloneNode(this._expression_),
            cloneNode(this._ou_),
            cloneNode(this._expression2_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAOuExpression(this);
    }

    public PExpression getExpression()
    {
        return this._expression_;
    }

    public void setExpression(PExpression node)
    {
        if(this._expression_ != null)
        {
            this._expression_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._expression_ = node;
    }

    public TOu getOu()
    {
        return this._ou_;
    }

    public void setOu(TOu node)
    {
        if(this._ou_ != null)
        {
            this._ou_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._ou_ = node;
    }

    public PExpression2 getExpression2()
    {
        return this._expression2_;
    }

    public void setExpression2(PExpression2 node)
    {
        if(this._expression2_ != null)
        {
            this._expression2_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._expression2_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._expression_)
            + toString(this._ou_)
            + toString(this._expression2_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._expression_ == child)
        {
            this._expression_ = null;
            return;
        }

        if(this._ou_ == child)
        {
            this._ou_ = null;
            return;
        }

        if(this._expression2_ == child)
        {
            this._expression2_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._expression_ == oldChild)
        {
            setExpression((PExpression) newChild);
            return;
        }

        if(this._ou_ == oldChild)
        {
            setOu((TOu) newChild);
            return;
        }

        if(this._expression2_ == oldChild)
        {
            setExpression2((PExpression2) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
