package sa;
import lParser.analysis.*;
import lParser.node.*;
import util.Type;

public class Sc2sa extends DepthFirstAdapter
{
    private SaNode returnValue;
    private Type returnType;

    public void defaultIn(@SuppressWarnings("unused") Node node)
    {
        //System.out.println("<" + node.getClass().getSimpleName() + ">");
    }

    public void defaultOut(@SuppressWarnings("unused") Node node)
    {
        //System.out.println("</" + node.getClass().getSimpleName() + ">");
    }

    public SaNode getRoot()
    {
        return this.returnValue;
    }


    @Override
    public void caseAProgramme(AProgramme node)
    {

        inAProgramme(node);
        SaLDecVar ldv = null;
        SaLDecFonc ldf = null;
        if(node.getListedecvar() != null)
        {
            node.getListedecvar().apply(this);
            ldv = (SaLDecVar) this.returnValue;
        }
        if(node.getListedecfonc() != null)
        {
            node.getListedecfonc().apply(this);
            ldf = (SaLDecFonc) this.returnValue;
        }
        this.returnValue = new SaProg(ldv, ldf);
        outAProgramme(node);
    }



    @Override
    public void caseADecvarListedecvar(ADecvarListedecvar node)
    {

        inADecvarListedecvar(node);
        SaDecVar dv = null;
        SaLDecVar ldv = null;
        if(node.getVariable() != null)
        {
            node.getVariable().apply(this);
            dv = (SaDecVar) this.returnValue;
        }
        if(node.getListedecvar2() != null)
        {
            node.getListedecvar2().apply(this);
            ldv = (SaLDecVar) this.returnValue;
        }
        this.returnValue = new SaLDecVar(dv, ldv);
        outADecvarListedecvar(node);
    }


    @Override
    public void caseAVideListedecvar(AVideListedecvar node)
    {
        inAVideListedecvar(node);
        this.returnValue = null;
        outAVideListedecvar(node);
    }



    @Override
    public void caseARestedecvarListedecvar2(ARestedecvarListedecvar2 node)
    {

        inARestedecvarListedecvar2(node);
        SaDecVar dv = null;
        SaLDecVar ldv = null;

        if(node.getVariable() != null)
        {
            node.getVariable().apply(this);
            dv = (SaDecVar) this.returnValue;
        }
        if(node.getListedecvar2() != null)
        {
            node.getListedecvar2().apply(this);
            ldv = (SaLDecVar) this.returnValue;
        }
        this.returnValue = new SaLDecVar(dv, ldv);
        outARestedecvarListedecvar2(node);
    }

    @Override
    public void caseAVideListedecvar2(AVideListedecvar2 node)
    {
        inAVideListedecvar2(node);
        this.returnValue = null;
        outAVideListedecvar2(node);
    }



    public void caseAVarsimpleVariable(AVarsimpleVariable node)
    {

        inAVarsimpleVariable(node);
        String identif = null;
        Type type = null;
        if(node.getPremier() != null)
        {
            node.getPremier().apply(this);
            type = this.returnType;
        }
        if(node.getIdentif() != null)
        {
            node.getIdentif().apply(this);
            identif = node.getIdentif().getText();
        }
        this.returnValue = new SaDecVarSimple(identif, type);
        outAVarsimpleVariable(node);
    }





    @Override
    public void caseAVartabVariable(AVartabVariable node)
    {
        inAVartabVariable(node);
        String nom = null;
        Type type = null;
        int taille = 0;

        node.getIdentif().apply(this);
        nom = node.getIdentif().getText();

        node.getSecond().apply(this);
        type = this.returnType;

        node.getNombre().apply(this);
        taille = Integer.parseInt(node.getNombre().getText());

        this.returnValue = new SaDecTab(nom, type, taille);
        outAVartabVariable(node);
    }



    @Override
    public void caseAEntierTypevar(AEntierTypevar node)
    {
        inAEntierTypevar(node);
        if(node.getEntier() != null)
        {
            node.getEntier().apply(this);
            returnType = Type.ENTIER;
        }
        outAEntierTypevar(node);
    }


    @Override
    public void caseABooleanTypevar(ABooleanTypevar node)
    {
        inABooleanTypevar(node);
        if(node.getBool() != null)
        {
            node.getBool().apply(this);
            returnType = Type.BOOL;
        }
        outABooleanTypevar(node);
    }





