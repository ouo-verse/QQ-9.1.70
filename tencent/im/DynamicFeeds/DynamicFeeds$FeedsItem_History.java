package tencent.im.DynamicFeeds;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class DynamicFeeds$FeedsItem_History extends MessageMicro<DynamicFeeds$FeedsItem_History> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"ulFeedID", "uiUpdateTimestamp", "bDislike"}, new Object[]{0L, 0, Boolean.FALSE}, DynamicFeeds$FeedsItem_History.class);
    public final PBUInt64Field ulFeedID = PBField.initUInt64(0);
    public final PBUInt32Field uiUpdateTimestamp = PBField.initUInt32(0);
    public final PBBoolField bDislike = PBField.initBool(false);
}
