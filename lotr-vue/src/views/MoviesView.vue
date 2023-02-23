<template>
  <div>
     <h1>Movies</h1>
     <div class="movie-container" >
      <movie-content 
      v-for="movie in movies" 
      :key="movie._id" 
      :movie="movie" 
      />
     </div>
  </div>
</template>

<script>
import MovieContent from '@/components/MovieContent.vue'
import backendService from '../services/BackendService.js'
export default {
  components: { MovieContent },
  name: 'movies-view',
  data(){
    return{
      movies: [],
    }
  },
  created(){
    backendService.viewMoviesFromAPI().then(response=>{
      if(response.status==200){
        this.movies=response.data;
      }
    })
  }
}
</script>

<style scoped>
  .movie-container{
    display: flex;
    flex-wrap: wrap;
    justify-content: space-evenly;
  }
</style>