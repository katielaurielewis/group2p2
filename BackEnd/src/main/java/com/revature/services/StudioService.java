package com.revature.services;

import com.revature.daos.StudioDAO;


@Service
public class StudioService {
	
	private StudioDAO sDao;
	
	@Autowired
	public StudioService(StudioDAO sDao) {
                :i

		super();
		this.sDao= sDao;
	}
	
	public Optional<List<Studio>> findByName(String name){
		return sDao.findByName(name);
	}

	public Studio save(Studio s) {
		return sDao.save(s);
		
	}
	





}
