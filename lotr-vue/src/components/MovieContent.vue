<template>
  <div class="movie-content">
    <router-link :to="{name: 'movie-quote', params:{id:movie._id}}">
      <h2>{{ movie.name }}</h2>
    </router-link>
    <ul>
      <li>Runtime: {{ movie.runtimeInMinutes }} minutes</li>
      <li>Budget: ${{ movie.budgetInMillions }} million</li>
    </ul>
    <button @click.prevent="addToFavorites(movie)">Add To Favorites</button>
  </div>
</template>

<script>
import backendService from '@/services/BackendService';

export default {
  name: 'movie-content',
  props: ["movie"],
  methods: {
    addToFavorites(movie){
      if(confirm("Add movie to your favorites?")){
        console.log(movie)

        backendService.addMovieToDatabase(movie).then(response =>{
          console.log(response)
          if(response.status ==201){
            alert("movie added!");
          }
        })
      }
    }
  }
}
</script>

<style scoped>
  .movie-content{
    border: black 2px solid;
    border-radius: 10px;
    width: 250px;
    height: 550px;
    margin: 20px;

    background-color: aquamarine;
  }
</style>