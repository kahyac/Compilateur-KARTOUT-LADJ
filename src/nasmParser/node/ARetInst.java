/* This file was generated by SableCC (http://www.sablecc.org/). */

package nasmParser.node;

import nasmParser.analysis.*;

@SuppressWarnings("nls")
public final class ARetInst extends PInst
{
    private POplabel _oplabel_;
    private TRet _ret_;

    public ARetInst()
    {
        // Constructor
    }

    public ARetInst(
        @SuppressWarnings("hiding") POplabel _oplabel_,
        @SuppressWarnings("hiding") TRet _ret_)
    {
        // Constructor
        setOplabel(_oplabel_);

        setRet(_ret_);

    }

    @Override
    public Object clone()
    {
        return new ARetInst(
            cloneNode(this._oplabel_),
            cloneNode(this._ret_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseARetInst(this);
    }

    public POplabel getOplabel()
    {
        return this._oplabel_;
    }

    public void setOplabel(POplabel node)
    {
        if(this._oplabel_ != null)
        {
            this._oplabel_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._oplabel_ = node;
    }

    public TRet getRet()
    {
        return this._ret_;
    }

    public void setRet(TRet node)
    {
        if(this._ret_ != null)
        {
            this._ret_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._ret_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._oplabel_)
            + toString(this._ret_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._oplabel_ == child)
        {
            this._oplabel_ = null;
            return;
        }

        if(this._ret_ == child)
        {
            this._ret_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._oplabel_ == oldChild)
        {
            setOplabel((POplabel) newChild);
            return;
        }

        if(this._ret_ == oldChild)
        {
            setRet((TRet) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
