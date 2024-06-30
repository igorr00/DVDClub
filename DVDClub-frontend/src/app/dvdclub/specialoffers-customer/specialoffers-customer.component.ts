import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MatTableDataSource } from '@angular/material/table';
import { SpecialOffer } from '../model/specialoffer';
import { MarketplacesService } from '../services/marketplaces.service';
import { PurchaseDTO } from '../dto/purchaseDTO';
import { PurchasesService } from '../services/purchases.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-specialoffers-customer',
  templateUrl: './specialoffers-customer.component.html',
  styleUrls: ['./specialoffers-customer.component.css']
})
export class SpecialoffersCustomerComponent implements OnInit {

  public dataSource = new MatTableDataSource<SpecialOffer>();
  public displayedColumns = ['name', 'startDate', 'endDate', 'price', 'buy'];
  public specialOffers: SpecialOffer[] = [];
  public title = '';
  public isMember: boolean = false;
  public purchaseDTO: PurchaseDTO = new PurchaseDTO();

  constructor(private router:Router, private marketplacesService: MarketplacesService,
    private purchasesService: PurchasesService, private toastr: ToastrService) { }

  ngOnInit(): void {
    this.marketplacesService.checkUser(localStorage.getItem('marketplaceId'), localStorage.getItem('loggedUserId')).subscribe({
      next: (res) => {
        this.isMember = true;
      },
      error: (e) => { this.isMember = false; }
  });

    this.marketplacesService.getById(localStorage.getItem('marketplaceId')).subscribe(res => {
      this.title = res.name;
      
      this.marketplacesService.getAvailableSpecialOffers(localStorage.getItem('marketplaceId')).subscribe(res => {
        this.specialOffers = res;
        this.dataSource.data = this.specialOffers;
      })
    })
  }

  public buy(id: any){
    this.purchaseDTO.userId = localStorage.getItem('loggedUserId');
    this.purchaseDTO.specialOfferId = id;
    this.purchasesService.add(this.purchaseDTO).subscribe(res => {
      this.toastr.success('Dvd purchased', 'DVD Club');
      this.router.navigate(['purchases']);
    })
  }

  public membership(){
    this.marketplacesService.membership(localStorage.getItem('marketplaceId'), localStorage.getItem('loggedUserId')).subscribe(res => {
      window.location.reload();
    })
  }

  public dvds(){
    this.router.navigate(['dvds-customer']);
  }

}
