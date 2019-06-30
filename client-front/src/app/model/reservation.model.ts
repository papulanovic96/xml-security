import { Accommodation } from "./accommodation.model";

export class Reservation {
    id: number;
    accommodation: Accommodation;
    fromDate: Date;
    tillDate: Date;
    status: String;
}
