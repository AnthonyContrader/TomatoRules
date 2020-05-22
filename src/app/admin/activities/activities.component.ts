import { Component, OnInit } from '@angular/core';
import {ActivityService } from 'src/service/activity.service';
import { ActivityDTO} from 'src/dto/activitydto';
import { ToolDTO } from 'src/dto/tooldto';
import { ToolService } from 'src/service/tool.service';


@Component({
  selector: 'app-activities',
  templateUrl: './activities.component.html',
  styleUrls: ['./activities.component.css']
})
export class ActivitiesComponent implements OnInit {

  activities: ActivityDTO[];
  activitytoinsert: ActivityDTO = new ActivityDTO();
  tools: ToolDTO[];

  constructor(private service: ActivityService, private serviceTool: ToolService) { }

  ngOnInit() {
    this.getActivities();
    this.getTools();
  }

  getTools() {
    this.serviceTool.getAll().subscribe(tools => this.tools = tools);
  }

  getActivities() {
    this.service.getAll().subscribe(activities => this.activities = activities);
    this.serviceTool.getAll().subscribe(tools => this.tools);
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
