package practice.api;

import practice.api.Request;


public class RequestRepo {

    public static Request getPostman() {
        Request request=new Request();
        request.setProtocol("https");
        request.setHost("postman-echo.com");
        request.setPath("get");
        request.setMethod("GET");
        return request;
    }

    private static Request baseTrelloRequest() {
        Request request=new Request();
        request.setProtocol("https");
        request.setHost("api.trello.com");
        return request;
    }

    private final static String KEY=Credentials.MyKey;
    private final static String TOKEN=Credentials.MyToken;

    public static Request createTrelloBoard(String boardName) {
        Request request=baseTrelloRequest();
        request.setPath("1/boards/?name="+ boardName+ "&defaultLists=false&key="+ KEY + "&token=" + TOKEN);
        request.setMethod("POST");
        return request;
    }

    public static Request deleteTrelloBoard(String boardId) {
        Request request=baseTrelloRequest();
        request.setPath("1/boards/"+boardId+"?key=" + KEY + "&token=" + TOKEN);
        request.setMethod("DELETE");
        return request;
    }
}
