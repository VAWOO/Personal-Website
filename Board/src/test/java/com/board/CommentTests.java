package com.board;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.board.domain.CommentDTO;
import com.board.service.CommentService;

@SpringBootTest
class CommentTests
{
	@Autowired
	private CommentService commentService;
	
	@Test
	public void registerComments()
	{
		int number = 20;
		
		for (int i = 1; i <= number; i++)
		{
			CommentDTO params = new CommentDTO();
			params.setBoardIdx((long) 2189); // 댓글을 추가할 게시글 번호
			params.setContent(i + "번 댓글을 추가합니다!");
			params.setWriter(i + "번 회원");
			commentService.registerComment(params);
		}
		System.out.println("댓글 " + number + "개가 등록되었습니다.");
	}
	
	@Test
	public void deleteComment()
	{
		commentService.deleteComment((long) 10); // 삭제할 댓글 번호
		getCommentList();
	}
	
	@Test
	public void getCommentList()
	{
		CommentDTO params = new CommentDTO();
		params.setBoardIdx((long) 2189); // 댓글을 추가할 게시글 번호
		
		for (CommentDTO comment : commentService.getCommentList(params))
		{
			System.out.println("==================");
			System.out.println(comment.getBoardIdx());
			System.out.println(comment.getContent());
			System.out.println(comment.getWriter());
			System.out.println("==================");
		}
	}
}