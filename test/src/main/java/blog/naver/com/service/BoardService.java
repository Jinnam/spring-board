package blog.naver.com.service;

import java.util.Map;

public interface BoardService {
		public int addBoard(Board board);
		Map<String, Object> getBoardListPerCurrentPage(int currentPage);
		Board getBoardView(int boardNo);
		int removeBoard(Board board);
		int modifyBoard(Board board);
	}

