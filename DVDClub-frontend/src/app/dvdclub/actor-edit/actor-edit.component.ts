import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ActorsService } from '../services/actors.service';
import { ToastrService } from 'ngx-toastr';
import { Actor } from '../model/actor';

@Component({
  selector: 'app-actor-edit',
  templateUrl: './actor-edit.component.html',
  styleUrls: ['./actor-edit.component.css']
})
export class ActorEditComponent implements OnInit {
  actor: Actor = new Actor();

  constructor(private actorsService: ActorsService, private router: Router, private toastr: ToastrService) { }

  ngOnInit(): void {
    this.actorsService.getById(localStorage.getItem('editActorId')).subscribe(res => {
      this.actor = res;
    })
  }

  submit(){
    if(this.actor.name == "" || this.actor.surname == "" || this.actor.age == 0 || this.actor.country.name == ""){
        this.showError('Fill out all fields.', 'DVD Club');
        return;   
      }
    this.actorsService.edit(this.actor).subscribe(
      {
        next: (res) => {
          this.router.navigate(['actors']);
          this.showSuccess('Actor Edited', 'DVD Club');
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
    this.actorsService.delete(this.actor.id).subscribe(
      {
        next: (res) => {
          this.router.navigate(['actors']);
          this.showSuccess('Actor Deleted', 'DVD Club');
        },
        error: (e) => {this.showError('Something went wrong', 'DVD Club');
          console.log(e);}
    });
  }

}