    @Override
    public void caseADecfonctionListedecfonc(ADecfonctionListedecfonc node)
    {

        inADecfonctionListedecfonc(node);
        SaDecFonc fct = null;
        SaLDecFonc ldf = null;
        if(node.getFonction() != null)
        {
            node.getFonction().apply(this);
            fct = (SaDecFonc) this.returnValue;
        }
        if(node.getListedecfonc() != null)
        {
            node.getListedecfonc().apply(this);
            ldf = (SaLDecFonc) this.returnValue;
        }
        this.returnValue = new SaLDecFonc(fct, ldf);
        outADecfonctionListedecfonc(node);
    }


    @Override
    public void caseAVideListedecfonc(AVideListedecfonc node)
    {
        inAVideListedecfonc(node);
        this.returnValue = null;
        outAVideListedecfonc(node);
    }






    @Override
    public void caseAFonction(AFonction node)
    {

        inAFonction(node);
        String nom = null;
        Type optionalType = null;
        SaLDecVar parameters = null;
        SaLDecVar variables = null;
        SaInst blocInstructions = null;
        if(node.getTypeoptionnel() != null)
        {
            node.getTypeoptionnel().apply(this);
            // optionalType = Type.valueOf(node.getIdentif().getText());
            optionalType = this.returnType;
        }
        if(node.getIdentif() != null)
        {
            node.getIdentif().apply(this);
            nom = node.getIdentif().getText();
        }
        if(node.getPremier() != null)
        {
            node.getPremier().apply(this);
            parameters = (SaLDecVar) this.returnValue;
        }
        if(node.getSecond() != null)
        {
            node.getSecond().apply(this);
            variables = (SaLDecVar) this.returnValue;
        }
        if(node.getBlocinstructions() != null)
        {
            node.getBlocinstructions().apply(this);
            blocInstructions = (SaInst) this.returnValue;
        }
        this.returnValue = new SaDecFonc(nom, optionalType, parameters, variables, blocInstructions);
        outAFonction(node);
    }


    public void caseAVideTypeoptionnel(AVideTypeoptionnel node)
    {
        inAVideTypeoptionnel(node);
        returnType = Type.NUL;
        outAVideTypeoptionnel(node);
    }




    @Override
    public void caseABlocinstructions(ABlocinstructions node)
    {

        inABlocinstructions(node);
        SaLInst listeInstructions = null;
        if(node.getListeinstructions() != null)
        {
            node.getListeinstructions().apply(this);
            listeInstructions = (SaLInst) this.returnValue;
        }
        this.returnValue = new SaInstBloc(listeInstructions);
        outABlocinstructions(node);
    }




    @Override
    public void caseAInstructionsListeinstructions(AInstructionsListeinstructions node)
    {

        inAInstructionsListeinstructions(node);
        SaInst firstInstruction = null;
        SaLInst listeInstructions = null;
        if(node.getInstruction() != null)
        {
            node.getInstruction().apply(this);
            firstInstruction = (SaInst) this.returnValue;
        }
        if(node.getListeinstructions() != null)
        {
            node.getListeinstructions().apply(this);
            listeInstructions = (SaLInst) this.returnValue;
        }
        this.returnValue = new SaLInst(firstInstruction, listeInstructions);
        outAInstructionsListeinstructions(node);
    }


    @Override
    public void caseAVideListeinstructions(AVideListeinstructions node)
    {
        inAVideListeinstructions(node);
        this.returnValue = null;
        outAVideListeinstructions(node);
    }




    @Override
    public void caseAAffectationInstruction(AAffectationInstruction node)
    {
        inAAffectationInstruction(node);
        SaVar var = null;
        SaExp exp = null;
        if(node.getVar() != null)
        {
            node.getVar().apply(this);
            var = (SaVar) this.returnValue;
        }

        if(node.getExpression() != null)
        {
            node.getExpression().apply(this);
            exp = (SaExp) this.returnValue;
        }
        this.returnValue = new SaInstAffect(var, exp);
        outAAffectationInstruction(node);
    }




    @Override
    public void caseAListeparametresListeexpressions(AListeparametresListeexpressions node)
    {

        inAListeparametresListeexpressions(node);
        SaExp firstExp = null;
        SaLExp listeExpressions = null;
        if(node.getExpression() != null)
        {
            node.getExpression().apply(this);
            firstExp = (SaExp) this.returnValue;
        }
        if(node.getListeexpressions2() != null)
        {
            node.getListeexpressions2().apply(this);
            listeExpressions = (SaLExp) this.returnValue;
        }
        this.returnValue = new SaLExp(firstExp, listeExpressions);
        outAListeparametresListeexpressions(node);
    }


    @Override
    public void caseAVideListeexpressions(AVideListeexpressions node)
    {
        inAVideListeexpressions(node);
        this.returnValue = null;
        outAVideListeexpressions(node);
    }

