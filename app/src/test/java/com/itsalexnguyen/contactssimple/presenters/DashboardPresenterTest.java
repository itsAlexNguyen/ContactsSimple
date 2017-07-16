package com.itsalexnguyen.contactssimple.presenters;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.itsalexnguyen.contactssimple.interfaces.DashboardView;
import com.itsalexnguyen.contactssimple.interfaces.ItemSelectedListener;
import com.itsalexnguyen.contactssimple.network.HttpCallback;
import com.itsalexnguyen.contactssimple.network.RestService;
import com.itsalexnguyen.contactssimple.network.models.randomuser.RandomUserResponse;
import com.itsalexnguyen.contactssimple.network.models.randomuser.User;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static com.itsalexnguyen.contactssimple.TestUtils.readFileAsString;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Tests the Dashboard Presenter.
 */
public class DashboardPresenterTest {
    private DashboardPresenter sut;
    private DashboardView view;
    private RestService restService;

    /**
     * Prepares data for testing.
     */
    @Before
    public void setup() {
        view = Mockito.mock(DashboardView.class);
        restService = Mockito.mock(RestService.class);
        sut = new DashboardPresenter(view, restService);
    }

    @After
    public void tearDown() {
        view = null;
        sut = null;
    }

    @Test
    public void testInitialization_shouldHaveNoContacts() {
        assertEquals(0, sut.getContacts().size());
    }

    @Test
    public void testRetrieveContactsSuccess_shouldReloadPage() {
        // Arrange
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                ((HttpCallback<RandomUserResponse>) invocation.getArguments()[0]).onSuccess(null, createRandomUserResponse());
                return null;
            }
        }).when(restService).getListRandomUsers(any(HttpCallback.class));

        // Act
        sut.retrieveContacts();

        // Assert
        verify(view, times(0)).showNetworkError();
        verify(view, times(1)).refreshPage();
        assertTrue(sut.getContacts().size() > 0);
    }

    @Test
    public void testRetrieveContactsFailure_shouldShowError() {
        // Arrange
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                ((HttpCallback<RandomUserResponse>) invocation.getArguments()[0]).onFailure(null, null);
                return null;
            }
        }).when(restService).getListRandomUsers(any(HttpCallback.class));

        // Act
        sut.retrieveContacts();

        // Assert
        verify(view, times(1)).showNetworkError();
    }

    @Test
    public void testSelectContact_shouldOpenDetails() {
        // Arrange
        ItemSelectedListener<User> listener = sut.createContactSelectedListener();
        User selectedUser = Mockito.mock(User.class);

        // Act
        listener.onItemSelected(selectedUser);

        // Assert
        verify(view, times(1)).displayContactDetails(selectedUser);
    }

    /**
     * Pulls a local JSON file and creates new RandomUserResponse Object.
     *
     * @return new testable RandomUserResponse.
     */
    private RandomUserResponse createRandomUserResponse() {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(readFileAsString("json/getListRandomUsers.json"), RandomUserResponse.class);
    }
}
