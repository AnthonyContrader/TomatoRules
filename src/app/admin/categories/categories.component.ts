import { Component, OnInit } from '@angular/core';
import { CategoryService} from 'src/service/category.service';
import { CategoryDTO} from 'src/dto/categorydto';
import { ToolService } from 'src/service/tool.service';
import { ToolDTO } from 'src/dto/tooldto';


@Component({
  selector: 'app-categories',
  templateUrl: './categories.component.html',
  styleUrls: ['./categories.component.css']
})
export class CategoriesComponent implements OnInit {

  categories: CategoryDTO[];
  categorytoinsert: CategoryDTO = new CategoryDTO();
  tools: ToolDTO[];

  constructor(private service: CategoryService, private serviceTool: ToolService) { }

  ngOnInit() {
    this.getCategories();
    this.getTools();
  }

  getTools() {
    this.serviceTool.getAll().subscribe(tools => this.tools = tools);
  }

  getCategories() {
    this.service.getAll().subscribe(categories => this.categories = categories);
    this.serviceTool.getAll().subscribe(tools => this.tools);
  }

  delete(category: CategoryDTO) {
    this.service.delete(category.id).subscribe(() => this.getCategories());
  }

  update(category: CategoryDTO) {
    this.service.update(category).subscribe(() => this.getCategories());
  }

  insert(category: CategoryDTO) {
    this.service.insert(category).subscribe(() => this.getCategories());
  }

  clear(){
    this.categorytoinsert = new CategoryDTO();
  }
}
