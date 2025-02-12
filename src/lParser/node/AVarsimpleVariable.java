/* This file was generated by SableCC (http://www.sablecc.org/). */

package lParser.node;

import lParser.analysis.*;

@SuppressWarnings("nls")
public final class AVarsimpleVariable extends PVariable
{
    private PTypevar _premier_;
    private TIdentif _identif_;

    public AVarsimpleVariable()
    {
        // Constructor
    }

    public AVarsimpleVariable(
        @SuppressWarnings("hiding") PTypevar _premier_,
        @SuppressWarnings("hiding") TIdentif _identif_)
    {
        // Constructor
        setPremier(_premier_);

        setIdentif(_identif_);

    }

    @Override
    public Object clone()
    {
        return new AVarsimpleVariable(
            cloneNode(this._premier_),
            cloneNode(this._identif_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAVarsimpleVariable(this);
    }

    public PTypevar getPremier()
    {
        return this._premier_;
    }

    public void setPremier(PTypevar node)
    {
        if(this._premier_ != null)
        {
            this._premier_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._premier_ = node;
    }

    public TIdentif getIdentif()
    {
        return this._identif_;
    }

    public void setIdentif(TIdentif node)
    {
        if(this._identif_ != null)
        {
            this._identif_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._identif_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._premier_)
            + toString(this._identif_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._premier_ == child)
        {
            this._premier_ = null;
            return;
        }

        if(this._identif_ == child)
        {
            this._identif_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._premier_ == oldChild)
        {
            setPremier((PTypevar) newChild);
            return;
        }

        if(this._identif_ == oldChild)
        {
            setIdentif((TIdentif) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
