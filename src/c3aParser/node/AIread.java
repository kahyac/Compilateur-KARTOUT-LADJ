/* This file was generated by SableCC (http://www.sablecc.org/). */

package c3aParser.node;

import c3aParser.analysis.*;

@SuppressWarnings("nls")
public final class AIread extends PIread
{
    private PEtiqop _etiqop_;
    private PTv _result_;
    private TAff _aff_;
    private TRead _read_;

    public AIread()
    {
        // Constructor
    }

    public AIread(
        @SuppressWarnings("hiding") PEtiqop _etiqop_,
        @SuppressWarnings("hiding") PTv _result_,
        @SuppressWarnings("hiding") TAff _aff_,
        @SuppressWarnings("hiding") TRead _read_)
    {
        // Constructor
        setEtiqop(_etiqop_);

        setResult(_result_);

        setAff(_aff_);

        setRead(_read_);

    }

    @Override
    public Object clone()
    {
        return new AIread(
            cloneNode(this._etiqop_),
            cloneNode(this._result_),
            cloneNode(this._aff_),
            cloneNode(this._read_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAIread(this);
    }

    public PEtiqop getEtiqop()
    {
        return this._etiqop_;
    }

    public void setEtiqop(PEtiqop node)
    {
        if(this._etiqop_ != null)
        {
            this._etiqop_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._etiqop_ = node;
    }

    public PTv getResult()
    {
        return this._result_;
    }

    public void setResult(PTv node)
    {
        if(this._result_ != null)
        {
            this._result_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._result_ = node;
    }

    public TAff getAff()
    {
        return this._aff_;
    }

    public void setAff(TAff node)
    {
        if(this._aff_ != null)
        {
            this._aff_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._aff_ = node;
    }

    public TRead getRead()
    {
        return this._read_;
    }

    public void setRead(TRead node)
    {
        if(this._read_ != null)
        {
            this._read_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._read_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._etiqop_)
            + toString(this._result_)
            + toString(this._aff_)
            + toString(this._read_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._etiqop_ == child)
        {
            this._etiqop_ = null;
            return;
        }

        if(this._result_ == child)
        {
            this._result_ = null;
            return;
        }

        if(this._aff_ == child)
        {
            this._aff_ = null;
            return;
        }

        if(this._read_ == child)
        {
            this._read_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._etiqop_ == oldChild)
        {
            setEtiqop((PEtiqop) newChild);
            return;
        }

        if(this._result_ == oldChild)
        {
            setResult((PTv) newChild);
            return;
        }

        if(this._aff_ == oldChild)
        {
            setAff((TAff) newChild);
            return;
        }

        if(this._read_ == oldChild)
        {
            setRead((TRead) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
