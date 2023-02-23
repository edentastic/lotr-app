<template>
  <div class="movie-content">
    <h2>{{ movie.name }}</h2>
    <ul>
      <li>Runtime: {{ movie.runtimeInMinutes }} minutes</li>
      <li>Budget: ${{ movie.budgetInMillions }} million</li>
    </ul>
  </div>
</template>

<script>
export default {
  name: 'movie-content',
  props: ["movie"],

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