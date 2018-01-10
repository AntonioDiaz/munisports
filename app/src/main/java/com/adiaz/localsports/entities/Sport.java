package com.adiaz.localsports.entities;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;

/**
 * Created by adiaz on 10/1/18.
 */

@AutoValue
public abstract class Sport implements Parcelable {

    public abstract Long id();
    public abstract String name();
    public abstract String tag();
    public abstract String image();
    public abstract Integer order();

    public static Builder builder() {
        return new AutoValue_Sport.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder id(Long id);
        public abstract Builder name(String name);
        public abstract Builder tag(String tag);
        public abstract Builder image(String image);
        public abstract Builder order(Integer order);
        public abstract Sport build();
    }
}