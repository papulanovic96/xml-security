import { Reservation } from './reservation.model';

export class EndUser{

    id: number;
    firstName: string;
    lastName: string;
    reservations: Array<Reservation>;

}