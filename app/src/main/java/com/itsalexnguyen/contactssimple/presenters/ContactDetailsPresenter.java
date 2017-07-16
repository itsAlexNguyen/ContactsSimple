package com.itsalexnguyen.contactssimple.presenters;

import com.itsalexnguyen.contactssimple.network.models.randomuser.User;

import org.apache.commons.lang3.text.WordUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ContactDetailsPresenter {
    private final User contact;

    /**
     * Retrieves the contact in Detail.
     *
     * @return selected Contact.
     */
    public User getContact() {
        return contact;
    }

    /**
     * Retrieve's the contact's Email.
     *
     * @return email address.
     */
    public String getContactEmail() {
        return contact.email;
    }

    /**
     * Retrieves the contact's gender. Male or Female.
     *
     * @return gender.
     */
    public String getContactGender() {
        return contact.gender;
    }

    /**
     * Retrieves the contact's location.
     *
     * @return formatted location.
     */
    public String getContactLocation() {
        StringBuilder sb = new StringBuilder();

        sb.append(WordUtils.capitalizeFully(contact.location.street))
                .append("\n")
                .append(WordUtils.capitalize(contact.location.city))
                .append("\n")
                .append(WordUtils.capitalize(contact.location.state))
                .append("\n")
                .append(contact.location.postcode);

        return sb.toString();
    }

    /**
     * Retrieve's contact's date of birth.
     *
     * @return formatted date of birth. Empty if cannot parse date of birth.
     */
    public String getDateOfBirth() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        try {
            Date date = format.parse(contact.dateOfBirth);
            return format.format(date);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    public ContactDetailsPresenter(User contact) {
        this.contact = contact;
    }
}
