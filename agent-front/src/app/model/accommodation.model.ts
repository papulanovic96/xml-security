import { Picture } from './picture.model';
import { AccommodationType } from './accommodationType.model';
import { AccommmodationCategory } from './accommodationCategory.model';
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
    category: AccommmodationCategory;
    description: string;
    cancelation: Cancelation;
    picture: Picture;
    priceInSeason: PriceInSeason;
    capacity: number;
}