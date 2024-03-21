/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.node;

import sc.analysis.*;

@SuppressWarnings("nls")
public final class ACarreExpressioncarre extends PExpressioncarre
{
    private PExpression7 _expression7_;
    private TCarre _carre_;

    public ACarreExpressioncarre()
    {
        // Constructor
    }

    public ACarreExpressioncarre(
        @SuppressWarnings("hiding") PExpression7 _expression7_,
        @SuppressWarnings("hiding") TCarre _carre_)
    {
        // Constructor
        setExpression7(_expression7_);

        setCarre(_carre_);

    }

    @Override
    public Object clone()
    {
        return new ACarreExpressioncarre(
            cloneNode(this._expression7_),
            cloneNode(this._carre_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseACarreExpressioncarre(this);
    }

    public PExpression7 getExpression7()
    {
        return this._expression7_;
    }

    public void setExpression7(PExpression7 node)
    {
        if(this._expression7_ != null)
        {
            this._expression7_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._expression7_ = node;
    }

    public TCarre getCarre()
    {
        return this._carre_;
    }

    public void setCarre(TCarre node)
    {
        if(this._carre_ != null)
        {
            this._carre_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._carre_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._expression7_)
            + toString(this._carre_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._expression7_ == child)
        {
            this._expression7_ = null;
            return;
        }

        if(this._carre_ == child)
        {
            this._carre_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._expression7_ == oldChild)
        {
            setExpression7((PExpression7) newChild);
            return;
        }

        if(this._carre_ == oldChild)
        {
            setCarre((TCarre) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
