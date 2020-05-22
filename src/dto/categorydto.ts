import { RootContextFlags } from '@angular/core/src/render3/interfaces/view';
import { ToolDTO } from './tooldto';

/**
 * Classe DTO di User. DEVE essere uguale (stesso nome classe, stessi attributi e stessi nomi) a
 * quello nel backend. 
 * 
 * @see Usertype
 * 
 * @author Vittorio Valent
 */
export class CategoryDTO {

    tool: ToolDTO;

    id: number;

    name: string;

    description: string;
}