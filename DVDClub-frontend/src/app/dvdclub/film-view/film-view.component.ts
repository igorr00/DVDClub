import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Film } from '../model/film';
import { FilmsService } from '../services/films.service';
import { Rating } from '../model/rating';
import { RatingsService } from '../services/ratings.service';

@Component({
  selector: 'app-film-view',
  templateUrl: './film-view.component.html',
  styleUrls: ['./film-view.component.css']
})
export class FilmViewComponent implements OnInit {
  film: Film = new Film();
  ratings: Rating[] = [];

  constructor(private router: Router, private toastr: ToastrService, private filmsService: FilmsService,
    private ratingsService: RatingsService) { }

  ngOnInit(): void {
    this.filmsService.getById(localStorage.getItem('filmViewId')).subscribe(res => {
      this.film = res;

      this.ratingsService.getByFilmId(res.id).subscribe(res => {
        this.ratings = res;
      })
    })
  }

  getGenreNames(): string {
    return this.film.genres.map(genre => genre.name).join(', ');
  }

  getActorNames(): string {
    return this.film.actors.map(actor => actor.name + " " + actor.surname).join(', ');
  }

  public add(){
    window.location.href="rating-add";
  }

  formatTime(time: string): string {
    return time.split(',').join(':');
}

}
