package com.itsalexnguyen.contactssimple.presenters;

import com.itsalexnguyen.contactssimple.interfaces.DashboardView;
import com.itsalexnguyen.contactssimple.network.HttpCallback;
import com.itsalexnguyen.contactssimple.network.RestService;
import com.itsalexnguyen.contactssimple.network.models.randomuser.RandomUserResponse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by alexnguyen on 2017-07-16.
 */

public class DashboardPresenterTest {
    private DashboardPresenter sut;
    private DashboardView view;
    private RestService restService;

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
}
