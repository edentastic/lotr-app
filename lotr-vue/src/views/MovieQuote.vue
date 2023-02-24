<template>
  <div>
    <h1>Movie Quote</h1>
    <p v-for="quote in quotes" :key="quote._id">
    {{ quote.dialog }}</p>
  </div>
</template>

<script>
import backendService from '@/services/BackendService'
export default {
    name: 'movie-quote',
    data(){
      return{
        quotes:[],
      }
    },
    created(){
      backendService.getAllQuotesByMovieId(this.$route.params.id).then(response=>{
        if(response.status ==200){
          this.quotes=response.data;
        }
      })
    }

}
</script>

<style>

</style>