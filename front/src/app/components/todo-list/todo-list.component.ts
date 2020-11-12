import { Component, EventEmitter, Input, Output } from '@angular/core';
import { TodoListService } from 'src/app/services/todo-list.service';

@Component({
  selector: 'app-todo-list',
  templateUrl: './todo-list.component.html',
  styleUrls: ['./todo-list.component.css'],
})
export class TodoListComponent {
  @Input() id: number;
  @Input() name = 'To Do List';
  @Input() public items = [];
  @Output() delete = new EventEmitter<number>();

  public task;
  public taskUpdated = null;

  constructor(private service: TodoListService) {}

  onDelete() {
    this.delete.emit(this.id);
  }

  public addToList() {
    if (this.task != '') {
      this.service
        .addItemToList(this.id, { name: this.task })
        .subscribe((t) => {
          this.items.push({ name: this.task, completed: false });
          this.task = '';
        });
    }
  }

  public editTask(index) {
    this.taskUpdated = index;
    this.task = this.items[index].name;
  }

  public updateTask() {
    const task = {
      ...this.items[this.taskUpdated],
      name: this.task,
      completed: this.items[this.taskUpdated].completed,
    };
    this.service.updateTask(task).subscribe(() => {
      this.items[this.taskUpdated] = task;
      this.taskUpdated = null;
    });
  }

  public deleteTask(index) {
    const id = this.items[index]?.id;
    this.service.removeItemFromList(id).subscribe(() => {
      this.items.splice(index, 1);
    });
  }

  public checkTask(index) {
    const task = this.items[index];
    const updatedTask = { ...task, completed: !task.completed };
    this.service.updateTask(updatedTask).subscribe(() => {
      this.items[index] = updatedTask;
    });
  }
}
