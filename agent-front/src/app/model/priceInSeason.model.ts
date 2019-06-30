import { Months } from './months.enum';
import { Accommodation } from './accommodation.model';

export class PriceInSeason{

    id:number;
    inMonth:Months;
    price:number;
    currency:string;
    accId: number;
   
}