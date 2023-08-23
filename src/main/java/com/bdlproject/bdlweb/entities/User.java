package com.bdlproject.bdlweb.entities;

import jakarta.persistence.*;
import org.springframework.scheduling.config.Task;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String password;
    private String username;
    private MemberType memberType;

    // RELACIONAMENTO (0:1) COM A CLASSE Employee
    @OneToOne
    @MapsId
    private Employee employee;

    /*****************************************************************************************************************
     *                                      [ CLASSE LADO UM (User.java]
     * Os usuário incluídos na classe TaskForce estão mapeados como "members" ==> @OneToMany(mappedBy = "members")
     * A lista destes membros também deve ser nomeada como "members" ==> List<TaskForce> members = new ArrayList<>()
     * ---------------------------------------------------------------------------------------------------------------
     *                                 [ CLASSE LADO MUITOS (TaskForce.java)]
     * O nome da variável que representa a Classe do lado MUITOS deve receber o mesmo nome da associação definida para
     * o lado UM, neste caso: "members"
     *****************************************************************************************************************/
    @OneToMany(mappedBy = "members")
    private List<TaskForce> members = new ArrayList<>();

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

    @OneToOne(mappedBy = "teamLeader", cascade = CascadeType.ALL)
    private TaskForce leader;

    // CONSTRUTORES
    public User(){
    }

    public User(Long id, String password, String username, MemberType memberType, Employee employee, List<TaskForce> members, TaskForce leader) {
        this.id = id;
        this.password = password;
        this.username = username;
        this.memberType = memberType;
        this.employee = employee;
        this.members = members;
        this.leader = leader;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public MemberType getMemberType() {
        return memberType;
    }

    public void setMemberType(MemberType memberType) {
        this.memberType = memberType;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public TaskForce getLeader() {
        return leader;
    }

    public void setLeader(TaskForce leader) {
        this.leader = leader;
    }

    public List<TaskForce> getMembers() {
        return members;
    }
}
