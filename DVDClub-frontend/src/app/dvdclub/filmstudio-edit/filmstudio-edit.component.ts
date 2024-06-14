import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FilmstudiosService } from '../services/filmstudios.service';
import { ToastrService } from 'ngx-toastr';
import { FilmStudio } from '../model/filmstudio';

@Component({
  selector: 'app-filmstudio-edit',
  templateUrl: './filmstudio-edit.component.html',
  styleUrls: ['./filmstudio-edit.component.css']
})
export class FilmstudioEditComponent implements OnInit {
  filmstudio: FilmStudio = new FilmStudio();

  constructor(private filmstudiosService: FilmstudiosService, private router: Router, private toastr: ToastrService) { }

  ngOnInit(): void {
    this.filmstudiosService.getById(localStorage.getItem('editFilmStudioId')).subscribe(res => {
      this.filmstudio = res;
    })
  }

  submit(){
    if(this.filmstudio.name == "" || this.filmstudio.country.name == ""){
        this.showError('Fill out all fields.', 'DVD Club');
        return;   
      }
      this.filmstudiosService.edit(this.filmstudio).subscribe(
        {
          next: (res) => {
            this.router.navigate(['filmstudios']);
            this.showSuccess('Film Studio Edited', 'DVD Club');
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
      this.filmstudiosService.delete(this.filmstudio.id).subscribe(
        {
          next: (res) => {
            this.router.navigate(['filmstudios']);
            this.showSuccess('Film Studio Deleted', 'DVD Club');
          },
          error: (e) => {this.showError('Film Studio has movies', 'DVD Club');
            console.log(e);}
      });
    }

}
