import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { ToolDTO } from 'src/dto/tooldto';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ToolService  extends AbstractService<ToolDTO> {

  constructor(http: HttpClient) {
    super(http);
    this.type = 'tool';
  }

}
