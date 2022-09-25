package uminho.dss.turmas3l.business;

import uminho.dss.turmas3l.data.AlunoDAO;

public class AlunoFacade {

    private AlunoDAO alunos;

    public  AlunoFacade(){
        this.alunos = AlunoDAO.getInstance();
    }
}
