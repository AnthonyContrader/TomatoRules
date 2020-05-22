import { Component, OnInit } from '@angular/core';
import { ToolService } from 'src/service/tool.service';
import { ToolDTO } from 'src/dto/tooldto';

@Component({
  selector: 'app-tools',
  templateUrl: './tools.component.html',
  styleUrls: ['./tools.component.css']
})
export class ToolsComponent implements OnInit {

  tools: ToolDTO[];
  tooltoinsert: ToolDTO = new ToolDTO();
  
  constructor(private service: ToolService) { }

  ngOnInit() {
    this.getTools();
  }

  getTools() {
    this.service.getAll().subscribe(tools => this.tools = tools);
  }

  delete(tool: ToolDTO) {
    this.service.delete(tool.id).subscribe(() => this.getTools());
  }

  update(tool: ToolDTO) {
    this.service.update(tool).subscribe(() => this.getTools());
  }

  insert(tool: ToolDTO) {
    this.service.insert(tool).subscribe(() => this.getTools());
  }

  clear() {
    this.tooltoinsert = new ToolDTO();
  }
}