    @Override
    public void caseAInstrvideInstruction(AInstrvideInstruction node)
    {
        inAInstrvideInstruction(node);
        if(node.getPointvirgule() != null)
        {
            node.getPointvirgule().apply(this);
        }
        outAInstrvideInstruction(node);
    }



    @Override
    public void caseAResteparametrescommencantvirguleListeexpressions2(AResteparametrescommencantvirguleListeexpressions2 node)
    {

        inAResteparametrescommencantvirguleListeexpressions2(node);
        SaExp firstExp = null;
        SaLExp listeExpressions = null;

        if(node.getExpression() != null)
        {
            node.getExpression().apply(this);
            firstExp = (SaExp) this.returnValue;
        }
        if(node.getListeexpressions2() != null)
        {
            node.getListeexpressions2().apply(this);
            listeExpressions = (SaLExp) this.returnValue;
        }
        this.returnValue = new SaLExp(firstExp, listeExpressions);
        outAResteparametrescommencantvirguleListeexpressions2(node);
    }

    @Override
    public void caseAVideListeexpressions2(AVideListeexpressions2 node)
    {
        inAVideListeexpressions2(node);
        this.returnValue = null;
        outAVideListeexpressions2(node);
    }





    //{tantque} tantque expression faire blocinstructions
    public void caseATantqueInstruction(ATantqueInstruction node)
    {
        inATantqueInstruction(node);
        SaExp expression = null;
        SaInst tantque = null;

        if(node.getExpression() != null)
        {
            node.getExpression().apply(this);
            expression =  (SaExp) this.returnValue;
        }

        if(node.getBlocinstructions() != null)
        {
            node.getBlocinstructions().apply(this);
            tantque = (SaInst) this.returnValue;
        }
        this.returnValue = new SaInstTantQue(expression, tantque);
        outATantqueInstruction(node);

    }
    //{sialors} si expression alors blocinstructions
    public void caseASialorsInstruction(ASialorsInstruction node)
    {
        inASialorsInstruction(node);
        SaExp test = null;
        SaInst alors = null;
//        SaInst sinon = null;

        if(node.getExpression() != null)
        {
            node.getExpression().apply(this);
            test = (SaExp) this.returnValue;
        }

        if(node.getBlocinstructions() != null)
        {
            node.getBlocinstructions().apply(this);
            alors = (SaInst) this.returnValue;
        }
        this.returnValue =  new SaInstSi(test,alors,null);
        outASialorsInstruction(node);

    }
    //{sisinon} si expression alors [premier]:blocinstructions sinon [second]:blocinstructions
    public void caseASisinonInstruction(ASisinonInstruction node)
    {
        inASisinonInstruction(node);
        SaExp test = null;
        SaInst alors = null, sinon = null;

        if(node.getExpression() != null)
        {
            node.getExpression().apply(this);
            test = (SaExp) this.returnValue;
        }

        if(node.getPremier() != null)
        {
            node.getPremier().apply(this);
            alors = (SaInst) this.returnValue;

        }

        if(node.getSecond() != null)
        {
            node.getSecond().apply(this);
            sinon = (SaInst) this.returnValue;
        }
        this.returnValue = new SaInstSi(test,alors,sinon);
        outASisinonInstruction(node);

    }
    //{retour} retour expression pointvirgule
    public void caseARetourInstruction(ARetourInstruction node)
    {
        inARetourInstruction(node);
        SaExp val = null;

        if(node.getExpression() != null)
        {
            node.getExpression().apply(this);
            val = (SaExp) this.returnValue;
        }
        this.returnValue = new SaInstRetour(val);
        outARetourInstruction(node);

    }
    //{appelfonction} identif po listeexpressions pf pointvirgule
    public void caseAAppelfonctionInstruction(AAppelfonctionInstruction node)
    {

        inAAppelfonctionInstruction(node);
        String nom = null;
        SaLExp arguments = null;

        if(node.getIdentif() != null)
        {
            node.getIdentif().apply(this);
            nom = node.getIdentif().getText();
        }

        if(node.getListeexpressions() != null)
        {
            node.getListeexpressions().apply(this);
            arguments = (SaLExp) this.returnValue;
        }
        this.returnValue =  new SaAppel(nom,arguments);
        outAAppelfonctionInstruction(node);

    }
    // var = {identificateur} identif
    public void caseAIdentificateurVar(AIdentificateurVar node)
    {

        inAIdentificateurVar(node);
        String nom = null;
        Type type;

        if(node.getIdentif() != null)
        {
            node.getIdentif().apply(this);
            nom = node.getIdentif().getText();

        }
        this.returnValue = new SaVarSimple(nom);
        outAIdentificateurVar(node);

    }

