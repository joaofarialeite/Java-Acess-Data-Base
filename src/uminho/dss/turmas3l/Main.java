/*
 *  DISCLAIMER: Este código foi criado para discussão e edição durante as aulas práticas de DSS, representando
 *  uma solução em construção. Como tal, não deverá ser visto como uma solução canónica, ou mesmo acabada.
 *  É disponibilizado para auxiliar o processo de estudo. Os alunos são encorajados a testar adequadamente o
 *  código fornecido e a procurar soluções alternativas, à medida que forem adquirindo mais conhecimentos.
 */
package uminho.dss.turmas3l;

import uminho.dss.turmas3l.business.Aluno;
import uminho.dss.turmas3l.business.Sala;
import uminho.dss.turmas3l.business.Turma;
import uminho.dss.turmas3l.data.AlunoDAO;
import uminho.dss.turmas3l.data.TurmaDAO;
import uminho.dss.turmas3l.ui.TextUI;

/**
 * @author DSS
 * @version 20201206
 */
public class Main {

    /**
     * O método main cria a aplicação e invoca o método run()
     */
    public static void main(String[] args) {

        try {
            new TextUI().run();

        }
        catch (Exception e) {
            System.out.println("Não foi possível arrancar: "+e.getMessage());
        }

/*       // Aluno a = new Aluno("A", "b", "c");
        AlunoDAO adao = AlunoDAO.getInstance();
        adao.removealuno("2");*/

    }

}

/* TESTAR ADICIONAR UMA TURMA A BASE DE DADOS
    TurmaDAO res = TurmaDAO.getInstance();
            res.put("22",  new Turma("22" , new Sala("ah", "ah", 2)));
*/


/* TESTAR ADICIONAR UM ALUNO A BASE DE DADOS

    Aluno a = new Aluno("A", "b", "c");
    AlunoDAO adao = AlunoDAO.getInstance();
        adao.adicionaaluno(a);

*/
