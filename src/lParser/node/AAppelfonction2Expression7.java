/* This file was generated by SableCC (http://www.sablecc.org/). */

package lParser.node;

import lParser.analysis.*;

@SuppressWarnings("nls")
public final class AAppelfonction2Expression7 extends PExpression7
{
    private TIdentif _identif_;
    private TPo _po_;
    private PListeexpressions _listeexpressions_;
    private TPf _pf_;

    public AAppelfonction2Expression7()
    {
        // Constructor
    }

    public AAppelfonction2Expression7(
        @SuppressWarnings("hiding") TIdentif _identif_,
        @SuppressWarnings("hiding") TPo _po_,
        @SuppressWarnings("hiding") PListeexpressions _listeexpressions_,
        @SuppressWarnings("hiding") TPf _pf_)
    {
        // Constructor
        setIdentif(_identif_);

        setPo(_po_);

        setListeexpressions(_listeexpressions_);

        setPf(_pf_);

    }

    @Override
    public Object clone()
    {
        return new AAppelfonction2Expression7(
            cloneNode(this._identif_),
            cloneNode(this._po_),
            cloneNode(this._listeexpressions_),
            cloneNode(this._pf_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAAppelfonction2Expression7(this);
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

    public TPo getPo()
    {
        return this._po_;
    }

    public void setPo(TPo node)
    {
        if(this._po_ != null)
        {
            this._po_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._po_ = node;
    }

    public PListeexpressions getListeexpressions()
    {
        return this._listeexpressions_;
    }

    public void setListeexpressions(PListeexpressions node)
    {
        if(this._listeexpressions_ != null)
        {
            this._listeexpressions_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._listeexpressions_ = node;
    }

    public TPf getPf()
    {
        return this._pf_;
    }

    public void setPf(TPf node)
    {
        if(this._pf_ != null)
        {
            this._pf_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._pf_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._identif_)
            + toString(this._po_)
            + toString(this._listeexpressions_)
            + toString(this._pf_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._identif_ == child)
        {
            this._identif_ = null;
            return;
        }

        if(this._po_ == child)
        {
            this._po_ = null;
            return;
        }

        if(this._listeexpressions_ == child)
        {
            this._listeexpressions_ = null;
            return;
        }

        if(this._pf_ == child)
        {
            this._pf_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._identif_ == oldChild)
        {
            setIdentif((TIdentif) newChild);
            return;
        }

        if(this._po_ == oldChild)
        {
            setPo((TPo) newChild);
            return;
        }

        if(this._listeexpressions_ == oldChild)
        {
            setListeexpressions((PListeexpressions) newChild);
            return;
        }

        if(this._pf_ == oldChild)
        {
            setPf((TPf) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
