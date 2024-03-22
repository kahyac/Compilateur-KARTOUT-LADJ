/* This file was generated by SableCC (http://www.sablecc.org/). */

package saParser.node;

import saParser.analysis.*;

@SuppressWarnings("nls")
public final class ASimpleVar extends PVar
{
    private TPo _po_;
    private TSavarsimple _savarsimple_;
    private TId _id_;
    private TPf _pf_;

    public ASimpleVar()
    {
        // Constructor
    }

    public ASimpleVar(
        @SuppressWarnings("hiding") TPo _po_,
        @SuppressWarnings("hiding") TSavarsimple _savarsimple_,
        @SuppressWarnings("hiding") TId _id_,
        @SuppressWarnings("hiding") TPf _pf_)
    {
        // Constructor
        setPo(_po_);

        setSavarsimple(_savarsimple_);

        setId(_id_);

        setPf(_pf_);

    }

    @Override
    public Object clone()
    {
        return new ASimpleVar(
            cloneNode(this._po_),
            cloneNode(this._savarsimple_),
            cloneNode(this._id_),
            cloneNode(this._pf_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseASimpleVar(this);
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

    public TSavarsimple getSavarsimple()
    {
        return this._savarsimple_;
    }

    public void setSavarsimple(TSavarsimple node)
    {
        if(this._savarsimple_ != null)
        {
            this._savarsimple_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._savarsimple_ = node;
    }

    public TId getId()
    {
        return this._id_;
    }

    public void setId(TId node)
    {
        if(this._id_ != null)
        {
            this._id_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._id_ = node;
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
            + toString(this._po_)
            + toString(this._savarsimple_)
            + toString(this._id_)
            + toString(this._pf_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._po_ == child)
        {
            this._po_ = null;
            return;
        }

        if(this._savarsimple_ == child)
        {
            this._savarsimple_ = null;
            return;
        }

        if(this._id_ == child)
        {
            this._id_ = null;
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
        if(this._po_ == oldChild)
        {
            setPo((TPo) newChild);
            return;
        }

        if(this._savarsimple_ == oldChild)
        {
            setSavarsimple((TSavarsimple) newChild);
            return;
        }

        if(this._id_ == oldChild)
        {
            setId((TId) newChild);
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
