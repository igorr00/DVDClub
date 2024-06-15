package main.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dto.NewsDTO;
import main.model.News;
import main.repository.NewsRepository;

@Service
public class NewsService {

	@Autowired
	private NewsRepository newsRepository;
	
	public Boolean add(NewsDTO dto) {
		News news = new News();
		news.setDate(LocalDate.now());
		news.setTitle(dto.getTitle());
		news.setText(dto.getText());
		
		newsRepository.save(news);
		return true;
	}
	
	public ArrayList<News> findAll(){
        ArrayList<News> news = new ArrayList<News>();
        for (News n: newsRepository.findAll()) {
        	news.add(n);
        }
        return news;
    }
	
	public Boolean edit(News news)
	{
		Optional<News> toEdit = newsRepository.findById(news.getId());
		if(!toEdit.isPresent())
		{
			return false;
		}

		newsRepository.save(news);
		return true;
	}
	
	public News findById(Long id) {
		return newsRepository.findById(id).get();
	}
	
	public void delete(Long id) {
		newsRepository.deleteById(id);
	}
}
