package st.project.studyWithUs.domain;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class pointInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pID;

    @NotNull
    private Long balance;

    @NotNull
    private String version;
}
