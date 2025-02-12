/* This file was generated by SableCC (http://www.sablecc.org/). */

package lParser.node;

import lParser.analysis.*;

@SuppressWarnings("nls")
public final class APlusExpression4 extends PExpression4
{
    private PExpression4 _expression4_;
    private TPlus _plus_;
    private PExpression5 _expression5_;

    public APlusExpression4()
    {
        // Constructor
    }

    public APlusExpression4(
        @SuppressWarnings("hiding") PExpression4 _expression4_,
        @SuppressWarnings("hiding") TPlus _plus_,
        @SuppressWarnings("hiding") PExpression5 _expression5_)
    {
        // Constructor
        setExpression4(_expression4_);

        setPlus(_plus_);

        setExpression5(_expression5_);

    }

    @Override
    public Object clone()
    {
        return new APlusExpression4(
            cloneNode(this._expression4_),
            cloneNode(this._plus_),
            cloneNode(this._expression5_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAPlusExpression4(this);
    }

    public PExpression4 getExpression4()
    {
        return this._expression4_;
    }

    public void setExpression4(PExpression4 node)
    {
        if(this._expression4_ != null)
        {
            this._expression4_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._expression4_ = node;
    }

    public TPlus getPlus()
    {
        return this._plus_;
    }

    public void setPlus(TPlus node)
    {
        if(this._plus_ != null)
        {
            this._plus_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._plus_ = node;
    }

    public PExpression5 getExpression5()
    {
        return this._expression5_;
    }

    public void setExpression5(PExpression5 node)
    {
        if(this._expression5_ != null)
        {
            this._expression5_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._expression5_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._expression4_)
            + toString(this._plus_)
            + toString(this._expression5_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._expression4_ == child)
        {
            this._expression4_ = null;
            return;
        }

        if(this._plus_ == child)
        {
            this._plus_ = null;
            return;
        }

        if(this._expression5_ == child)
        {
            this._expression5_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._expression4_ == oldChild)
        {
            setExpression4((PExpression4) newChild);
            return;
        }

        if(this._plus_ == oldChild)
        {
            setPlus((TPlus) newChild);
            return;
        }

        if(this._expression5_ == oldChild)
        {
            setExpression5((PExpression5) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
