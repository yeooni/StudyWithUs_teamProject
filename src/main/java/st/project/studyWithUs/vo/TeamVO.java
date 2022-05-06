package st.project.studyWithUs.vo;


import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import st.project.studyWithUs.domain.UserTeam;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class TeamVO {

    private Long tID;
    private Long ttID;
    private String teamName;
    private Long depositPoint;
    private Long totalDepositPoint;
    private Long targetTime;
    private Integer headCount;
    private Integer currentCount;
    private String teamDesc;
    private LocalDate startDate;
    private LocalDate endDate;
    private String teamImage;

}
