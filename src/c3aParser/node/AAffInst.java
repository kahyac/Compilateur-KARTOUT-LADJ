/* This file was generated by SableCC (http://www.sablecc.org/). */

package c3aParser.node;

import c3aParser.analysis.*;

@SuppressWarnings("nls")
public final class AAffInst extends PInst
{
    private PAffect _affect_;

    public AAffInst()
    {
        // Constructor
    }

    public AAffInst(
        @SuppressWarnings("hiding") PAffect _affect_)
    {
        // Constructor
        setAffect(_affect_);

    }

    @Override
    public Object clone()
    {
        return new AAffInst(
            cloneNode(this._affect_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAAffInst(this);
    }

    public PAffect getAffect()
    {
        return this._affect_;
    }

    public void setAffect(PAffect node)
    {
        if(this._affect_ != null)
        {
            this._affect_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._affect_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._affect_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._affect_ == child)
        {
            this._affect_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._affect_ == oldChild)
        {
            setAffect((PAffect) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
