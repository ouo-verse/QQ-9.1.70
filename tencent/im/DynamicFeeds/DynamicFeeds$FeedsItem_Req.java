package tencent.im.DynamicFeeds;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class DynamicFeeds$FeedsItem_Req extends MessageMicro<DynamicFeeds$FeedsItem_Req> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uiResID", "uiOpenFlag"}, new Object[]{0, 0}, DynamicFeeds$FeedsItem_Req.class);
    public final PBUInt32Field uiResID = PBField.initUInt32(0);
    public final PBUInt32Field uiOpenFlag = PBField.initUInt32(0);
}
