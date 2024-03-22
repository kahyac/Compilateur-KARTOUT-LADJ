/* This file was generated by SableCC (http://www.sablecc.org/). */

package saParser.node;

import saParser.analysis.*;

@SuppressWarnings("nls")
public final class AFinLdecvar extends PLdecvar
{
    private TNull _null_;

    public AFinLdecvar()
    {
        // Constructor
    }

    public AFinLdecvar(
        @SuppressWarnings("hiding") TNull _null_)
    {
        // Constructor
        setNull(_null_);

    }

    @Override
    public Object clone()
    {
        return new AFinLdecvar(
            cloneNode(this._null_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAFinLdecvar(this);
    }

    public TNull getNull()
    {
        return this._null_;
    }

    public void setNull(TNull node)
    {
        if(this._null_ != null)
        {
            this._null_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._null_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._null_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._null_ == child)
        {
            this._null_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._null_ == oldChild)
        {
            setNull((TNull) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
