/* This file was generated by SableCC (http://www.sablecc.org/). */

package c3aParser.node;

import c3aParser.analysis.*;

@SuppressWarnings("nls")
public final class ATCtv extends PCtv
{
    private PTemporaire _temporaire_;

    public ATCtv()
    {
        // Constructor
    }

    public ATCtv(
        @SuppressWarnings("hiding") PTemporaire _temporaire_)
    {
        // Constructor
        setTemporaire(_temporaire_);

    }

    @Override
    public Object clone()
    {
        return new ATCtv(
            cloneNode(this._temporaire_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseATCtv(this);
    }

    public PTemporaire getTemporaire()
    {
        return this._temporaire_;
    }

    public void setTemporaire(PTemporaire node)
    {
        if(this._temporaire_ != null)
        {
            this._temporaire_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._temporaire_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._temporaire_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._temporaire_ == child)
        {
            this._temporaire_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._temporaire_ == oldChild)
        {
            setTemporaire((PTemporaire) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
