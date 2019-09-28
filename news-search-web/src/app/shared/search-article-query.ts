export class SearchArticleQuery {
    private _country: string;
    private _category: string;
    private _query: string;
    private _pageSize: number;
    private _pageNumber: number;

    set country(country: string) {
        this._country = country;
    }

    set category(category: string) {
        this._category = category;
    }

    set query(query: string) {
        this._query = query;
    }

    set pageSize(pageSize: number) {
        this._pageSize = pageSize;
    }

    set pageNumber(pageNumber: number) {
        this._pageNumber = pageNumber;
    }

    get isValid(): boolean {
        return !!this._country && !!this._category && !!this._pageSize && !!this._pageNumber;
    }

    get searchUrl(): string {
        let url = `/${this._country}/${this._category}?page=${this._pageNumber}&pageSize=${this._pageSize}`;

        if(!!this._query) {
            url = url + `&q=${this._query}`;
        }

        return url;
    }
}