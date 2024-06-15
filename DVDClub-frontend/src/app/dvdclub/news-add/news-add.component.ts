import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NewsService } from '../services/news.service';
import { ToastrService } from 'ngx-toastr';
import { NewsDTO } from '../dto/newsDTO';

@Component({
  selector: 'app-news-add',
  templateUrl: './news-add.component.html',
  styleUrls: ['./news-add.component.css']
})
export class NewsAddComponent implements OnInit {
  newsDTO = new NewsDTO();

  constructor(private newsService: NewsService, private router: Router, private toastr: ToastrService) { }

  ngOnInit(): void {
  }

  submit(){
    if(this.newsDTO.title == "" || this.newsDTO.text == ""){
        this.showError('Fill out all fields.', 'DVD Club');
        return;   
      }
    this.newsService.add(this.newsDTO).subscribe(
      {
        next: (res) => {
          this.router.navigate(['news']);
          this.showSuccess();
        },
        error: (e) => {this.showError('Something went wrong', 'DVD Club');
          console.log(e);}
    });
  }
  showSuccess() {
    this.toastr.success('News Added', 'DVD Club');
  }
  showError(message: string, title: string) {
    this.toastr.error(message, title);
  }

}
