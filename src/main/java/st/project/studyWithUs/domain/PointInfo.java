package st.project.studyWithUs.domain;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class PointInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pID;


    @NotNull
    private Long balance;


    @Version
    private int version;

    public PointInfo() {

    }

    public PointInfo(Long balance) {
        this.balance = balance;
    }

}