    //{casetableau} identif co expression cf ;
    public void caseACasetableauVar(ACasetableauVar node)
    {

        inACasetableauVar(node);
        String nom = null ;
        SaExp indice = null ;
        int taille ;
        if(node.getIdentif() != null)
        {
            node.getIdentif().apply(this);
            nom = node.getIdentif().getText();
        }

        if(node.getExpression() != null)
        {
            node.getExpression().apply(this);
            indice = (SaExp) this.returnValue;
        }
        this.returnValue = new SaVarIndicee(nom,indice);
        outACasetableauVar(node);

    }

    //ecrire} ecrire po expression pf pointvirgule
    public void caseAEcrireInstruction(AEcrireInstruction node)
    {

        inAEcrireInstruction(node);
        SaExp arg = null;

        if(node.getExpression() != null)
        {
            node.getExpression().apply(this);
            arg = (SaExp) this.returnValue;
        }
        this.returnValue = new SaInstEcriture(arg);
        outAEcrireInstruction(node);
    }

    //expression2 = {et} expression2 et expression3
    public void caseAEtExpression2(AEtExpression2 node)
    {
        inAEtExpression2(node);
        SaExp op1 = null;
        SaExp op2 = null;

        if(node.getExpression2() != null)
        {
            node.getExpression2().apply(this);
            op1 = (SaExp) this.returnValue;
        }

        if(node.getExpression3() != null)
        {
            node.getExpression3().apply(this);
            op2 = (SaExp) this.returnValue;

        }

        this.returnValue = new SaExpAnd(op1,op2);
        outAEtExpression2(node);
    }


    //expression = {ou} expression ou expression2
    public void caseAOuExpression(AOuExpression node)
    {
        inAOuExpression(node);
        SaExp op1 = null;
        SaExp op2 = null;
        if(node.getExpression() != null)
        {
            node.getExpression().apply(this);
            op1 = (SaExp) this.returnValue;
        }

        if(node.getExpression2() != null)
        {
            node.getExpression2().apply(this);
            op2 = (SaExp) this.returnValue;
        }
        this.returnValue = new SaExpOr(op1,op2);
        outAOuExpression(node);
    }
    //expression3 = {egal} expression3 egal expression4
    public void caseAEgalExpression3(AEgalExpression3 node)
    {
        inAEgalExpression3(node);
        SaExp op1 = null;
        SaExp op2 = null;
        if(node.getExpression3() != null)
        {
            node.getExpression3().apply(this);
            op1 = (SaExp) this.returnValue;

        }

        if(node.getExpression4() != null)
        {
            node.getExpression4().apply(this);
            op2 = (SaExp) this.returnValue;
        }
        this.returnValue = new SaExpEqual(op1,op2);
        outAEgalExpression3(node);
    }
    // {inferieur} expression3 inferieur expression4
    public void caseAInferieurExpression3(AInferieurExpression3 node)
    {

        inAInferieurExpression3(node);
        SaExp op1 = null;
        SaExp op2 = null;
        if(node.getExpression3() != null)
        {
            node.getExpression3().apply(this);
            op1 = (SaExp) this.returnValue;
        }

        if(node.getExpression4() != null)
        {
            node.getExpression4().apply(this);
            op2 = (SaExp) this.returnValue;
        }
        this.returnValue = new SaExpInf(op1,op2);
        outAInferieurExpression3(node);
    }

    // {plus} expression4 plus expression5
    @Override
    public void caseAPlusExpression4(APlusExpression4 node)
    {

        inAPlusExpression4(node);
        SaExp op1 = null;
        SaExp op2 = null;


        node.getExpression4().apply(this);
        op1 = (SaExp) this.returnValue;



        node.getExpression5().apply(this);
        op2 = (SaExp) this.returnValue;

        this.returnValue = new SaExpAdd(op1, op2);
        outAPlusExpression4(node);
    }



    // {moins} expression4 moins expression5
    @Override
    public void caseAMoinsExpression4(AMoinsExpression4 node)
    {

        inAMoinsExpression4(node);
        SaExp op1 = null;
        SaExp op2 = null;
        if(node.getExpression4() != null)
        {
            node.getExpression4().apply(this);
            op1 = (SaExp) this.returnValue;
        }

        if(node.getExpression5() != null)
        {
            node.getExpression5().apply(this);
            op2 = (SaExp) this.returnValue;
        }
        this.returnValue = new SaExpSub(op1, op2);
        outAMoinsExpression4(node);
    }


