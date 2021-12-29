package kr.or.fineapple.service.community.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.fineapple.domain.User;
import kr.or.fineapple.domain.community.Board;
import kr.or.fineapple.domain.community.Cmnt;
import kr.or.fineapple.domain.community.Group;
import kr.or.fineapple.domain.community.GroupUser;
import kr.or.fineapple.domain.community.Report;
import kr.or.fineapple.mapper.CommunityMapper;
import kr.or.fineapple.service.community.CommunityService;



@Service
public class CommunityServiceImpl implements CommunityService {
	
	@Autowired
	private CommunityMapper communityMapper;

	public CommunityServiceImpl() {
		System.out.println(getClass().getName()+  "������");
	}

	@Override
	public void addPost(Board board) {
		communityMapper.addPost(board);
	}

	@Override
	public void addCmnt(Cmnt cmnt) {
	}

	@Override
	public List<Board> getPostList() {
		return communityMapper.getPostList();
	}
	
	@Override
	public Map getPost(Board board) {
		Map map = new HashMap();
		map.put("list", communityMapper.getCmntList(board));
		map.put("board", communityMapper.getPost(board));
		return map;
	}
	
	@Override
	public void updatePostViewCount(Board board) {
		communityMapper.updatePostViewCount(board);
	}

	@Override
	public void updatePostLike(Board board, int flag) {
		Map map = new HashMap();
		map.put(board, flag);
		communityMapper.updatePostLike(map);
	}

	@Override
	public void updateCmntLike(Cmnt cmnt, int flag) {
		Map map = new HashMap();
		map.put(cmnt, flag);
		communityMapper.updateCmntLike(map);
	}
	
	@Override
	public List<User> getGroupInterUser(GroupUser groupUser) {
		return communityMapper.getGroupInterUser(groupUser);
	}
	
	
	public List<Group> getGroupInterGroup(GroupUser groupUser){
		return communityMapper.getGroupInterGroup(groupUser);
	}
	
	public void addReport(Report report) {
		communityMapper.addReport(report);
	}

	@Override
	public void addGroup(Group group) {
		communityMapper.addGroup(group);
	}
	
	
	
	
	
	
	
	
	

	


}
