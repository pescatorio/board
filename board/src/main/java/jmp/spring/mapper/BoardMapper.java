package jmp.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import jmp.spring.vo.BoardVo;

public interface BoardMapper {
	
	@Select("select sysdate from dual") 
	public String getTime(); 
	
	public String getTime2();
	
	public List<BoardVo> getList();
	
	//단순 확인용 메서드
	public int insert(BoardVo vo);
	
	//게시판 추가용 메서드
	public int insertBoard(BoardVo vo); 
	
	public BoardVo get(int bno);
	
	public int delete(int bno);
	
	//update,insert,delete는 int반환
	public int update(BoardVo board);
}
