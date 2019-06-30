import { Image } from './image.model';
import { AccommodationType } from './accommodationType.model';
import { AccommodationCategory } from './accommodationCategory.model';
import { Address } from './address.model';
import { AdditionalService } from './additionalservice.model';
import { Cancelation } from './cancelation.model';
import { PriceInSeason } from './priceInSeason.model';

export class Accommodation {

    id: number;
    name: string;
    address: Address = new Address();
    additionalService: AdditionalService[] = [];
    type: AccommodationType;
    category: AccommodationCategory = new AccommodationCategory();
    description: string;
    cancelation = new Cancelation();
    priceInSeason: PriceInSeason[] = [];
    capacity: number;
}