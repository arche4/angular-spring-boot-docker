import { Component, OnInit } from '@angular/core';
import { TodoListService } from './services/todo-list.service';

type List = { name: string; description?: string };

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit {
  newList: string;
  lists: List[];
  constructor(private service: TodoListService) {}

  ngOnInit() {
    this.service.fechLists().subscribe((lists) => {
      this.lists = lists;
    });
  }

  public createList() {
    if (this.newList != '') {
      this.service.createLists({ name: this.newList }).subscribe((l: any) => {
        this.lists.push(l);
        this.newList = '';
      });
    }
  }

  public deleteList(id){
    this.service.deleteList(id).subscribe(() => {
      this.lists = this.lists.filter((list: any) => list.id !== id)
    })
  }
}
