package ru.ltst.u2020mvp.data.api.mock;

import javax.inject.Inject;

import retrofit2.Response;
import retrofit2.Result;
import retrofit2.http.Path;
import ru.ltst.u2020mvp.data.api.ImageService;
import ru.ltst.u2020mvp.data.api.ServerDatabase;
import ru.ltst.u2020mvp.data.api.model.response.ImageResponse;
import rx.Observable;

public class MockImageService implements ImageService {

    private final ServerDatabase serverDatabase;

    @Inject
    MockImageService(ServerDatabase serverDatabase) {
        this.serverDatabase = serverDatabase;
    }

    @Override
    public Observable<Result<ImageResponse>> image(@Path("id") String id) {
        return Observable.just(Result.response(Response.success(serverDatabase.getImageForId(id))));
    }
}
