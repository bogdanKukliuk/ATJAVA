package api;


import org.json.JSONArray;
import org.testng.Assert;
import org.testng.annotations.Test;
import practice.api.Response;
import practice.api.TrelloBO;

public class TrelloTest {
    TrelloBO trelloBO=new TrelloBO();

    @Test
    public void createBoardTest(){
        trelloBO.createBoard();
    }
    @Test
    public void deleteBoardByIdTest(){
        Response res=trelloBO.deleteBoard("hCba3vq7");
        Assert.assertEquals(res.getStatusCode().intValue(),
                200,
                "invalid code");
    }
    @Test
    public void updateTest(){
        Assert.assertEquals(trelloBO.updateBoard(trelloBO.createBoard()).getStatusCode().intValue(),
                200,
                "invalid code");
    }
    @Test
    public void createListTest(){
        String boardId=trelloBO.createBoard();
        Assert.assertEquals(trelloBO.customBoard(boardId, "To Do").getStatusCode().intValue(),
                200,
                "invalid code");
        Assert.assertEquals(trelloBO.customBoard(boardId, "Doing").getStatusCode().intValue(),
                200,
                "invalid code");
        Assert.assertEquals(trelloBO.customBoard(boardId, "Done").getStatusCode().intValue(),
                200,
                "invalid code");
    }
    @Test
    public void createCardTest(){
        String boardId = trelloBO.createBoard();
        trelloBO.customBoard(boardId, "Do");
        String listId = trelloBO.getListIds(boardId).getJSONObject(0).get("id").toString();
        Assert.assertEquals(trelloBO.createCard(listId, "TEST").getStatusCode().intValue(),
                200,
                "invalid code");
    }
    @Test
    public void getMemdersTest(){
        String boardId = trelloBO.createBoard();
        Assert.assertEquals(trelloBO.getMembers(boardId).getStatusCode().intValue(),
                200,
                "invalid code");
    }
    @Test
    public void createChecklistTest(){
        String boardId = trelloBO.createBoard();
        trelloBO.customBoard(boardId, "Do");
        String listId = trelloBO.getListIds(boardId).getJSONObject(0).get("id").toString();
        trelloBO.createCard(listId, "TEST");
        String cardId = trelloBO.getCardIdsByList(listId).getJSONObject(0).get("id").toString();
        Assert.assertEquals(trelloBO.createChecklist(cardId,"Qwerty").getStatusCode().intValue(),
                200,
                "invalid code");
    }
}
