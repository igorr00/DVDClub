import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { UserLoginService } from '../services/user-login.service';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {
  email: string = "";
  password: string = "";

  constructor(private userLoginService: UserLoginService, private router: Router, private toastr: ToastrService) { }

  ngOnInit(): void {
  }

  login(){
    if(this.email == "" || this.password == ""){ 
      this.showError('Fill out all fields', 'Dvd Club')
    } else {
      this.userLoginService.login(this.email, this.password).subscribe(
        {
          next: (res) => {
            localStorage.setItem('loggedUser', this.email);
            localStorage.setItem('loggedUserId', res.id);
            localStorage.setItem('loggedUserRole', res.type);
            if(res.type == 'Customer'){
              window.location.href = 'marketplaces-customer';
            } else if (res.type == 'Admin'){
              window.location.href = 'admin-page';
            } else if (res.type == 'MarketingManager'){
              window.location.href = 'news';
            } else if (res.type == 'SalesManager'){
              window.location.href = 'dvds-manager';
            }
            this.showSuccess();
          },
          error: (e) => {this.showError('Login Failed', 'Dvd Club');
            console.log(e);}
      });
    }
  }
  showSuccess() {
    this.toastr.success('Logged In', 'Dvd Club');
  }
  showError(message: string, title: string) {
    this.toastr.error(message, title);
  }

  register(){
    this.router.navigate(['/user-registration']);
  }

}
