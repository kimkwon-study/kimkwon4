package com.hanhae.hanhae99.board.model.entity;

import com.hanhae.hanhae99.board.model.response.BoardResponse;
import com.hanhae.hanhae99.global.model.entity.AuditingFields;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@ToString
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Board extends AuditingFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pid;

    @Column
    private String name;

    @Column
    @Setter
    private String title;

    @Column
    @Setter
    private String content;

    @OneToMany( mappedBy = "board", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    public static BoardResponse changeEntity(Board board) {
        return new BoardResponse(board.getTitle(),
                board.getName(),
                board.getContent(),
                board.getCreatedAt().toString(),
                board.getComments()
        );
    }



}
