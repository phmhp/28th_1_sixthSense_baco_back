package solux.baco.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long review_id;

    private String startPlace;

    private String endPlace;

    private String content;

    private java.time.LocalDate date;

    private String hashtag;

    @ManyToOne
<<<<<<< HEAD
    @JoinColumn(name = "member_id")
    private Member member; //FK

    @OneToOne(mappedBy = "review")
    private Route route; //FK
=======
    @JoinColumn(name = "member_id", referencedColumnName = "id")
    private Member member; //FK (외래키)

    @ManyToOne
    @JoinColumn(name = "route_id", referencedColumnName = "id")
    private Route route; //FK (외래키)
>>>>>>> develop


}

