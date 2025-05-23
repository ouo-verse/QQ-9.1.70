package tencent.im.DynamicFeeds;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class DynamicDislike$FeedsItem_Dislike extends MessageMicro<DynamicDislike$FeedsItem_Dislike> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"ulFeedID", "strFeedCookie", "strDislikeFeedback"}, new Object[]{0L, "", ""}, DynamicDislike$FeedsItem_Dislike.class);
    public final PBUInt64Field ulFeedID = PBField.initUInt64(0);
    public final PBStringField strFeedCookie = PBField.initString("");
    public final PBStringField strDislikeFeedback = PBField.initString("");
}
