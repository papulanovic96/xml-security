import { User } from "./user.model";
import { AccommodationType } from "./accommodation-type.model";
import { AccommodationCategory } from "./accommodation-category.model";
import { Address } from "./address.model";
import { AdditionalService } from "./additional-service.model";
import { PriceInSeason } from "./price-in-season.model";
import { Agent } from "./agent.model";
import { Comment } from "./comment.model";
import { ImageResource } from "./image-resource.model";


export class Accommodation {
    id: number;
    name: string;
    type: AccommodationType;
    category: AccommodationCategory;
    ownedBy: String;
    description: string;
    address: Address;
    additionalService: AdditionalService[];
    comments: Comment[];
    priceInSeason: PriceInSeason;
    fromDate: Date;
    tillDate: Date;
    capacity: string;
    distance: number;
    rate: number;
    status: string;
    image: ImageResource[];
}
