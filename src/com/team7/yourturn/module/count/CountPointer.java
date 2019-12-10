package com.team7.yourturn.module.count;

import com.team7.yourturn.module.base.BaseViewModel;
import com.team7.yourturn.module.base.ItemComponent;

import java.awt.event.KeyEvent;

public class CountPointer extends BaseViewModel {

    private final int POINT_TO_AGAIN = 1100;//再来一次
    private final int POINT_TO_RANK = 1101;//查看排行榜
    private final int POINT_TO_EXIT = 1102;//退出游戏

    private final int DEFAULT_X = 400;
    private final int DEFAULT_Y = 400;
    private final int DEFAULT_WIDTH = 60;
    private final int DEFAULT_HEIGHT = 60;

    private int pointerState = POINT_TO_AGAIN;


    public CountPointer(){
        x = 200;
        y = 700;
        this.itemComponent = new ItemComponent("checkPoint.jpg",60,60);
        itemComponent.setLocation(x, y);
    }

    public int HandleEvent(int eventCode) {
        switch (eventCode) {

            case KeyEvent.VK_UP:
            case KeyEvent.VK_DOWN:
                return changePointer(eventCode);
            case KeyEvent.VK_ENTER:
                return PAGE_END;
            default:
                return NO_MEANING_EVENT;

        }
    }
    private int changePointer(int eventCode){
        int moveDistance = 120;

        switch (eventCode) {

            case KeyEvent.VK_DOWN:
                if (pointerState == POINT_TO_AGAIN){
                    pointerState = POINT_TO_RANK;
                    y += moveDistance;
                } else if (pointerState == POINT_TO_RANK){
                    pointerState = POINT_TO_EXIT;
                    y += moveDistance;
                } else{
                    pointerState = POINT_TO_AGAIN;
                    y -= moveDistance;
                }
                locationUpdate();
                return EVENT_HANDLE_SUCCEED;

            case KeyEvent.VK_UP:
                if (pointerState == POINT_TO_AGAIN){
                    pointerState = POINT_TO_EXIT;
                    y += moveDistance;
                } else if (pointerState == POINT_TO_RANK){
                    pointerState = POINT_TO_AGAIN;
                    y += moveDistance;
                } else{
                    pointerState = POINT_TO_RANK;
                    y -= moveDistance;
                }
                locationUpdate();
                return EVENT_HANDLE_SUCCEED;

            default:
                return CASE_WONT_HAPPEN;
        }
    }

    public int getPointerState() {
        return pointerState;
    }
}
