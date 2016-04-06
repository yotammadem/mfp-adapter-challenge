package com.acme.apis;

import org.junit.Test;

public class ContactListApiIT {

    /**
     * - Test that adding a new contact returns status 201 and the "Location" header contains the link to the added contact
     * - Make sure that calling to get contact after adding contact will return the same contact info
     * - Delete the contact and make sure that calling to get contact after deleting will fail.
     */
    @Test
    public void testAddContact() {
        //TODO implement
    }


    /**
     * - Add contact
     * - Delete the contact we just added (expected HTTP status: 200)
     * - Make sure the contact is not there after deletion (status: 404)
     * - Try to delete the same contact one more time and expect 404
     */
    @Test
    public void testDeleteContact(){
        //TODO implement
    }


    /**
     * - Add contact
     * - Then update the contact's phone number using PUT, (expect status 200)
     * - Get the contact and make sure the phone number was updated
     * - Delete the contact
     * - Try to update again and make sure we got 404
     */
    @Test
    public void testUpdateContact() {
        //TODO implement
    }

    /**
     * - Add 2 contacts
     * - Get all contacts and make sure the 2 contacts we've added are part of the list
     */
    @Test
    public void testGetAllContacts(){
        //TODO implement
    }

}
