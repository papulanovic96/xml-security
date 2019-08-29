export class Comment{
    constructor(
        public id: number,
        public content: string,
        public visible: number,
        public posted_by_id: string
    ){}
}

export class UpdateCommentRequest {
    id: number;
}

export class CprdCommentResponse {
    feedback: string;
}

export class CommentsUpdateResponse {
    approved: Comment[];
    refused: Comment[];
}

