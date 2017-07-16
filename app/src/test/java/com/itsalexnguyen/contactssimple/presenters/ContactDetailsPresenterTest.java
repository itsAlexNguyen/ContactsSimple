package com.itsalexnguyen.contactssimple.presenters;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.itsalexnguyen.contactssimple.network.models.randomuser.User;

import org.junit.Before;
import org.junit.Test;

import static com.itsalexnguyen.contactssimple.TestUtils.readFileAsString;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class ContactDetailsPresenterTest {
    private ContactDetailsPresenter sut;
    private User user;

    @Before
    public void setup() {
        Gson gson = new GsonBuilder().create();
        user = gson.fromJson(readFileAsString("json/singleRandomUser.json"), User.class);
        sut = new ContactDetailsPresenter(user);
    }

    @Test
    public void testInitalization_shouldSetSelectedContact() {
        assertTrue(sut.getContact() != null);
    }

    @Test
    public void testGetContact_shouldBeSameContact() {
        assertEquals(user, sut.getContact());
    }

    @Test
    public void testGetContactEmail_shouldReturnContactEmail() {
        assertEquals("victor.christensen@example.com", sut.getContactEmail());
    }

    @Test
    public void testGetContactLocation_shouldReturnFormattedContactLocation() {
        assertEquals("9532 Torvegade\n" +
                "Kongens  Lyngby\n" +
                "Sjælland\n" +
                "43480", sut.getContactLocation());
    }

    @Test
    public void testGetDateOfBirth_shouldReturnFormattedDateOfBirth() {
        assertEquals("1952-11-12", sut.getDateOfBirth());
    }
}
