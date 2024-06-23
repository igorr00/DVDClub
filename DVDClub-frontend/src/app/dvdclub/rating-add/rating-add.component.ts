import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RatingsService } from '../services/ratings.service';
import { ToastrService } from 'ngx-toastr';
import { RatingDTO } from '../dto/ratingDTO';

@Component({
  selector: 'app-rating-add',
  templateUrl: './rating-add.component.html',
  styleUrls: ['./rating-add.component.css']
})
export class RatingAddComponent implements OnInit {
  ratingDTO = new RatingDTO();

  constructor(private ratingsService: RatingsService, private router: Router, private toastr: ToastrService) { }

  ngOnInit(): void {
  }

  submit(){
    const userIdString = localStorage.getItem('loggedUserId');
    if(userIdString !== null){
      this.ratingDTO.userId = parseFloat(userIdString);
    }
    const filmIdString = localStorage.getItem('filmViewId');
    if(filmIdString !== null){
      this.ratingDTO.filmId = parseFloat(filmIdString);
    }
    if(this.ratingDTO.score == 0 || this.ratingDTO.comment == ""){
        this.showError('Fill out all fields.', 'DVD Club');
        return;   
      }
    this.ratingsService.add(this.ratingDTO).subscribe(
      {
        next: (res) => {
          this.router.navigate(['film-view']);
          this.showSuccess();
        },
        error: (e) => {this.showError('You already rated this film', 'DVD Club');
          console.log(e);}
    });
  }
  showSuccess() {
    this.toastr.success('Rating Added', 'DVD Club');
  }
  showError(message: string, title: string) {
    this.toastr.error(message, title);
  }

}
