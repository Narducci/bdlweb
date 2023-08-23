package com.bdlproject.bdlweb.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_task_force")
public class TaskForce {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String jobName;
    private String jobDescription;


    /*****************************************************************************************************************
     *                                      [ CLASSE LADO UM (User.java]
     * Os usuário incluídos na classe TaskForce estão mapeados como "members" ==> @OneToMany(mappedBy = "members")
     * A lista destes membros também deve ser nomeada como "members" ==> List<TaskForce> members = new ArrayList<>()
     * ---------------------------------------------------------------------------------------------------------------
     *                                 [ CLASSE LADO MUITOS (TaskForce.java)]
     * O nome da variável que representa a Classe do lado MUITOS deve receber o mesmo nome da associação definida para
     * o lado UM, neste caso: "members"
     *****************************************************************************************************************/

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User members;


    /*****************************************************************************************************************
     * INSLUSÃO DE UM RELACIONAMENTO UM-PARA-UM (PARALELO AO MUITOS-PARA-UM)
     * Uma nova FK será adicionada à tabela relacionada (tb_task_force), que já tem outra FK do relacionamento
     * anterior.
     * Na Classe principal (User) incluir um novo atributo do tipo relacionado: "private TaskForce teamLeader;"
     * Neste caso a tabela relacionada refere-se à Classe TaskForce, e o nome da variável é leader também mas poderia
     * ser qualquer outro nome...), desde que seja utilizado na cláusula mappedBy:
     * @OneToOne(mappedBy = "teamLeader", cascade = CascadeType.ALL)
     * ---------------------------------------------------------------------------------------------------------------
     * Se a ANNOTATION "@MapsId" for utilizada, o nome da FK criada será será team_deder_user_id.
     * Caso se deseje ter outro nome basta substituir a annotation "@MapsId" por @JoinColumn(name = "nome-desejado")
     *****************************************************************************************************************/


    @OneToOne
    @JoinColumn(name = "leader_id")//@MapsId
    private User teamLeader;
}
