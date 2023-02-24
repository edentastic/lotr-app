import axios from 'axios';

const http = axios.create({
    baseURL: 'http://localhost:9000'
});

export default {
    viewMoviesFromAPI() {
        return http.get('/movie');
    },
    addMovieToDatabase(movie) {
        return http.post('/add-movie', movie);
    },
    getAllQuotesByMovieId(id) {
        return http.get(`/quotesByMovie/${id}`);
    }
}