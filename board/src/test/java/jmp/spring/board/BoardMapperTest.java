package jmp.spring.board;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import jmp.spring.mapper.BoardMapper;
import jmp.spring.service.BoardService;
import jmp.spring.vo.BoardVo;
import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardMapperTest {

	@Autowired
	BoardService service;
	
	@Autowired
	BoardMapper mapper;
	
	public void testInsert() {
		BoardVo board = new BoardVo();
		board.setTitle("새로 작성");
		board.setContent("새 내용");
		board.setWriter("작가");
		mapper.insertBoard(board);
		log.info(board);
	}
	
}
