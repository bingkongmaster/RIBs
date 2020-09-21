package com.uber.rib.root.logged_out;

//import android.support.annotation.Nullable;

import androidx.annotation.Nullable;

import android.util.Log;

import com.uber.rib.core.Bundle;
import com.uber.rib.core.Interactor;
import com.uber.rib.core.RibInteractor;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Coordinates Business Logic for {@link LoggedOutScope}.
 * <p>
 * TODO describe the logic of this scope.
 */
@RibInteractor
public class LoggedOutInteractor
        extends Interactor<LoggedOutInteractor.LoggedOutPresenter, LoggedOutRouter> {

    @Inject
    LoggedOutPresenter presenter;

    @Override
    protected void didBecomeActive(@Nullable Bundle savedInstanceState) {
        super.didBecomeActive(savedInstanceState);

        // TODO: Add attachment logic here (RxSubscriptions, etc.).

        Disposable disposable = presenter
                .loginName()
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String name) throws Exception {
                        Log.d("MOO", name);
                    }
                });
    }

    @Override
    protected void willResignActive() {
        super.willResignActive();

        // TODO: Perform any required clean up here, or delete this method entirely if not needed.
    }


    /**
     * Presenter interface implemented by this RIB's view.
     */
    interface LoggedOutPresenter {
        Observable<String> loginName();


    }


}
