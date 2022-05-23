
# My Movie Helper
Android studio project for Polytech Intl
A small Android application to browse movie catalogues made using REST API provided by
IMDB-API.com

Gradle Dependencies :



    
    // Retrofit & OkHttp
    compile 'com.squareup.retrofit2:retrofit:2.5.0'

    // JSON Converter
    compile 'com.squareup.retrofit2:converter-gson:2.5.0'

    //Image Uri Handling
    compile 'com.squareup.picasso:picasso:latest'

PS : Use the same version for retrofit and converter-gson to avoid conflict errors




## API Reference
https://imdb-api.com/

Base URL : https://imdb-api.com/en/API/

Change API_KEY in **RequestManager.java**
#### Get all items

```http
  GET SearchMovie/api_key/{movie_name}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `movie_name`      | `string` | **Required**. Search Expression |

#### Get item

```http
  GET Title/api_key/{movie_id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. Id of item to fetch |



Returns Movie information details


