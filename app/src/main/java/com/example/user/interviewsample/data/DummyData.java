package com.example.user.interviewsample.data;

import java.util.ArrayList;
import java.util.List;

/**
 * 文件描述 : 假資料
 * Created by User
 * 2017/6/13
 * 版本 : 0.0.0.1
 */

public class DummyData {
    public static List<ItemEvent> getData() {
        List<ItemEvent> list = new ArrayList<>();
        list.add(new ItemEvent("學歷", null, ItemEvent.MAIN_TYPE));
        list.add(new ItemEvent("忠信學校", "普通科", ItemEvent.EVENT_TYPE));
        list.add(new ItemEvent("私立銘傳大學", "資訊管理學系", ItemEvent.EVENT_TYPE));
        list.add(new ItemEvent("工作經驗", null, ItemEvent.MAIN_TYPE));
        list.add(new ItemEvent("楷翔資訊", "2016 - 08 ~ 2016 - 04", ItemEvent.EVENT_TYPE));
        list.add(new ItemEvent("證照資格", null, ItemEvent.MAIN_TYPE));
        list.add(new ItemEvent("JAVA", "JAVA SCJP", ItemEvent.EVENT_TYPE));
        list.add(new ItemEvent("語言能力", null, ItemEvent.MAIN_TYPE));
        list.add(new ItemEvent("中文", "普通", ItemEvent.EVENT_TYPE));
        list.add(new ItemEvent("英文", "普通", ItemEvent.EVENT_TYPE));
        return list;
    }
}
