package tencent.im.DynamicFeeds;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class DynamicLike$FeedsItem_Like extends MessageMicro<DynamicLike$FeedsItem_Like> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"ulFeedID", "uiClickTime", "strFeedCookie"}, new Object[]{0L, 0, ""}, DynamicLike$FeedsItem_Like.class);
    public final PBUInt64Field ulFeedID = PBField.initUInt64(0);
    public final PBUInt32Field uiClickTime = PBField.initUInt32(0);
    public final PBStringField strFeedCookie = PBField.initString("");
}
