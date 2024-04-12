package c3a;
import ts.*;
import sa.*;

import java.util.List;


public class Sa2c3a extends SaDepthFirstVisitor <C3aOperand> {
    private C3a c3a;
    int indentation;
    public C3a getC3a(){return this.c3a;}

    public Sa2c3a(SaNode root, Ts tableGlobale){
        c3a = new C3a();
        C3aTemp result = c3a.newTemp();
        C3aFunction fct = new C3aFunction(tableGlobale.getFct("main"));
        c3a.ajouteInst(new C3aInstCall(fct, result, ""));
        c3a.ajouteInst(new C3aInstStop(result, ""));
        indentation = 0;
    }

    public void defaultIn(SaNode node)
    {
        //for(int i = 0; i < indentation; i++){System.out.print(" ");}
        //indentation++;
        ///System.out.println("<" + node.getClass().getSimpleName() + ">");
    }

    public void defaultOut(SaNode node)
    {
        //indentation--;
        //for(int i = 0; i < indentation; i++){System.out.print(" ");}
        //System.out.println("</" + node.getClass().getSimpleName() + ">");
    }


    // EXP -> op2 EXP EXP
    public C3aOperand visit(SaExpAdd node) throws Exception
    {
        defaultIn(node);
        C3aOperand op1 = node.getOp1().accept(this);
        C3aOperand op2 = node.getOp2().accept(this);
        C3aOperand result = c3a.newTemp();

        c3a.ajouteInst(new C3aInstAdd(op1, op2, result, ""));
        defaultOut(node);
        return result;
    }


    @Override
    public C3aOperand visit(SaProg node) throws Exception {
        defaultIn(node);

        defaultOut(node);

        return super.visit(node);

    }

    @Override
    public C3aOperand visit(SaDecTab node) throws Exception {
        defaultIn(node);
        defaultOut(node);
        return super.visit(node);
    }

    @Override
    public C3aOperand visit(SaExp node) throws Exception {
        defaultIn(node);
        defaultOut(node);
        return super.visit(node);
    }

    @Override
    public C3aOperand visit(SaExpInt node) throws Exception {
        defaultIn(node);
        C3aOperand op = new C3aConstant(node.getVal());
        defaultOut(node);
        return op;
    }

    @Override
    public C3aOperand visit(SaExpVrai node) throws Exception {
        defaultIn(node);
        C3aOperand op = new C3aConstant(1);
        defaultOut(node);
        return op;
    }

    @Override
    public C3aOperand visit(SaExpFaux node) throws Exception {
        defaultIn(node);
        C3aOperand op = new C3aConstant(0);
        defaultOut(node);
        return op;
    }

    @Override
    public C3aOperand visit(SaExpVar node) throws Exception {
        defaultIn(node);
        C3aOperand var = node.getVar().accept(this);
        defaultOut(node);
        return var;
    }

    @Override
    public C3aOperand visit(SaInstEcriture node) throws Exception {
        defaultIn(node);
        C3aOperand op = node.getArg().accept(this);
        c3a.ajouteInst(new C3aInstWrite(op,""));
        defaultOut(node);
        return op;
    }

    @Override
    public C3aOperand visit(SaInstTantQue node) throws Exception {
        defaultIn(node);
        C3aLabel labelDebut = c3a.newAutoLabel();
        C3aLabel labelFin = c3a.newAutoLabel();
        c3a.addLabelToNextInst(labelDebut);
        C3aOperand temp = node.getTest().accept(this);
        c3a.ajouteInst(new C3aInstJumpIfEqual(temp, new C3aConstant(0), labelFin, ""));
        node.getFaire().accept(this);
        c3a.ajouteInst(new C3aInstJump(labelDebut, ""));
        c3a.addLabelToNextInst(labelFin);
        defaultOut(node);
        return temp;
    }

    @Override
    public C3aOperand visit(SaLInst node) throws Exception {
        defaultIn(node);
        defaultOut(node);
        return super.visit(node);
    }

    @Override
    public C3aOperand visit(SaDecFonc node) throws Exception {
        defaultIn(node);
        c3a.ajouteInst(new C3aInstFBegin(node.tsItem, "entree fonction"));
        C3aOperand op = node.getCorps().accept(this);
        c3a.ajouteInst(new C3aInstFEnd(""));
        defaultOut(node);
        return op;
    }

    @Override
    public C3aOperand visit(SaDecVar node) throws Exception {
        defaultIn(node);
        defaultOut(node);
        return super.visit(node);
    }

    @Override
    public C3aOperand visit(SaInstAffect node) throws Exception {
        defaultIn(node);
        C3aOperand var = node.getLhs().accept(this);
        C3aOperand exp = node.getRhs().accept(this);
        c3a.ajouteInst(new C3aInstAffect(exp, var, ""));
        defaultOut(node);
        return var;
    }

