/* This file was generated by SableCC (http://www.sablecc.org/). */

package nasmParser.node;

import nasmParser.analysis.*;

@SuppressWarnings("nls")
public final class ARecLvar extends PLvar
{
    private PVar _var_;
    private PLvar _lvar_;

    public ARecLvar()
    {
        // Constructor
    }

    public ARecLvar(
        @SuppressWarnings("hiding") PVar _var_,
        @SuppressWarnings("hiding") PLvar _lvar_)
    {
        // Constructor
        setVar(_var_);

        setLvar(_lvar_);

    }

    @Override
    public Object clone()
    {
        return new ARecLvar(
            cloneNode(this._var_),
            cloneNode(this._lvar_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseARecLvar(this);
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

    public PLvar getLvar()
    {
        return this._lvar_;
    }

    public void setLvar(PLvar node)
    {
        if(this._lvar_ != null)
        {
            this._lvar_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._lvar_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._var_)
            + toString(this._lvar_);
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

        if(this._lvar_ == child)
        {
            this._lvar_ = null;
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

        if(this._lvar_ == oldChild)
        {
            setLvar((PLvar) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
