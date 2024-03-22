/* This file was generated by SableCC (http://www.sablecc.org/). */

package nasmParser.node;

import nasmParser.analysis.*;

@SuppressWarnings("nls")
public final class ARecLglobal extends PLglobal
{
    private TGlobal _global_;
    private PLabel _label_;
    private PLglobal _lglobal_;

    public ARecLglobal()
    {
        // Constructor
    }

    public ARecLglobal(
        @SuppressWarnings("hiding") TGlobal _global_,
        @SuppressWarnings("hiding") PLabel _label_,
        @SuppressWarnings("hiding") PLglobal _lglobal_)
    {
        // Constructor
        setGlobal(_global_);

        setLabel(_label_);

        setLglobal(_lglobal_);

    }

    @Override
    public Object clone()
    {
        return new ARecLglobal(
            cloneNode(this._global_),
            cloneNode(this._label_),
            cloneNode(this._lglobal_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseARecLglobal(this);
    }

    public TGlobal getGlobal()
    {
        return this._global_;
    }

    public void setGlobal(TGlobal node)
    {
        if(this._global_ != null)
        {
            this._global_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._global_ = node;
    }

    public PLabel getLabel()
    {
        return this._label_;
    }

    public void setLabel(PLabel node)
    {
        if(this._label_ != null)
        {
            this._label_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._label_ = node;
    }

    public PLglobal getLglobal()
    {
        return this._lglobal_;
    }

    public void setLglobal(PLglobal node)
    {
        if(this._lglobal_ != null)
        {
            this._lglobal_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._lglobal_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._global_)
            + toString(this._label_)
            + toString(this._lglobal_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._global_ == child)
        {
            this._global_ = null;
            return;
        }

        if(this._label_ == child)
        {
            this._label_ = null;
            return;
        }

        if(this._lglobal_ == child)
        {
            this._lglobal_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._global_ == oldChild)
        {
            setGlobal((TGlobal) newChild);
            return;
        }

        if(this._label_ == oldChild)
        {
            setLabel((PLabel) newChild);
            return;
        }

        if(this._lglobal_ == oldChild)
        {
            setLglobal((PLglobal) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
