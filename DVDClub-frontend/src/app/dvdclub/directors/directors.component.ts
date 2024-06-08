import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MatTableDataSource } from '@angular/material/table';
import { Director } from '../model/director';
import { DirectorsService } from '../services/directors.service';

@Component({
  selector: 'app-directors',
  templateUrl: './directors.component.html',
  styleUrls: ['./directors.component.css']
})
export class DirectorsComponent implements OnInit {

  public dataSource = new MatTableDataSource<Director>();
  public displayedColumns = ['name', 'surname', 'age', 'country', 'edit'];
  public directors: Director[] = [];

  constructor(private router:Router, private directorsService: DirectorsService) { }

  ngOnInit(): void {
    this.directorsService.getAll().subscribe(res => {
      this.directors = res;
      this.dataSource.data = this.directors;
    })
  }

  public edit(id: any){
    
  }

  public add(){
    window.location.href="director-add";
  }

}
