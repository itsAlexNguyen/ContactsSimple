package com.itsalexnguyen.contactssimple.interfaces;

/**
 * A listener to detect when an Item has been selected.
 *
 * @param <T> Generic item.
 */
public interface ItemSelectedListener<T> {
    void onItemSelected(T item);
}
