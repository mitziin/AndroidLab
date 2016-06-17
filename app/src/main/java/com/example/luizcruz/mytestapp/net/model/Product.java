package com.example.luizcruz.mytestapp.net.model;

import java.util.List;

/**
 * Created by guilherme on 20/05/16.
 *
 * Product API v3
 * http://raml-portal.atlas.b2w/api/v3/portal
 *
 */
public class Product {

    private String id;
    private String name;
    private Rating rating;
    private List<Image> images;
    private List<Offer> offers;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

    public class Rating {

        private Integer reviews;
        private Integer recommendations;
        private Float average;

        public Integer getReviews() {
            return reviews;
        }

        public void setReviews(Integer reviews) {
            this.reviews = reviews;
        }

        public Integer getRecommendations() {
            return recommendations;
        }

        public void setRecommendations(Integer recommendations) {
            this.recommendations = recommendations;
        }

        public Float getAverage() {
            return average;
        }

        public void setAverage(Float average) {
            this.average = average;
        }


    }

    public class Image {

        private String medium;
        private String big;
        private String large;
        private String extraLarge;

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }

        public String getBig() {
            return big;
        }

        public void setBig(String big) {
            this.big = big;
        }

        public String getLarge() {
            return large;
        }

        public void setLarge(String large) {
            this.large = large;
        }

        public String getExtraLarge() {
            return extraLarge;
        }

        public void setExtraLarge(String extraLarge) {
            this.extraLarge = extraLarge;
        }

    }
}


