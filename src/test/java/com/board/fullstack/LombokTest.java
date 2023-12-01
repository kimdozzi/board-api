package com.board.fullstack;

import com.board.fullstack.domain.ResultVO;
import org.junit.jupiter.api.Test;

public class LombokTest {
    @Test
    public void ResultTest() throws Exception {

        ResultVO resultVO = new ResultVO(0, "hong");
        System.out.println(resultVO);
    }
}
