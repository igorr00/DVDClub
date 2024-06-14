import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MarketplacesService } from '../services/marketplaces.service';
import { ToastrService } from 'ngx-toastr';
import { Marketplace } from '../model/marketplace';
import { User } from '../model/user';
import { UsersService } from '../services/users.service';

@Component({
  selector: 'app-marketplace-edit',
  templateUrl: './marketplace-edit.component.html',
  styleUrls: ['./marketplace-edit.component.css']
})
export class MarketplaceEditComponent implements OnInit {
  marketplace: Marketplace = new Marketplace();
  managers: User[] = [];

  constructor(private marketplacesService: MarketplacesService, private router: Router, private toastr: ToastrService,
    private usersService: UsersService) { }

  ngOnInit(): void {
    this.marketplacesService.getById(localStorage.getItem('editMarketplaceId')).subscribe(res => {
      this.marketplace = res;
      this.usersService.getAllFreeManagers().subscribe(res => {
        this.managers = res;
        this.managers.push(this.marketplace.manager);
      })
    })
  }

  compareManagers(manager1: any, manager2: any): boolean {
    return manager1 && manager2 ? manager1.id === manager2.id : manager1 === manager2;
  }

  submit(){
    console.log(this.marketplace);
    if(this.marketplace.name == "" || this.marketplace.street == "" || this.marketplace.number == "" ||
      this.marketplace.city.name == "" || this.marketplace.city.country.name == "" || this.managers.length == 0){
        this.showError('Fill out all fields.', 'DVD Club');
        return;   
      }
      this.marketplacesService.edit(this.marketplace).subscribe(
        {
          next: (res) => {
            this.router.navigate(['marketplaces']);
            this.showSuccess('Marketplace Edited', 'DVD Club');
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
      this.marketplacesService.delete(this.marketplace.id).subscribe(
        {
          next: (res) => {
            this.router.navigate(['marketplaces']);
            this.showSuccess('Marketplace Deleted', 'DVD Club');
          },
          error: (e) => {this.showError('Marketplace has dvds in it', 'DVD Club');
            console.log(e);}
      });
    }

}
