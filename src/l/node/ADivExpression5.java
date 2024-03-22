/* This file was generated by SableCC (http://www.sablecc.org/). */

package l.node;

import l.analysis.*;

@SuppressWarnings("nls")
public final class ADivExpression5 extends PExpression5
{
    private PExpression5 _expression5_;
    private TDiv _div_;
    private PExpression6 _expression6_;

    public ADivExpression5()
    {
        // Constructor
    }

    public ADivExpression5(
        @SuppressWarnings("hiding") PExpression5 _expression5_,
        @SuppressWarnings("hiding") TDiv _div_,
        @SuppressWarnings("hiding") PExpression6 _expression6_)
    {
        // Constructor
        setExpression5(_expression5_);

        setDiv(_div_);

        setExpression6(_expression6_);

    }

    @Override
    public Object clone()
    {
        return new ADivExpression5(
            cloneNode(this._expression5_),
            cloneNode(this._div_),
            cloneNode(this._expression6_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseADivExpression5(this);
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

    public TDiv getDiv()
    {
        return this._div_;
    }

    public void setDiv(TDiv node)
    {
        if(this._div_ != null)
        {
            this._div_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._div_ = node;
    }

    public PExpression6 getExpression6()
    {
        return this._expression6_;
    }

    public void setExpression6(PExpression6 node)
    {
        if(this._expression6_ != null)
        {
            this._expression6_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._expression6_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._expression5_)
            + toString(this._div_)
            + toString(this._expression6_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._expression5_ == child)
        {
            this._expression5_ = null;
            return;
        }

        if(this._div_ == child)
        {
            this._div_ = null;
            return;
        }

        if(this._expression6_ == child)
        {
            this._expression6_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._expression5_ == oldChild)
        {
            setExpression5((PExpression5) newChild);
            return;
        }

        if(this._div_ == oldChild)
        {
            setDiv((TDiv) newChild);
            return;
        }

        if(this._expression6_ == oldChild)
        {
            setExpression6((PExpression6) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
