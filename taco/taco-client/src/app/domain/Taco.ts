import {Ingredient} from "./Ingredient";

export interface Taco {
  id: bigint;
  createdAt: Date;
  name: string;
  ingredients: Ingredient[];
}
