package blog.naver.com.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import blog.naver.com.service.Board;
import blog.naver.com.service.BoardService;



@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/board/boardModify", method=RequestMethod.GET)
	public String boardModify(Model model, @RequestParam(value="boardNo") int boardNo){
		model.addAttribute("board",boardService.getBoardView(boardNo));
		return "/board/boardModify";
	}
	
	@RequestMapping(value="/board/boardModify", method=RequestMethod.POST)
	public String boardModify(Model model, Board board){
		int boardNo=board.getBoardNo();
		model.addAttribute(boardService.getBoardView(boardNo));
		return "/board/boardView";
	}
	
	@RequestMapping(value="/board/boardRemove", method=RequestMethod.GET)
	public String boardRemove(){
		return "/board/boardRemove";
	}
	
	@RequestMapping(value="/board/boardRemove", method=RequestMethod.POST)
	public String boardRemove(Board board){
		boardService.removeBoard(board);
		return "redirect:/board/boardList";
	}
	
	@RequestMapping(value="/board/boardView")
	public String boardView(Model model, @RequestParam(value="boardNo") int boardNo){
		model.addAttribute("board",boardService.getBoardView(boardNo));
		return "/board/boardView";
	}
	
	@RequestMapping(value="/board/boardList")
	public String boardList(Model model,	//model = map을 상속받은 spring model
			@RequestParam(value="currentPage", defaultValue="1") int currentPage){
		Map<String, Object> returnMap = boardService.getBoardListPerCurrentPage(currentPage);
		model.addAttribute("currentPage",currentPage);
		model.addAttribute("totalRowCount",returnMap.get("totalRowCount"));
		model.addAttribute("lastPage",returnMap.get("lastPage"));
		model.addAttribute("list",returnMap.get("list"));
	
		return "/board/boardList";
	}
	@RequestMapping(value="/board/boardAdd", method=RequestMethod.POST)
	public String boardAdd(Board board){
		System.out.println(board);
		boardService.addBoard(board);
		return "redirect:/board/boardList";	//forward WEB-INF�ȿ� .jsp�� ������	�̸��� ������ ���ε��� �ȴ�.
	}
	
	@RequestMapping(value="/board/boardAdd", method=RequestMethod.GET)
	public String boardAdd(){
		return "/board/boardAdd";	//forward WEB-INF�ȿ� .jsp�� ������
	}
}




