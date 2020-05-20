import { Component, OnInit } from '@angular/core';
import {ActivityService } from 'src/service/activity.service';
import { ActivityDTO} from 'src/dto/activitydto';

@Component({
  selector: 'app-activity',
  templateUrl: './activity.component.html',
  styleUrls: ['./activity.component.css']
})
export class ActivitiesComponent implements OnInit {

  activities: ActivityDTO[];
  activitytoinsert: ActivityDTO = new ActivityDTO();

  constructor(private service: ActivityService) { }

  ngOnInit() {
    this.getActivities();
  }

  getActivities() {
    this.service.getAll().subscribe(activities => this.activities = activities);
  }

  delete(activity: ActivityDTO) {
    this.service.delete(activity.id).subscribe(() => this.getActivities());
  }

  update(activity: ActivityDTO) {
    this.service.update(activity).subscribe(() => this.getActivities());
  }

  insert(activity: ActivityDTO) {
    this.service.insert(activity).subscribe(() => this.getActivities());
  }

  clear() {
    this.activitytoinsert = new ActivityDTO();
  }
}
