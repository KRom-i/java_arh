package ru.geekbrains.handler.method;

import ru.geekbrains.entity.User;
import ru.geekbrains.request.HttpRequest;
import ru.geekbrains.request.RequestMethod;
import ru.geekbrains.response.HttpResponse;
import ru.geekbrains.response.HttpStatus;

import java.util.Optional;

@Handle (method = RequestMethod.PUT, order = 4)
public class MethodHandlerPut extends MethodHandler{

    public MethodHandlerPut (MethodHandler methodHandler) {
        super (methodHandler);
    }

    @Override
    HttpResponse handle (HttpRequest httpRequest) {
        return super.methodsHandle (this, httpRequest);
    }

    @UrlRequest ("/put/user/description")
    private HttpResponse putUserDescription(HttpRequest httpRequest){
        Long id = Long.parseLong (httpRequest.getParam ("id"));
        Optional<User> user = userRepository.findById (id);

        if (!user.isEmpty ()){
            User update = user.get ();
            update.setDescription (httpRequest.getParam ("description"));
            userRepository.beginTransaction ();
            userRepository.update (update);
            userRepository.commitTransaction ();
            return createJsonMessage (HttpStatus.OK, "Данные сохранены!");
        }
        return createJsonMessage (HttpStatus.NOT_FOUND, "Пользователь не найден!");
    }
}
