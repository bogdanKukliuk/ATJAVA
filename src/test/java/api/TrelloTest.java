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
        //Step_1
        String boardId="hCba3vq7";
        //Step_2
        Response res=trelloBO.deleteBoard(boardId);
        //Validate
        Assert.assertEquals(res.getStatusCode().intValue(),200,"invalid code");
    }
}

//61a51dd34acd696f0df54e56
