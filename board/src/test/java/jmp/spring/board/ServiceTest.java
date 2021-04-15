package jmp.spring.board;

import org.junit.Test;
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

public class ServiceTest {
	@Autowired
	BoardService service;
	
	@Autowired
	BoardMapper mapper;
	
	@Test
	public void testUpdate() {
		BoardVo vo = new BoardVo();
		vo.setBno(24);
		vo.setTitle("깨진거 수정되라");
		vo.setContent("수정되라");
		vo.setWriter("수정되라고");
		int up= mapper.update(vo);
		log.info(up);
	}
	
	
	@Test
	public void testDelete() {
		log.info("Delete Count : "+mapper.delete(1));
	}
	
	@Test
	public void getService() {
		BoardVo vo = service.get(41);
		log.info(vo);
	}
	
	@Test
	public void get() {
		BoardVo vo = mapper.get(41);
		log.info(vo);
	}
	
	@Test
	public void mapper() {
		BoardVo vo = new BoardVo();
		vo.setContent("내용-mapperTest");
		vo.setTitle("제목 - mapperTest");
		vo.setWriter("작성자 - mapperTest");
		
		int res = mapper.insertBoard(vo);
		
		//log.info("mapper.insert.test=========== : "+res);
		log.info("service.insertBoard=============:"+service.insertBoard(vo));
	}
	
	@Test
	public void service() {
		
		log.info("service==============="+service.getList());
	}
}
