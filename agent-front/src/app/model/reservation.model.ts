import { EndUser } from './endUser.model';
import { Accommodation } from './accommodation.model';

export class Reservation {
    reservationId: number;
    reservedBy: EndUser;
    dateFrom: Date;
    dateTo: Date;
    finalPrice: number;
    status: boolean;
    accommodation: Accommodation;
   
}