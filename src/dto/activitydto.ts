import { RootContextFlags } from '@angular/core/src/render3/interfaces/view';
import { ToolDTO } from './tooldto';
import { CategoryDTO } from './categorydto';

export class ActivityDTO {

    category: CategoryDTO;

    tool: ToolDTO;

    id: number;

    name: string;

    time: number;
}