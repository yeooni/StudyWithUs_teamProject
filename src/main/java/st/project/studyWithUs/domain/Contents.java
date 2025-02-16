package st.project.studyWithUs.domain;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Contents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cID;

    @NotNull
    private String content;

    @NotNull
    private LocalDate uploadTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="uID")
    private User user;

    @OneToMany(mappedBy = "contents", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();
}
