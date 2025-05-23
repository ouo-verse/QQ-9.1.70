package yx;

import com.tencent.mobileqq.data.MessageRecord;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a {
    public static boolean a(MessageRecord messageRecord) {
        return "1".equalsIgnoreCase(messageRecord.getExtInfoFromExtStr("recent_list_advertisement_message"));
    }
}
