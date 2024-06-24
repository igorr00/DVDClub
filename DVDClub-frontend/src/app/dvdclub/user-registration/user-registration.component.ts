import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserRegistrationService } from '../services/user-registration.service';
import { ToastrService } from 'ngx-toastr';
import { UserDTO } from '../dto/userDTO';

@Component({
  selector: 'app-user-registration',
  templateUrl: './user-registration.component.html',
  styleUrls: ['./user-registration.component.css']
})
export class UserRegistrationComponent implements OnInit {
  userDTO = new UserDTO();
  confirmPassword: string = "";

  constructor(private userRegistrationService: UserRegistrationService, private router: Router, private toastr: ToastrService) { }

  ngOnInit(): void {
  }

  submit(){
    if(this.userDTO.name == "" || this.userDTO.surname == "" || this.userDTO.email == "" || this.userDTO.password == "" ||
       this.userDTO.phone == ""){
        this.showError('Fill out all fields.', 'DVD Club');
        return;   
      }
      if(this.userDTO.password != this.confirmPassword){
        this.showError('Passwords don\'t match.', 'DVD Club');
        return;   
      }
    this.userRegistrationService.register(this.userDTO).subscribe(
      {
        next: (res) => {
          this.router.navigate(['']);
          this.showSuccess();
        },
        error: (e) => {this.showError('Something went wrong', 'DVD Club');
          console.log(e);}
    });
  }
  showSuccess() {
    this.toastr.success('User Registered', 'DVD Club');
  }
  showError(message: string, title: string) {
    this.toastr.error(message, title);
  }

}
