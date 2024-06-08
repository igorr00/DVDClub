import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DirectorsService } from '../services/directors.service';
import { ToastrService } from 'ngx-toastr';
import { DirectorDTO } from '../dto/directorDTO';

@Component({
  selector: 'app-director-add',
  templateUrl: './director-add.component.html',
  styleUrls: ['./director-add.component.css']
})
export class DirectorAddComponent implements OnInit {
  directorDTO = new DirectorDTO();

  constructor(private directorsService: DirectorsService, private router: Router, private toastr: ToastrService) { }

  ngOnInit(): void {
  }

  submit(){
    if(this.directorDTO.name == "" || this.directorDTO.surname == "" || this.directorDTO.age == 0 || this.directorDTO.country == ""){
        this.showError('Fill out all fields.', 'DVD Club');
        return;   
      }
    this.directorsService.add(this.directorDTO).subscribe(
      {
        next: (res) => {
          this.router.navigate(['directors']);
          this.showSuccess();
        },
        error: (e) => {this.showError('Something went wrong', 'DVD Club');
          console.log(e);}
    });
  }
  showSuccess() {
    this.toastr.success('Director Added', 'DVD Club');
  }
  showError(message: string, title: string) {
    this.toastr.error(message, title);
  }

}
