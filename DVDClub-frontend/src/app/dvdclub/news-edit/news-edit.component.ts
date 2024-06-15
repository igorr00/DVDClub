import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NewsService } from '../services/news.service';
import { ToastrService } from 'ngx-toastr';
import { News } from '../model/news';

@Component({
  selector: 'app-news-edit',
  templateUrl: './news-edit.component.html',
  styleUrls: ['./news-edit.component.css']
})
export class NewsEditComponent implements OnInit {
  news : News = new News();

  constructor(private newsService: NewsService, private router: Router, private toastr: ToastrService) { }

  ngOnInit(): void {
    this.newsService.getById(localStorage.getItem('editNewsId')).subscribe(res => {
      this.news = res;
    })
  }

  submit(){
    if(this.news.title == "" || this.news.text == ""){
        this.showError('Fill out all fields.', 'DVD Club');
        return;   
      }
      this.newsService.edit(this.news).subscribe(
        {
          next: (res) => {
            this.router.navigate(['news']);
            this.showSuccess('News Edited', 'DVD Club');
          },
          error: (e) => {this.showError('Something went wrong', 'DVD Club');
            console.log(e);}
      });
    }
    showSuccess(message: string, title: string) {
      this.toastr.success(message, title);
    }
    showError(message: string, title: string) {
      this.toastr.error(message, title);
    }
  
    delete(){
      this.newsService.delete(this.news.id).subscribe(
        {
          next: (res) => {
            this.router.navigate(['news']);
            this.showSuccess('News Deleted', 'DVD Club');
          },
          error: (e) => {this.showError('Something went wrong', 'DVD Club');
            console.log(e);}
      });
    }

}
