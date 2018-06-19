package rudenko.andrey.currenciesapp.di.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rudenko.andrey.currenciesapp.api.RetrofitClient;

@Module
public class RetrofitClientModule {

    @Provides
    @Singleton
    RetrofitClient provideRetrofitClient() {
        return RetrofitClient.getInstance();
    }
}
