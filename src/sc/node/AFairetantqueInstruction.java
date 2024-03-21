/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.node;

import sc.analysis.*;

@SuppressWarnings("nls")
public final class AFairetantqueInstruction extends PInstruction
{
    private TFaire _faire_;
    private PBlocinstructions _blocinstructions_;
    private TTantque _tantque_;
    private PExpression _expression_;

    public AFairetantqueInstruction()
    {
        // Constructor
    }

    public AFairetantqueInstruction(
        @SuppressWarnings("hiding") TFaire _faire_,
        @SuppressWarnings("hiding") PBlocinstructions _blocinstructions_,
        @SuppressWarnings("hiding") TTantque _tantque_,
        @SuppressWarnings("hiding") PExpression _expression_)
    {
        // Constructor
        setFaire(_faire_);

        setBlocinstructions(_blocinstructions_);

        setTantque(_tantque_);

        setExpression(_expression_);

    }

    @Override
    public Object clone()
    {
        return new AFairetantqueInstruction(
            cloneNode(this._faire_),
            cloneNode(this._blocinstructions_),
            cloneNode(this._tantque_),
            cloneNode(this._expression_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAFairetantqueInstruction(this);
    }

    public TFaire getFaire()
    {
        return this._faire_;
    }

    public void setFaire(TFaire node)
    {
        if(this._faire_ != null)
        {
            this._faire_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._faire_ = node;
    }

    public PBlocinstructions getBlocinstructions()
    {
        return this._blocinstructions_;
    }

    public void setBlocinstructions(PBlocinstructions node)
    {
        if(this._blocinstructions_ != null)
        {
            this._blocinstructions_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._blocinstructions_ = node;
    }

    public TTantque getTantque()
    {
        return this._tantque_;
    }

    public void setTantque(TTantque node)
    {
        if(this._tantque_ != null)
        {
            this._tantque_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._tantque_ = node;
    }

    public PExpression getExpression()
    {
        return this._expression_;
    }

    public void setExpression(PExpression node)
    {
        if(this._expression_ != null)
        {
            this._expression_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._expression_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._faire_)
            + toString(this._blocinstructions_)
            + toString(this._tantque_)
            + toString(this._expression_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._faire_ == child)
        {
            this._faire_ = null;
            return;
        }

        if(this._blocinstructions_ == child)
        {
            this._blocinstructions_ = null;
            return;
        }

        if(this._tantque_ == child)
        {
            this._tantque_ = null;
            return;
        }

        if(this._expression_ == child)
        {
            this._expression_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._faire_ == oldChild)
        {
            setFaire((TFaire) newChild);
            return;
        }

        if(this._blocinstructions_ == oldChild)
        {
            setBlocinstructions((PBlocinstructions) newChild);
            return;
        }

        if(this._tantque_ == oldChild)
        {
            setTantque((TTantque) newChild);
            return;
        }

        if(this._expression_ == oldChild)
        {
            setExpression((PExpression) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
