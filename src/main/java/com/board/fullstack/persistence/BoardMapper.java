package com.board.fullstack.persistence;

import com.board.fullstack.domain.BoardVO;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.ibatis.annotations.*;

import java.util.List;

/*
 * control layer에서 request를 받은 다음 바로 응답을 주는것이 아니라
 * db를 조회해야 하므로 db처리를 담당할 persistence layer 생성
 * */
@Mapper
public interface BoardMapper {
    // 게시판 추가
    @Insert({"<script>",
            "INSERT INTO board(title, content)",
            "VALUES(#{title}, #{content})",
            "</script>"})
    int insertBoard(BoardVO boardVO);

    // 게시판 모두 조회 & 목록보기 페이지네이션
    @Select({"<script>",
            "SELECT * from board",
            "order by id desc",
            "<if test='offset != null and page_size != null'>",
            "LIMIT #{offset}, #{page_size}",
            "</if>",
            "</script>"})
    List<BoardVO> findAllBoard(@Param("offset") Integer offset, @Param("page_size") Integer page_size);


    // 전체 게시판 개수 리턴
    @Select({"<script>",
            "SELECT count(*) from board",
            "</script>"})
    Integer countBoard();


    // 특정 게시판 조회
    @Select({"<script>",
            "SELECT * FROM board",
            "WHERE ID = ${id}",
            "</script>"})
    BoardVO findOndBoard(int id);


    // 게시판 수정
    @Update({"<script>",
            "UPDATE board",
            "<trim prefix='SET' suffixOverrides=','>",
            "<if test='title != null'>title = #{title}, </if>",
            "<if test='content != null'>content = #{content}, </if>",
            "</trim>",
            "WHERE id = ${id}",
            "</script>"})
    int updateBoard(BoardVO boardVO);


    // 게시판 삭제
    @Delete({"<script>",
            "DELETE FROM board",
            "WHERE id = ${id}",
            "</script>"})
    int deleteBoard(int id);
}
