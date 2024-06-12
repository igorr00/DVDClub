import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MatTableDataSource } from '@angular/material/table';
import { User } from '../model/user';
import { UsersService } from '../services/users.service';

@Component({
  selector: 'app-managers',
  templateUrl: './managers.component.html',
  styleUrls: ['./managers.component.css']
})
export class ManagersComponent implements OnInit {

  public dataSource = new MatTableDataSource<User>();
  public displayedColumns = ['name', 'surname', 'email', 'type'];
  public managers: User[] = [];

  constructor(private router:Router, private usersService: UsersService) { }

  ngOnInit(): void {
    this.usersService.getAllManagers().subscribe(res => {
      this.managers = res;
      this.dataSource.data = this.managers;
    })
  }

  public edit(id: any){
    
  }

  public add(){
    window.location.href="manager-add";
  }

}
