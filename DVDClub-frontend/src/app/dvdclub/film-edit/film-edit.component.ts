import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FilmsService } from '../services/films.service';
import { FilmstudiosService } from '../services/filmstudios.service';
import { DirectorsService } from '../services/directors.service';
import { ActorsService } from '../services/actors.service';
import { GenresService } from '../services/genres.service';
import { ToastrService } from 'ngx-toastr';
import { Film } from '../model/film';
import { FilmStudio } from '../model/filmstudio';
import { Director } from '../model/director';
import { Genre } from '../model/genre';
import { Actor } from '../model/actor';

@Component({
  selector: 'app-film-edit',
  templateUrl: './film-edit.component.html',
  styleUrls: ['./film-edit.component.css']
})
export class FilmEditComponent implements OnInit {
  film: Film = new Film();
  filmstudios: FilmStudio[] = [];
  directors: Director[] = [];
  genres: Genre[] = [];
  actors: Actor[] = [];
  
  constructor(private filmsService: FilmsService, private router: Router, private toastr: ToastrService, private filmstudiosService: FilmstudiosService, private genresService: GenresService,
    private directorsService: DirectorsService, private actorsService: ActorsService) { }

  ngOnInit(): void {
    this.filmsService.getById(localStorage.getItem('editFilmId')).subscribe(res => {
      this.film = res;
    })
    this.filmstudiosService.getAll().subscribe(res => {
      this.filmstudios = res;
    })
    this.genresService.getAll().subscribe(res => {
      this.genres = res;
    })
    this.directorsService.getAll().subscribe(res => {
      this.directors = res;
    })
    this.actorsService.getAll().subscribe(res => {
      this.actors = res;
    })
  }

  compareDirectors(director1: any, director2: any): boolean {
    return director1 && director2 ? director1.id === director2.id : director1 === director2;
  }

  compareFilmStudios(filmstudio1: any, filmstudio2: any): boolean {
    return filmstudio1 && filmstudio2 ? filmstudio1.id === filmstudio2.id : filmstudio1 === filmstudio2;
  }

  compareActors(actor1: any, actor2: any): boolean {
    return actor1 && actor2 ? actor1.id === actor2.id : actor1 === actor2;
  }

  compareGenres(genre1: any, genre2: any): boolean {
    return genre1 && genre2 ? genre1.id === genre2.id : genre1 === genre2;
  }

  submit(){
    if(this.film.name == "" || this.film.year == 0 || this.film.country.name == "" || this.film.image == ""){
        this.showError('Fill out all fields.', 'DVD Club');
        return;   
      }
      this.filmsService.edit(this.film).subscribe(
        {
          next: (res) => {
            this.router.navigate(['films']);
            this.showSuccess('Film Edited', 'DVD Club');
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
      this.filmsService.delete(this.film.id).subscribe(
        {
          next: (res) => {
            this.router.navigate(['films']);
            this.showSuccess('Film Deleted', 'DVD Club');
          },
          error: (e) => {this.showError('Film has a dvd in a marketplace', 'DVD Club');
            console.log(e);}
      });
    }

}
