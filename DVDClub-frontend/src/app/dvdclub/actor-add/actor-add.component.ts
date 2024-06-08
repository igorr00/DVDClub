import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ActorsService } from '../services/actors.service';
import { ToastrService } from 'ngx-toastr';
import { ActorDTO } from '../dto/actorDTO';

@Component({
  selector: 'app-actor-add',
  templateUrl: './actor-add.component.html',
  styleUrls: ['./actor-add.component.css']
})
export class ActorAddComponent implements OnInit {
  actorDTO = new ActorDTO();

  constructor(private actorsService: ActorsService, private router: Router, private toastr: ToastrService) { }

  ngOnInit(): void {
  }

  submit(){
    if(this.actorDTO.name == "" || this.actorDTO.surname == "" || this.actorDTO.age == 0 || this.actorDTO.country == ""){
        this.showError('Fill out all fields.', 'DVD Club');
        return;   
      }
    this.actorsService.add(this.actorDTO).subscribe(
      {
        next: (res) => {
          this.router.navigate(['actors']);
          this.showSuccess();
        },
        error: (e) => {this.showError('Something went wrong', 'DVD Club');
          console.log(e);}
    });
  }
  showSuccess() {
    this.toastr.success('Actor Added', 'DVD Club');
  }
  showError(message: string, title: string) {
    this.toastr.error(message, title);
  }

}
