package com.board.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.board.domain.ContactDTO;

@Mapper
public interface ContactMapper
{
	public int insertContact(ContactDTO params);
}
