package com.julianbattaglino.uishowcase.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    private static final int COUNT = 23;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static DummyItem createDummyItem(int position) {
        return makeDetails(position);
    }

    private static DummyItem makeDetails(int position) {
        DummyItem item = new DummyItem(String.valueOf(position), false, "");
        StringBuilder builder = new StringBuilder();
        switch (position) {
            case 1:
                builder.append("10+ Ready made Templates with Material Design and Animations.");
                break;
            case 2:
                builder.append("5 Login UI examples.");
                break;
            case 3:
                builder.append("5 Profile UI examples.");
                break;
            case 4:
                builder.append("Easy and Reusable AnimationUtils class for developer.");
                break;
            case 5:
                builder.append("Only 1 helper class for all animations.");
                break;
            case 6:
                item.setDemo(true);
                builder.append("AnimationUtils.popIn();");
                break;
            case 7:
                item.setDemo(true);
                builder.append("AnimationUtils.popOut();");
                break;
            case 8:
                item.setDemo(true);
                builder.append("AnimationUtils.enterLeft();");
                break;
            case 9:
                item.setDemo(true);
                builder.append("AnimationUtils.enterRight();");
                break;
            case 10:
                item.setDemo(true);
                builder.append("AnimationUtils.enterBottom();");
                break;
            case 11:
                item.setDemo(true);
                builder.append("AnimationUtils.enterTop();");
                break;
            case 12:
                item.setDemo(true);
                builder.append("AnimationUtils.hideMe();");
                break;
            case 13:
                item.setDemo(true);
                builder.append("AnimationUtils.showMe();");
                break;
            case 14:
                item.setDemo(true);
                builder.append("AnimationUtils.rotateX();");
                break;
            case 15:
                item.setDemo(true);
                builder.append("AnimationUtils.rotateY();");
                break;
            case 16:
                item.setDemo(true);
                builder.append("AnimationUtils.rotateClockWise();");
                break;
            case 17:
                item.setDemo(true);
                builder.append("AnimationUtils.rotateAntiClockWise();");
                break;
            case 18:
                item.setDemo(true);
                builder.append("AnimationUtils.setCount();");
                break;
            case 19:
                item.setDemo(true);
                builder.append("AnimationUtils.makeRoundCorner();");
                break;
            case 20:
                item.setDemo(true);
                builder.append("AnimationUtils.landMeX();");
                break;
            case 21:
                item.setDemo(true);
                builder.append("AnimationUtils.landMeY();");
                break;
            case 22:
                item.setDemo(true);
                builder.append("AnimationUtils.landMe();");
                break;
            case 23:
                item.setDemo(true);
                builder.append("AnimationUtils.changeBound();");
                break;


        }
        item.setDetails(builder.toString());
        return item;
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public String id;
        public boolean isDemo;
        public String details;

        public DummyItem(String id, boolean isDemo, String details) {
            this.id = id;
            this.isDemo = isDemo;
            this.details = details;
        }

        public String getDetails() {
            return details;
        }

        public void setDetails(String details) {
            this.details = details;
        }

        public boolean isDemo() {
            return isDemo;
        }

        public void setDemo(boolean demo) {
            isDemo = demo;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return details;
        }
    }
}
