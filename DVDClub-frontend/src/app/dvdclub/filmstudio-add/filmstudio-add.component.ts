import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FilmstudiosService } from '../services/filmstudios.service';
import { ToastrService } from 'ngx-toastr';
import { FilmStudioDTO } from '../dto/filmstudioDTO';

@Component({
  selector: 'app-filmstudio-add',
  templateUrl: './filmstudio-add.component.html',
  styleUrls: ['./filmstudio-add.component.css']
})
export class FilmstudioAddComponent implements OnInit {
  filmstudioDTO = new FilmStudioDTO();

  constructor(private filmstudiosService: FilmstudiosService, private router: Router, private toastr: ToastrService) { }

  ngOnInit(): void {
  }

  submit(){
    if(this.filmstudioDTO.name == "" || this.filmstudioDTO.country == ""){
        this.showError('Fill out all fields.', 'DVD Club');
        return;   
      }
    this.filmstudiosService.add(this.filmstudioDTO).subscribe(
      {
        next: (res) => {
          this.router.navigate(['filmstudios']);
          this.showSuccess();
        },
        error: (e) => {this.showError('Something went wrong', 'DVD Club');
          console.log(e);}
    });
  }
  showSuccess() {
    this.toastr.success('Film Studio Added', 'DVD Club');
  }
  showError(message: string, title: string) {
    this.toastr.error(message, title);
  }

}
