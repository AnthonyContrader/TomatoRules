import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { ActivityDTO } from 'src/dto/activitydto';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class ActivityService extends AbstractService<ActivityDTO>{

  constructor(http: HttpClient) {
    super(http);
    this.type = 'activity';
 }

}
