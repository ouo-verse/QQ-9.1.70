package tencent.im.DynamicFeeds;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class DynamicFeeds$FeedsItem_Resp extends MessageMicro<DynamicFeeds$FeedsItem_Resp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 40, 48}, new String[]{"ulFeedID", "strTemplatData", "uiUpdateTime", "strFeedCookie", "uiResID", "exp_temlate_id"}, new Object[]{0L, "", 0, "", 0, 0}, DynamicFeeds$FeedsItem_Resp.class);
    public final PBUInt64Field ulFeedID = PBField.initUInt64(0);
    public final PBStringField strTemplatData = PBField.initString("");
    public final PBUInt32Field uiUpdateTime = PBField.initUInt32(0);
    public final PBStringField strFeedCookie = PBField.initString("");
    public final PBUInt32Field uiResID = PBField.initUInt32(0);
    public final PBUInt32Field exp_temlate_id = PBField.initUInt32(0);
}