    @Override
    public C3aOperand visit(SaLDecVar node) throws Exception {
        defaultIn(node);
        defaultOut(node);
        return super.visit(node);
    }

    @Override
    public C3aOperand visit(SaLDecFonc node) throws Exception {
        defaultIn(node);
        defaultOut(node);
        return super.visit(node);
    }

    @Override
    public C3aOperand visit(SaExpAppel node) throws Exception {
        defaultIn(node);
        C3aOperand op = node.getVal().accept(this);

        defaultOut(node);
        return op;
    }

    @Override
    public C3aOperand visit(SaExpSub node) throws Exception {
        defaultIn(node);
        C3aOperand op1 = node.getOp1().accept(this);
        C3aOperand op2 = node.getOp2().accept(this);
        C3aOperand result = c3a.newTemp();

        c3a.ajouteInst(new C3aInstSub(op1, op2, result, ""));
        defaultOut(node);
        return result;
    }

    @Override
    public C3aOperand visit(SaExpMult node) throws Exception {
        defaultIn(node);
        C3aOperand op1 = node.getOp1().accept(this);
        C3aOperand op2 = node.getOp2().accept(this);
        C3aOperand result = c3a.newTemp();

        c3a.ajouteInst(new C3aInstMult(op1, op2, result, ""));
        defaultOut(node);
        return result;
    }

    @Override
    public C3aOperand visit(SaExpDiv node) throws Exception {
        defaultIn(node);
        C3aOperand op1 = node.getOp1().accept(this);
        C3aOperand op2 = node.getOp2().accept(this);
        C3aOperand result = c3a.newTemp();

        c3a.ajouteInst(new C3aInstDiv(op1, op2, result, ""));
        defaultOut(node);
        return result;
    }
    @Override
    public C3aOperand visit(SaInstSi node) throws Exception {
        defaultIn(node);
        C3aLabel label1 = c3a.newAutoLabel();
        C3aLabel label2 = c3a.newAutoLabel();
        C3aOperand test = node.getTest().accept(this);

        C3aOperand op = null;

        if (node.getAlors() != null) {

            if (node.getSinon() == null) {

                c3a.ajouteInst(new C3aInstJumpIfEqual(test, new C3aConstant(0),label2,""));
                op = node.getAlors().accept(this);
                c3a.addLabelToNextInst(label2);
            }
            else {
                c3a.ajouteInst(new C3aInstJumpIfEqual(test, new C3aConstant(0),label1,""));
                op = node.getAlors().accept(this);
                c3a.ajouteInst(new C3aInstJump(label2,""));
                c3a.addLabelToNextInst(label1);

                op = node.getSinon().accept(this);

                c3a.addLabelToNextInst(label2);

            }
            ;
        }


        defaultOut(node);
        return op;
    }

    @Override
    public C3aOperand visit(SaInstRetour node) throws Exception {
        defaultIn(node);

        C3aOperand op = node.getVal().accept(this);
        c3a.ajouteInst(new C3aInstReturn(op, ""));
        c3a.ajouteInst(new C3aInstFEnd(""));
        defaultOut(node);

        return op;
    }

    @Override
    public C3aOperand visit(SaLExp node) throws Exception {
        defaultIn(node);
        defaultOut(node);

        return super.visit(node);
    }

    @Override
    public C3aOperand visit(SaVarIndicee node) throws Exception {
        defaultIn(node);
        C3aOperand var = new C3aVar(node.getTsItem(), node.getIndice().accept(this));
        defaultOut(node);
        return var;
    }

    @Override
    public C3aOperand visit(SaExpInf node) throws Exception {
        defaultIn(node);

        C3aLabel label = c3a.newAutoLabel();
        C3aOperand temp = c3a.newTemp();

        C3aOperand op1 = node.getOp1().accept(this);
        C3aOperand op2 = node.getOp2().accept(this);


        c3a.ajouteInst(new C3aInstAffect(new C3aConstant(1), temp, ""));
        c3a.ajouteInst(new C3aInstJumpIfLess(op1, op2, label, ""));
        c3a.ajouteInst(new C3aInstAffect(new C3aConstant(0), temp, ""));

        c3a.addLabelToNextInst(label);
        defaultOut(node);
        return temp;
    }

    @Override
    public C3aOperand visit(SaExpEqual node) throws Exception {
        defaultIn(node);

        C3aOperand result = c3a.newTemp();
        C3aLabel label = c3a.newAutoLabel();

        C3aOperand op1 = node.getOp1().accept(this);
        C3aOperand op2 = node.getOp2().accept(this);

        c3a.ajouteInst(new C3aInstAffect(new C3aConstant(1), result, ""));

        c3a.ajouteInst(new C3aInstJumpIfEqual(op1, op2, label,""));

        c3a.ajouteInst(new C3aInstAffect(new C3aConstant(0), result, ""));

        c3a.addLabelToNextInst(label);

        defaultOut(node);
        return result;
    }

