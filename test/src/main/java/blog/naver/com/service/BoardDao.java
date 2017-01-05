package blog.naver.com.service;

import java.util.List;
import java.util.Map;

public interface BoardDao {

	int insertBoard(Board board);
	int selectTotalBoardCount();
	List<Board> selectBoardListPerPage(Map<String, Integer> map);
	Board selectBoardByKey(int boardNo);
	int deleteBoard(Board board);
	int updateBoard(Board board);
}
