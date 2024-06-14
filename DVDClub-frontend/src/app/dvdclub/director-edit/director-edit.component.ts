import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DirectorsService } from '../services/directors.service';
import { ToastrService } from 'ngx-toastr';
import { Director } from '../model/director';

@Component({
  selector: 'app-director-edit',
  templateUrl: './director-edit.component.html',
  styleUrls: ['./director-edit.component.css']
})
export class DirectorEditComponent implements OnInit {
  director: Director = new Director();

  constructor(private directorsService: DirectorsService, private router: Router, private toastr: ToastrService) { }

  ngOnInit(): void {
    this.directorsService.getById(localStorage.getItem('editDirectorId')).subscribe(res => {
      this.director = res;
    })
  }

  submit(){
    if(this.director.name == "" || this.director.surname == "" || this.director.age == 0 || this.director.country.name == ""){
        this.showError('Fill out all fields.', 'DVD Club');
        return;   
      }
    this.directorsService.edit(this.director).subscribe(
      {
        next: (res) => {
          this.router.navigate(['directors']);
          this.showSuccess('Director Edited', 'DVD Club');
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
    this.directorsService.delete(this.director.id).subscribe(
      {
        next: (res) => {
          this.router.navigate(['directors']);
          this.showSuccess('Director Deleted', 'DVD Club');
        },
        error: (e) => {this.showError('Something went wrong', 'DVD Club');
          console.log(e);}
    });
  }

}
