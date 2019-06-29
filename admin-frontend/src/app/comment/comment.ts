export class Comment{
    constructor(
        public id: number,
        public content: string,
        public visible: number,
        public posted_by_id: number
    ){}
}