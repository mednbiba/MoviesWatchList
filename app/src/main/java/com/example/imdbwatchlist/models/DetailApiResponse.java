package com.example.imdbwatchlist.models;

import java.util.List;

public class DetailApiResponse {
    String id="";
    String title="";
    String originalTitle="";
    String fullTitle="";
    String type="";
    String year="";
    String image="";
    String releaseDate="";
    String runtimeMins="";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getFullTitle() {
        return fullTitle;
    }

    public void setFullTitle(String fullTitle) {
        this.fullTitle = fullTitle;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getRuntimeMins() {
        return runtimeMins;
    }

    public void setRuntimeMins(String runtimeMins) {
        this.runtimeMins = runtimeMins;
    }

    public String getRuntimeStr() {
        return runtimeStr;
    }

    public void setRuntimeStr(String runtimeStr) {
        this.runtimeStr = runtimeStr;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getPlotLocal() {
        return plotLocal;
    }

    public void setPlotLocal(String plotLocal) {
        this.plotLocal = plotLocal;
    }

    public Boolean getPlotLocalIsRtl() {
        return plotLocalIsRtl;
    }

    public void setPlotLocalIsRtl(Boolean plotLocalIsRtl) {
        this.plotLocalIsRtl = plotLocalIsRtl;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    public String getDirectors() {
        return directors;
    }

    public void setDirectors(String directors) {
        this.directors = directors;
    }

    public List<directorList> getDirectorListList() {
        return directorListList;
    }

    public void setDirectorListList(List<directorList> directorListList) {
        this.directorListList = directorListList;
    }

    public String getWriters() {
        return writers;
    }

    public void setWriters(String writers) {
        this.writers = writers;
    }

    public List<writerList> getWriterListList() {
        return writerListList;
    }

    public void setWriterListList(List<writerList> writerListList) {
        this.writerListList = writerListList;
    }

    public String getstars() {
        return stars;
    }

    public void setstars(String stars) {
        stars = stars;
    }

    public List<starList> getStarListList() {
        return starListList;
    }

    public void setStarListList(List<starList> starListList) {
        this.starListList = starListList;
    }

    public List<actorList> getActorListList() {
        return actorListList;
    }

    public void setActorListList(List<actorList> actorListList) {
        this.actorListList = actorListList;
    }

    public Boolean getFullCast() {
        return fullCast;
    }

    public void setFullCast(Boolean fullCast) {
        this.fullCast = fullCast;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public List<genreList> getGenreListList() {
        return genreListList;
    }

    public void setGenreListList(List<genreList> genreListList) {
        this.genreListList = genreListList;
    }

    public String getCompanies() {
        return companies;
    }

    public void setCompanies(String companies) {
        this.companies = companies;
    }

    public List<companyList> getCompanyListList() {
        return companyListList;
    }

    public void setCompanyListList(List<companyList> companyListList) {
        this.companyListList = companyListList;
    }

    public String getCountries() {
        return countries;
    }

    public void setCountries(String countries) {
        this.countries = countries;
    }

    public List<countryList> getCountryListList() {
        return countryListList;
    }

    public void setCountryListList(List<countryList> countryListList) {
        this.countryListList = countryListList;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getContentRating() {
        return contentRating;
    }

    public void setContentRating(String contentRating) {
        this.contentRating = contentRating;
    }

    public String getImDbRating() {
        return imDbRating;
    }

    public void setImDbRating(String imDbRating) {
        this.imDbRating = imDbRating;
    }

    public String getImDbRatingVotes() {
        return imDbRatingVotes;
    }

    public void setImDbRatingVotes(String imDbRatingVotes) {
        this.imDbRatingVotes = imDbRatingVotes;
    }

    public String getMetacriticRating() {
        return metacriticRating;
    }

    public void setMetacriticRating(String metacriticRating) {
        this.metacriticRating = metacriticRating;
    }

    public String getRatings() {
        return ratings;
    }

    public void setRatings(String ratings) {
        this.ratings = ratings;
    }

    public String getWikipedia() {
        return wikipedia;
    }

    public void setWikipedia(String wikipedia) {
        this.wikipedia = wikipedia;
    }

    public String getPosters() {
        return posters;
    }

    public void setPosters(String posters) {
        this.posters = posters;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public com.example.imdbwatchlist.models.boxOffice getBoxOffice() {
        return boxOffice;
    }

    public void setBoxOffice(com.example.imdbwatchlist.models.boxOffice boxOffice) {
        this.boxOffice = boxOffice;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getTvSeriesInfo() {
        return tvSeriesInfo;
    }

    public void setTvSeriesInfo(String tvSeriesInfo) {
        this.tvSeriesInfo = tvSeriesInfo;
    }

    public String getTvEpisodeInfo() {
        return tvEpisodeInfo;
    }

    public void setTvEpisodeInfo(String tvEpisodeInfo) {
        this.tvEpisodeInfo = tvEpisodeInfo;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    String runtimeStr="";
    String plot="";
    String plotLocal="";
    Boolean plotLocalIsRtl=Boolean.FALSE;
    String awards="";
    String directors="";
    List<directorList> directorListList;
    String writers="";
    List<writerList> writerListList;
    String stars="";
    List<starList> starListList;
    List<actorList> actorListList;
    Boolean fullCast = null;
    String genres ="";
    List<genreList> genreListList;
    String companies="";
    List<companyList> companyListList;
    String countries="";
    List<countryList> countryListList;
    String languages;
    String contentRating="";
    String imDbRating="";
    String imDbRatingVotes="";
    String metacriticRating="";
    String ratings=null;
    String wikipedia=null;
    String posters=null;
    String images=null;
    String trailer=null;
    boxOffice boxOffice;
    String tagline="";
    String keywords="";
    String tvSeriesInfo=null;
    String tvEpisodeInfo=null;
    String errorMessage=null;









}
