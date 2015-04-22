package org.kudrenko.telegram.ui.common;

import android.support.v7.app.ActionBarActivity;

import org.androidannotations.annotations.App;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.kudrenko.telegram.TelegramApplication;
import org.kudrenko.telegram.otto.OttoBus;

@EActivity
public abstract class AbsTelegramActivity extends ActionBarActivity {
    protected final String TAG = getClass().getName();

    @App
    protected TelegramApplication application;

    @Bean
    protected OttoBus ottoBus;

    @Override
    protected void onStart() {
        ottoBus.register(this);
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        ottoBus.unregister(this);
    }
}
