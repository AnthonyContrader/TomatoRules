import { Component, OnInit } from '@angular/core';
import {ActivityService } from 'src/service/activity.service';
import { ActivityDTO} from 'src/dto/activitydto';
import { ToolDTO } from 'src/dto/tooldto';
import { ToolService } from 'src/service/tool.service';
import { CategoryDTO } from 'src/dto/categorydto';
import { CategoryService } from 'src/service/category.service';


@Component({
  selector: 'app-activities',
  templateUrl: './activities.component.html',
  styleUrls: ['./activities.component.css']
})
export class ActivitiesComponent implements OnInit {

  activities: ActivityDTO[];
  activitytoinsert: ActivityDTO = new ActivityDTO();
  tools: ToolDTO[];
  categories: CategoryDTO[];

  constructor(private service: ActivityService, private serviceTool: ToolService, private serviceCategory: CategoryService) { }

  ngOnInit() {
    this.getActivities();
    this.getTools();
    this.getCategories();
  }

  getCategories() {
    this.serviceCategory.getAll().subscribe(categories => this.categories = categories);
  }

  getTools() {
    this.serviceTool.getAll().subscribe(tools => this.tools = tools);
  }

  getActivities() {
    this.service.getAll().subscribe(activities => this.activities = activities);
    this.serviceTool.getAll().subscribe(tools => this.tools);
    this.serviceCategory.getAll().subscribe(categories => this.categories);
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
