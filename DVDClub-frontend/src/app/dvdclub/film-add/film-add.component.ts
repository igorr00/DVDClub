import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FilmsService } from '../services/films.service';
import { FilmstudiosService } from '../services/filmstudios.service';
import { DirectorsService } from '../services/directors.service';
import { ActorsService } from '../services/actors.service';
import { GenresService } from '../services/genres.service';
import { ToastrService } from 'ngx-toastr';
import { FilmDTO } from '../dto/filmDTO';
import { FilmStudio } from '../model/filmstudio';
import { Director } from '../model/director';
import { Genre } from '../model/genre';
import { Actor } from '../model/actor';

@Component({
  selector: 'app-film-add',
  templateUrl: './film-add.component.html',
  styleUrls: ['./film-add.component.css']
})
export class FilmAddComponent implements OnInit {
  filmDTO = new FilmDTO('', 0, '', new FilmStudio(), [], new Director(), [], '');
  filmstudios: FilmStudio[] = [];
  directors: Director[] = [];
  genres: Genre[] = [];
  actors: Actor[] = [];

  constructor(private filmsService: FilmsService, private router: Router, private toastr: ToastrService,
    private filmstudiosService: FilmstudiosService, private genresService: GenresService,
    private directorsService: DirectorsService, private actorsService: ActorsService) { }

  ngOnInit(): void {
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

  submit(){
    if(this.filmDTO.name == "" || this.filmDTO.year == 0 || this.filmDTO.country == "" || this.filmDTO.image == ""){
        this.showError('Fill out all fields.', 'DVD Club');
        return;   
      }
    this.filmsService.add(this.filmDTO).subscribe(
      {
        next: (res) => {
          this.router.navigate(['films']);
          this.showSuccess();
        },
        error: (e) => {this.showError('Something went wrong', 'DVD Club');
          console.log(e);}
    });
  }
  showSuccess() {
    this.toastr.success('Film Added', 'DVD Club');
  }
  showError(message: string, title: string) {
    this.toastr.error(message, title);
  }

}
