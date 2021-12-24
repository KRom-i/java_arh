package ru.geekbrains.handler.method;

import ru.geekbrains.entity.User;
import ru.geekbrains.request.HttpRequest;
import ru.geekbrains.request.RequestMethod;
import ru.geekbrains.response.HttpResponse;
import ru.geekbrains.response.HttpStatus;

import java.util.Optional;

@Handle (method = RequestMethod.DELETE, order = 3)
public class MethodHandlerDelete extends MethodHandler{

    public MethodHandlerDelete (MethodHandler methodHandler) {
        super (methodHandler);
    }

    @Override
    HttpResponse handle (HttpRequest httpRequest) {
        return super.methodsHandle (this, httpRequest);
    }

    @UrlRequest ("/delete/user")
    private HttpResponse deleteUser(HttpRequest httpRequest){
        Long id = Long.parseLong (httpRequest.getParam("id"));
        Optional<User> user = userRepository.findById (id);

        if (!user.isEmpty ()){
            userRepository.beginTransaction ();
            userRepository.delete (user.get ());
            userRepository.commitTransaction ();
            return createJsonMessage (HttpStatus.OK, "Пользователь удален!");
        }
        return createJsonMessage (HttpStatus.NOT_FOUND, "Пользователь не найден!");
    }
}
