import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UsersService } from '../services/users.service';
import { ToastrService } from 'ngx-toastr';
import { UserDTO } from '../dto/userDTO';

@Component({
  selector: 'app-manager-add',
  templateUrl: './manager-add.component.html',
  styleUrls: ['./manager-add.component.css']
})
export class ManagerAddComponent implements OnInit {
  userDTO = new UserDTO();
  confirmPassword: string = "";

  constructor(private usersService: UsersService, private router: Router, private toastr: ToastrService) { }

  ngOnInit(): void {
  }

  submit(){
    if(this.userDTO.name == "" || this.userDTO.surname == "" || this.userDTO.email == "" || this.userDTO.password == "" || this.userDTO.jmbg == "" ||
       this.userDTO.phone == ""){
        this.showError('Fill out all fields.', 'DVD Club');
        return;   
      }
      if(this.userDTO.password != this.confirmPassword){
        this.showError('Passwords don\'t match.', 'DVD Club');
        return;   
      }
    this.usersService.add(this.userDTO).subscribe(
      {
        next: (res) => {
          this.router.navigate(['managers']);
          this.showSuccess();
        },
        error: (e) => {this.showError('Something went wrong', 'DVD Club');
          console.log(e);}
    });
  }
  showSuccess() {
    this.toastr.success('Manager Added', 'DVD Club');
  }
  showError(message: string, title: string) {
    this.toastr.error(message, title);
  }

}
