import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

type List = { name: string; description?: string };
type Task = { name: string; completed?: boolean };

@Injectable({
  providedIn: 'root',
})
export class TodoListService {
  url = 'http://localhost:9082/api/v1';

  constructor(private http: HttpClient) {}

  fechLists() {
    return this.http.get<List[]>(`${this.url}/getTodos`);
  }

  createLists({ name, description = '' }: List) {
    const body = { name, description_list: description };

    return this.http.post(`${this.url}/createTodos`, body);
  }

  deleteList(id: number) {
    return this.http.delete(`${this.url}/deleteLisTodo/${id}`);
  }

  addItemToList(id: number, { name, completed = false }: Task) {
    const body = { name, completed };

    return this.http.post(`${this.url}/create/${id}`, body);
  }

  removeItemFromList(id: number) {
    return this.http.delete(`${this.url}/delete/${id}`);
  }

  updateTask(task: Partial<Task>) {
    return this.http.put(`${this.url}/update`, task);
  }
}