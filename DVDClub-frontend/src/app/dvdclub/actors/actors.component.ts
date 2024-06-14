import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MatTableDataSource } from '@angular/material/table';
import { Actor } from '../model/actor';
import { ActorsService } from '../services/actors.service';

@Component({
  selector: 'app-actors',
  templateUrl: './actors.component.html',
  styleUrls: ['./actors.component.css']
})
export class ActorsComponent implements OnInit {

  public dataSource = new MatTableDataSource<Actor>();
  public displayedColumns = ['name', 'surname', 'age', 'country', 'edit'];
  public actors: Actor[] = [];

  constructor(private router:Router, private actorsService: ActorsService) { }

  ngOnInit(): void {
    this.actorsService.getAll().subscribe(res => {
      this.actors = res;
      this.dataSource.data = this.actors;
    })
  }

  public edit(id: any){
    localStorage.setItem('editActorId', id);
    window.location.href="actor-edit";
  }

  public add(){
    window.location.href="actor-add";
  }

}