    // {mult} expression5 mult expression6
    @Override
    public void caseAMultExpression5(AMultExpression5 node)
    {
        inAMultExpression5(node);
        SaExp op1 = null;
        SaExp op2 = null;
        if(node.getExpression5() != null)
        {
            node.getExpression5().apply(this);
            op1 = (SaExp) this.returnValue;
        }

        if(node.getExpression6() != null)
        {
            node.getExpression6().apply(this);
            op2 = (SaExp) this.returnValue;

        }
        this.returnValue = new SaExpMult(op1, op2);
        outAMultExpression5(node);
    }


    // {div} expression5 div expression6
    @Override
    public void caseADivExpression5(ADivExpression5 node)
    {

        inADivExpression5(node);
        SaExp op1 = null;
        SaExp op2 = null;

        if(node.getExpression5() != null)
        {
            node.getExpression5().apply(this);
            op1 = (SaExp) this.returnValue;
        }
        if(node.getExpression6() != null)
        {
            node.getExpression6().apply(this);
            op2 = (SaExp) this.returnValue;
        }
        this.returnValue = new SaExpDiv(op1, op2);
        outADivExpression5(node);
    }


    // {non} non expression6
    @Override
    public void caseANonExpression6(ANonExpression6 node)
    {

        inANonExpression6(node);
        SaExp op1 = null;
        if(node.getExpression6() != null)
        {
            node.getExpression6().apply(this);
            op1 = (SaExp) this.returnValue;
        }
        this.returnValue = new SaExpNot(op1);
        outANonExpression6(node);
    }

    @Override
    public void caseAVarExpression7(AVarExpression7 node)
    {
        inAVarExpression7(node);
        SaVar var = null;
        if(node.getVar() != null)
        {
            node.getVar().apply(this);
            var = (SaVar) this.returnValue;
        }
        this.returnValue = new SaExpVar(var);
        outAVarExpression7(node);
    }

    @Override
    public void caseANombreExpression7(ANombreExpression7 node)
    {

        inANombreExpression7(node);
        int entier = 0;
        if(node.getNombre() != null)
        {
            node.getNombre().apply(this);
            entier = Integer.parseInt(node.getNombre().getText());
        }
        this.returnValue = new SaExpInt(entier);
        outANombreExpression7(node);
    }


    // {appelfonction2} identif po listeexpressions pf
    @Override
    public void caseAAppelfonction2Expression7(AAppelfonction2Expression7 node)
    {
        inAAppelfonction2Expression7(node);
        String id = null;
        SaLExp arg = null;


        if(node.getIdentif() != null){
            node.getIdentif().apply(this);
            id = node.getIdentif().getText();
        }

        if(node.getListeexpressions() != null)
        {
            node.getListeexpressions().apply(this);
            arg = (SaLExp) this.returnValue;
        }
        this.returnValue = new SaExpAppel(new SaAppel(id, arg));
        outAAppelfonction2Expression7(node);
    }



    @Override
    public void caseAVraiExpression7(AVraiExpression7 node)
    {
        inAVraiExpression7(node);
        if(node.getVrai() != null)
        {
            node.getVrai().apply(this);
        }
        this.returnValue = new SaExpVrai();
        outAVraiExpression7(node);
    }
    public void caseAFauxExpression7(AFauxExpression7 node)
    {
        inAFauxExpression7(node);
        if(node.getFaux() != null)
        {
            node.getFaux().apply(this);
        }
        this.returnValue = new SaExpFaux();
        outAFauxExpression7(node);
    }
    @Override
    public void caseAInstrincrInstruction(AInstrincrInstruction node)
    {
        inAInstrincrInstruction(node);
        SaVar var = null;
        SaExp exp = null;
        if(node.getVar() != null)
        {
            node.getVar().apply(this);
            var = (SaVar) this.returnValue;
        }

        if(node.getExpression() != null)
        {
            node.getExpression().apply(this);
            exp = (SaExp) this.returnValue;
        }
        this.returnValue = new SaIncr(var, exp);
        outAInstrincrInstruction(node);
    }

    @Override
    public void caseAModuloExpression5(AModuloExpression5 node)
    {
        inAModuloExpression5(node);
        SaExp var = null;
        SaExp exp = null;
        if(node.getExpression5() != null)
        {
            node.getExpression5().apply(this);
            var = (SaExp) this.returnValue;
        }

        if(node.getExpression6() != null)
        {
            node.getExpression6().apply(this);
            exp = (SaExp) this.returnValue;
        }
        this.returnValue = new SaExpModulo(var, exp);
        outAModuloExpression5(node);
    }




}