    @Override
    public C3aOperand visit(SaExpAnd node) throws Exception {
        defaultIn(node);

        C3aOperand result = c3a.newTemp();

        C3aLabel label1 = c3a.newAutoLabel();
        C3aLabel label2 = c3a.newAutoLabel();

        C3aOperand op1 = node.getOp1().accept(this);
        C3aOperand op2 = node.getOp2().accept(this);

        c3a.ajouteInst(new C3aInstJumpIfEqual(op1, new C3aConstant(0), label2,""));

        c3a.ajouteInst(new C3aInstJumpIfEqual(op2, new C3aConstant(0), label2,""));

        c3a.ajouteInst(new C3aInstAffect(new C3aConstant(1), result, ""));

        c3a.ajouteInst(new C3aInstJump(label1,""));

        c3a.addLabelToNextInst(label2);
        c3a.ajouteInst(new C3aInstAffect(new C3aConstant(0), result, ""));

        c3a.addLabelToNextInst(label1);
        defaultOut(node);
        return result;
    }

    @Override
    public C3aOperand visit(SaExpOr node) throws Exception {
        defaultIn(node);

        C3aOperand result = c3a.newTemp();

        System.out.println(node);

        C3aLabel label1 = c3a.newAutoLabel();
        C3aLabel label2 = c3a.newAutoLabel();

        C3aOperand op1 = node.getOp1().accept(this);
        C3aOperand op2 = node.getOp2().accept(this);

        c3a.ajouteInst(new C3aInstJumpIfNotEqual(op1, new C3aConstant(0), label2,""));

        c3a.ajouteInst(new C3aInstJumpIfNotEqual(op2, new C3aConstant(0), label2,""));

        c3a.ajouteInst(new C3aInstAffect(new C3aConstant(0), result, ""));

        c3a.ajouteInst(new C3aInstJump(label1,""));

        c3a.addLabelToNextInst(label2);
        c3a.ajouteInst(new C3aInstAffect(new C3aConstant(1), result, ""));

        c3a.addLabelToNextInst(label1);
        defaultOut(node);
        return result;
    }

    @Override
    public C3aOperand visit(SaExpNot node) throws Exception {
        defaultIn(node);

        C3aOperand result = c3a.newTemp();

        C3aLabel label = c3a.newAutoLabel();
        C3aOperand op = node.getOp1().accept(this);
        c3a.ajouteInst(new C3aInstAffect(new C3aConstant(1), result, ""));

        c3a.ajouteInst(new C3aInstJumpIfEqual(op, new C3aConstant(0), label,""));

        c3a.ajouteInst(new C3aInstAffect(new C3aConstant(0), result, ""));

        c3a.addLabelToNextInst(label);

        defaultOut(node);
        return result;
    }

    @Override
    public C3aOperand visit(SaExpLire node) throws Exception {
        defaultIn(node);
        defaultOut(node);
        return super.visit(node);
    }

    @Override
    public C3aOperand visit(SaInstBloc node) throws Exception {
        defaultIn(node);
        defaultOut(node);
        return super.visit(node);
    }

    @Override
    public C3aOperand visit(SaVarSimple node) throws Exception {
        defaultIn(node);

        C3aOperand var = new C3aVar(node.tsItem, null);

        defaultOut(node);
        return var;
    }

    @Override
    public C3aOperand visit(SaAppel node) throws Exception {
        defaultIn(node);
        C3aOperand temp = c3a.newTemp();

        if (node.getArguments() != null) {
            SaLExp args = node.getArguments();
            for (int i = 0; i < node.getArguments().length(); i++) {
                C3aOperand param = args.getTete().accept(this);
                c3a.ajouteInst(new C3aInstParam(param,""));
                if (args.getQueue() == null) {
                    break;
                }
                args = args.getQueue();
            }
        }

        c3a.ajouteInst(new C3aInstCall(new C3aFunction(node.tsItem), temp, ""));
        defaultOut(node);
        return temp;
    }

    @Override
    public C3aOperand visit(SaIncr node) throws Exception {
        defaultIn(node);
        C3aOperand op1 = node.getLhs().accept(this);
        C3aOperand op2 = node.getRhs().accept(this);
        C3aOperand result = c3a.newTemp();

        c3a.ajouteInst(new C3aInstAdd(op1, op2, result, ""));
        defaultOut(node);
        return result;
    }
    @Override
    public C3aOperand visit(SaExpModulo node) throws Exception {
        defaultIn(node);
        C3aOperand op1 = node.getOp1().accept(this);
        C3aOperand op2 = node.getOp2().accept(this);
        C3aOperand result = c3a.newTemp();

        c3a.ajouteInst(new C3aInstDiv(op1, op2, op1, ""));
        defaultOut(node);
        return result;
    }
}
