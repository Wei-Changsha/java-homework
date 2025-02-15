package com.team7.yourturn.module.checkpoint;

import com.team7.yourturn.module.base.BaseController;
import com.team7.yourturn.module.base.GameWindow;
import com.team7.yourturn.module.game.GameController;
import com.team7.yourturn.utils.Bundle;

public class CheckpointController extends BaseController {

    private int numOfPlayer;
    private int checkpointSelected;
    private CheckpointPointer checkpointPointer;

    public CheckpointController() {

    }

    public CheckpointController(Bundle bundle) {
        super(bundle);
        checkpointPointer = new CheckpointPointer();
        numOfPlayer = bundle.getInt("player");
    }

    @Override
    protected void initView() {
        checkpointPointer.draw();
    }

    @Override
    protected void initEvent() {
        gameWindow.addKeyListener(new CheckpointSelectListener(this));
    }

    @Override
    protected int handleEvent(int eventCode) {
        return 0;
    }

    @Override
    protected void gotoNextPage() {
        Bundle bundle = new Bundle();
        bundle.addInt("player", numOfPlayer);
        bundle.addInt("checkpoint",checkpointPointer.getPointerState());
        gameWindow.setController(new GameController(bundle));
    }
}
