package ts;
import sa.*;
import util.Error;

public class Sa2ts extends SaDepthFirstVisitor <Void> {
    enum Context {
	LOCAL,
	GLOBAL,
	PARAM
    }
    
    private Ts tableGlobale;
    private Ts tableLocaleCourante;
    private Context context;
    
    public Ts getTableGlobale(){return this.tableGlobale;}

    public Sa2ts()
    {
        tableGlobale = new Ts();
        tableLocaleCourante = null;
        context = Context.GLOBAL;

    }

    public Void visit(SaDecVar node) throws ErrorException {
        defaultIn(node);
        if (context == Context.PARAM){
            node.setTsItem(tableLocaleCourante.getVar(node.getNom()));
            if(node.getTsItem() == null){
                node.setTsItem(tableLocaleCourante.addParam(node.getNom(),node.getType()));
            }else {
                throw  new ErrorException(Error.TS,"la variable existe déja");
            }

        }
        else if (context == Context.LOCAL){
            node.setTsItem(tableLocaleCourante.getVar(node.getNom()));
            if (node.getTsItem() == null){
                node.setTsItem(tableLocaleCourante.addVar(node.getNom(), node.getType()));
            } else {
                throw  new ErrorException(Error.TS,"la variable existe déja");
            }

        }
        else if (context == Context.GLOBAL){
            node.setTsItem(tableGlobale.getVar(node.getNom()));
            if (node.getTsItem() == null){
                node.setTsItem(tableGlobale.addVar(node.getNom(),node.getType()));
            }else {
                throw  new ErrorException(Error.TS,"la variable existe déja");
            }

        }

        defaultOut(node);
        return null;

    }


    public Void visit(SaDecFonc node) throws Exception {
        defaultIn(node);
        node.tsItem = tableGlobale.fonctions.get(node.getNom());
        if ( node.tsItem == null){
            int longueur_liste_arg = (node.getParametres() == null)? 0 : node.getParametres().length();
            tableLocaleCourante = new Ts();
            node.tsItem = tableGlobale.addFct(node.getNom(), node.getTypeRetour(), longueur_liste_arg,tableLocaleCourante,node);
            context = Context.PARAM;
            if(node.getParametres() != null) node.getParametres().accept(this);
            context = Context.LOCAL;
            if(node.getVariable() != null) node.getVariable().accept(this);
            if(node.getCorps() != null) node.getCorps().accept(this);
            context = Context.GLOBAL;
        }
        else {
            throw new ErrorException(Error.TS, "la variable est déja déclarée");
        }
        defaultOut(node);
        return null;
    }




    public Void visit(SaVarSimple node) throws ErrorException {
        defaultIn(node);
        TsItemVar item = null;
        if(context == Context.GLOBAL){
            item = tableGlobale.getVar(node.getNom());
            if (item == null){
                throw new ErrorException(Error.TS, "la variable globale : " + node.getNom()+ "n'éxsite pas !");
            }
            node.tsItem = (TsItemVarSimple) item;
        }
        else {
            item = tableLocaleCourante.getVar(node.getNom());
            if (item == null){
                throw new ErrorException(Error.TS , "la variable locale : " + node.getNom() + "n'éxiste pas !");
            }
            node.tsItem = (TsItemVarSimple) item;
        }
        defaultOut(node);
        return null;
    }


    public Void visit(SaAppel node) throws ErrorException {
        defaultIn(node);
        TsItemFct item = tableGlobale.getFct(node.getNom());
        if (item == null) {
            throw new ErrorException(Error.TS,"ERREUR: " + node.getNom() + " pas déclaré" );
        }

        if ((item.nbArgs == 0 && node.getArguments() != null) || item.nbArgs > 0 && node.getArguments() != null && item.nbArgs != node.getArguments().length()) {
            throw  new ErrorException(Error.TS,"ERREUR: " + node.getNom() + " Nombre d'argument incorrecte");
        }
        node.tsItem = item;
        defaultOut(node);
        return null;
    }


    public Void visit(SaVarIndicee node) throws Exception {
        defaultIn(node);
        if (node.getIndice()!= null){
            if(context == Context.GLOBAL){
                node.tsItem = tableGlobale.variables.get(node.getNom());
                if (node.tsItem == null) throw new ErrorException(Error.TS, "la variable " + node.getNom() +" n'existe pas");
            }
            if (context == Context.LOCAL || context == Context.PARAM){
                node.tsItem = tableLocaleCourante.variables.get(node.getNom());
                if (node.tsItem == null) {
                    node.tsItem = tableGlobale.variables.get(node.getNom());
                    if (node.tsItem == null)  throw new ErrorException(Error.TS, "la variable " + node.getNom() + " n'existe pas ");
                }
            }
            node.getIndice().accept(this);
        }
        else {
            throw new ErrorException(Error.TS, "la variable est déja déclarée");
        }
        defaultOut(node);
        return null;
    }





    // DEC -> var id taille

    public Void visit(SaDecTab node) throws Exception{
        defaultIn(node);
        if (context == Context.GLOBAL){
            node.setTsItem(tableGlobale.getVar(node.getNom()));
            if (node.getTsItem() == null){
                node.setTsItem(tableGlobale.addTab(node.getNom(), node.getType(), node.getTaille()));
            } else {
                throw new ErrorException(Error.TS, "Une variable ayant le meme nom existe déjà");
            }
        } else if (context == Context.LOCAL){
            node.setTsItem(tableLocaleCourante.getVar(node.getNom()));
            if (node.getTsItem() == null){
                node.setTsItem(tableLocaleCourante.addTab(node.getNom(), node.getType(), node.getTaille()));
            } else {
                throw new ErrorException(Error.TS, "Une variable ayant le meme nom existe déjà");
            }
        } else if (context == Context.PARAM) {
            node.setTsItem(tableLocaleCourante.getVar(node.getNom()));
            if (node.getTsItem() == null){
                node.setTsItem(tableLocaleCourante.addParam(node.getNom(), node.getType()));
            } else {
                throw new ErrorException(Error.TS, "Une variable ayant le meme nom existe déjà");
            }
        }
        defaultOut(node);
        return null;
    }

}
