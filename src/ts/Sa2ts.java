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
                throw  new ErrorException(Error.TS,"la variable y est déja");
            }

        }
        else if (context == Context.LOCAL){
            node.setTsItem(tableLocaleCourante.getVar(node.getNom()));
            if (node.getTsItem() == null){
                node.setTsItem(tableLocaleCourante.addVar(node.getNom(), node.getType()));
            } else {
                throw  new ErrorException(Error.TS,"la variable y est déja");
            }

        }
        else if (context == Context.GLOBAL){
            node.setTsItem(tableGlobale.getVar(node.getNom()));
            if (node.getTsItem() == null){
                node.setTsItem(tableGlobale.addVar(node.getNom(),node.getType()));
            }else {
                throw  new ErrorException(Error.TS,"la variable y est déja");
            }

        }

        defaultOut(node);
        return null;

    }


    @Override
    public Void visit(SaDecFonc node) throws Exception {

        String idFct = node.getNom();
        SaLDecVar parameters = node.getParametres();
        SaLDecVar variable = node.getVariable();
        SaInst corps =  node.getCorps();

        if (tableGlobale.getFct(idFct) != null) {
            throw new ErrorException(Error.TS, "La fonction " + idFct + " y est déja .");
        }

        Ts table = new Ts();
        tableLocaleCourante = table;
        int nbArgs = 0;

        if (parameters != null) {
            context = Context.PARAM;
            parameters.accept(this);
            nbArgs = parameters.length();
        }

        if (variable != null) {
            context = Context.LOCAL;
            variable.accept(this);
        }

        node.tsItem = tableGlobale.addFct(idFct, node.getTypeRetour(), nbArgs, table, node);


        SaInstBloc tempCorps = (SaInstBloc) corps;


        if (corps != null && tempCorps.getVal() != null) {
            context = Context.LOCAL;
            corps.accept(this);
        }

        context = Context.GLOBAL;
        return null;
    }




    @Override
    public Void visit(SaVarSimple node) throws Exception {
        String idVar = node.getNom();
        TsItemVarSimple varSimple = node.getTsItem();
        if (context == Context.LOCAL) {
            if (tableLocaleCourante.getVar(idVar) == null && tableGlobale.getVar(idVar) == null) {
                throw new ErrorException(Error.TS, "La variable " + idVar + " n'y est pas..");
            }
            if (tableLocaleCourante.getVar(idVar) != null) {
                node.tsItem = (TsItemVarSimple) tableLocaleCourante.getVar(idVar);
            } else {
                node.tsItem = (TsItemVarSimple) tableGlobale.getVar(idVar);
            }
        } else if (context == Context.PARAM) {
            if (tableLocaleCourante.getVar(idVar) == null) {
                throw new ErrorException(Error.TS, "La variable " + idVar + " n'y est pas.");
            }
        } else if (context == Context.GLOBAL) {
            if (tableGlobale.getVar(idVar) == null || varSimple.getTaille() > 1) {
                throw new ErrorException(Error.TS, "La variable " + idVar + " n'y est pas.");
            }
            node.tsItem = (TsItemVarSimple) tableGlobale.getVar(idVar);
        }
        return null;
    }




    public Void visit(SaAppel node) throws ErrorException {
        defaultIn(node);
        TsItemFct item = tableGlobale.getFct(node.getNom());
        if (item == null) {
            throw new ErrorException(Error.TS,"ERREUR: " + node.getNom() + " n'y est pas" );
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
