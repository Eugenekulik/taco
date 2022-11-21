import {User} from "./User";

export interface Order {
  id: bigint;
  user: User;
  placedAt: Date;
}
