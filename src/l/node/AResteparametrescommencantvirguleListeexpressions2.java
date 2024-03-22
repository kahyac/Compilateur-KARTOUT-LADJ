/* This file was generated by SableCC (http://www.sablecc.org/). */

package l.node;

import l.analysis.*;

@SuppressWarnings("nls")
public final class AResteparametrescommencantvirguleListeexpressions2 extends PListeexpressions2
{
    private TVirgule _virgule_;
    private PExpression _expression_;
    private PListeexpressions2 _listeexpressions2_;

    public AResteparametrescommencantvirguleListeexpressions2()
    {
        // Constructor
    }

    public AResteparametrescommencantvirguleListeexpressions2(
        @SuppressWarnings("hiding") TVirgule _virgule_,
        @SuppressWarnings("hiding") PExpression _expression_,
        @SuppressWarnings("hiding") PListeexpressions2 _listeexpressions2_)
    {
        // Constructor
        setVirgule(_virgule_);

        setExpression(_expression_);

        setListeexpressions2(_listeexpressions2_);

    }

    @Override
    public Object clone()
    {
        return new AResteparametrescommencantvirguleListeexpressions2(
            cloneNode(this._virgule_),
            cloneNode(this._expression_),
            cloneNode(this._listeexpressions2_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAResteparametrescommencantvirguleListeexpressions2(this);
    }

    public TVirgule getVirgule()
    {
        return this._virgule_;
    }

    public void setVirgule(TVirgule node)
    {
        if(this._virgule_ != null)
        {
            this._virgule_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._virgule_ = node;
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

    public PListeexpressions2 getListeexpressions2()
    {
        return this._listeexpressions2_;
    }

    public void setListeexpressions2(PListeexpressions2 node)
    {
        if(this._listeexpressions2_ != null)
        {
            this._listeexpressions2_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._listeexpressions2_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._virgule_)
            + toString(this._expression_)
            + toString(this._listeexpressions2_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._virgule_ == child)
        {
            this._virgule_ = null;
            return;
        }

        if(this._expression_ == child)
        {
            this._expression_ = null;
            return;
        }

        if(this._listeexpressions2_ == child)
        {
            this._listeexpressions2_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._virgule_ == oldChild)
        {
            setVirgule((TVirgule) newChild);
            return;
        }

        if(this._expression_ == oldChild)
        {
            setExpression((PExpression) newChild);
            return;
        }

        if(this._listeexpressions2_ == oldChild)
        {
            setListeexpressions2((PListeexpressions2) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
