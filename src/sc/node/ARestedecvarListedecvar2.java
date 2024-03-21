/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.node;

import sc.analysis.*;

@SuppressWarnings("nls")
public final class ARestedecvarListedecvar2 extends PListedecvar2
{
    private TVirgule _virgule_;
    private PVariable _variable_;
    private PListedecvar2 _listedecvar2_;

    public ARestedecvarListedecvar2()
    {
        // Constructor
    }

    public ARestedecvarListedecvar2(
        @SuppressWarnings("hiding") TVirgule _virgule_,
        @SuppressWarnings("hiding") PVariable _variable_,
        @SuppressWarnings("hiding") PListedecvar2 _listedecvar2_)
    {
        // Constructor
        setVirgule(_virgule_);

        setVariable(_variable_);

        setListedecvar2(_listedecvar2_);

    }

    @Override
    public Object clone()
    {
        return new ARestedecvarListedecvar2(
            cloneNode(this._virgule_),
            cloneNode(this._variable_),
            cloneNode(this._listedecvar2_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseARestedecvarListedecvar2(this);
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

    public PVariable getVariable()
    {
        return this._variable_;
    }

    public void setVariable(PVariable node)
    {
        if(this._variable_ != null)
        {
            this._variable_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._variable_ = node;
    }

    public PListedecvar2 getListedecvar2()
    {
        return this._listedecvar2_;
    }

    public void setListedecvar2(PListedecvar2 node)
    {
        if(this._listedecvar2_ != null)
        {
            this._listedecvar2_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._listedecvar2_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._virgule_)
            + toString(this._variable_)
            + toString(this._listedecvar2_);
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

        if(this._variable_ == child)
        {
            this._variable_ = null;
            return;
        }

        if(this._listedecvar2_ == child)
        {
            this._listedecvar2_ = null;
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

        if(this._variable_ == oldChild)
        {
            setVariable((PVariable) newChild);
            return;
        }

        if(this._listedecvar2_ == oldChild)
        {
            setListedecvar2((PListedecvar2) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
