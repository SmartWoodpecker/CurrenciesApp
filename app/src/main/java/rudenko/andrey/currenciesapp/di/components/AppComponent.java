package rudenko.andrey.currenciesapp.di.components;

import javax.inject.Singleton;

import dagger.Component;
import rudenko.andrey.currenciesapp.di.modules.RetrofitClientModule;
import rudenko.andrey.currenciesapp.mvpmodels.DateDetailsModelImpl;

@Component (modules = {RetrofitClientModule.class})
@Singleton
public interface AppComponent {

    void inject(DateDetailsModelImpl dateDetailsModelImpl);
}
